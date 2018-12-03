import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regexps {

    private static Charset charset;

    public static void main(String[] args) {
        Path inFile =  Paths.get("src/main/java/file/inMessage");
        Path outFile =  Paths.get("src/main/java/file/outMessage");

        readerWriteFile(inFile, outFile);
    }
    public static void readerWriteFile(Path inFile, Path outFile) {
        charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(inFile, charset);
             BufferedWriter writer = Files.newBufferedWriter(outFile, charset)) {

            String line = null;
            while ((line = reader.readLine()) != null)
                for (String phone: getNumber(line))
                    writer.write(phone + "\n");
                writer.flush();
            }catch(Exception e){
                e.printStackTrace();
            }
    }

    public static List<String> getNumber(String line) {
        List<String> phones = new ArrayList<>();

        Pattern p = Pattern.compile("\\+\\d\\(\\d{3}\\) \\d{3}( \\d{2}){2}");
        Matcher m = p.matcher(line);

        while (m.find()) phones.add(m.group().replaceAll("[^\\d]", ""));
        return phones;
    }

    }
