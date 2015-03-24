package Tests;

public class Results {
    private static final String LETTERS = "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя";
    private static final String RESULT_LETTERS = "абвгдежзиклмнопрстуфхцчшщэюя";

    private String inputString;
    private int numOfQuestions;
    private int numOfAnswers;

    private String string;
    private int groupSize;
    private String[] groupOfLetters;
    private String answers = "";

    public Results(int numOfQuestions, int numOfAnswers, String inputString) {
        this.numOfQuestions = numOfQuestions;
        this.numOfAnswers = numOfAnswers;
        this.inputString = inputString;
        this.setString();
        this.setGroupOfLetters();
        this.generateAnswers();
    }

    private void generateAnswers() {
        for (int i = 0; i < this.string.length(); i++) {
            for (int j = 0; j < this.groupOfLetters.length; j++) {
                char letter = this.string.charAt(i);
                if (this.groupOfLetters[j].indexOf(letter) >= 0) {
                    this.answers += RESULT_LETTERS.charAt(j);
                    break;
                }
            }
        }
    }

    private void setString() {
        this.inputString = this.inputString.replace(" ", "");
        this.string = inputString;
        while (this.string.length() < this.numOfQuestions) {
            this.string += this.inputString;
        }
        this.string = this.string.substring(0, this.numOfQuestions);
    }

    private void setGroupSize() {
        this.groupSize = Math.round((LETTERS.length() / 2) / this.numOfAnswers) * 2;
    };

    private void setGroupOfLetters() {
        this.setGroupSize();
        this.groupOfLetters = new String[this.numOfAnswers];
        for (int i = 0; i < this.numOfAnswers; i++) {
            int beginIndex = i * this.groupSize;
            int endIndex;
            if (i == this.numOfAnswers - 1) {
                endIndex = LETTERS.length();
            } else {
                endIndex = beginIndex + this.groupSize;
            }
            this.groupOfLetters[i] = LETTERS.substring(beginIndex, endIndex);
        }
    }

    public void representAnswers() {
        for (int i = 0; i < this.answers.length(); i++) {
            System.out.println((i + 1) + ". " + this.answers.charAt(i));
        }
    }
}
