import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private HashMap hashMap;

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));




        //filter
        String patternString = "##";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(result);
        for (int i = 0; matcher.find(); i++) {

            System.out.println(
                    matcher.

            );
        }
        //recollect
        //regex to find
        //regex to print
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}
