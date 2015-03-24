package BeerSong;

public class BeerSong {
    public static void run() {
        int beerNum = 99, lastNum;
        String word;

        while (beerNum > 0) {
            lastNum = Math.floorMod(beerNum, 10);
            // Если число бутылок заканчивается на 0, 5, 6, 7, 8, 9 или оно равно 11, 12, 13, 14, пишем "бутылок", например: 11 бутылок
            if (lastNum == 0 || lastNum > 4 || (beerNum > 10 && beerNum < 15)) word = "бутылок";
            // Если число бутылок заканчивается на 2, 3, 4, пишем "бутылки", например: 2 бутылки
            else if (lastNum > 1) word = "бутылки";
            // Если число бутылок заканчивается на 1, пишем "бутылка", например: 1 бутылка
            else word = "бутылка";

            System.out.print(beerNum + " " + word + " пива на столе\n" +
                    beerNum + " " + word + " пива.\n" +
                    "Возьми одну.\n" +
                    "Пусти по кругу.\n\n");

            beerNum--;
        }

        System.out.print("Нет бутылок пива на столе.");
    }
}