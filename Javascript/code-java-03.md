Here are some Java coding interview questions ranging from basic to advanced levels:

### 1. **Basic Java Questions:**

#### a. **Reverse a String**
Write a Java function that reverses a string without using built-in functions.

```java
public class ReverseString {
    public static String reverse(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
}
```

#### b. **Check for Palindrome**
Write a function to check whether a given string is a palindrome.

```java
public class Palindrome {
    public static boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));  // true
        System.out.println(isPalindrome("hello"));    // false
    }
}
```

#### c. **Find Factorial of a Number**
Write a function to find the factorial of a number using recursion.

```java
public class Factorial {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // Output: 120
    }
}
```

---

### 2. **Intermediate Java Questions:**

#### a. **Find Missing Number in an Array**
Given an array of size `n-1` containing unique integers from 1 to `n`, find the missing number.

```java
public class MissingNumber {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int totalSum = n * (n + 1) / 2;
        int sumOfArray = 0;
        for (int num : arr) {
            sumOfArray += num;
        }
        return totalSum - sumOfArray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 3, 7, 8};
        System.out.println(findMissingNumber(arr)); // Output: 5
    }
}
```

#### b. **Find the Second Largest Element in an Array**
Write a function to find the second largest element in an array of integers.

```java
public class SecondLargest {
    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println(findSecondLargest(arr));  // Output: 34
    }
}
```

#### c. **Sort an Array Using Bubble Sort**
Implement bubble sort to sort an array of integers.

```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

---

### 3. **Advanced Java Questions:**

#### a. **Find the Longest Substring Without Repeating Characters**
Write a function that finds the length of the longest substring without repeating characters.

```java
import java.util.HashSet;

public class LongestSubstring {
    public static int longestSubstring(String s) {
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabcbb"));  // Output: 3
        System.out.println(longestSubstring("bbbbb"));     // Output: 1
    }
}
```

#### b. **Implement a Linked List**
Write your own linked list class with basic operations like insert, delete, and print.

```java
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    // Insert at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Delete first occurrence of element
    public void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.printList(); // Output: 10 20 30
        list.delete(20);
        System.out.println();
        list.printList(); // Output: 10 30
    }
}
```

#### c. **Detect Cycle in a Linked List**
Write a function to detect a cycle in a linked list using Floyd’s cycle-finding algorithm (Tortoise and Hare).

```java
public class LinkedListCycle {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) return false;
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;  // Cycle detected
            }
        }
        return false;  // No cycle
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;  // Creating a cycle

        System.out.println(hasCycle(head));  // Output: true
    }
}
```

---

These questions cover a range of core concepts and algorithms typically asked in Java interviews. Make sure to practice solving these problems, and if you need more challenging or specific questions, feel free to ask!

Here are the Java solutions for each of the tasks you requested:

## **Easy Level Questions**

### 1. **Reverse a String**
```java
public class Main {
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.println(reverseString(input)); // Output: "olleh"
    }
}
```

### 2. **Find Maximum and Minimum in an Array**
```java
public class Main {
    public static void findMaxMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        findMaxMin(arr);
    }
}
```

### 3. **Check if a String is a Palindrome**
```java
public class Main {
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "madam";
        System.out.println(isPalindrome(input)); // Output: true
    }
}
```

### 4. **Remove Duplicates from an Array**
```java
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : arr) {
            uniqueElements.add(num);
        }

        // Convert set back to array
        return uniqueElements.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        int[] result = removeDuplicates(arr);
        for (int num : result) {
            System.out.print(num + " "); // Output: 1 2 3 4 5
        }
    }
}
```

### 5. **Count Vowels in a String**
```java
public class Main {
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String input = "hello world";
        System.out.println(countVowels(input)); // Output: 3
    }
}
```

### 6. **FizzBuzz**
```java
public class Main {
    public static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        fizzBuzz();
    }
}
```

### 7. **Sum of Digits in a Number**
```java
public class Main {
    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int number = 1234;
        System.out.println(sumOfDigits(number)); // Output: 10
    }
}
```

### 8. **Find Missing Number in an Array**
```java
public class Main {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int totalSum = n * (n + 1) / 2;
        int arrSum = 0;
        
