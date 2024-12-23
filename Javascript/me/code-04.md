Here's a list of the topics and questions you can practice:

### 1\. **String Manipulation Questions**

### 1\. **Reverse a String**

To reverse a string in Python:

```python
pythonCopy codedef reverse_string(s: str) -> str:
    return s[::-1]
```

### 2\. **Check if a String is a Palindrome**

A palindrome is a string that reads the same forward and backward.

```python
pythonCopy codedef is_palindrome(s: str) -> bool:
    return s == s[::-1]
```

### 3\. **Find the First Non-Repeating Character in a String**

You can use a dictionary or counter to track the occurrences of each character and find the first character with only one occurrence.

```python
pythonCopy codefrom collections import Counter

def first_non_repeating(s: str) -> str:
    count = Counter(s)
    for char in s:
        if count[char] == 1:
            return char
    return None  # If no non-repeating character exists
```

### 4\. **Count the Number of Vowels in a String**

To count the number of vowels, check if each character is in the set of vowels (`'aeiou'` or `'AEIOU'`).

```python
pythonCopy codedef count_vowels(s: str) -> int:
    vowels = set('aeiouAEIOU')
    return sum(1 for char in s if char in vowels)
```

### 5\. **Remove Duplicate Characters from a String**

To remove duplicates, you can use a set to track characters you've seen and append only the first occurrences.

```python
pythonCopy codedef remove_duplicates(s: str) -> str:
    seen = set()
    result = []
    for char in s:
        if char not in seen:
            result.append(char)
            seen.add(char)
    return ''.join(result)
```

### 6\. **Find the Longest Substring Without Repeating Characters**

To find the longest substring without repeating characters, a sliding window approach works best.

```python
pythonCopy codedef longest_substring_without_repeating(s: str) -> str:
    start = 0
    max_len = 0
    max_substr = ""
    seen = {}

    for end in range(len(s)):
        if s[end] in seen and seen[s[end]] >= start:
            start = seen[s[end]] + 1
        seen[s[end]] = end
        if end - start + 1 > max_len:
            max_len = end - start + 1
            max_substr = s[start:end+1]
    
    return max_substr
```

### 7\. **Check if Two Strings are Anagrams of Each Other**

Two strings are anagrams if they contain the same characters in the same frequency. One way to check this is by sorting both strings and comparing them.

```python
pythonCopy codedef are_anagrams(s1: str, s2: str) -> bool:
    return sorted(s1) == sorted(s2)
```

Alternatively, you can use a `Counter` to count the occurrences of each character.

```python
pythonCopy codefrom collections import Counter

def are_anagrams(s1: str, s2: str) -> bool:
    return Counter(s1) == Counter(s2)
```

---

These functions should cover the basic string manipulation tasks. Let me know if you need further explanation or examples!

### 2\. **Array Manipulation Questions**

Here are the solutions to each of the problems you've mentioned:

### 1\. **Reverse an Array**

To reverse an array in Python, you can use the `reverse()` method or slicing.

```python
pythonCopy codedef reverse_array(arr):
    return arr[::-1]

# Example
arr = [1, 2, 3, 4, 5]
print(reverse_array(arr))  # Output: [5, 4, 3, 2, 1]
```

### 2\. **Find the Maximum Product of Two Integers in an Array**

To find the maximum product of two integers, we can sort the array and check the product of the two largest numbers, or the product of the two smallest numbers (if they are negative).

```python
pythonCopy codedef max_product(arr):
    arr.sort()
    return max(arr[0] * arr[1], arr[-1] * arr[-2])

# Example
arr = [1, 10, -5, 1, -100]
print(max_product(arr))  # Output: 5000
```

### 3\. **Find the Missing Number in an Array (1 to N)**

If the array contains numbers from 1 to N, the sum of the numbers can be calculated using the formula <math><semantics><mrow><mfrac><mrow><mi>n</mi><mo>(</mo><mi>n</mi><mo>+</mo><mn>1</mn><mo>)</mo></mrow><mn>2</mn></mfrac></mrow><annotation>\\frac{n(n+1)}{2}</annotation></semantics></math>2n(n+1)​. The difference between the expected sum and the actual sum gives the missing number.

```python
pythonCopy codedef find_missing_number(arr, n):
    total_sum = n * (n + 1) // 2
    actual_sum = sum(arr)
    return total_sum - actual_sum

# Example
arr = [1, 2, 4, 5, 6]
n = 6
print(find_missing_number(arr, n))  # Output: 3
```

### 4\. **Move All Zeroes in an Array to the End, Maintaining the Order of Other Elements**

This can be done by maintaining two pointers, one for iterating through the array and one for tracking the last non-zero position.

