//Ex. 6.8

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of yesterday clients: ");
        int[] yesterday_clients = new int[scan.nextInt()];

        System.out.print("Enter number of today clients: ");
        int[] today_clients = new int[scan.nextInt()];


        System.out.printf("%n|Parking clients data input|%n%n");


        System.out.println("Enter info about yesterday clients: ");

        int count = 0;
        while (true) {
            System.out.printf("Enter hours parked for the client [%d]: ", count+1);
            yesterday_clients[count] = scan.nextInt();
            if (++count == yesterday_clients.length) break;
        }


        System.out.printf("%nEnter info about today clients: %n");

        count = 0;
        while (true) {
            System.out.printf("Enter hours parked for the client [%d]: ", count+1);
            today_clients[count] = scan.nextInt();
            if (++count == today_clients.length) break;
        }


        float[] yesterday_charges = new float[yesterday_clients.length];
        yesterday_charges = calculateCharges(yesterday_clients);

        float[] today_charges = new float[today_clients.length];
        today_charges = calculateCharges(today_clients);


        System.out.printf("%n|Displaying clients charges|%n%n");

        System.out.printf("            Yesterday clients         %n");
        System.out.printf("| Client Num | Hours Parked | Charge |%n");
        System.out.printf("|------------------------------------|%n");
        for (int i = 0; i < yesterday_clients.length; i++) {
            System.out.printf("|     %-7d|      %-8d|  %-6.2f|%n", i+1, yesterday_clients[i], yesterday_charges[i]);
        }
        System.out.printf("|------------------------------------|%n%n");


        System.out.printf("              Today clients           %n");
        System.out.printf("| Client Num | Hours Parked | Charge |%n");
        System.out.printf("|------------------------------------|%n");
        for (int i = 0; i < today_clients.length; i++) {
            System.out.printf("|     %-7d|      %-8d|  %-6.2f|%n", i+1, today_clients[i], today_charges[i]);
        }
        System.out.printf("|------------------------------------|");

    }

    public static float[] calculateCharges(int[] clientsHours) {
        float[] charges = new float[clientsHours.length];
        for (int i = 0; i < clientsHours.length; i++) {

            if (clientsHours[i] <= 3) charges[i] = 2f;
            else if (clientsHours[i] >= 19 && clientsHours[i] <=24) charges[i] = 10f;
            else if (clientsHours[i] > 3) {
                charges[i] = 2 + (clientsHours[i] - 3) * 0.5f;
            }
        }
        return charges;
    }

}


//Ex. 6.15

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double leg1, leg2;

        while (true) {
            System.out.println("Enter legs values (or -1 to exit): ");
            if ((leg1 = scan.nextDouble()) < 0 || (leg2 = scan.nextDouble()) < 0)
                break;

            System.out.printf("Hypotenuse is %.2f", Hypotenuse(leg1, leg2));

            System.out.println();
        }
    }

    public static double Hypotenuse(double leg1, double leg2) {
        return Math.sqrt(Math.pow(leg1, 2) + Math.pow(leg2, 2));
    }
}


//Ex. 6.19

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter square size: ");
        int squareSize = scan.nextInt();

        System.out.println("Enter fill character: ");
        char fillChar = scan.next().charAt(0);
        System.out.println();


        squareOfChars(squareSize, fillChar);
    }

    public static void squareOfChars(int squareSize, char fillChar) {
        int counter = 0, innerCounter = 0;

        while (counter < squareSize) {
            System.out.printf("%n");

            while (innerCounter < squareSize) {
                System.out.printf("%c", fillChar);
                innerCounter++;
            }
            innerCounter = 0;

            counter++;
        }
    }

}


//Ex. 6.20

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the radius =  ");
        int radius = scan.nextInt();
        
        System.out.printf("Area = %.4f", circleArea(radius));
        
    }
    
    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }
    
}


//Ex. 6.22

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double cels, fahren;

        System.out.print("Enter temperature in celsius degrees: ");
        cels = scan.nextDouble();

        System.out.printf("Converted in fahrenheit degrees: %.2f°%n", Fahrenheit(cels));

        System.out.print("Enter temperature in fahrenheit degrees: ");
        fahren = scan.nextDouble();

        System.out.printf("Converted in celsius degrees: %.2f°", Celsius(fahren));
    }

    static double Celsius(double fahrenheit) {
        return 5.0 / 9.0 * (fahrenheit - 32);
    }

    static double Fahrenheit(double celsius) {
        return 9.0 / 5.0 * celsius + 32;
    }

}


//Ex. 6.26

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number =  ");
        int num = scan.nextInt();
        int Div = 10;
        int Diver = 1;
        int size = 1;

        while(true) {
            if (num/Div == 0) break;
            size++;
            Div *= 10;
        }
        Div = 10;

        System.out.printf("size: %d%n", size);


        int[] decArr = new int[size];
        int mult = 1;
        for (int i = 0; i < size; i++) {
            decArr[i] = mult;
            mult *= 10;
            System.out.printf("%d ", decArr[i]);
        }
        System.out.println();

        int zerosCount = 0; 
        int count = 0;
        int newNum = 0;
        while (count < size){
            if (num%Div/Diver == 0) zerosCount++;  
            newNum += num%Div/Diver * decArr[size - 1 - count];
            count++;
            Div *= 10;
            Diver *= 10;
        }

        for (int i = 0; i < zerosCount; i++)  
            System.out.printf("%d", 0);        

        System.out.printf("%d", newNum);

    }
}


//Ex. 6.29

import java.security.SecureRandom;
        import java.util.Scanner;

public class Main
{
    private static enum Coin { HEAD, TAIL };

    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        int frequencyHead = 0;
        int frequencyTail = 0;
        int face;
        Coin coinFace = Coin.TAIL;

        System.out.println("Enter 0 to toss (-1 to exit)");

        while(scan.nextInt() >= 0) {

            int randNumOfFlips = 1 + randomNumbers.nextInt(10000);

            System.out.printf("Random num of flips: %d%n%n", randNumOfFlips);

            for (int flips = 1; flips <= randNumOfFlips; flips++)
            {
                face = 1 + randomNumbers.nextInt(2);

                switch (face)
                {
                    case 1:
                        frequencyHead++;
                        coinFace = Coin.HEAD;
                        break;
                    case 2:
                        frequencyTail++;
                        coinFace = Coin.TAIL;
                        break;
                }
            }



            System.out.println("Face\tFrequency");
            System.out.printf("1\t%d%n2\t%d%n%n", frequencyHead, frequencyTail);
            frequencyHead = 0;
            frequencyTail = 0;

            if (coinFace == Coin.HEAD)
                System.out.printf("The last > Head");
            else
                System.out.printf("The last > Tail");

            System.out.printf("%n%n");
        }
    }
}