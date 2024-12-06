//Ex. 20.5

public class Main {

    public static void main(String[] args){

        Integer[] integerArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.printf("Array integerArray contains:%n");
        printArray(integerArray, 0, 4);
        System.out.printf("%nArray doubleArray contains:%n");
        printArray(doubleArray, 2, 5);
        System.out.printf("%nArray characterArray contains:%n");
        printArray(characterArray, 0, 4);

    }

    public static <T> void printArray(T[] inputArray, int lowSubscript, int highSubscript){
        try{
            if((lowSubscript < 0 || lowSubscript>=inputArray.length) || 
                (highSubscript < 0 || highSubscript >= inputArray.length) || lowSubscript > highSubscript) {
                throw new Exception("InvalidSubscriptException");
            }
            System.out.println("Array Size: " + inputArray.length);
        } 
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        
        for(int i = 0; i < inputArray.length; i++) {
                if(i < lowSubscript) continue;
                if(i > highSubscript) break;
                System.out.printf("%s ",inputArray[i]);
        }
        System.out.println();
    }
}