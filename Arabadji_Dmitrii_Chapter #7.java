//Ex. 7.12

import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> arr = new ArrayList<Integer>();

        System.out.println("|Enter five numbers|");

        System.out.print("Enter number [1]: ");
        arr.add(scan.nextInt());

        int tmp; boolean bool;
        for (int i = 1; i < 5; i++) {
            System.out.printf("Enter number [%d]: ", i+1);
            tmp = scan.nextInt();

            bool = true;
            for (int j : arr) {
                if (tmp == j) {
                    bool = false;
                    break;
                }
            }

            if (bool) {
                System.out.printf("This number is unique so far.%n");
                arr.add(tmp);
            }
            else {
                System.out.printf("This number is repetitive!!!%n");
            }

            System.out.print("Current array: ");
            for (int num : arr)
                System.out.printf("%d ", num);

            System.out.println();
        }

        System.out.printf("%nThe size of the array with unique values is %d", arr.size());
    }
}


//Ex. 7.14

public class Main
{
    public static void main(String[] args) {

        int num1 = 14, num2 = 8;
        double num3 = 7.5, num4 = 9.84;

        double[] vals = {3.4, 2.5, 7.1, 8.25};

        System.out.print("Passing 2 int variables casted to double: ");
        System.out.printf("num1 = %d and num2 = %d%n", num1, num2);
        System.out.printf("The result is %.2f (explicit and automated casting)%n%n", product((double)num1, num2));

        System.out.print("Passing 3 variables: ");
        System.out.printf("num2 = %d, num3 = %.2f, num4 = %.2f%n", num2, num3, num4);
        System.out.printf("The result is %.2f%n%n", product(num2, num3, num4));

        System.out.print("Passing 4 variables: ");
        System.out.printf("num1 = %d, num2 = %d, num3 = %.2f, num4 = %.2f%n", num1, num2, num3, num4);
        System.out.printf("The result is %.2f%n%n", product(num1, num2, num3, num4));

        System.out.println("----------------------------------------------------------------");

        System.out.print("Passing an array of 4 double values: ");
        System.out.printf("vals[0] = %.2f, vals[1] = %.2f, vals[2] = %.2f, vals[3] = %.2f%n", vals[0], vals[1], vals[2], vals[3]);
        System.out.printf("The result is %.2f", product(vals));
    }

    public static double product(double... numbers){
        double result = 1.0;

        for (double num : numbers) {
            result *= num;
        }

        return result;
    }
}


//Ex. 7.15

public class Main
{
    public static void main(String[] args)
    {
        int[] array;
        int arraySize = 0;
        boolean isNumber = true;

        if (args[0] != null && !args[0].isEmpty()) {

            for (char c : args[0].toCharArray()) {
                if (!Character.isDigit(c)) {
                    isNumber = false;
                    break;
                }
            }

            if (isNumber && Integer.parseInt(args[0]) > 0) {
                arraySize = Integer.parseInt(args[0]);
                System.out.println("ues");
            }
            else {
                arraySize = 10;
            }
        }
        else {
            arraySize = 10;
        }

        array = new int[arraySize];


        System.out.printf("%s%8s%n", "Index", "Value");

        for (int counter = 0; counter < array.length; counter++)
            System.out.printf("%5d%8d%n", counter, array[counter]);
    }
}


//Ex. 7.17

import java.security.SecureRandom;

public class Main
{
    private static final SecureRandom randomNumbers = new SecureRandom();

    public static void main(String[] args)
    {
        int[] sums = new int[11];
        int face1 = 0, face2 = 0;

        for (int roll = 0; roll <= 36_000_0; roll++)
        {
            face1 = 1 + randomNumbers.nextInt(6);
            face2 = 1 + randomNumbers.nextInt(6);

            sums[face1 + face2 - 2]++;
        }

        System.out.println();
        for (int i = 0; i < sums.length; i++) {
            System.out.printf("%-2d |  %-6d |", i+2, sums[i]);
            System.out.println();
        }

    }
}


//Ex. 7.18

import java.security.SecureRandom;

public class Main
{
    private static final SecureRandom randomNumbers = new SecureRandom();

    private enum Status {CONTINUE, WON, LOST};

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args)
    {
        int myPoint = 0;
        Status gameStatus;

        int winTime = 0;
        int lostTime = 0;

        final int arrSize = 40;
        int[] winArr = new int[arrSize];
        int[] lostArr = new int[arrSize];


        for(int i = 0; i < 1_000_00; i++) {
            int sumOfDice = rollDice();

            winTime = 1;
            lostTime = 1;

            switch (sumOfDice) {
                case SEVEN:
                case YO_LEVEN:
                    gameStatus = Status.WON;
                    break;
                case SNAKE_EYES:
                case TREY:
                case BOX_CARS:
                    gameStatus = Status.LOST;
                    break;
                default:
                    gameStatus = Status.CONTINUE;
                    myPoint = sumOfDice;
                    break;
            }


            while (gameStatus == Status.CONTINUE) {
                sumOfDice = rollDice();

                if (winTime < arrSize - 1) {
                    winTime++;
                }
                if (lostTime < arrSize - 1){
                    lostTime++;
                }

                if (sumOfDice == myPoint) {
                    gameStatus = Status.WON;
                }
                else if (sumOfDice == SEVEN) {
                    gameStatus = Status.LOST;
                }
            }

            if (gameStatus == Status.WON) {
                winArr[winTime]++;
            }
            else {
                lostArr[lostTime]++;
            }
        }

        for (int i = 1; i < winArr.length; i++) {
            System.out.printf("%-2d |  %-6d |  %-6d |", i, winArr[i], lostArr[i]);
            System.out.println();
        }

    }


    public static int rollDice()
    {
        int die1 = 1 + randomNumbers.nextInt(6); // first die roll
        int die2 = 1 + randomNumbers.nextInt(6); // second die roll

        return die1 + die2;
    }
}