package SimpleBattleShip;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleShip {
    public static void run() {
        int numOfGuesses = 0;
        Ship ship = new Ship();
        int randomNum = (int) (Math.random() * 5);

        ArrayList<String> locations = new ArrayList<String>();
        locations.add(Integer.toString(randomNum));
        locations.add(Integer.toString(randomNum + 1));
        locations.add(Integer.toString(randomNum + 2));

        ship.setLocationCells(locations);

        GameHelper helper = new GameHelper();
        String guess;

        while (ship.getIsAlive()) {
            guess = helper.getUserInput("Введите число:");
            ship.checkYourself(guess);
            numOfGuesses++;
        }

        System.out.println("Вам понадобилось " + numOfGuesses + " попыток(и)");
    }

    /*public static void test() {
        Ship ship = new Ship();

        int[] locations = {2, 3, 4};
        ship.setLocationCells(locations);

        String userGuess = "2";

        String result = ship.checkYourself(userGuess);

        String testResult = "Неудача";
        if (result.equals("Попал")) {
            testResult = "Пройден";
        }

        System.out.println(testResult);
    }*/
}
