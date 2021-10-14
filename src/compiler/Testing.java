package compiler;
import compiler.Main;

import java.io.File;
import java.io.IOException;

public class Testing {
    public static void main(String[] args) throws IOException {
        File s=new File("C:\\Users\\NeginPardaz\\Desktop\\java\\tests\\t14-macro2.in");
        try {
            System.out.println(Main.run(s));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
