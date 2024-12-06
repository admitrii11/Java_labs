//Ex. 14.5

import java.security.SecureRandom;

public class Main {

    static final SecureRandom randomGenerator = new SecureRandom();

    public static void main(String[] args) {
        String[] article = new String[] {"the", "a", "one", "some", "any"};
        String[] noun = new String[] {"boy", "girl", "dog", "town", "car"};
        String[] verb = new String[] {"drove", "jumped", "ran", "walked", "skipped"};
        String[] preposition = new String[] {"to", "from", "over", "under", "on"};

        for (int i = 0; i < 20; i++) {
            int randArticle = randomGenerator.nextInt(5);
            int randNoun = randomGenerator.nextInt(5);
            int randVerb = randomGenerator.nextInt(5);
            int randPreposition = randomGenerator.nextInt(5);

            String sentence = article[randArticle].substring(0, 1).toUpperCase() + article[randArticle].substring(1)
                    + " " + noun[randNoun]
                    + " " + verb[randVerb]
                    + " " + preposition[randPreposition] + ".";

            System.out.println(sentence);
        }
    }
}


//Ex. 14.7

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputSentence = scan.nextLine();

        inputSentence = inputSentence.replaceAll("[^A-Za-z ]+", "");

        String[] inputArr = inputSentence.split(" ");

        StringBuilder builder = new StringBuilder();

        for (String word : inputArr) {
            word = word.substring(1) + word.substring(0, 1) + "ay";
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(word);
        }

        String outputSentence = builder.toString();;

        System.out.println(outputSentence);
    }
}


//Ex. 14.9

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputSentence = scan.nextLine();

        inputSentence = inputSentence.replaceAll("[^A-Za-z ]+", "");

        String[] inputArr = inputSentence.split(" ");

        StringBuilder builder = new StringBuilder();

        for (int i = inputArr.length - 1; i >= 0; i--) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(inputArr[i]);
        }

        String outputSentence = builder.toString();;

        System.out.println(outputSentence);
    }
}
