//Ex. 8.4

//Rectangle.java

public class Rectangle {
    private double length;
    private double width;

    Rectangle() {
        length = 1;
        width = 1;
    }

    public void setLength(double length) {
        if (length > 0.0 && length < 20.0) this.length = length;
    }

    public double getLength(){
        return this.length;
    }

    public void setWidth(double width) {
        if (width > 0.0 && width < 20.0) this.width = width;
    }

    public double getWidth() {
        return this.width;
    }


    public double calcPerimeter() {
        return (length + width) * 2;
    }

    public double calcArea() {
        return length * width;
    }

}

//Rectangle.java ends

//Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Rectangle shape = new Rectangle();

        System.out.printf("Default attributes of Rectangle class object: length = %.2f | width = %.2f%n", shape.getLength(), shape.getWidth());
        System.out.println("Enter length and width to set rectangle attributes: ");
        shape.setLength(scan.nextDouble());
        shape.setWidth(scan.nextDouble());
        System.out.printf("Set attributes of rectangle: length = %.2f | width = %.2f", shape.getLength(), shape.getWidth());

        System.out.println();

        System.out.printf("Perimeter = %.2f%nArea = %.2f", shape.calcPerimeter(), shape.calcArea());

    }
}

//Main.java ends


//Ex. 8.5

//Time2.java

public class Time2
{
    private int timeInSeconds; //86400

    public Time2() {
        this(0, 0, 0);
    }
    public Time2(int hour) {
        this(hour, 0, 0);
    }
    public Time2(int hour, int minute) {
        this(hour, minute, 0);
    }
    public Time2(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }
    
    public Time2(Time2 time) {
        this(time.getHour(), time.getMinute(), time.getSecond());
    }


    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");

        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");

        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        this.timeInSeconds = (hour*3600) + (minute*60) + second;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");

        this.timeInSeconds -= getHour() + hour*3600;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");

        this.timeInSeconds -= getMinute() + minute*60;
    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        this.timeInSeconds -= getSecond() + second;
    }


    public int getHour() { return timeInSeconds/3600; }

    public int getMinute() { return (timeInSeconds - getHour()*3600)/60; }

    public int getSecond() { return timeInSeconds - getHour()*3600 - getMinute()*60; }

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                                                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}

//Time2.java ends


//Time2Test.java

public class Time2Test
{
    public static void main(String[] args)
    {
        Time2 t1 = new Time2(); // 00:00:00
        Time2 t2 = new Time2(2); // 02:00:00
        Time2 t3 = new Time2(21, 34); // 21:34:00
        Time2 t4 = new Time2(12, 25, 42); // 12:25:42
        Time2 t5 = new Time2(t4); // 12:25:42

        System.out.println("Constructed with:");
        displayTime("t1: all default arguments", t1);
        displayTime("t2: hour specified; default minute and second", t2);
        displayTime("t3: hour and minute specified; default second", t3);
        displayTime("t4: hour, minute and second specified", t4);
        displayTime("t5: Time2 object t4 specified", t5);

        try {
            Time2 t6 = new Time2(27, 74, 99);
        } catch (IllegalArgumentException e) {
            System.err.printf("%nException while initializing t6: %s%n", e.getMessage());
        }
    }

    private static void displayTime(String header, Time2 t)
    {
        System.out.printf("%s%n   %s%n   %s%n", header, t.toUniversalString(), t.toString());
    }
}

//Time2Test.java ends


//Ex. 8.6

//SavingAccount.java

public class SavingAccount
{
    static double annualInterestRate;

    private double savingBalance;

    SavingAccount (double deposit) {
        this.savingBalance = deposit;
    }

    public void setSavingBalance (double deposit) {
        this.savingBalance = deposit;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calculateMonthlyInterest() {
        return (savingBalance * annualInterestRate) / 12;
    }

    public static void modifyInterestRate (double newRate) {
        annualInterestRate = newRate;
    }
}

//SavingAccount.java ends


//Main.java

import java.util.Scanner;

public class Main
{
    static double[] monthly_income = new double[12];

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        SavingAccount saver1 = new SavingAccount(2000.0);
        SavingAccount saver2 = new SavingAccount(3000.0);

        saver1.modifyInterestRate(0.04);
        saver2.modifyInterestRate(0.04);


        System.out.printf("Monthly income for savrer №1 is %.2f%n", saver1.calculateMonthlyInterest());
        System.out.printf("Monthly income for savrer №2 is %.2f%n", saver2.calculateMonthlyInterest());

        printBalancePlan(1, saver1);
        printBalancePlan(2, saver2);

        System.out.println("Modifying interest rate...");

        saver1.modifyInterestRate(0.05);
        saver2.modifyInterestRate(0.05);
        System.out.printf("New monthly income for savrer №1 is %.2f%n", saver1.calculateMonthlyInterest());
        System.out.printf("New monthly income for savrer №2 is %.2f%n%n", saver2.calculateMonthlyInterest());

        printBalancePlan(1, saver1);
        printBalancePlan(2, saver2);
    }