        for (int num : arr) {
            arrSum += num;
        }
        
        return totalSum - arrSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        System.out.println(findMissingNumber(arr)); // Output: 3
    }
}
```

Each of these solutions provides the Java code for the specified tasks. You can run these in any Java development environment (IDE) to verify the output.

## **Medium Level Questions**
Here are the Java solutions for each of the tasks you requested:

### 1. **Two Sum**
Given an array of integers and a target value, find two numbers such that their sum is equal to the target value.

```java
import java.util.HashMap;

public class Main {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {}; // return empty array if no solution found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int num : result) {
            System.out.print(num + " "); // Output: 0 1
        }
    }
}
```

### 2. **Palindrome Number**
Determine whether an integer is a palindrome (same when reversed), without converting the integer to a string.

```java
public class Main {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;  // Negative numbers are not palindrome
        int original = x, reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        int number = 121;
        System.out.println(isPalindrome(number)); // Output: true
    }
}
```

### 3. **Longest Substring Without Repeating Characters**
Given a string, find the length of the longest substring without repeating characters.

```java
import java.util.HashSet;

public class Main {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); // Output: 3
    }
}
```

### 4. **Merge Sorted Arrays**
Given two sorted arrays, merge them into a single sorted array.

```java
import java.util.Arrays;

public class Main {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < n) {
            result[k++] = arr1[i++];
        }

        while (j < m) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] result = mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(result)); // Output: [1, 2, 3, 4, 5, 6]
    }
}
```

### 5. **Anagram Check**
Given two strings, check if they are anagrams of each other (contain the same characters in any order).

```java
import java.util.Arrays;

public class Main {
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(areAnagrams(str1, str2)); // Output: true
    }
}
```

### 6. **Valid Parentheses**
Given a string containing just the characters (, ), {, }, [, and ], determine if the input string is valid.

```java
import java.util.Stack;

public class Main {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(isValid(s)); // Output: true
    }
}
```

### 7. **Find the First Non-Repeating Character in a String**
Given a string, find the first non-repeating character.

```java
import java.util.HashMap;

public class Main {
    public static char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';  // return a space if no non-repeating character found
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s)); // Output: 'v'
    }
}
```

### 8. **Rotate an Array**
Given an array and a number `k`, rotate the array `k` positions to the right.

```java
import java.util.Arrays;

public class Main {
    public static void rotateArray(int[] nums, int k) {
        k = k % nums.length;  // In case k is larger than array length
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateArray(nums, k);
        System.out.println(Arrays.toString(nums)); // Output: [5, 6, 7, 1, 2, 3, 4]
    }
}
```

These Java implementations provide solutions for the tasks you've asked about. Feel free to run these code snippets in a Java IDE or environment to see how they work.


## **Hard Level Questions**
Here are the Java solutions for each of the tasks you requested:

### 1. **Find the Kth Largest Element in an Array**
Given an array and a number `k`, find the kth largest element.

```java
import java.util.PriorityQueue;

public class Main {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k)); // Output: 5
    }
}
```

### 2. **Merge Intervals**
Given a collection of intervals, merge all overlapping intervals.

```java
import java.util.*;

public class Main {
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);
        
        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                merged.add(current);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = mergeIntervals(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval)); // Output: [1, 6], [8, 10], [15, 18]
        }
    }
}
```

### 3. **Word Ladder**
Given a begin word, an end word, and a dictionary of words, return the shortest transformation sequence from the begin word to the end word, where each transformed word must exist in the dictionary.

```java
import java.util.*;

