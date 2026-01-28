import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.Map;

// ## ✅ Hello World Program
public class Mainlinkedin01 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // fnSumTwoNumbers();
        // fnCheckEvenOrOdd();
        // fnLargestOfTwoNumbers();
        // fnLargestOfThreeNumbers();
        // fnPositiveNegativeOrZeroCheck();
        // fnFeapYearCheck();
        // fnSwapTwoNumbers();
        // fnFactorialOfNumber();
         fnFindFactorialUsingRecursion(5);
         fnFibonacciSeries();
         fibonacci(10);
        // fnReverseNumberAndString();
        // fnPalindromeNumberAndStringCheck();
        // fnArmstrongNumberCheck();
        // fnPrimeNumberCheck();
        // fnPrintAllPrimeNumbers();
        // fnMultiplicationTableFfNumber();
        // fnSumAllElements();
        // fnSumOfDigitsOfNumber();
        // fnPrintNumbersWithoutLoop();
        // fnSquarePattern();
        // fnRightTrianglePattern();
        // fnIvertedTrianglePattern();
        // fnPyramidPattern();
        // fnDiamondPattern();
        // fnNumberPattern();
        // fnAlphabetPattern();
        // fnFindLargestAndSmallestElement();
        // fneRverseArray();
        // fnSortAnArrayWithBuildMethodAndWithoutMethod();
        // fnDuplicateCharacters();
        // fnFindDuplicateElementsWithInbuildMethodandWithout();
        // fnFindMissingNumberInArray();
        // fnSecondHighestNumber();
        // fnMatrixAdditionSubtractionMultiplication();
        // fnTransposeOfMatrix();
        // fnVowelConsonantCount();
        // fnCountOccurrencesInString();
        // fnFirstNonRepeatedChar();
        // fnAnagramCheck();
        // fnCommonElementsInTwoArrays();
        // fnFindSubstring("Hello", "Hello World");
        // fnLongestSubstring();

        
    }

    // ## ✅ Sum of Two Numbers
    public static void fnSumTwoNumbers() {
       
    }

    // ## ✅ Check Even or Odd
    public static void fnCheckEvenOrOdd() {
        int n = 23;
        //Output: Odd
    }
    
    // ## ✅ Largest of Two Numbers
    public static void fnLargestOfTwoNumbers() {
        int a = 23;
        int b = 11;

        int result = a > b ? a: b;
        System.out.println(result);
        //Output: 23
    }

    // ## ✅ Largest of Three Numbers
    public static void fnLargestOfThreeNumbers() {
        int a = 22;
        int b = 11;
        int c = 55;
		
		int max = a;
		if(b > max) max = b;
		if(c > max) max = c;
		
		System.out.println(max);		
        //Output: 55
    }

    // ## ✅ Positive, Negative, or Zero Check
    public static void fnPositiveNegativeOrZeroCheck() {
        int n = 30;


        //Output: Positive
    }

    // ## ✅ Leap Year Check
    public static void fnFeapYearCheck() {
        int year = 2024;

        boolean leap = (year % 400 == 0) || (year % 4 == 0) || (year % 100 != 0);
		
		System.out.println(leap ? "Leap Year" : "Not Leap Ywar");
        //Output: Leap Year
		
		// 2000 → Leap Year ✅ 2023 → Not a Leap Year ❌
    }

    // ## ✅ Swap Two Numbers (With & Without Third Variable)
    public static void fnSwapTwoNumbers () {
        int a = 10, b = 20, c;		 
        // With third variable
		c = a;
		a = b;
		b = c;
        
        // System.out.println(a + " 1 " + b);
        //Output: 20 10

        // Without third variable (XOR)
        a = a + b;
		b = a - b;
		a = a - b;
		
        
        System.out.println(a + " 2 " + b);
        //Output: 20 10
    }

    // ## ✅ Factorial of a Number (Iterative)
    public static void fnFactorialOfNumber() {
        int n = 5;

        //Output: 120
    }

    // ## ✅ Find Factorial Using Recursion
    static long fnFindFactorialUsingRecursion(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
		long num = (n <= 1) ? 1L : n * fnFindFactorialUsingRecursion(n - 1);
        
		System.out.println(num);
        return num;
        // Output: 
        // 1
        // 2
        // 6
        // 24
        // 120
    }


    // ## ✅ Fibonacci Series (First N Terms)
    public static void fnFibonacciSeries() {
        int n = 5;
		long a = 0, b = 1;
		
		for (int i = 0; i < n; i++) {
			System.out.print(a + (i < n - 1 ? " " : ""));
			long c = a + b;
			a = b;
			b = c;
		}
		

        // Output: 0 1 1 2 3
    }

    // ## ✅ Find Nth Fibonacci Number Using Recursion
    static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n <= 1) return n;

        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        
        System.out.println(b);
        return b;

        //Output: 55
    }

    // ## ✅ Reverse a Number  and string
    public static void fnReverseNumberAndString() {
        
        //Way One: Reverse Numbers
        int number = 12345;
        
        //Output: 54321  
        
        //Way One: Reverse String 1
        String str = "HelloWorld";
      
        //Output: Reversed string: dlroWolleH

        //Way two: Reverse String 2
        String strTemp = "HelloWorld";

        //Output: Reversed string: dlroWolleH

        //Way Three: Reverse String 3


        //Output: olleh
    }

    // ## ✅ Palindrome Number Check
    public static void fnPalindromeNumberAndStringCheck() {      

        //Way one: Check if string is palindrome
        String str = "madam";
        boolean isPalindromeNum = true;
        
        //Output: madam is a palindrome.
        
        //Way two: check palindrome with number
        int number = 121;        
        boolean isPalindrome = true;

        //Output: 121 is a palindrome number.

        // Way three
      

        //Output: Palindrome
    }

    // ## ✅ Armstrong Number Check (3-digit)
    public static void fnArmstrongNumberCheck () {
        int n = 12;

        // Output: Armstrong
    }

    // Prime Number Check
    public static void fnPrimeNumberCheck() {
        int n = 12;

        // Output: Not Prime
    }

    // ## ✅ Print All Prime Numbers Between 1 and N
    public static void fnPrintAllPrimeNumbers() {
        System.out.println("Prime numbers between 1 and 100:");
        int nums = 100;
        
        // Prime numbers between 1 and 100: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
    }

    // ## ✅ Multiplication Table of a Number
    public static void fnMultiplicationTableFfNumber() {
        int n = 5;

        
        // 5 x 1 = 5
        // 5 x 2 = 10
        // 5 x 3 = 15
        // 5 x 4 = 20
        // 5 x 5 = 25
    }

    // ## ✅ Sum All Elements of an Array
    public static void fnSumAllElements() {
        int[] arr = {1, 2, 3, 4, 5};  // Example array
        int sum = 0;

        
        System.out.println("Sum of all elements in the array: " + sum);
        //Output: Sum of all elements in the array: 15
    }

    // ## ✅ Sum of Digits of a Number
    public static void fnSumOfDigitsOfNumber() {
        int n = 100;
        int sum = 0;


        //Output: 5
    }

    // ✅ Print Numbers 1 to 100W ithout Loop (Using Recursion)
    public static void fnPrintNumbersWithoutLoop (int i) {
        if (i > 10) return;

        
        //Output: 12345678910
    }

    // ## ✅ Square Pattern (`****`)
    public static void fnSquarePattern () {
        int n = 4;

        
        // ****
        // ****
        // ****
        // ****
    }

    // ## ✅ Right Triangle Pattern
    public static void fnRightTrianglePattern() {
        int n = 5;

        
        // *
        // **
        // ***
        // ****
        // *****
    }

    // ## ✅ Inverted Triangle Pattern
    public static void fnIvertedTrianglePattern() {
        int n = 5;

        
        
        // *****
        // ****
        // ***
        // **
        // *
    }

    //## ✅ Pyramid Pattern
    public static void fnPyramidPattern() {
        int n = 5;

        
        //     *
        //    ***
        //   *****
        //  *******
        // *********           
    }

    // ## ✅ Diamond Pattern
    public static void fnDiamondPattern() {
        int n = 5;

        // Upper half
        

        // Lower half
        
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        //  *******
        //   *****
        //    ***
        //     *
    }

    // ## ✅ Number Pattern (1, 12, 123, ...)
    public static void fnNumberPattern () {
        int n = 5;

        

        // 1
        // 12
        // 123
        // 1234
        // 12345
    }

    // ## ✅ Alphabet Pattern (A, AB, ABC, ...)
    public static void fnAlphabetPattern () {
        int n = 5;


        // Output:
        // A
        // AB
        // ABC
        // ABCD
        // ABCDE
    }

    // ## ✅ Find Largest and Smallest Element in an Array
    public static void fnFindLargestAndSmallestElement () {
        int[] arr = {5, 2, 9, -1, 7};

       
        //Output: Min = -1, Max = 9
    }
    

    // ## ✅ Reverse an Array
    public static void fneRverseArray() {
        int[] arr = {1, 2, 3, 4, 5};
    
       
        //Output: [5, 4, 3, 2, 1]
    }

    // ## ✅ Sort an Array (Ascending / Descending)
    public static void fnSortAnArrayWithBuildMethodAndWithoutMethod () {
        // with in built function
        Integer[] arrData = {5, 1, 4, 2, 3};

        
        // [1, 2, 3, 4, 5]
        // [5, 4, 3, 2, 1]
        
        // Using loop  =========
        int[] arr = {5, 2, 9, 1, 5, 6};

    

        //Output: 1 2 5 5 6 9
    }

    // ## ✅ Find the Duplicate Characters in a String
    public static void fnDuplicateCharacters() {
        // Way 1 ====
		String str = "programming";

        //Output: Duplicate characters: r g m 

        // way 2 ========
        String s = "programming";

       
        //Output: progamin
	}

    // ## ✅ Find Duplicate Elements in an Array
    public static void fnFindDuplicateElementsWithInbuildMethodandWithout () {
        // With Inbuild functions
        int[] arr = {1, 2, 3, 1, 2, 4, 5};

        
        //Output: [1, 2]
        
        // using without inbuilt method ======
        int[] nums = {2, 5, 2, 7, 8, 9, 5, 3};
        
        //Output: 2 5 
    }

    // ## ✅ Find Missing Number in an Array (1 to N)
    public static void fnFindMissingNumberInArray () {
        int[] arr = {1, 2, 4, 5};
        int n = 5;

        
        // 3
    }

    // ## ✅ Find Second Largest Element in an Array
    public static void fnSecondHighestNumber() {
        int[] arr = {10, 5, 20, 20, 15, 5, 30};
       

        // Second-highest number: 20
    }

    // ## ✅ Matrix Addition, Subtraction, and Multiplication
    public static void fnMatrixAdditionSubtractionMultiplication() {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int n = 2;
       
        
        // 19 22 
        // 43 50 
    }

    // ## ✅ Transpose of a Matrix
    public static void fnTransposeOfMatrix() {
        int[][] A = {{1, 2, 3}, {4, 5, 6}};
        
        
        // 1 4 
        // 2 5 
        // 3 6 
    }

    // ## ✅ Count Vowels and Consonants in a String
    public static void fnVowelConsonantCount() {
        String str = "Hello World";  // Example string
        int vowels = 0, consonants = 0;

        // Vowels: 3
        // Consonants: 7
    }

    // ## ✅ Count Occurrences of Each Word in a String
    public static void fnCountOccurrencesInString() {
        // Way one ==========
        String s = "to be or not to be";
        
        //output: {to=2, be=2, or=1, not=1}

        // Way two ==========
        String str = "to be or not to be";

        //output: {to=2, be=2, or=1, not=1}
    }
    

    // ## ✅ Find First Non-Repeated Character in a String
    public static void fnFirstNonRepeatedChar () {
        // way one ==================
        String str = "stress";
        char result = ' ';
        

        System.out.println(result); // Output: t

        // way two ==================
        String s = "swiss";
        

        System.out.println("None");
        // w
    }

    // ## ✅ Check Anagram Strings
    public static void fnAnagramCheck() {
        String str1 = "listen";  // Example strings
        String str2 = "silent";

        
        //output: listen and silent are anagrams.
    }

    // ## ✅ Find the Common Elements Between Two Arrays
    public static void fnCommonElementsInTwoArrays() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        
        // 3 4 5 
    }

    // ✅ Find Substring in a String (Without using contains())
    public static void fnFindSubstring(String sub, String s) {
        // Way one: without contain
        boolean found = false;

        
        System.out.println(found); // Print the result - true

        // way two: using contain
        String str = "Hello World";  // Example string
        String substring = "World";  // Substring to check

        // Output:  The string contains the substring
    }

    // ## ✅ Longest Substring Without Repeating Characters
    public static void fnLongestSubstring () {
		String s = "abcabcbb";
        int maxLength = 0;


        System.out.println(maxLength);
		// 3
	}



}