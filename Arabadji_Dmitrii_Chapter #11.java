
//Ex. 11.16

public class Main
{
    public static void main(String[] args) {
        try {
            throw new ExceptionB();
        } catch(ExceptionA exA) {
            System.out.println(exA.toString());
        }

        try {
            throw new ExceptionC();
        } catch(ExceptionA exA) {
            System.out.println(exA.toString());
        }
    }
}

class ExceptionA extends Exception { }

class ExceptionB extends ExceptionA { }

class ExceptionC extends ExceptionB { }


//Ex. 11.17

import java.io.IOException;

public class Main
{
    public static void main(String[] args) {
        try {
            throw new ExceptionA();
        } catch(Exception exeption) {
            System.out.println(exeption.toString());
        }

        try {
            throw new ExceptionB();
        } catch(Exception exeption) {
            System.out.println(exeption.toString());
        }
        
        try {
            throw new IOException();
        } catch(Exception exeption) {
            System.out.println(exeption.toString());
        }
        
        try {
            throw new NullPointerException();
        } catch(Exception exeption) {
            System.out.println(exeption.toString());
        }
    }
}

class ExceptionA extends Exception { }

class ExceptionB extends ExceptionA { }


//Ex. 11.20

import java.io.IOException;

public class Main
{
    static void someMethod2() throws IOException {
        throw new IOException();
    }
    
    static void someMethod() throws Exception {
        someMethod2();
    }
    
    public static void main(String[] args) {
        try {
            someMethod();
        } catch(Exception exeption) {
            exeption.printStackTrace();
        }
    }
}