public class Main {
    public static int wordLadderLength(String beginWord, String endWord, Set<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); j++) {
                    char[] wordArray = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String newWord = new String(wordArray);
                        if (newWord.equals(endWord)) return length + 1;
                        if (wordList.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.add(newWord);
                        }
                    }
                }
            }
            length++;
        }
        
        return 0;
    }

    public static void main(String[] args) {
        Set<String> wordList = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(wordLadderLength(beginWord, endWord, wordList)); // Output: 5
    }
}
```

### 4. **Find the Longest Common Subsequence**
Given two strings, find the length of the longest subsequence that is common to both strings.

```java
public class Main {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2)); // Output: 3
    }
}
```

### 5. **Dynamic Programming: Longest Increasing Subsequence**
Given an array of integers, find the length of the longest increasing subsequence.

```java
public class Main {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums)); // Output: 4
    }
}
```

### 6. **Jump Game II**
Given an array of integers where each element represents the maximum jump length from that position, find the minimum number of jumps to reach the end.

```java
public class Main {
    public static int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums)); // Output: 2
    }
}
```

### 7. **Sudoku Solver**
Write a program to solve a Sudoku puzzle by filling the empty cells with digits.

```java
public class Main {
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.'; // backtrack
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num || board[row][i] == num) {
                return false;
            }
        }
        
        int startRow = 3 * (row / 3), startCol = 3 * (col / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '3', '7', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'6', '.', '.', '.', '.', '.', '2', '8', '.'},
            {'

8', '5', '3', '.', '8', '1', '7', '6', '2'},
            {'9', '2', '7', '.', '9', '6', '5', '4'}
        };
        solveSudoku(board);
    }
}
```

### 8. **Merge k Sorted Lists**
Given k sorted linked lists, merge them into one sorted list.

```java
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        
        ListNode[] lists = {list1, list2, list3};
        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " "); // Output: 1 1 2 3 4 4 5 6
            result = result.next;
        }
    }
}
```

These Java implementations cover the required solutions for your problems. Run these in your environment to see the results.


## **Data Structures and Algorithms Focused Questions**
Here are Java solutions to the problems you've listed, covering linked lists, binary search, trees, graphs, dynamic programming, recursion, and sorting:

### 1. **Reverse a Linked List**

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = reverseList(head);
        
        // Output the reversed list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " "); // Output: 3 2 1
            current = current.next;
        }
    }
}
```

### 2. **Detect a Cycle in a Linked List**

```java
public class Main {
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next; // Creates a cycle
        
        System.out.println(hasCycle(head)); // Output: true
    }
}
```

### 3. **Find the Middle Element of a Linked List**

```java
public class Main {
    public static ListNode findMiddle(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        ListNode middle = findMiddle(head);
        System.out.println(middle.val); // Output: 3
    }
}
```

### 4. **Implement Binary Search**

```java
public class Main {
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int target = 4;
        System.out.println(binarySearch(nums, target)); // Output: 3
    }
}
```

### 5. **Find the First and Last Occurrence of a Number in a Sorted Array**

```java
public class Main {
    public static int[] findFirstAndLast(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);
        return result;
    }

    private static int binarySearch(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                if (findFirst) right = mid - 1;
                else left = mid + 1;
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 5};
        int target = 3;
        int[] result = findFirstAndLast(nums, target);
        System.out.println("First: " + result[0] + ", Last: " + result[1]); // Output: First: 2, Last: 4
    }
}
```

---

### **In-order, Pre-order, Post-order Traversal of a Binary Tree**

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class Main {
    // Pre-order Traversal
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // In-order Traversal
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // Post-order Traversal
    public static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Pre-order: ");
        preOrder(root); // Output: 1 2 4 5 3
        System.out.println();
        
        System.out.print("In-order: ");
        inOrder(root); // Output: 4 2 5 1 3
        System.out.println();
        
        System.out.print("Post-order: ");
        postOrder(root); // Output: 4 5 2 3 1
    }
}
```

---

### **Lowest Common Ancestor of a Binary Search Tree (BST)**

```java
public class Main {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        
        return root; // One node is on the left, the other on the right, so root is the LCA
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        
        TreeNode p = root.left;  // Node 2
        TreeNode q = root.left.right.right;  // Node 5
        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println(lca.val); // Output: 2
    }
}
```

### **Validate a Binary Search Tree (BST)**

```java
public class Main {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        
        if (root.val <= min || root.val >= max) return false;
        
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        
        System.out.println(isValidBST(root)); // Output: true
    }
}
```

---

### **Depth-First Search (DFS) / Breadth-First Search (BFS)**

```java
import java.util.*;

