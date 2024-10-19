
//Ex. 2.15

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

	    int num1, num2;
	    int sum, diff, prod;
	    float quot;

		System.out.print("Enter num1 = ");
		num1 = scan.nextInt();
		System.out.print("Enter num2 = ");
		num2 = scan.nextInt();

		sum  = num1 + num2;
		diff = num1 - num2;
		prod = num1 * num2;
		quot = (float)num1 / num2;

		System.out.println("Sum = " + sum + " | Diff = " + diff + " | Prod = " + prod + " | Quot = " + quot);
	}
}


//Ex. 2.16


import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

	    int num1, num2;
	    int sum, diff, prod;
	    float quot;

		System.out.print("Enter num1 = ");
		num1 = scan.nextInt();
		System.out.print("Enter num2 = ");
		num2 = scan.nextInt();

		if (num1 == num2)
            System.out.println("This numbers are equal.");
        else if (num1 < num2)
            System.out.printf("Num2 = %d is greater.%n", num2);
        else if (num1 > num2)
            System.out.printf("Num1 = %d is greater.%n", num1);
	}
}


//Ex. 2.17


import java.util.Scanner;           

public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

	    int num1, num2, num3;

		System.out.print("Enter num1 = ");
		num1 = scan.nextInt();
		System.out.print("Enter num2 = ");
		num2 = scan.nextInt();
		System.out.print("Enter num3 = ");
		num3 = scan.nextInt();


	    int sum  = num1 + num2 + num3;
		int avg = sum / 3;
		int prod = num1 * num2 * num3;

		System.out.println("Sum = " + sum + " | Avg = " + avg + " | Prod = " + prod);


        if (num1 < num2)
            if (num2 < num3)
                System.out.printf("Num1 = %d is the smallest.%nNum3 = %d is the largest.", num1, num3);
            else if (num3 < num2)
                if (num3 < num1)
                    System.out.printf("Num3 = %d is the smallest.%nNum2 = %d is the largest.", num3, num2);
                else
                    System.out.printf("Num1 = %d is the smallest.%nNum2 = %d is the largest.", num1, num2);

        else if (num2 < num1)
            if (num1 < num3)
                System.out.printf("Num2 = %d is the smallest.%nNum3 = %d is the largest.", num2, num3);
            else if (num3 < num1)
                if (num3 < num2)
                    System.out.printf("Num3 = %d is the smallest.%nNum1 = %d is the largest.", num3, num1);
                else
                    System.out.printf("Num2 = %d is the smallest.%nNum1 = %d is the largest.", num2, num1);
	}
}


//Ex. 2.24


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nums[] = new int[5];

        System.out.print("Enter num1 = ");
        nums[0] = scan.nextInt();
        System.out.print("Enter num2 = ");
        nums[1] = scan.nextInt();
        System.out.print("Enter num3 = ");
        nums[2] = scan.nextInt();
        System.out.print("Enter num4 = ");
        nums[3] = scan.nextInt();
        System.out.print("Enter num5 = ");
        nums[4] = scan.nextInt();

        int min = nums[0], max = nums[0];

        for (int i = 0; i < 5; i++){
            if (nums[i] < min) min = nums[i];
            if (max < nums[i]) max = nums[i];
        }

        System.out.printf("%d is the smallest.%n%d is the largest.", min, max);
    }
}


//Ex. 2.25


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = scan.nextInt();

        if (num % 2 == 0) System.out.printf("Number %d is even", num);
        else System.out.printf("Number %d is odd", num);
    }
}


//Ex. 2.26


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter num1 =  ");
        int num1 = scan.nextInt();
        System.out.print("Enter num2 =  ");
        int num2 = scan.nextInt();

        if (num1 % num2 == 0) {
            System.out.printf("%d is multiple of %d%n", num1, num2);
            System.out.printf("The whole part of the division num1/num2 = %d, and the remainder = %d", num1/num2, num1%num2);
        }
        else {
            System.out.printf("%d isn't multiple of %d%n", num1, num2);
            System.out.printf("The whole part of the division num1/num2 = %d, and the remainder = %d", num1/num2, num1%num2);
        }
    }
}


//Ex. 2.28


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the radius =  ");
        int radius = scan.nextInt();

        System.out.printf("Diameter = %.2f%nCircumference = %.4f%nArea = %.4f",
                2 * (float)radius,
                2 * Math.PI * (float)radius,
                Math.PI * (float)radius * (float)radius);
    }
}


//Ex. 2.30


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the five digit number =  ");
        int num = scan.nextInt();

        System.out.printf("%d   %d   %d   %d   %d", num%100000/10000, num%10000/1000, num%1000/100, num%100/10, num%10);
    }
}


//Ex. 2.31


public class Main
{
    public static void main(String[] args) {

        System.out.println("number | square | cube");

        for (int i = 0; i < 10; i++)
            System.out.printf("  %d       %d       %d   %n", i, i*i, i*i*i);
    }
}


//Ex. 2.32


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nums[] = new int[5];

        System.out.print("Enter num1 = ");
        nums[0] = scan.nextInt();
        System.out.print("Enter num2 = ");
        nums[1] = scan.nextInt();
        System.out.print("Enter num3 = ");
        nums[2] = scan.nextInt();
        System.out.print("Enter num4 = ");
        nums[3] = scan.nextInt();
        System.out.print("Enter num5 = ");
        nums[4] = scan.nextInt();

        int countNeg = 0, countPos = 0, countZeros = 0;

        for (int i = 0; i < 5; i++){
            if (nums[i] < 0) countNeg++;
            if (nums[i] == 0) countZeros++;
            if (nums[i] > 0) countPos++;
        }

        System.out.printf("%d negative %n%d positive %n%d zeros", countNeg, countZeros, countPos);
    }
}