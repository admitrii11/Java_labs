//Ex. 16.13

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        Set<String> namesSet = new HashSet<>(Arrays.asList("Dave", "Bob", "Amy", "Jo", "Steve", "Will", "Wayne", "Ivan", "Federico", 
                                "Oleg", "Marcus", "Bob", "Catalina", "Jo" , "Ivan", "Federico"));
        for (String name : namesSet)
            System.out.println(name);
        System.out.println();
        
        
        while (true) {
            
            System.out.println("Enter name (-1 to exit): ");
            String inputName = scan.nextLine();
            
            if (inputName.equals("-1")) break;
            
            int index = 0;
            boolean check = false;
            for(String name : namesSet){
                if(name.equals(inputName)){
                    System.out.println(inputName + " exists and have index: " + index);
                    check = true;
                    break;
                }
                index++;
            }
            if(!check) System.out.println(inputName + " doesn't exist");
        }
    }
}


//Ex. 16.14

import java.util.*;

public class Main {
    public static void main(String[] args){
        Map<Character, Integer> myMap = new HashMap<>();
        createMap(myMap);
        displayMap(myMap);
    }
    
    private static void createMap(Map<Character, Integer> map)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scan.nextLine();

        char[] str = inputString.toLowerCase().toCharArray();
        int count;
        for (char c : str) {
            if (c == ' ') continue;
            if (map.containsKey(c)) {
                count = map.get(c);
                map.put(c, count + 1);
            } 
            else {
                map.put(c, 1);
            }
        }
    }
    
    private static void displayMap(Map<Character, Integer> map)
    {
        Set<Character> keys = map.keySet();
        Set<Character> sortedKeys = new TreeSet<>(keys);

        System.out.println("\nMap contains: \nKey\t\tValue");
        for(char key:sortedKeys){
            System.out.printf("%-10c%10d\n", key, map.get(key));
        }
        System.out.printf("%nSize: %d%nisEmpty: %b%n", map.size() , map.isEmpty());
    }
}