import core.Calculator;
import data.FileData;
import util.FileParser;

import java.io.File;
import java.util.ArrayList;

public class Main {
    private static final String DIR_PATH_INPUT = "NC_Files" + File.separator + "${group}";
    private static final String DIR_PATH_OUTPUT = DIR_PATH_INPUT + File.separator + "out";

    public static void main(String[] args) {
        generate("Setup A");
        generate("Setup B");
    }

    private static void generate(String s) {
        String inputPath = DIR_PATH_INPUT.replace("${group}", s);
        String outputPath = DIR_PATH_OUTPUT.replace("${group}", s);

        FileParser parser = new FileParser();

        File dir = new File(inputPath);
        if (dir.exists()) {
            ArrayList<FileData> data = new ArrayList<FileData>();
            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    data.add(parser.parse(file));
                }
            }

            Calculator<FileData> calculator = new Calculator<FileData>();
            FileData average = calculator.average(data);
            FileData sd = calculator.sd(data);

            File output = new File(outputPath);
            if (!output.exists()) {
                output.mkdir();
            }


            File averageFile = new File(outputPath + File.separator + "average");
            File sdFile = new File(outputPath + File.separator + "sd");
            parser.saveAs(averageFile, average);
            parser.saveAs(sdFile, sd);

            System.out.printf("See aggregating result for %s in %s and %s\n",
                    s, averageFile.getAbsolutePath(), sdFile.getAbsolutePath());
        }
    }
}
