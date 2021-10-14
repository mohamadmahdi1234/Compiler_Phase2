package compiler;
import compiler.Main;

import java.io.File;
import java.io.IOException;

public class Testing {
    public static void main(String[] args) throws IOException {
        File s=new File("C:\\Users\\NeginPardaz\\Desktop\\nem.txt");
        try {
            System.out.println(Main.run(s));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
