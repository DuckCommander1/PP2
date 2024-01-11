import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static String input;
    static String tokens;
    static StringTokenizer token;
    static ArrayList<String> dates = new ArrayList<>();
    static ArrayList<String> rest = new ArrayList<>();
    static ArrayList<Integer> nums= new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input string:");
        input = in.nextLine();
        input = toString(input);
        System.out.println(input);

        System.out.println("Input tokens:");
        tokens = in.nextLine();

        token = new StringTokenizer(input, tokens);
        //while(token.hasMoreTokens()) {
           //String a = token.nextToken();
           //System.out.println(a);
        //}
        lookForDate();
        printResults();
    }

    private static String toString(String str) {
        int a = (int)(Math.random()*100);

        return str + a;
    }

    public static void printResults()
    {
        System.out.println("Found dates:");
        for(String a: dates){
            System.out.println(a);
        }

        System.out.println("Found numbers:");
        for(Integer a: nums) {
            System.out.println(a);
        }

        System.out.println("Rest of strings:");
        for(String a: rest){
            if(!a.isEmpty())
                System.out.println(a);
        }
    }
    public static void lookForDate()
    {
        String regex = "\\d{2}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);

        while(token.hasMoreTokens()) {
            String a = token.nextToken();
            a = a.replaceAll("\\(.*?\\)", "");
            Matcher matcher = pattern.matcher(a);
            while(matcher.find())
            {
                dates.add(matcher.group());
            }

            String new_txt = a.replaceAll(regex, "");
            try {
                nums.add(Integer.parseInt(new_txt));
            }
            catch (NumberFormatException e) {
                rest.add(new_txt);
            }
        }
    }
}