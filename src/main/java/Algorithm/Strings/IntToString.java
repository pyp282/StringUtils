package Algorithm.Strings;

public class IntToString {
    public static String transform(int number) {
        boolean isNegative = false;
        StringBuilder sb = new StringBuilder();
        if (number == 0) {
            return "0";
        }

        if (number < 0){
            isNegative = true;
        }
            number = Math.abs(number);
        while (number > 0){
            sb.append(number % 10);
            number = number/10;
        }
        if(isNegative)
            sb.append("-");

        return sb.reverse().toString();
    }

}
