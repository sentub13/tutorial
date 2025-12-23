import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Print "Hello, World!" to the console
        System.out.println("Hello, World!");
        System.out.println("--------------------");
        // ReverseString();
        // ReverseArray();
        // SumOfNumber();
        // SwapWithoutThirdVariable();
        CountWordsUsingHashMap();
    }

    public static void ReverseString() {
        String str = "Hello, World!";
        char[] strArray = str.toCharArray();
        StringBuilder tempArr = new StringBuilder();
        String reversedStr = "";
        
        for(int i=strArray.length-1; i >= 0; i--) {
            tempArr.append(strArray[i]);
            reversedStr += strArray[i];
        }
        System.out.println(tempArr);
        System.out.println(reversedStr);
    }

    static void ReverseArray () {
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        String[] tempArr = new String[cars.length];
        for(int i=cars.length-1; i >= 0; i--) {
             // System.out.println("cars[i] ---- " + cars[i]);
             tempArr[cars.length-1-i] = cars[i];
        }
       System.out.println("tempArr ---- " + java.util.Arrays.toString(tempArr));
    }

    public static void SumOfNumber() {
        int[] num = {1,2,3,4,5};
        int sum = 0;
        for(int i=0; i < num.length; i++) {
            sum += num[i];
        }
        System.out.println("sum----" + sum);
    }

    static void SwapWithoutThirdVariable() {
        System.out.println("Swap Without Third Variable");
        int a = 10;
        int b = 15;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a: " + a + " b: " + b);
    }

    static void CountWordsUsingHashMap () {
        String str = "Hello world, how are you world";
        String[] words = str.split(" ");

        System.out.println("words----"+ words);
    }

    static void CountWordsUsingHashMapTemp() {
        String str = "hello world hello everyone .";
        String[] words = str.split(" ");
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        for (String word : wordCountMap.keySet()) {
            System.out.println(word + ": " + wordCountMap.get(word));
        }    
    }


}

