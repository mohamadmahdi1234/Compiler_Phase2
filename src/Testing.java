import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Testing {
    public static void main(String[] args) throws IOException {
        File s=new File("C:\\Users\\NeginPardaz\\Desktop\\java\\tests\\t13-macro1.in");
        try {
            System.out.println(Main.run(s));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
