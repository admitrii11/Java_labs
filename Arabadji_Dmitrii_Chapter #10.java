//Ex. 10.12

//PayrollSystemTest.java

public class Main
{
    public static void main(String[] args)
    {
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", new Date(2, 28, 1988), 800.00);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", new Date(11, 10, 1993), 16.75, 40);

        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", new Date(7, 12, 1992), 10000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", new Date(9, 5, 1991), 5000, .04, 300);

        Date curDate = new Date(7, 5, 2020);

        Employee[] employees = new Employee[4];

        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;


        System.out.printf("Current date: %s%n%n", curDate.toString());

        for (int i = 0; i < employees.length; i++)
        {
            if (employees[i].getBirthDate().getMonth() == curDate.getMonth()) {
                System.out.printf("%s %s earned: $%,.2f with the 100$ bonus, cause birthday is on %s%n",
                        employees[i].getLastName(), employees[i].getClass().getName(), employees[i].earnings() + 100, employees[i].getBirthDate().toString());
            }
            else {
                System.out.printf("%s %s earned: $%,.2f%n", employees[i].getLastName(), employees[i].getClass().getName(), employees[i].earnings());
            }
        }
    }
}

//PayrollSystemTest.java ends

//-------------------------------------------------------------------------------------------------------------------------------

//Employee.java

public abstract class Employee
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private final Date birthDate;
    
    public Employee(String firstName, String lastName, String socialSecurityNumber, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthDate = birthDate;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s %s%nsocial security number: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
    }
    
    public abstract double earnings(); 
} 

//Employee.java ends

//-------------------------------------------------------------------------------------------------------------------------------

//Date.java

public class Date {
    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // year bigger than 0

    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int month, int day, int year)
    {
        if (year <= 0)
            throw new IllegalArgumentException("year (" + month + ") must be > 0");

        if (month <= 0 || month > 12)
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");

        if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

        if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

        this.month = month;
        this.day = day;
        this.year = year;

    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void nextDay() {
        if (this.day < daysPerMonth[this.month]) {
            this.day += 1;
        }
        else if (this.month < 12) {
            this.month += 1;
            this.day = 1;
        }
        else if (this.month == 12) {
            this.year += 1;
            this.month = 1;
            this.day = 1;
        }
    }

    @Override
    public String toString()
    {
        return String.format("%d/%d/%d", month, day, year);
    }
}

//Date.java ends

//-------------------------------------------------------------------------------------------------------------------------------

//CommissionEmployee.java

public class CommissionEmployee extends Employee
{
    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage
    
    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double grossSales, double commissionRate)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);

        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

        if (grossSales < 0.0) 
            throw new IllegalArgumentException("Gross sales must be >= 0.0");

        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }
    
    public void setGrossSales(double grossSales)
    {
        if (grossSales < 0.0) // validate
            throw new IllegalArgumentException("Gross sales must be >= 0.0");

        this.grossSales = grossSales;
    }

    public double getGrossSales()
    {
        return grossSales;
    }
    
    public void setCommissionRate(double commissionRate)
    {
        if (commissionRate <= 0.0 || commissionRate >= 1.0) // validate
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

        this.commissionRate = commissionRate;
    }
    
    public double getCommissionRate()
    {
        return commissionRate;
    }
    
    @Override
    public double earnings()
    {
        return getCommissionRate() * getGrossSales();
    }
    
    @Override
    public String toString()
    {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "commission employee", super.toString(), "gross sales", getGrossSales(), "commission rate", getCommissionRate());
    }
} 

//CommissionEmployee.java ends

//-------------------------------------------------------------------------------------------------------------------------------

//BasePlusCommissionEmployee.java

public class BasePlusCommissionEmployee extends CommissionEmployee
{
    private double baseSalary; 
    
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double grossSales, double commissionRate, double baseSalary)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate, grossSales, commissionRate);

        if (baseSalary < 0.0) 
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    }

    public void setBaseSalary(double baseSalary)
    {
        if (baseSalary < 0.0) 
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    }
    
    public double getBaseSalary()
    {
        return baseSalary;
    }

    @Override
    public double earnings()
    {
        return getBaseSalary() + super.earnings();
    }

    @Override
    public String toString()
    {
        return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
    }
}