```python
pythonCopy codedef move_zeroes(arr):
    non_zero_index = 0
    for i in range(len(arr)):
        if arr[i] != 0:
            arr[non_zero_index], arr[i] = arr[i], arr[non_zero_index]
            non_zero_index += 1
    return arr

# Example
arr = [0, 1, 9, 0, 5, 0, 3]
print(move_zeroes(arr))  # Output: [1, 9, 5, 3, 0, 0, 0]
```

### 5\. **Find the Intersection of Two Arrays**

The intersection of two arrays can be found using sets to eliminate duplicates.

```python
pythonCopy codedef intersection(arr1, arr2):
    return list(set(arr1) & set(arr2))

# Example
arr1 = [1, 2, 3, 4, 5]
arr2 = [3, 4, 5, 6, 7]
print(intersection(arr1, arr2))  # Output: [3, 4, 5]
```

### 6\. **Find the Pair with the Smallest Absolute Difference in an Array**

Sort the array first and then check adjacent pairs for the smallest difference.

```python
pythonCopy codedef smallest_diff(arr):
    arr.sort()
    min_diff = float('inf')
    pair = None
    for i in range(len(arr) - 1):
        diff = abs(arr[i] - arr[i + 1])
        if diff < min_diff:
            min_diff = diff
            pair = (arr[i], arr[i + 1])
    return pair

# Example
arr = [1, 5, 3, 19, 18, 25]
print(smallest_diff(arr))  # Output: (18, 19)
```

### 7\. **Rotate an Array by a Given Number of Steps**

To rotate an array to the right by `k` steps, use slicing.

```python
pythonCopy codedef rotate_array(arr, k):
    n = len(arr)
    k = k % n  # To handle rotations greater than array length
    return arr[-k:] + arr[:-k]

# Example
arr = [1, 2, 3, 4, 5]
k = 2
print(rotate_array(arr, k))  # Output: [4, 5, 1, 2, 3]
```

### 8\. **Merge Two Sorted Arrays into One Sorted Array**

We can use the two-pointer technique to merge two sorted arrays.

```python
pythonCopy codedef merge_sorted_arrays(arr1, arr2):
    result = []
    i, j = 0, 0
    while i < len(arr1) and j < len(arr2):
        if arr1[i] < arr2[j]:
            result.append(arr1[i])
            i += 1
        else:
            result.append(arr2[j])
            j += 1
    result.extend(arr1[i:])
    result.extend(arr2[j:])
    return result

# Example
arr1 = [1, 3, 5, 7]
arr2 = [2, 4, 6, 8]
print(merge_sorted_arrays(arr1, arr2))  # Output: [1, 2, 3, 4, 5, 6, 7, 8]
```

### 9\. **Find the First Duplicate Number in an Array**

We can use a set to track the numbers we've already seen.

```python
pythonCopy codedef first_duplicate(arr):
    seen = set()
    for num in arr:
        if num in seen:
            return num
        seen.add(num)
    return None

# Example
arr = [1, 2, 3, 4, 5, 3, 6]
print(first_duplicate(arr))  # Output: 3
```

These solutions cover each of the problems efficiently using Python. Let me know if you'd like further clarification or improvements!

### 3\. **Sorting & Searching**

Sure! Below are the solutions for the questions you asked:

### 1\. **Quicksort Implementation**

```python
pythonCopy codedef quicksort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quicksort(left) + middle + quicksort(right)

# Example:
arr = [3, 6, 8, 10, 1, 2, 1]
sorted_arr = quicksort(arr)
print(sorted_arr)  # Output: [1, 1, 2, 3, 6, 8, 10]
```

### 2\. **Mergesort Implementation**

```python
pythonCopy codedef mergesort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = mergesort(arr[:mid])
    right = mergesort(arr[mid:])
    
    return merge(left, right)

def merge(left, right):
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result.extend(left[i:])
    result.extend(right[j:])
    return result

# Example:
arr = [3, 6, 8, 10, 1, 2, 1]
sorted_arr = mergesort(arr)
print(sorted_arr)  # Output: [1, 1, 2, 3, 6, 8, 10]
```

### 3\. **Binary Search Implementation**

```python
pythonCopy codedef binary_search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1  # Target not found

# Example:
arr = [1, 2, 3, 4, 5, 6, 7, 8]
target = 4
result = binary_search(arr, target)
print(result)  # Output: 3 (index of 4)
```

### 4\. **Find the kth Largest/Smallest Element in an Array**

```python
pythonCopy codeimport heapq

def kth_largest(arr, k):
    return heapq.nlargest(k, arr)[-1]

def kth_smallest(arr, k):
    return heapq.nsmallest(k, arr)[-1]

# Example:
arr = [7, 10, 4, 3, 20, 15]
k = 3
print(kth_largest(arr, k))  # Output: 10 (3rd largest element)
print(kth_smallest(arr, k))  # Output: 7 (3rd smallest element)
```

### 5\. **Find the Majority Element (Element that Appears More than n/2 Times)**