public class Main {
    public static void dfs(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        dfs(root.left);
        dfs(root.right);
    }

    public static void bfs(TreeNode root) {
        if (

root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        System.out.print("DFS: ");
        dfs(root); // Output: 1 2 3
        
        System.out.println();
        
        System.out.print("BFS: ");
        bfs(root); // Output: 1 2 3
    }
}
```

### **Fibonacci Sequence**

```java
public class Main {
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6)); // Output: 8
    }
}
```

---

### **0/1 Knapsack Problem**

```java
public class Main {
    public static int knapSack(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0) return 0;
        
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
        } else {
            return knapSack(W, wt, val, n - 1);
        }
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        System.out.println(knapSack(W, wt, val, val.length)); // Output: 220
    }
}
```

---

### **Coin Change Problem**

```java
public class Main {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount)); // Output: 3
    }
}
```

---

### **Tower of Hanoi**

```java
public class Main {
    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        towerOfHanoi(3, 'A', 'B', 'C'); // Output steps to move disks from A to C
    }
}
```

---

### **Merge Sort**

```java
public class Main {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr);
        
        for (int num : arr) {
            System.out.print(num + " "); // Output: 3 9 10 27 38 43 82
        }
    }
}
```

---

### **Quick Sort**

```java
public class Main {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        
        for (int num : arr) {
            System.out.print(num + " "); // Output: 1 5 7 8 9 10
        }
    }
}
```

## **System Design Questions**
Designing scalable systems like a URL shortener, cache system, messaging system, file storage system, and social media platform involves understanding various system design principles such as scalability, reliability, performance, and efficient data storage. Below are the Java code snippets and high-level approaches to design these systems.

### 1. **URL Shortener**
A URL shortener takes long URLs and converts them into shorter, easily shareable versions (e.g., bit.ly). The system involves a unique identifier for each URL and a mechanism to retrieve the original URL.

#### Components:
- **Database**: Store the mapping between the short URL and the original URL.
- **Encoder/Decoder**: Convert a long URL into a unique short URL and decode it back to the original URL.

```java
import java.util.HashMap;
import java.util.Map;

public class URLShortener {
    private Map<String, String> urlDatabase;
    private static final String BASE_URL = "http://short.ly/";

    public URLShortener() {
        urlDatabase = new HashMap<>();
    }

    // Encode the URL
    public String encode(String longUrl) {
        String shortUrl = BASE_URL + Long.toHexString(longUrl.hashCode());
        urlDatabase.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decode the URL
    public String decode(String shortUrl) {
        return urlDatabase.get(shortUrl);
    }

    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();
        String longUrl = "https://www.example.com";
        String shortUrl = urlShortener.encode(longUrl);
        System.out.println("Short URL: " + shortUrl);
        System.out.println("Original URL: " + urlShortener.decode(shortUrl));
    }
}
```

---

### 2. **Cache System (LRU Cache)**
An LRU (Least Recently Used) Cache is a data structure that removes the least recently used item when the cache exceeds its capacity. We use `LinkedHashMap` for an efficient implementation of LRU.

```java
import java.util.*;

public class LRUCache<K, V> {
    private final int capacity;
    private Map<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    // Get value by key
    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    // Put value in the cache
    public void put(K key, V value) {
        if (cache.size() >= capacity) {
            Iterator<Map.Entry<K, V>> iterator = cache.entrySet().iterator();
            iterator.next();
            iterator.remove();  // Remove least recently used entry
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(2);
        lruCache.put(1, "A");
        lruCache.put(2, "B");
        System.out.println(lruCache.get(1)); // Output: A
        lruCache.put(3, "C");
        System.out.println(lruCache.get(2)); // Output: null (removed)
    }
}
```

---

### 3. **Messaging System**
Designing a scalable messaging system for real-time communication requires distributed queues, real-time event processing, and a pub/sub mechanism.

#### Key Components:
- **Message Queue**: Distributes messages to users.
- **Pub/Sub Model**: Allows users to subscribe to message topics.
- **Database**: Stores user data and messages.

```java
import java.util.*;

class Message {
    String content;
    String sender;
    String receiver;

