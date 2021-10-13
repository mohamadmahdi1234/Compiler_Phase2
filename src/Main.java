import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class Main {
    //this is for our test script
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java Main -i <input> -o <output>");
            return;
        }
        String inputFileName = null;
        String outputFileName = null;
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-i")) {
                    inputFileName = args[i + 1];
                }
                if (args[i].equals("-o")) {
                    outputFileName = args[i + 1];
                }
            }
        }
        String outputPath = "out/" + outputFileName;
        createFile(outputPath);

        // Read the input file and write to the output file.

        String[] lines = {
                "class",
                "T_ID Program",
                "{",
                "void",
                "T_ID main",
                "(",
                ")",
                "{",
                "}",
                "}"
        };

        writeContentToFile(outputPath, lines);
    }

    private static boolean createFile(String path) {
        File file = new File(path);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void writeContentToFile(String path, String[] lines) {
        try (FileWriter writer = new FileWriter(new File(path))) {
            String content = String.join("\n", lines);
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //this is for quera test and should implement and return string
    public static String run(java.io.File inputFile) throws Exception {
        String input= Files.readString(inputFile.toPath(), StandardCharsets.ISO_8859_1);
        Pre_Processor p=new Pre_Processor(input);
        String define_handeled=p.handle_define();
        return "";



    }

}
