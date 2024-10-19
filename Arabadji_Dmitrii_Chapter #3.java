
//Ex. 3.11


public class Account
{
   private String name;
   private double balance;

   public Account(String name, double balance) {
        this.name = name;

        if (balance > 0.0)
            this.balance = balance;
   }

   public void deposit(double depositAmount) {
      if (depositAmount > 0.0)
         balance = balance + depositAmount;
   }

   public void withdraw(double withdrawAmount) {
        if (withdrawAmount <= balance)
            balance = balance - withdrawAmount;
        else
            System.out.print("Withdrawal amount exceeded account balance!"); // prompt
   }

   public double getBalance() {
      return balance;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}

import java.util.Scanner;

public class AccountTest
{
   public static void main(String[] args)
   {
        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("John Blue", 94.53);

        System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance());

        Scanner input = new Scanner(System.in);

        System.out.print("Enter deposit amount for account1: ");
        double depositAmount = input.nextDouble();
        System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
        account1.deposit(depositAmount);

    
        System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance());

        System.out.print("Enter withdraw amount for account2: ");
        double withdrawAmount = input.nextDouble();
        System.out.printf("%nsubstracting %.2f from account2 balance%n%n", withdrawAmount);
        account2.withdraw(withdrawAmount);

        
        System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f%n%n",account2.getName(), account2.getBalance());

   }
}


//Ex. 3.12


public class Invoice
{
   private String partNumber;
   private String partDesc;
   private int quantity;
   private double price;

   public Invoice(String partNumber, String partDesc, int quantity, double price) {
        this.partNumber = partNumber;
        this.partDesc = partDesc;

        if (quantity > 0)   this.quantity = quantity;
        else                this.quantity = 0;

        if (price > 0)  this.price = price;
        else            this.price = 0.0;
   }

    public void setPartNumber(String partNumber)
    { this.partNumber = partNumber; }

    public String getPartNumber()
    { return partNumber; }

    public void setPartDesc(String partDesc)
    { this.partDesc = partDesc; }

    public String getPartDesc()
    { return partDesc; }

    public void setQuantity(int quantity) {
        if (quantity > 0) this.quantity = quantity;
    }
    public int getQuantity()
    { return quantity; }

    public void setPrice(double price) {
        if (price > 0) this.price = price;
    }
    public double getPrice()
    { return price; }


    public double getInvoiceAmount() {
        return quantity * price;
    }
}


import java.util.Scanner;

public class InvoiceTest
{
   public static void main(String[] args)
   {
        Invoice invoice1 = new Invoice("011F34", "atx motherboard", 4, 200.0);

        System.out.printf("Invoice №1:%n%s | %s | Quantity : %d |  Price per item : $%.2f%n",
            invoice1.getPartNumber(), invoice1.getPartDesc(), invoice1.getQuantity(), invoice1.getPrice());

        System.out.printf("The invoice №1 amount is: $%.2f dollars%n%n", invoice1.getInvoiceAmount());


        Invoice invoice2 = new Invoice("","",0,0.0);

        Scanner input = new Scanner(System.in);

        System.out.printf("Enter data for invoice №2:%n");

        System.out.print("Enter part number: ");
        invoice2.setPartNumber(input.nextLine());
        System.out.print("Enter part description: ");
        invoice2.setPartDesc(input.nextLine());
        System.out.print("Enter parts quantity: ");
        invoice2.setQuantity(input.nextInt());
        System.out.print("Enter price per item: ");
        invoice2.setPrice(input.nextDouble());


        System.out.printf("%nInvoice №2:%n%s | %s | Quantity : %d |  Price per item : $%.2f%n",
            invoice2.getPartNumber(), invoice2.getPartDesc(), invoice2.getQuantity(), invoice2.getPrice());

        System.out.printf("The invoice №2 amount is: $%.2f dollars%n%n", invoice2.getInvoiceAmount());
   }
}


//Ex. 3.13


public class Employee
{
    private String first_name;
    private String last_name;
    private double salary;

    public Employee(String first_name, String last_name, double salary) {
        this.first_name = first_name;
        this.last_name = last_name;

        if (salary >= 0) this.salary = salary;
    }

    public void setFirstName(String first_name)
    { this.first_name = first_name; }

    public String getFirstName()
    { return first_name; }

    public void setLastName(String last_name)
    { this.last_name = last_name; }

    public String getLastName()
    { return last_name; }

    public void setSalary(double salary)
    { if (salary >= 0) this.salary = salary; }

