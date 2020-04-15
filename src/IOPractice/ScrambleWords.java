package IOPractice;

import java.util.Random;

public class ScrambleWords {

    public static void main(String[] args) {
        Random random = new Random();

        String s = "gianni";

        System.out.println(s);

        String newS = "";

        for (int i = 0; i < s.length(); i++) {
            int randomInt = new Random().nextInt(s.length());
            char c = s.charAt(randomInt);
            newS += c;
        }

        System.out.println(newS);
    }
}
