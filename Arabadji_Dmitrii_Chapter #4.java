

//Ex. 4.17

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int quit = 0;
        int miles, gallons;
        int count = 1;
        int milesAll = 0;
        int gallonsAll = 0;

        while (quit != -1){
            System.out.printf("Enter data for trip № %d%n", count);
            System.out.print("Enter miles: ");
            miles = scan.nextInt();
            System.out.print("Enter gallons: ");
            gallons = scan.nextInt();

            System.out.printf("For this trip miles/gallon = %.2f %n", (float)miles / gallons);

            milesAll += miles;
            gallonsAll += gallons;
            count++;

            System.out.printf("%nDo you want to quit? (Yes -> input -1 , No -> input 0): ");
            quit = scan.nextInt();
            System.out.println();
        }

        System.out.printf("For %d entered trips combined miles/gallon = %.2f %n", count-1, (float)milesAll /  gallonsAll);
    }
}


//Ex. 4.18


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = 1, quit = 0;
        int accountNumber;
        int beginBalance;
        int chargedSum;
        int creditSum;
        int allowedCreditLimit;
        int curBalance;

        while (quit != -1) {
            System.out.printf("|Enter customer №%d balance data|:%n", count);

            System.out.print("Enter account number: ");
            accountNumber = scan.nextInt();
            System.out.print("Enter balance at the beginning of the month: ");
            beginBalance = scan.nextInt();
            System.out.print("Enter total of all items charged by the customer this month: ");
            chargedSum = scan.nextInt();
            System.out.print("Enter total of all credits applied to the customer’s account this month: ");
            creditSum = scan.nextInt();
            System.out.print("Enter allowed credit limits: ");
            allowedCreditLimit = scan.nextInt();

            curBalance = beginBalance + chargedSum - creditSum;

            System.out.printf("%nCustomer №%d current balance %d", count, curBalance);

            if (curBalance < -1*allowedCreditLimit)
                System.out.printf("%n!!!Credit limit exceeded!!!%n");

            System.out.printf("%nDo you want to quit? (Yes -> input -1 , No -> input 0): ");
            quit = scan.nextInt();
            System.out.println();

            count++;
        }
    }
}


//Ex. 4.19


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = 1, quit = 0;
        float[][] items = new float[2][4];
        float earning = 0;

        items[0][0] = 239.99f;
        items[0][1] = 129.75f;
        items[0][2] = 99.95f;
        items[0][3] = 350.89f;

        while (quit != -1){
            System.out.printf("Enter quantity of each item sold by salesperson №%d:%n", count);

            System.out.print("Item [1] quantity: ");
            items[1][0] = scan.nextInt();
            System.out.print("Item [2] quantity: ");
            items[1][1] = scan.nextInt();
            System.out.print("Item [3] quantity: ");
            items[1][2] = scan.nextInt();
            System.out.print("Item [4] quantity: ");
            items[1][3] = scan.nextInt();

            for (int i = 0; i < items[0].length; i++) {
                earning += items[0][i] * items[1][i];
            }

            System.out.printf("The earning is %.2f $", earning);

            System.out.printf("%nDo you want to quit? (Yes -> input -1 , No -> input 0): ");
            quit = scan.nextInt();
            System.out.println();

            count++;
            earning = 0;
        }

    }
}


//Ex. 4.20


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        float salary, hourlyWage;
        int hoursWorked;
        int count = 1;

        while (count <= 3){

            System.out.printf("Enter monthly salary for employee №%d: ", count);
            salary = scan.nextFloat();

            hourlyWage = salary / 40;

            System.out.printf("Enter hours worked for employee №%d: ", count);
            hoursWorked = scan.nextInt();

            if (hoursWorked == 40)
                System.out.printf("The gross pay is %.2f $", salary);
            else if (hoursWorked > 40)
                System.out.printf("The gross pay is %.2f $%n%n", salary + (hourlyWage/2 * (hoursWorked - 40)));

            count++;
        }

    }
}


//Ex. 4.21


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = 1;
        int recentNumber;
        int largest;

        System.out.printf("Enter number <%d>: ", count);
        largest = scan.nextInt();
        count++;

        while (count <= 10){

            System.out.printf("Enter number <%d>: ", count);
            recentNumber = scan.nextInt();

            if (recentNumber > largest) { largest = recentNumber; }
            count++;
        }

        System.out.printf("The largest number is %d ", largest);
    }
}


//Ex. 4.22


public class Main
{
    public static void main(String[] args) {

        int n = 1;

        System.out.println("N     10*N     100*N      1000*N");
        while (n <= 5){
            System.out.printf("%d     %d       %d        %d%n", n, n*10, n*100, n*1000);
            n = n + 1;
        }
    }
}


//Ex. 4.23


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = 1;
        int recentNumber;
        int largest, second_largest;

        System.out.printf("Enter number <%d>: ", count);
        largest = scan.nextInt();
        count++;
        System.out.printf("Enter number <%d>: ", count);
        second_largest = scan.nextInt();
        count++;

        while (count <= 10){

            System.out.printf("Enter number <%d>: ", count);
            recentNumber = scan.nextInt();

            if (recentNumber > largest) {
                second_largest = largest;
                largest = recentNumber;
            }
            else if (recentNumber > second_largest) {
                second_largest = recentNumber;
            }
            count++;
        }

        System.out.printf("The largest number is %d%n", largest);
        System.out.printf("Second largest number is %d ", second_largest);
    }
}


//Ex. 4.24


import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int passes = 0;
        int failures = 0;
        int studentCounter = 1;

        while (studentCounter <= 10)
        {
            System.out.print("Enter result (1 = pass, 2 = fail): ");
            int result = input.nextInt();

            if (result == 1 || result == 2)
            {
                if (result == 1)
                    passes = passes + 1;
                else
                    failures = failures + 1;

                studentCounter = studentCounter + 1;
            }
        }

        System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);

        if (passes > 8)
            System.out.println("Bonus to instructor!");
    }
}


//Ex. 4.29


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int squareSize, counter = 0, innerCounter = 0;

        System.out.println("Enter square size (1-20): ");
        squareSize = scan.nextInt();
        System.out.println();

        while (counter < squareSize) {
            System.out.print("*");
            counter++;
        }
        counter = 0;

        while (counter < squareSize - 2) {
            System.out.printf("%n*");

            while (innerCounter < squareSize - 2) {
                System.out.print(" ");
                innerCounter++;
            }
            innerCounter = 0;

            System.out.printf("*");

            counter++;
        }
        counter = 0;

        System.out.println();
        while (counter < squareSize) {
            System.out.print("*");
            counter++;
        }
    }
}