import java.io.File;
import java.util.ArrayList;

import core.Calculator;
import data.FileData;
import util.FileParser;

public class Main {
  private static final String DIR_PATH_INPUT = "D:" + File.separator + "NC_Files" + File.separator + "Setup A";
  private static final String DIR_PATH_OUTPUT = DIR_PATH_INPUT + File.separator + "out";

  static {
    File output = new File(DIR_PATH_OUTPUT);
    if (!output.exists()) {
      output.mkdir();
    }
  }

  public static void main(String[] args) {
    FileParser parser = new FileParser();

    File dir = new File(DIR_PATH_INPUT);
    if (dir.exists()) {
      ArrayList<FileData> datas = new ArrayList<FileData>();
      for (File file : dir.listFiles()) {
        datas.add(parser.parse(file));
      }

      Calculator<FileData> calculator = new Calculator<FileData>();
      FileData average = calculator.average(datas);
      FileData sd = calculator.sd(datas);

      parser.saveAs(new File(DIR_PATH_OUTPUT + File.separator + "average"), average);
      parser.saveAs(new File(DIR_PATH_OUTPUT + File.separator + "sd"), sd);
    }
  }
}