//BasePlusCommissionEmployee.java ends

//-------------------------------------------------------------------------------------------------------------------------------

//HourlyEmployee.java

public class HourlyEmployee extends Employee
{
    private double wage; // wage per hour
    private double hours; // hours worked for week
    
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double wage, double hours)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);

        if (wage < 0.0)
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");

        if ((hours < 0.0) || (hours > 168.0))
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

        this.wage = wage;
        this.hours = hours;
    }

    public void setWage(double wage)
    {
        if (wage < 0.0)
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");

        this.wage = wage;
    }

    public double getWage()
    {
        return wage;
    }

    public void setHours(double hours)
    {
        if ((hours < 0.0) || (hours > 168.0))
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

        this.hours = hours;
    }

    public double getHours()
    {
        return hours;
    }

    @Override
    public double earnings()
    {
        if (getHours() <= 40) 
            return getWage() * getHours();
        else
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
    }

    @Override
    public String toString()
    {
        return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(), "hours worked", getHours());
    }
}

//HourlyEmployee.java ends

//-------------------------------------------------------------------------------------------------------------------------------

//SalariedEmployee.java

public class SalariedEmployee extends Employee
{
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double weeklySalary)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);

        if (weeklySalary < 0.0)
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");

        this.weeklySalary = weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary)
    {
        if (weeklySalary < 0.0)
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");

        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary()
    {
        return weeklySalary;
    }

    @Override
    public double earnings()
    {
        return getWeeklySalary();
    }

    @Override
    public String toString()
    {
        return String.format("salaried employee: %s%n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
    }
}

//SalariedEmployee.java ends


//Ex. 10.13

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7);
        Triangle triangle = new Triangle(5, 7, 8);
        Square square = new Square(4);
        
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Triangle area: " + triangle.getArea());
        System.out.println("Square area: " + square.getArea());
        System.out.println();
        
        Sphere sphere = new Sphere(5);
        
        System.out.println("Sphere area: " + sphere.getArea());
        System.out.println("Sphere volume: " + sphere.getVolume());
        
        Cube cube = new Cube(4);
        
        System.out.println("Cube area: " + cube.getArea());
        System.out.println("Cube volume: " + cube.getVolume());
        
        Tetrahedron tetrahedron = new Tetrahedron(5.4);
        
        System.out.println("Tetrahedron area: " + tetrahedron.getArea());
        System.out.println("Tetrahedron volume: " + tetrahedron.getVolume());
        
    }
}


public abstract class Shape 
{
    public final int dimensions;
    
    Shape (int dimensions) {
        this.dimensions = dimensions;
    }
}


public abstract class TwoDimensionalShape extends Shape 
{
    TwoDimensionalShape () {
        super(2);
    }
    abstract public double getArea();
}


public abstract class ThreeDimensionalShape extends Shape 
{
    ThreeDimensionalShape () {
        super(3);
    }
    abstract public double getArea();
    abstract public double getVolume();
}


public class Circle extends TwoDimensionalShape 
{
    private double radius;

    public Circle(double radius) {
       this.radius = radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    @Override
    public double getArea() {
       return Math.PI*Math.pow(radius, 2);
    }
}


public class Square extends TwoDimensionalShape 
{
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    public double getLength() {
        return length;
    }

    @Override
    public double getArea() {
        return length * length;
    }

}


public class Triangle extends TwoDimensionalShape 
{
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if ((a < b+c) && (b < a+c) && (c < a+b)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new IllegalArgumentException("Not valid sides of the triangle!");
        }
    }

    public double getSizeA(){
        return this.a;
    }
    public double getSizeB(){
        return this.b;
    }
    public double getSizeC(){
        return this.c;
    }

    @Override
    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}


public class Sphere extends ThreeDimensionalShape 
{
    private double radius;
      
    public Sphere(double radius) {
        this.radius = radius;    
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
 
    
    @Override
    public double getArea() {
       return 4.*Math.PI*Math.pow(radius, 2);
    }
    
    @Override
    public double getVolume() {
        return (4./3)*Math.PI*Math.pow(radius, 3);
    }
}


public class Cube extends ThreeDimensionalShape 
{
    private double edge;

