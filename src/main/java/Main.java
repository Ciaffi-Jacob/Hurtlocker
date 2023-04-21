import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
      private static ArrayList<String> arrayList = new ArrayList<>(); ///0 milk 1 bread 2 cookies 3 apples


    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }
    public static Matcher pattern(String s, String splitter){//take dataToString and what will be split on
        //pattern-matcher to break up data
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(splitter);
        return  matcher;
    }
    public static void split(Matcher matcher){//takes broken up data and breaks up further with regex [;:^@] etc
        String[]  name = {"milk", "bread", "cookies", "apples"};
        for (int i = 0; i < matcher.groupCount(); i++) {
            if(matcher.find()){
                for (int j = 0; j < 4; j++) {
                    Pattern namePattern = Pattern.compile("(?i)(name:)(.+?)([;@^*%])");
                    if (namePattern.equals(name[i])) {
                        Pattern pricePattern = Pattern.compile("(?i)(price:)(.+?)([;@^*%])");
                        store(i, pricePattern.toString());    //sends index and cost to store
                    }
                }
            }
        }
        //send broken matcher to store
    }
    public static void store(int i, String s){//takes broken up data and puts into map
        arrayList.add(i, s);

    }
    public static String format(){//takes map and formats for print
    //store()
        //checkCount()
        //
        return  null;
    }
    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        Matcher matcher = pattern(output, "##");
        split(matcher);
        String print = format();

        System.out.println(print);
    }
}
/*
1) turn data to string
2) pattern-matcher by ##
3) use regex on each match
 */