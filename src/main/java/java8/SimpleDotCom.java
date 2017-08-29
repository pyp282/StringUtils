package java8;

/**
 * Created by bys on 26/06/2017.
 */
public class SimpleDotCom {
    int[] locationCells;
    int numberOfHits = 0;

    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }

    public String checkYourself(String strGuess) {
        int guess = Integer.parseInt(strGuess);
        String result = "miss";

        for (int cell : locationCells) {
            if(cell == guess) {
                result = "hit";
                numberOfHits++;
                if(numberOfHits == locationCells.length) {
                    result = "kill";
                }

                break;
            }

        }
        System.out.println(result);
        return result;
    }

}
