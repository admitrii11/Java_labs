//Ex. 9.14

//Employee.java

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;


    Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
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

    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n", "commission employee", firstName, lastName, "social security number", socialSecurityNumber);
    }
}

//Employee.java ends

//CommissionEmployee.java

public class CommissionEmployee extends Employee
{
    private double grossSales;
    private double commissionRate;

    CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate)
    {
        super(firstName, lastName, socialSecurityNumber);

        if (grossSales < 0.0)
            throw new IllegalArgumentException(
                    "Gross sales must be >= 0.0");

        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");

        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }


    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0)
            throw new IllegalArgumentException(
                    "Gross sales must be >= 0.0");

        this.grossSales = grossSales;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");

        this.commissionRate = commissionRate;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public double earnings() {
        return commissionRate * grossSales;
    }

    @Override
    public String toString() {
        return String.format("%s%s: %.2f%n%s: %.2f", super.toString(),
                "gross sales", grossSales,
                "commission rate", commissionRate);
    }
}

//CommissionEmployee.java ends


//CommissionEmployeeTest.java

public class CommissionEmployeeTest
{
    public static void main(String[] args)
    {
        // instantiate CommissionEmployee object
        CommissionEmployee employee = new CommissionEmployee(
                "Sue", "Jones", "222-22-2222", 10000, .06);

        // get commission employee data
        System.out.println(
                "Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is",
                employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is",
                employee.getLastName());
        System.out.printf("%s %s%n", "Social security number is",
                employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is",
                employee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is",
                employee.getCommissionRate());

        employee.setGrossSales(5000);
        employee.setCommissionRate(.1);

        System.out.printf("%n%s:%n%n%s%n",
                "Updated employee information obtained by toString", employee);
    } // end main
}

//CommissionEmployeeTest.java ends


//Ex. 9.15

//HourlyEmployeeTest.java

public class HourlyEmployeeTest {
    public static void main(String[] args) {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Bob", "Jo", "252-12-2829", 250, 40);
        System.out.println(hourlyEmployee.toString());
    }
}

//HourlyEmployeeTest.java ends


//Employee.java
public class Employee
{
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;


    Employee(String firstName, String lastName, String socialSecurityNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
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

    @Override
    public String toString()
    {
        return String.format("%s, %s%nSocial security number: %s%n",
                lastName, firstName, socialSecurityNumber);
    }
}

//Employee.java ends


//HourlyEmployee.java

public class HourlyEmployee extends Employee
{
    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours)
    {
        super(firstName, lastName, socialSecurityNumber);

        setWage(wage);
        setHours(hours);
    }

    public void setWage(double wage) {
        if (wage < 0.0) throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }

    public void setHours(double hours) {
        if ((hours < 0.0) || (hours > 168.0)) throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

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
        return String.format("Hourly employee: %s%nHourly wage: $%.2f%nHours worked: %.2f%nTotal salary: $%.2f",
                super.toString(), getWage(), getHours(), earnings());
    }
}

//HourlyEmployee.java ends