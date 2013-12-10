package util;

import data.FileData;
import data.Row;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private String[] header;

    public FileData parse(File file) {
        BufferedReader reader = null;
        FileData fileData = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            setHeader(reader.readLine().substring(1));
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

    private void setHeader(String header) {
        header = "times " + header;
        this.header = header.split(" ");
    }

    public void saveAs(File file, FileData filedata) {
        PrintWriter writer = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new PrintWriter(new FileWriter(file));
            String header = "";
            for (String h : this.header) {
                header += h + "\t";
            }
            writer.println(header);
            int i = 0;
            for (Row row : filedata.getRows()) {
                writer.printf("%d\t%s\n", ++i, row.toString());
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