    public double getSalary()
    { return salary; }


    public double getYearSalary() {
        return salary * 12;
    }
}


import java.util.Scanner;

public class EmployeeTest
{
    public static void main(String[] args)
    {
        Employee emp1 = new Employee("Ivan", "Petrov", 800.0);
        Employee emp2 = new Employee("Nicolas", "Bispiaci", 700.0);

        System.out.printf("First employee: %n   %s %s gets salary %.2f $ per month.%n",
                emp1.getFirstName(), emp1.getLastName(), emp1.getSalary());
        System.out.printf("   Emp1 yearly salary is %.2f%n", emp1.getYearSalary());


        System.out.printf("Second employee: %n   %s %s gets salary %.2f $ per month.%n",
                emp2.getFirstName(), emp2.getLastName(), emp2.getSalary());
        System.out.printf("   Emp2 yearly salary is %.2f", emp2.getYearSalary());

        Scanner scan = new Scanner(System.in);

        System.out.printf("%n%Enter salary increase rate: ");
        double rate = scan.nextDouble();

        emp1.setSalary(emp1.getSalary() + (emp1.getSalary() * rate / 100));
        emp2.setSalary(emp2.getSalary() + (emp2.getSalary() * rate / 100));

        System.out.printf("Emp1: salary/month = %.2f $ | salary/year = %.2f $ %n", emp1.getSalary(), emp1.getYearSalary());
        System.out.printf("Emp2: salary/month = %.2f $ | salary/year = %.2f $ %n%n", emp2.getSalary(), emp2.getYearSalary());
    }
}


//Ex. 3.14


public class Date
{
    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year) {
        if (month > 0 && month <= 12 ) this.month = month;

        if (day > 0 && day <= 31 ) this.day = day;

        if (year >= 0) this.year = year;
    }

    public void setMonth(int month) {
        if (month > 0 && month <= 12 ) this.month = month;
    }
    public int getMonth() { return month; }

    public void setDay(int day) {
        if (day > 0 && day <= 31 ) this.day = day;
    }
    public int getDay() { return day; }

    public void setYear(int year) {
        if (year >= 0) this.year = year;
    }
    public int getYear() { return year; }


    public void displayDate()
    {
        System.out.printf("%d / %d / %d %n", month, day, year);
    }
}


import java.util.Scanner;

public class DateTest
{
    public static void main(String[] args)
    {
        Date date1 = new Date(9, 15, 2020);
        Date date2 = new Date(9, 16, 2020);

        System.out.printf("First Date in next format: MM/DD/YY %n                          ");
        date1.displayDate();
        System.out.printf("Second Date in next format: MM/DD/YY %n                            ");
        date2.displayDate();


        Scanner scan = new Scanner(System.in);

        System.out.println("Enter new data for second date:");

        System.out.print("month: ");
        date2.setMonth(scan.nextInt());
        System.out.print("day: ");
        date2.setDay(scan.nextInt());
        System.out.print("year: ");
        date2.setYear(scan.nextInt());

        System.out.print("Modified date2: ");
        date2.displayDate();
    }
}


//Ex. 3.15


public class Account
{
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;

        if (balance > 0.0)
            this.balance = balance;
    }

    public void deposit(double depositAmount) {
        if (depositAmount > 0.0)
            balance = balance + depositAmount;
    }

    public void withdraw(double withdrawAmount) {
        if (withdrawAmount <= balance)
            balance = balance - withdrawAmount;
        else
            System.out.print("Withdrawal amount exceeded account balance!"); // prompt
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


import java.util.Scanner;

public class AccountTest
{
    public static void main(String[] args)
    {

        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("John Blue", 94.53);

        displayAccount(account1);
        displayAccount(account2);

        Scanner input = new Scanner(System.in);

        //First account1
        System.out.print("Enter deposit amount for account1: ");
        double depositAmount = input.nextDouble();
        System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
        account1.deposit(depositAmount);

        // display balances
        displayAccount(account1);
        displayAccount(account2);

        //Second Account
        System.out.print("Enter withdraw amount for account2: ");
        double withdrawAmount = input.nextDouble();
        System.out.printf("%nsubstracting %.2f from account2 balance%n%n", withdrawAmount);
        account2.withdraw(withdrawAmount);

        // display balances
        displayAccount(account1);
        displayAccount(account2);

    }

    public static void displayAccount(Account accountToDisplay) {
        System.out.printf("%s balance: $%.2f%n", accountToDisplay.getName(), accountToDisplay.getBalance());
    }
}