import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static ArrayList<String> milk =new ArrayList<>();
    private static ArrayList<String> bread =new ArrayList<>();
    private static ArrayList<String> cookies =new ArrayList<>();
    private static ArrayList<String> apples =new ArrayList<>();
      private static ArrayList<ArrayList<String>> arrayList = new ArrayList<>(); ///0 milk 1 bread 2 cookies 3 apples

    public static void main(String[] args) throws Exception{
        arrayList.add(milk);
        arrayList.add(bread);
        arrayList.add(cookies);
        arrayList.add(apples);
        String output = (new Main()).readRawDataToString();
        Matcher matcher = pattern(output, "##");
        split(matcher);

        System.out.println(format());
    }
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
                    Pattern namePattern = Pattern.compile("(?<=name:)(.+?)(?=;price)");
                    Matcher nameMatch = namePattern.matcher(matcher.group());
                    if (nameMatch.group().toLowerCase().equals(name[i])) {
                        Pattern pricePattern = Pattern.compile("(?<=price:)(.+?)(?=;type)");
                        store(i, pricePattern.toString());    //sends index and cost to store
                        System.out.println("hiuh");
                    }
                }
            }
        }
        //send broken matcher to store
    }
    public static void store(int i, String s){//takes broken up data and puts into map
        arrayList.get(i).add(i, s);
    }
    public static String format(){//takes map and formats for print
    //store()
        String s = ("name:    Milk \t\t seen: "+ arrayList.get(0).size() + " times\n" +
                "============= \t \t =============\n" +
                "Price: \t 3.23\t\t seen: 5 times\n" +
                "-------------\t\t -------------\n" +
                "Price:   1.23\t\t seen: 1 time\n" +
                "\n" +
                "name:    Bread \t\t seen: "+ arrayList.get(1).size() + " times\n" +
                "=============\t\t =============\n" +
                "Price:   1.23\t\t seen: 6 times\n" +
                "-------------\t\t -------------\n" +
                "\n" +
                "name:    Cookies \t\t seen: "+ arrayList.get(2).size() + " times\n" +
                "=============     \t =============\n" +
                "Price:   2.25        seen: 8 times\n" +
                "-------------        -------------\n" +
                "\n" +
                "name:    Apples \t\t seen: "+ arrayList.get(3).size() + " times\n" +
                "=============     \t =============\n" +
                "Price:   0.25     \t seen: 2 times\n" +
                "-------------     \t -------------\n" +
                "Price:   0.23  \t \t seen: 2 times\n" +
                "\n" +
                "Errors         \t \t seen: 4 times\n");
        //checkCount()
        //
        return  s;
    }

}
/*
1) turn data to string
2) pattern-matcher by ##
3) use regex on each match
 */