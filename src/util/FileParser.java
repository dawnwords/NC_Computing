package util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import data.FileData;
import data.Row;

public class FileParser {
  private String header;

  public FileData parse(File file) {
    BufferedReader reader = null;
    FileData fileData = null;
    try {
      reader = new BufferedReader(new FileReader(file));
      header = reader.readLine();
      String line;
      List<Row> rows = new ArrayList<Row>();
      while ((line = reader.readLine()) != null) {
        rows.add(Row.parse(line));
      }
      fileData = new FileData(rows);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close(reader);
    }
    return fileData;
  }

  public void saveAs(File file, FileData filedata) {
    PrintWriter writer = null;
    try {
      if (!file.exists()) {
        file.createNewFile();
      }
      writer = new PrintWriter(new FileWriter(file));
      writer.println(header);
      for (Row row : filedata.getRows()) {
        writer.println(row.toString());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close(writer);
    }
  }

  private void close(Closeable closable) {
    try {
      if (closable != null) {
        closable.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