    public Cube(double edge) {
        this.edge = edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    @Override
    public double getArea() {
        return 6 * Math.pow(edge, 2);
    }

    @Override
    public double getVolume() {
        return Math.pow(edge, 3);
    }
}


public class Tetrahedron extends ThreeDimensionalShape 
{
    private double edge;

    public Tetrahedron(double edge) {
        this.edge = edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * Math.pow(edge, 2);
    }

    @Override
    public double getVolume() {
        return Math.pow(edge, 3) * Math.sqrt(2) / 12.;
    }
}


//Ex. 10.14

//PayrollSystemTest.java

public class Main
{
    public static void main(String[] args)
    {
        PieceWorker pieceWorker = new PieceWorker("Bob", "Jo", "241-76-9872", new Date(3, 4, 1994), 200, 98);
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", new Date(2, 28, 1988), 800.00);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", new Date(11, 10, 1993), 16.75, 40);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", new Date(7, 12, 1992), 10000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", new Date(9, 5, 1991), 5000, .04, 300);

        Date curDate = new Date(7, 5, 2020);

        Employee[] employees = new Employee[5];

        employees[0] = pieceWorker;
        employees[1] = salariedEmployee;
        employees[2] = hourlyEmployee;
        employees[3] = commissionEmployee;
        employees[4] = basePlusCommissionEmployee;


        System.out.printf("Current date: %s%n%n", curDate.toString());

        for (int i = 0; i < employees.length; i++)
        {
            System.out.println(employees[i].toString() + "\nTotal earnings: " + employees[i].earnings() + "\n");
        }
    }
}

//PayrollSystemTest.java ends

//Employee.java

public abstract class Employee
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private final Date birthDate;

    public Employee(String firstName, String lastName, String socialSecurityNumber, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s%nsocial security number: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    public abstract double earnings();
}

//Employee.java ends

//PieceWorker.java

public class PieceWorker extends Employee
{
    private double wage;
    private int pieces;

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double wage, int pieces)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);

        setWage(wage);
        setPieces(pieces);
    }

    public void setWage(double wage) {
        if (wage < 0.0) throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        this.wage = wage;
    }

    public void setPieces(int pieces)
    {
        if (pieces < 0.0) throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        this.pieces = pieces;
    }

    public double getWage() {
        return wage;
    }

    public int getPieces() {
        return pieces;
    }

    @Override
    public double earnings()
    {
        return wage * pieces;
    }

    @Override
    public String toString()
    {
        return String.format("Piece worker: %s%n%s: $%,.2f; %s: %d",
                super.toString(), "Wage per piece", getWage(), "Pieces produced", getPieces());
    }
}

//PieceWorker.java ends

//CommissionEmployee.java

public class CommissionEmployee extends Employee
{
    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double grossSales, double commissionRate)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);

        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0.0");

        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public void setGrossSales(double grossSales)
    {
        if (grossSales < 0.0) // validate
            throw new IllegalArgumentException("Gross sales must be >= 0.0");

        this.grossSales = grossSales;
    }

    public double getGrossSales()
    {
        return grossSales;
    }

    public void setCommissionRate(double commissionRate)
    {
        if (commissionRate <= 0.0 || commissionRate >= 1.0) // validate
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

        this.commissionRate = commissionRate;
    }

    public double getCommissionRate()
    {
        return commissionRate;
    }

    @Override
    public double earnings()
    {
        return getCommissionRate() * getGrossSales();
    }

    @Override
    public String toString()
    {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "commission employee", super.toString(), "gross sales", getGrossSales(), "commission rate", getCommissionRate());
    }
}

//CommissionEmployee.java ends

//BasePlusCommissionEmployee.java

public class BasePlusCommissionEmployee extends CommissionEmployee
{
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double grossSales, double commissionRate, double baseSalary)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate, grossSales, commissionRate);

        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    }

    public void setBaseSalary(double baseSalary)
    {
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    }

    public double getBaseSalary()
    {
        return baseSalary;
    }

    @Override
    public double earnings()
    {
        return getBaseSalary() + super.earnings();
    }

    @Override
    public String toString()
    {
        return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
    }
}

