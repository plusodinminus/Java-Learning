package Game;

import java.util.Scanner;

public class Game {
    public int amountOfPlayers, targetNumber;
    public Player[] players;

    public Game() {
        // загадываем число
        this.thinkATargetNumber();
    }

    public static void run() {
        Game myGame = new Game();

        // Вводим число игроков с клавиатуры
        System.out.print("Введите число игроков: ");
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        System.out.println();

        // запускаем игру для amount-числа игроков
        myGame.startGame(amount);
    }

    public void startGame(int playersNumber) {
        // сохраняем число игроков внутри объекта, чтобы его можно было использовать другим функциям
        this.amountOfPlayers = playersNumber;

        // создаем игроков
        this.players = new Player[playersNumber];
        for (int i = 0; i < playersNumber; i++) {
            this.players[i] = new Player();
            this.players[i].generatePlayerName();
        }

        // пытаемся угадать загаданное число
        this.thinkANumbers();

        // создаем переменную для хранения числа попыток
        int tryNumber = 1;

        // и переменную для прекращения выполнения цикла
        boolean breakWhile = false;
        while (!breakWhile) {
            // начинаем проверять, угадал ли кто-нибудь наше загаданное число
            for (int i = 0; i < playersNumber; i++) {
                // если число угадано верно
                if (this.numberIsRight(this.players[i].chosenNumber)) {
                    System.out.print("Попытка №" + tryNumber + "\n" +
                            "Игра закончена! Загаданное число - " + this.targetNumber + "\n");

                    // показываем, что загадал каждый игрок
                    for (int j = 0; j < playersNumber; j++) {
                        System.out.print((j + 1) + ". " + this.players[j].playerName + " загадал число " + this.players[j].chosenNumber + "\n");
                    }

                    // прекращаем работу программы
                    breakWhile = true;
                    break;
                }
            }

            // если никто не угадал задуманное число
            if (!breakWhile) {
                System.out.print("Попытка №" + tryNumber + "\n" +
                        "Никто не смог угадать число! Попробуем еще раз!\n\n");

                // пробуем угадать еще раз
                this.thinkANumbers();

                // увеличиваем число попыток
                tryNumber++;
            }
        }
    }

    // функция для задумывания числа
    public void thinkATargetNumber() {
        // загадываем число от 0 до 9
        this.targetNumber = (int) (Math.random() * 10);
    }

    // функция для угадывания числа игроками
    public void thinkANumbers() {
        for (int i = 0; i < this.amountOfPlayers; i++) {
            // игрок пытается угадать число
            this.players[i].thinkANumber();
        }
    }

    // функция для проверки правильности угадывания числа игроком
    public boolean numberIsRight(int verifiedNumber) {
        // если игрок угадал, возвращаем true, иначе - false
        return verifiedNumber == this.targetNumber;
    }
}
