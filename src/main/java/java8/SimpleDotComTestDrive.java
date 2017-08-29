package java8;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by bys on 26/06/2017.
 */
public class SimpleDotComTestDrive {
    public static void main(String[] args) throws IOException {
        SimpleDotCom dot = new SimpleDotCom();

        int[] location = {2, 3, 4};
        dot.setLocationCells(location);
        boolean flag = true;

        while (flag) {
            System.out.print("enter a number ");
            Scanner scanner = new Scanner(System.in);
            String userGuess = scanner.nextLine();

            String result = dot.checkYourself(userGuess);

            if(result.equals("kill")) {
                flag = false;
            }
        }

    }
}