    public Message(String sender, String receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }
}

public class MessagingSystem {
    private Map<String, List<Message>> messages;

    public MessagingSystem() {
        messages = new HashMap<>();
    }

    // Send a message from sender to receiver
    public void sendMessage(String sender, String receiver, String content) {
        Message message = new Message(sender, receiver, content);
        messages.computeIfAbsent(receiver, k -> new ArrayList<>()).add(message);
        System.out.println("Message sent from " + sender + " to " + receiver);
    }

    // Retrieve all messages for a user
    public List<Message> getMessages(String receiver) {
        return messages.getOrDefault(receiver, new ArrayList<>());
    }

    public static void main(String[] args) {
        MessagingSystem system = new MessagingSystem();
        system.sendMessage("Alice", "Bob", "Hello, Bob!");
        system.sendMessage("Bob", "Alice", "Hi, Alice!");

        List<Message> bobMessages = system.getMessages("Bob");
        for (Message msg : bobMessages) {
            System.out.println(msg.sender + ": " + msg.content);
        }
    }
}
```

---

### 4. **File Storage System (like Dropbox/Google Drive)**
A simple file storage system can allow uploading, storing, and downloading files. The system can store file metadata (e.g., file name, size) in a database and files in a storage service.

#### Key Components:
- **Database**: Store file metadata (e.g., file name, size, owner).
- **File Storage**: A system (local or cloud) to store the actual files.

```java
import java.util.*;

class FileMetadata {
    String filename;
    long size;
    String owner;

    public FileMetadata(String filename, long size, String owner) {
        this.filename = filename;
        this.size = size;
        this.owner = owner;
    }
}

public class FileStorageSystem {
    private Map<String, FileMetadata> fileDatabase;

    public FileStorageSystem() {
        fileDatabase = new HashMap<>();
    }

    // Upload a file
    public void uploadFile(String filename, long size, String owner) {
        FileMetadata metadata = new FileMetadata(filename, size, owner);
        fileDatabase.put(filename, metadata);
        System.out.println("File uploaded: " + filename);
    }

    // Download a file's metadata
    public FileMetadata downloadFile(String filename) {
        return fileDatabase.get(filename);
    }

    public static void main(String[] args) {
        FileStorageSystem storage = new FileStorageSystem();
        storage.uploadFile("document1.txt", 5000, "Alice");
        FileMetadata file = storage.downloadFile("document1.txt");
        System.out.println("Filename: " + file.filename + ", Owner: " + file.owner);
    }
}
```

---

### 5. **Social Media Platform (like Twitter/Facebook)**
A social media platform allows users to post content, follow others, and view feeds. We need components for users, posts, followers, and the feed system.

#### Key Components:
- **User**: Stores user information.
- **Post**: Represents a user's post.
- **Follow System**: Manages user follow relationships.
- **Feed**: Retrieves posts based on followers.

```java
import java.util.*;

class User {
    String username;
    Set<User> followers;

    public User(String username) {
        this.username = username;
        this.followers = new HashSet<>();
    }

    // Follow another user
    public void follow(User user) {
        this.followers.add(user);
    }

    // Post something on feed
    public void post(String content) {
        System.out.println(username + " posted: " + content);
    }
}

public class SocialMediaPlatform {
    private Map<String, User> users;

    public SocialMediaPlatform() {
        users = new HashMap<>();
    }

    // Register a new user
    public User registerUser(String username) {
        User user = new User(username);
        users.put(username, user);
        return user;
    }

    // Get feed for a user (posts from people they follow)
    public void getFeed(User user) {
        for (User follower : user.followers) {
            System.out.println(follower.username + " posted something.");
        }
    }

