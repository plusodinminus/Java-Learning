package Game;

public class Player {
    // переменная хранит число, которое выбрал игрок
    public int chosenNumber;
    public String playerName;

    // TODO
    private String[] playerNames = {"Алексей", "Юрий", "Василий", "Евгений", "Андрей", "Сергей"};

    // функция для угадывания числа игроком
    public void thinkANumber() {
        // пытаемся угадать число, выбрав случайно число от 0 до 9
        this.chosenNumber = (int) (Math.random() * 10);
    }

    // TODO
    public void generatePlayerName() {
        this.playerName = this.playerNames[(int) (Math.random() * this.playerNames.length)];
    }
}
