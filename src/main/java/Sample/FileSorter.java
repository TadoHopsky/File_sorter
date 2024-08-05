package Sample;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FileSorter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileSorter <input_file>");
            return;
        }

        String inputFileName = args[0];
        String stringFileName = "strings.txt";
        String intFileName = "ints.txt";
        String floatFileName = "floats.txt";

        try {
            // Read all lines from the input file
            List<String> lines = Files.readAllLines(Paths.get(inputFileName));

            // Create writers for output files
            BufferedWriter stringWriter = new BufferedWriter(new FileWriter(stringFileName));
            BufferedWriter intWriter = new BufferedWriter(new FileWriter(intFileName));
            BufferedWriter floatWriter = new BufferedWriter(new FileWriter(floatFileName));

            for (String line : lines) {
                if (isInteger(line)) {
                    intWriter.write(line);
                    intWriter.newLine();
                } else if (isFloat(line)) {
                    floatWriter.write(line);
                    floatWriter.newLine();
                } else {
                    stringWriter.write(line);
                    stringWriter.newLine();
                }
            }

            // Close all writers
            stringWriter.close();
            intWriter.close();
            floatWriter.close();

            System.out.println("Processing complete. Check the generated files.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}