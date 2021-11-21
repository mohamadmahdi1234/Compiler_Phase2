package compiler;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    //this is for our test script
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java compiler.Main -i <input> -o <output>");
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
        Path path=Paths.get("in/"+inputFileName);
        StringBuilder contentBuilder=new StringBuilder();
        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String input=contentBuilder.toString();
        Pre_Processor p=new Pre_Processor(input);
        String define_handeled=p.handle_define();
        Scanner_phase1 scanner=new Scanner_phase1(new StringReader(define_handeled.trim()));
        try {
            while(true){
                String a=scanner.yylex();
                if(a==null){
                    break;
                }
            }
        }catch (Exception e){}

        String ans=scanner.answer.toString();
        String[]answer=ans.split("\n");
        writeContentToFile(outputPath,answer);
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
        StringBuilder contentBuilder=new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(inputFile.getAbsolutePath()), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String input=contentBuilder.toString();
        Pre_Processor p=new Pre_Processor(input);
        String define_handeled=p.handle_define();
        Scanner_phase1 scanner=new Scanner_phase1(new StringReader(define_handeled.trim()));
        while(true){
            String a=scanner.yylex();
            if(a==null){
                break;
            }
        }
        String ans=scanner.answer.toString();
        return ans.substring(0,ans.length()-1);

    }

}
