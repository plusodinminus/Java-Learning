package SimpleBattleShip;

import java.util.ArrayList;

public class Ship {
    private ArrayList<String> locationCells;
    private int numOfHits = 0;
    private boolean isAlive = true;

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);

        String result = "Мимо";

        int index = locationCells.indexOf(stringGuess);

        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "Потопил";
                isAlive = false;
            } else {
                result = "Попал";
            }
        }

        System.out.println(result);

        return result;
    }

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }
}
