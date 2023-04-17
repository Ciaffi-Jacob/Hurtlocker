import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private HashMap hashMap; //buckets will track how many of each thing for count

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }
    public String pattern(String s, String splitter){//take dataToString and what will be split on
        //pattern-matcher to break up data
        Pattern pattern = Pattern.compile()
        return  null;
    }
    public String split(String s){//takes broken up data and breaks up further with regex [;:^@] etc
        return null;
        //send broken matcher to store
    }
    public void store(){//takes broken up data and puts into map

    }
    public void format(){//takes map and formats for print

    }
    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();

        System.out.println(output);
    }
}