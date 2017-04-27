package Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {
       // validating();
//        replace();
        String s = "welcome to join sfsf";
        String[] strings = s.split("\\s");
        int count = 0;
        for (String string : strings) {

            System.out.println(string + count++);
        }
    }

    public static void validating() {
        List<String> input = new ArrayList<String>();

        input.add("123-45-6789");
        input.add("9876-5-4321");
        input.add("987-65-4321 (attack)");
        input.add("987-65-4321 ");
        input.add("192-83-7465");

        for(String phone : input){
            if(phone.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")){
                System.out.println(phone);
            }
        }

        for (String ssn : input) {
            if (ssn.matches("\\b\\d{3}-?\\d{2}-?\\d{4}\\b")) {
                System.out.println("Found good SSN: " + ssn);
            }
        }
    }

    public static void replace() {
        String input =
                "User clientId=23421. Some more text clientId=33432. This clientNum=100";

        Pattern pattern = Pattern.compile("(clientId=)(\\d+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println("Masking = " + matcher.group(2));

        }
    }

    
}