//BasePlusCommissionEmployee.java ends

//HourlyEmployee.java

public class HourlyEmployee extends Employee
{
    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double wage, double hours)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);

        if (wage < 0.0)
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");

        if ((hours < 0.0) || (hours > 168.0))
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

        this.wage = wage;
        this.hours = hours;
    }

    public void setWage(double wage)
    {
        if (wage < 0.0)
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");

        this.wage = wage;
    }

    public double getWage()
    {
        return wage;
    }

    public void setHours(double hours)
    {
        if ((hours < 0.0) || (hours > 168.0))
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

        this.hours = hours;
    }

    public double getHours()
    {
        return hours;
    }

    @Override
    public double earnings()
    {
        if (getHours() <= 40)
            return getWage() * getHours();
        else
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
    }

    @Override
    public String toString()
    {
        return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(), "hours worked", getHours());
    }
}

//HourlyEmployee.java ends

//SalariedEmployee.java

public class SalariedEmployee extends Employee
{
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double weeklySalary)
    {
        super(firstName, lastName, socialSecurityNumber, birthDate);

        if (weeklySalary < 0.0)
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");

        this.weeklySalary = weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary)
    {
        if (weeklySalary < 0.0)
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");

        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary()
    {
        return weeklySalary;
    }

    @Override
    public double earnings()
    {
        return getWeeklySalary();
    }

    @Override
    public String toString()
    {
        return String.format("salaried employee: %s%n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
    }
}

//SalariedEmployee.java ends

//Date.java

public class Date {
    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // year bigger than 0

    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int month, int day, int year)
    {
        if (year <= 0)
            throw new IllegalArgumentException("year (" + month + ") must be > 0");

        if (month <= 0 || month > 12)
            throw new IllegalArgumentException("month (" + month + ") must be 1-12");

        if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

        if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

        this.month = month;
        this.day = day;
        this.year = year;

    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void nextDay() {
        if (this.day < daysPerMonth[this.month]) {
            this.day += 1;
        }
        else if (this.month < 12) {
            this.month += 1;
            this.day = 1;
        }
        else if (this.month == 12) {
            this.year += 1;
            this.month = 1;
            this.day = 1;
        }
    }

    @Override
    public String toString()
    {
        return String.format("%d/%d/%d", month, day, year);
    }
}

//Date.java ends


//Ex. 10.17

//Main.java

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CarbonFootprints> carbonObjects = new ArrayList<>();

        carbonObjects.add(new Building(3000, 400, 900));
        carbonObjects.add(new Car(120, 800));
        carbonObjects.add(new Bicycle());

        for (CarbonFootprints footprints : carbonObjects) {
            System.out.println(footprints.getClass().getName() + "\n" +
                    "Carbon footprints: " + footprints.getCarbonFootprint());
        }

    }
}

//Main.java ends


//Interface CarbonFootprints.java

public interface CarbonFootprints {
    double getCarbonFootprint();
}

//Interface CarbonFootprints.java ends


//Building.java

public class Building implements CarbonFootprints {
    private double electricitySpending;
    private double gasSpending;
    private double waterConsumption;

    Building (double electrSpend, double gasSpend, double waterConsum) {
        this.electricitySpending = electrSpend;
        this.gasSpending = gasSpend;
        this.waterConsumption = waterConsum;
    }

    @Override
    public double getCarbonFootprint() {
        return ((electricitySpending * 0.01102) + (gasSpending * 0.024) + (waterConsumption * 0.0034)) * 0.89;
    }
}

//Building.java ends


//Car.java

public class Car implements CarbonFootprints {
    private double fuelConsumption;
    private double distanceTravel;

    Car (double fuelConsumption, double distanceTravel) {
        this.fuelConsumption = fuelConsumption;
        this.distanceTravel = distanceTravel;
    }

    @Override
    public double getCarbonFootprint() {
        return (distanceTravel + fuelConsumption) * 0.024;
    }
}

//Car.java ends


//Bicycle.java

public class Bicycle implements CarbonFootprints {
    private double wheelsDiameter;

    @Override
    public double getCarbonFootprint() {
        return 0;
    }
}

//Bicycle.java ends