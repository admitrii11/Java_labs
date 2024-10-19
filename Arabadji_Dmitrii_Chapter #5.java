

//Ex. 5.11


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of input values: ");
        int inputNum = scan.nextInt();

        int[] arr = new int[inputNum];

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter element [%d]: ", i);
            arr[i] = scan.nextInt();
        }

        int min = arr[0], index = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }

        System.out.printf("The smallest is arr[%d] = %d", index, min);
    }
}


//Ex. 5.16


import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = new int[5];
        
        System.out.println("|Enter five numbers|");
        
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter number [%d]: ", i);
            arr[i] = scan.nextInt();
        }
        
        System.out.println();
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


//Ex. 5.17


import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);

        int productType, quantity;
        double price = 1, proceed, retailValue = 0;
        boolean wrongProduct = false;

        System.out.println("Enter data to compute (or -1 to exit): ");

        while (true) {

            System.out.print("Enter product type: ");
            productType = scan.nextInt();

            if (productType < 0 ) break;

            switch (productType){
                case 1: price = 2.98;
                    break;
                case 2: price = 4.50;
                    break;
                case 3: price = 9.98;
                    break;
                case 4: price = 4.49;
                    break;
                case 5: price = 6.87;
                    break;
                default:
                    wrongProduct = true;
                    break;
            }

            if (wrongProduct) {
                System.out.println("Entered product type doesn't exist");
                continue;
            }

            System.out.print("Enter quantity sold: ");
            quantity = scan.nextInt();

            if (quantity < 0 ) break;

            proceed = price * quantity;

            System.out.printf("Retail value of product (type %d) sold is %.2f $", productType, proceed);

            retailValue += proceed;

            System.out.println();
        }

        System.out.printf("%nThe retail value of all products sold is %.2f $", retailValue);
    }
}