    public static void main(String[] args) {
        SocialMediaPlatform platform = new SocialMediaPlatform();
        
        User alice = platform.registerUser("Alice");
        User bob = platform.registerUser("Bob");
        User charlie = platform.registerUser("Charlie");

        alice.follow(bob);
        alice.follow(charlie);
        
        bob.post("Hello, world!");
        charlie.post("Good morning, everyone!");
        
        platform.getFeed(alice);
    }
}
```

---

### Key Design Considerations
- **Scalability**: Systems like these should be designed to scale horizontally (add more servers) to handle high traffic.
- **Caching**: Cache frequently accessed data (e.g., URLs in URL shorteners, user data in social media) to reduce database load.
- **Distributed Systems**: Many of these systems (especially file storage, messaging, and social media) would benefit from distributed architectures for high availability and fault tolerance.
- **Data Persistence**: Data should be stored in databases with proper indexes and optimized for reads/writes based on the use case.



## **Miscellaneous**

Designing scalable systems like a URL shortener, cache system, messaging system, file storage system, and social media platform involves understanding various system design principles such as scalability, reliability, performance, and efficient data storage. Below are the Java code snippets and high-level approaches to design these systems.

### 1. **URL Shortener**
A URL shortener takes long URLs and converts them into shorter, easily shareable versions (e.g., bit.ly). The system involves a unique identifier for each URL and a mechanism to retrieve the original URL.

#### Components:
- **Database**: Store the mapping between the short URL and the original URL.
- **Encoder/Decoder**: Convert a long URL into a unique short URL and decode it back to the original URL.

```java
import java.util.HashMap;
import java.util.Map;

public class URLShortener {
    private Map<String, String> urlDatabase;
    private static final String BASE_URL = "http://short.ly/";

    public URLShortener() {
        urlDatabase = new HashMap<>();
    }

    // Encode the URL
    public String encode(String longUrl) {
        String shortUrl = BASE_URL + Long.toHexString(longUrl.hashCode());
        urlDatabase.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decode the URL
    public String decode(String shortUrl) {
        return urlDatabase.get(shortUrl);
    }

    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();
        String longUrl = "https://www.example.com";
        String shortUrl = urlShortener.encode(longUrl);
        System.out.println("Short URL: " + shortUrl);
        System.out.println("Original URL: " + urlShortener.decode(shortUrl));
    }
}
```

---

### 2. **Cache System (LRU Cache)**
An LRU (Least Recently Used) Cache is a data structure that removes the least recently used item when the cache exceeds its capacity. We use `LinkedHashMap` for an efficient implementation of LRU.

```java
import java.util.*;

public class LRUCache<K, V> {
    private final int capacity;
    private Map<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    // Get value by key
    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    // Put value in the cache
    public void put(K key, V value) {
        if (cache.size() >= capacity) {
            Iterator<Map.Entry<K, V>> iterator = cache.entrySet().iterator();
            iterator.next();
            iterator.remove();  // Remove least recently used entry
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(2);
        lruCache.put(1, "A");
        lruCache.put(2, "B");
        System.out.println(lruCache.get(1)); // Output: A
        lruCache.put(3, "C");
        System.out.println(lruCache.get(2)); // Output: null (removed)
    }
}
```

---

### 3. **Messaging System**
Designing a scalable messaging system for real-time communication requires distributed queues, real-time event processing, and a pub/sub mechanism.

#### Key Components:
- **Message Queue**: Distributes messages to users.
- **Pub/Sub Model**: Allows users to subscribe to message topics.
- **Database**: Stores user data and messages.

```java
import java.util.*;

class Message {
    String content;
    String sender;
    String receiver;

    public Message(String sender, String receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }
}

public class MessagingSystem {
    private Map<String, List<Message>> messages;

    public MessagingSystem() {
        messages = new HashMap<>();
    }

    // Send a message from sender to receiver
    public void sendMessage(String sender, String receiver, String content) {
        Message message = new Message(sender, receiver, content);
        messages.computeIfAbsent(receiver, k -> new ArrayList<>()).add(message);
        System.out.println("Message sent from " + sender + " to " + receiver);
    }

