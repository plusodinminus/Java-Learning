package BattleShip;

import java.util.ArrayList;

public class BattleShip {
    private GameHelper helper = new GameHelper();
    private ArrayList<Ship> shipList = new ArrayList<Ship>();
    private int numOfGuesses = 0;

    public static void run() {
        BattleShip game = new BattleShip();
        game.setUpGame();
        game.startPlaying();
    }

    private void setUpGame() {
        Ship one = new Ship();
        one.setName("Корабль 1");
        Ship two = new Ship();
        two.setName("Корабль 2");
        Ship three = new Ship();
        three.setName("Корабль 3");
        shipList.add(one);
        shipList.add(two);
        shipList.add(three);

        System.out.println("Ваша цель - потопить три корабля.");
        System.out.println("Корабль 1, Корабль 2 и Корабль 3.");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов.");

        for (Ship ship : shipList) {
            ship.setLocationCells(helper.placeShip(3));
        }
    }

    private void startPlaying() {
        while (!shipList.isEmpty()) {
            checkUserGuess(helper.getUserInput("Сделайте ход:"));
        }

        finishGame();
    }

    private void checkUserGuess(String userInput) {
        numOfGuesses++;

        String result = "Мимо";

        for (Ship ship : shipList) {
            result = ship.checkYourself(userInput);

            if (!ship.getIsAlive()) {
                shipList.remove(ship);
                break;
            }
            if (result.equals("Попал")) {
                break;
            }
        }

        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("Все корабли ушли ко дну!");

        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у Вас всего " + numOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того, как ваши корабли утанули.");
        } else {
            System.out.println("Это заняло у Вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хорододы вокруг ваших кораблей.");
        }
    }
}
