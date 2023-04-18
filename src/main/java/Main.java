import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private HashMap hashMap; //buckets will track how many of each thing for count
    private String[]  name = {"Milk", "Bread", "Cookies", "Apples"};
    private String[] outline = {"name:milk;price:3.23;type:food;expiration:1/25/2016", "", "", ""};

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }
    public static Matcher pattern(String s, String splitter){//take dataToString and what will be split on
        //pattern-matcher to break up data
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(splitter);
       // HashMap hashMap = new HashMap<>();
       // StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < matcher.groupCount(); i++) {
//           // hashMap.
//            sb.append(split(matcher.group(i)));
//        }
        return  matcher;
    }
    public static HashMap<String, Double> split(Matcher matcher){//takes broken up data and breaks up further with regex [;:^@] etc
        Pattern pattern = Pattern.compile(matcher.group());
        Matcher m = pattern.matcher()
        for (int i = 0; i < matcher.groupCount(); i++) {

            matcher.;
        }
        return null;
        //send broken matcher to store
    }
    public void store(String s, Double d){//takes broken up data and puts into map
        this.hashMap = hashMap;

    }
    public int checkCount(String s){
        return -1;
    }
    public static void format(){//takes map and formats for print
    //store()
        //checkCount()
        //
    }
    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        Matcher matcher = pattern(output, "##");
        HashMap<String, Double> map = split(matcher);
        System.out.println(output);
    }
}
/*
1) turn data to string
2) pattern-matcher by ##
3) use regex on each match
 */