```python
pythonCopy codefrom collections import Counter

def majority_element(arr):
    count = Counter(arr)
    n = len(arr)
    for num, freq in count.items():
        if freq > n // 2:
            return num
    return None  # No majority element

# Example:
arr = [3, 3, 4, 2, 4, 4, 2, 4, 4]
print(majority_element(arr))  # Output: 4 (appears more than n/2 times)
```

### 6\. **Sort an Array of Strings Based on Length**

```python
pythonCopy codedef sort_strings_by_length(arr):
    return sorted(arr, key=len)

# Example:
arr = ["apple", "banana", "cherry", "date"]
sorted_arr = sort_strings_by_length(arr)
print(sorted_arr)  # Output: ['date', 'apple', 'banana', 'cherry']
```

### 7\. **Find the Peak Element in an Array**

A peak element is an element that is greater than its neighbors. For the first and last element, one of its neighbors is considered out of bounds.

```python
pythonCopy codedef find_peak_element(arr):
    n = len(arr)
    if n == 1:
        return arr[0]
    if arr[0] > arr[1]:
        return arr[0]
    if arr[n - 1] > arr[n - 2]:
        return arr[n - 1]
    
    for i in range(1, n - 1):
        if arr[i] > arr[i - 1] and arr[i] > arr[i + 1]:
            return arr[i]
    return None  # No peak found (though this is unlikely)

# Example:
arr = [1, 3, 20, 4, 1, 0]
print(find_peak_element(arr))  # Output: 20 (peak element)
```

---

These are the answers for the questions you provided. Let me know if you need further explanations or adjustments!

### 4\. **Linked List Questions**

* Reverse a singly linked list.
* Detect a cycle in a linked list.
* Merge two sorted linked lists.
* Find the middle element of a linked list.
* Find the intersection point of two linked lists.
* Remove the nth node from the end of a linked list.

### 5\. **Dynamic Programming**

* Implement the Fibonacci sequence (both recursive and iterative).
* Find the maximum sum of a subarray (Kadane's Algorithm).
* Coin change problem.
* Longest common subsequence (LCS).
* Longest increasing subsequence (LIS).
* 0/1 Knapsack problem.

### 6\. **Recursion and Backtracking**

* Solve the N-Queens problem.
* Generate all possible subsets of a set (power set).
* Solve a maze (find a path from the start to the end).
* Generate all permutations of a string or an array.
* Solve the subset sum problem.

### 7\. **Tree and Graph Questions**

* Implement a binary tree (insertion, traversal, etc.).
* Find the height of a binary tree.
* Check if a binary tree is balanced.
* Level order traversal of a binary tree (Breadth-First Search).
* Depth-first search (DFS) of a graph.
* Breadth-first search (BFS) of a graph.
* Find the lowest common ancestor (LCA) of two nodes in a binary tree.
* Serialize and deserialize a binary tree.
* Find all paths from the root to leaf nodes in a binary tree.
* Detect a cycle in a directed or undirected graph.
* Implement topological sort.

### 8\. **Bit Manipulation**

* Check if a number is a power of two.
* Count the number of 1-bits in a number (Hamming weight).
* Swap two numbers without using a temporary variable.
* Find the single number in an array where every other number appears twice.
* Determine if two numbers have opposite signs.

### 9\. **Hashing and HashMap Questions**

* Find the first non-repeating character in a string (using a hash map).
* Check if two strings are anagrams (using a hash map).
* Group anagrams from a list of strings.
* Find all pairs that sum to a target value in an array.
* Given a list of numbers, find all pairs that sum to a specific value.
* Implement an LRU cache.

### 10\. **Mathematical Problems**

* Find the greatest common divisor (GCD) of two numbers.
* Find the least common multiple (LCM) of two numbers.
* Check if a number is prime.
* Find the sum of digits of a number.
* Find the factorial of a number.
* Compute the power of a number (exponentiation).

### 11\. **Concurrency and Asynchronous Programming**

* Implement a basic Promise or async/await pattern.
* Implement a debounce function.
* Implement a throttle function.
* Handle concurrent requests with Promise.all or Promise.race.
* Implement a simple event loop.
* Design a rate limiter using JavaScript.

### 12\. **Design and System Design**

* Design a URL shortener service (like Bitly).
* Design a cache system (e.g., LRU Cache).
* Design a parking lot system.
* Design a ticket booking system.
* Design a chat application.
* Design a file system.
* Design a messaging queue (e.g., Kafka, RabbitMQ).

### 13\. **Miscellaneous**

* Find the maximum subarray sum of a given array.
* Check if a number is a palindrome.
* Implement a simple calculator for basic arithmetic operations.
* Check if a string is a valid number (e.g., integer, floating-point).
* Convert a number to a string in a specific base (binary, hexadecimal).
* Implement a function to perform matrix multiplication.

---

Let me know if you want to dive deeper into any of these questions or need help with solutions!