    // Retrieve all messages for a user
    public List<Message> getMessages(String receiver) {
        return messages.getOrDefault(receiver, new ArrayList<>());
    }

    public static void main(String[] args) {
        MessagingSystem system = new MessagingSystem();
        system.sendMessage("Alice", "Bob", "Hello, Bob!");
        system.sendMessage("Bob", "Alice", "Hi, Alice!");

        List<Message> bobMessages = system.getMessages("Bob");
        for (Message msg : bobMessages) {
            System.out.println(msg.sender + ": " + msg.content);
        }
    }
}
```

---

### 4. **File Storage System (like Dropbox/Google Drive)**
A simple file storage system can allow uploading, storing, and downloading files. The system can store file metadata (e.g., file name, size) in a database and files in a storage service.

#### Key Components:
- **Database**: Store file metadata (e.g., file name, size, owner).
- **File Storage**: A system (local or cloud) to store the actual files.

```java
import java.util.*;

class FileMetadata {
    String filename;
    long size;
    String owner;

    public FileMetadata(String filename, long size, String owner) {
        this.filename = filename;
        this.size = size;
        this.owner = owner;
    }
}

public class FileStorageSystem {
    private Map<String, FileMetadata> fileDatabase;

    public FileStorageSystem() {
        fileDatabase = new HashMap<>();
    }

    // Upload a file
    public void uploadFile(String filename, long size, String owner) {
        FileMetadata metadata = new FileMetadata(filename, size, owner);
        fileDatabase.put(filename, metadata);
        System.out.println("File uploaded: " + filename);
    }

    // Download a file's metadata
    public FileMetadata downloadFile(String filename) {
        return fileDatabase.get(filename);
    }

    public static void main(String[] args) {
        FileStorageSystem storage = new FileStorageSystem();
        storage.uploadFile("document1.txt", 5000, "Alice");
        FileMetadata file = storage.downloadFile("document1.txt");
        System.out.println("Filename: " + file.filename + ", Owner: " + file.owner);
    }
}
```

---

### 5. **Social Media Platform (like Twitter/Facebook)**
A social media platform allows users to post content, follow others, and view feeds. We need components for users, posts, followers, and the feed system.

#### Key Components:
- **User**: Stores user information.
- **Post**: Represents a user's post.
- **Follow System**: Manages user follow relationships.
- **Feed**: Retrieves posts based on followers.

```java
import java.util.*;

class User {
    String username;
    Set<User> followers;

    public User(String username) {
        this.username = username;
        this.followers = new HashSet<>();
    }

    // Follow another user
    public void follow(User user) {
        this.followers.add(user);
    }

    // Post something on feed
    public void post(String content) {
        System.out.println(username + " posted: " + content);
    }
}

public class SocialMediaPlatform {
    private Map<String, User> users;

    public SocialMediaPlatform() {
        users = new HashMap<>();
    }

    // Register a new user
    public User registerUser(String username) {
        User user = new User(username);
        users.put(username, user);
        return user;
    }

    // Get feed for a user (posts from people they follow)
    public void getFeed(User user) {
        for (User follower : user.followers) {
            System.out.println(follower.username + " posted something.");
        }
    }

    public static void main(String[] args) {
        SocialMediaPlatform platform = new SocialMediaPlatform();
        
        User alice = platform.registerUser("Alice");
        User bob = platform.registerUser("Bob");
        User charlie = platform.registerUser("Charlie");

        alice.follow(bob);
        alice.follow(charlie);
        
        bob.post("Hello, world!");
        charlie.post("Good morning, everyone!");
        
        platform.getFeed(alice);
    }
}
```

---

### Key Design Considerations
- **Scalability**: Systems like these should be designed to scale horizontally (add more servers) to handle high traffic.
- **Caching**: Cache frequently accessed data (e.g., URLs in URL shorteners, user data in social media) to reduce database load.
- **Distributed Systems**: Many of these systems (especially file storage, messaging, and social media) would benefit from distributed architectures for high availability and fault tolerance.
- **Data Persistence**: Data should be stored in databases with proper indexes and optimized for reads/writes based on the use case.
