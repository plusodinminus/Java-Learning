package BattleShip;

import java.util.ArrayList;

public class Ship {
    private String name;
    private ArrayList<String> locationCells;
    private boolean isAlive = true;

    public String checkYourself(String stringGuess) {
        String result = "Мимо";

        int index = locationCells.indexOf(stringGuess);

        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "Потопил";
                System.out.println("Ой! Вы потопили " + name + " :'(");
                isAlive = false;
            } else {
                result = "Попал";
            }
        }

        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }
}
