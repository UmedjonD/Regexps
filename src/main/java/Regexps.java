import javafx.scene.shape.Path;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regexps {
    private static Charset charset;

//    private static final String inFile = ("src/main/java/file/inMessage.txt");
//    private static final String outFile = ("src/main/java/file/outMessage.txt");

    
    public static void main(String[] args) {
        Path inFile = (Path) Paths.get("src/main/java/file/inMessage.txt");
        Path outFile = (Path) Paths.get("src/main/java/file/outMessage.txt");

        readerWriteFile(inFile, outFile);

    }

    public static void readerWriteFile(Path inFile, Path outFile) {
        charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(inFile, charset);
             BufferedReader writer = Files.newBufferedReader(outFile, charset)) {

            String line = null;
            while ((line = reader.readLine()) != null)
                for (String phone: getNumber(line))
                    writer.write(phone + "n\")
            }catch(Exception e){
                e
            }

        }

        Pattern pattern = Pattern.compile("[1-3]");
        Matcher matcher = pattern.matcher("rfrtkf1fhf123");

        while(matcher.find()){
            System.out.println(matcher.start() + " " + matcher.group());
        }
        System.out.println(" ");

    }

}