    public static void printBalancePlan(int clientNum, SavingAccount saver) {
        monthly_income[0] = saver.getSavingBalance();

        for (int i = 1; i < monthly_income.length; i++) {
            monthly_income[i] = monthly_income[i - 1] + saver.calculateMonthlyInterest();
        }

        System.out.printf("%n|          Balance plan for 12 months         |%n");
        System.out.printf("| Client | Annual Rate | Month |   Balance    |%n");
        System.out.printf("|---------------------------------------------|%n");
        for (int i = 0; i < monthly_income.length; i++) {
            System.out.printf("|    %-4d|      %-7.2f|   %-4d|   %-11.2f|%n", clientNum, saver.annualInterestRate, i+1, monthly_income[i]);
        }
        System.out.printf("|---------------------------------------------|%n");
        System.out.printf("|            Total income : %-18.2f|%n", monthly_income[11] - saver.getSavingBalance());
        System.out.printf("|---------------------------------------------|%n%n");
    }
}

//Main.java ends


//Ex. 8.7

//Time2.java

public class Time2
{
    private int timeInSeconds; //86400

    public Time2() {
        this(0, 0, 0);
    }
    public Time2(int hour) {
        this(hour, 0, 0);
    }
    public Time2(int hour, int minute) {
        this(hour, minute, 0);
    }
    public Time2(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }
    public Time2(Time2 time) {
        this(time.getHour(), time.getMinute(), time.getSecond());
    }


    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) throw new IllegalArgumentException("hour must be 0-23");
        if (minute < 0 || minute >= 60) throw new IllegalArgumentException("minute must be 0-59");
        if (second < 0 || second >= 60) throw new IllegalArgumentException("second must be 0-59");

        this.timeInSeconds = (hour*3600) + (minute*60) + second;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");

        this.timeInSeconds -= getHour() + hour*3600;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");

        this.timeInSeconds -= getMinute() + minute*60;
    }

    public void setSecond(int second) {
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        this.timeInSeconds -= getSecond() + second;
    }


    public int getHour()   { return timeInSeconds/3600; }
    public int getMinute() { return (timeInSeconds - getHour()*3600)/60; }
    public int getSecond() { return timeInSeconds - getHour()*3600 - getMinute()*60; }


    public void tick () {
        if (this.timeInSeconds + 1 < 86400) {
            this.timeInSeconds += 1;
        } else {
            this.timeInSeconds = 0;
        }
    }

    public void incrementMinute () {
        if (this.timeInSeconds + 60 < 86400) {
            this.timeInSeconds += 60;
        } else {
            this.timeInSeconds = getSecond();
        }
    }

    public void incrementHour () {
        if (this.timeInSeconds + 3600 < 86400) {
            this.timeInSeconds += 3600;
        } else {
            this.timeInSeconds = (getMinute() * 60) + getSecond();
        }
    }


    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d %s", (getHour() == 12) ? 0 : getHour() % 12,
                                                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}

//Time2.java ends


//Time2Test.java

public class Time2Test
{
    public static void main(String[] args)
    {
        Time2 time2 = new Time2(23, 25, 42); // 23:25:42

        displayTime("Before tick method", time2);
        time2.tick();
        displayTime("After tick method", time2);

        System.out.println();

        displayTime("Before incrementMinute method", time2);
        time2.incrementMinute();
        displayTime("After incrementMinute method", time2);

        System.out.println();

        displayTime("Before incrementHour method", time2);
        time2.incrementHour();
        displayTime("After incrementHour method", time2);
    }

    private static void displayTime(String header, Time2 t)
    {
        System.out.printf("%s%n   %s%n   %s%n", header, t.toUniversalString(), t.toString());
    }
}

//Time2Test.java ends


//Ex. 8.8

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

        System.out.printf("Date object constructor for date %s%n", this);
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


//DateTest.java

public class DateTest 
{
    public static void main(String[] args)
    {
        Date date = new Date(7, 24, 1949);

        int curMonth = date.getMonth();

        System.out.printf("Current date: %02d-%02d-%02d%n", date.getMonth(), date.getDay(), date.getYear());
        while (curMonth == date.getMonth()){
            date.nextDay();
            System.out.println("nextDay...");
            System.out.printf("Current date: %02d-%02d-%02d%n", date.getMonth(), date.getDay(), date.getYear());
        }

        System.out.println();
        System.out.println();

        int curYear = date.getYear();

        System.out.printf("Current year: %02d-%02d-%02d%n", date.getMonth(), date.getDay(), date.getYear());
        while (curYear == date.getYear()){
            date.nextDay();
            System.out.println("nextDay...");
            System.out.printf("Current year: %02d-%02d-%02d%n", date.getMonth(), date.getDay(), date.getYear());
        }
    }
}

//DateTest.java ends


//Ex. 8.10

//TrafficLightEnum.java

public enum TrafficLight
{
    RED(45),
    YELLOW(5),
    GREEN(50);

    private final int lightDuration; //sec

    TrafficLight(int lightDuration) {
        this.lightDuration = lightDuration;
    }

    public int getLightDuration() {
        return lightDuration;
    }
}

//TrafficLightEnum.java


//TrafficLightEnumTest.java

public class Main
{
    public static void main(String[] args)
    {
        for (TrafficLight light : TrafficLight.values())
            System.out.printf("%-10s%d sec%n", light, light.getLightDuration());
    }
}

//TrafficLightEnumTest.java