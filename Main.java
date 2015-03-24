import Tests.Results;

public class Main {
    public static void main(String[] args) {
        Results testResults = new Results(20, 4, "Купрейчик Алексей");
        System.out.println("Ответы на тест:");
        testResults.representAnswers();
    }
}
