Here’s a list of 100 JavaScript questions similar to the ones you’ve asked for. These questions can cover a range of topics from basic to intermediate/advanced JavaScript concepts.

### Basic JavaScript Questions:

### Code 0: How to remove duplicates from an array of objects using JavaScript ?

#### Way 1: Using one of the keys as an index
```javascript
  var books = [
      { title: "C++", author: "Bjarne" },
      { title: "Java", author: "James" },
      { title: "Python", author: "Guido" },
      { title: "Java", author: "James" },
  ];

   let arrLeft = [];
    let arrRight = [];
    let result = [];
    function getDuplicate(books) {
        for (let index = 0; index < books.length; index++) {
            if(!arrLeft.includes(books[index].title)) {
                arrLeft.push(books[index].title);                
            } else {
                arrRight.push(books[index].title);
                result.push(books[index]);
            }
        }

        console.log("result----", result);
    }
   
    getDuplicate(books);
```

#### Way 2: Using filter() and includes() Method

```javascript
const books = [
    { title: "C++", author: "Bjarne" },
    { title: "Java", author: "James" },
    { title: "Python", author: "Guido" },
    { title: "Java", author: "James" },
];
 
const ids = books.map(({ title }) => title);
const filtered = books.filter(({ title }, index) =>
    !ids.includes(title, index + 1));
 
console.log(filtered);
```
#### Way 3: Using filter() and findIndex() Method
```javascript
const books = [
    { title: "C++", author: "Bjarne" },
    { title: "Java", author: "James" },
    { title: "Python", author: "Guido" },
    { title: "Java", author: "James" },
];
 
const unique = books.filter((obj, index) => {
    return index === books.findIndex(o => obj.title === o.title);
});
 
console.log(unique);
```

------------------------------------------
### Code 3: Remove Duplicate characters from String 
```javascript
#### Way 1: using includes method
function removeDuplicateCharacters() {
    var string = 'priya riya supriya';
    let result = '';
    
    // Loop through each character in the string
    for (let i = 0; i < string.length; i++) {
        let char = string[i];

        if (!result.includes(char)) {
            result += char;
        }

    }
    
    return result;
    }
console.log(removeDuplicateCharacters()); // Output: priya su

#### Way 2: using includes indexOf
function removeDuplicateCharacters() {
  var string = 'priya riya supriya';
  let result = '';
  
  // Loop through each character in the string
  for (let i = 0; i < string.length; i++) {
    let char = string[i];
    
    // Check if the character is already in the result
    if (result.indexOf(char) === -1) {
      result += char;  // Add the character to the result if it's not a duplicate
    }
  }
  
  return result;
}

console.log(removeDuplicateCharacters()); // Output: priya su
```

### Code 4: Remove Duplicate characters from array of element using filter or for loop
```javascript

#### Way 1
	let arrLeft = [];
    let arrRight = [];
    let result = [];
    function getDuplicate(arr) {
        for (let index = 0; index < arr.length; index++) {
            if(!arrLeft.includes(arr[index])) {
                arrLeft.push(arr[index]);                
            } else {
                arrRight.push(arr[index]);
                result.push(arr[index]);
            }
        }

        console.log("result----", result);
    }
   
getDuplicate([1,2,3,4,3,7,4,5]); // output  [3, 4]

#### Way 2
var myArray = ['a', 1, 'a', 2, '1'];
var unique = myArray.filter((value, index, arr) => arr.indexOf(value) === index);
// output: ['a', 1, 2, '1']
```
------------------------------------------
### Code 5: String reverse without reversing of individual words (Array of elements can be reverse with reverse() method but for string it is won't possible so required to split 

#### Way 1: Using split, reverse and join
```javascript
function removeDuplicates(){
   var string ="India is my country"
   let result = string.split('').reverse().join('').split(' ').reverse().join(' ')
   return result
}
console.log(removeDuplicates()) 
output = "aidnI si ym yrtnuoc"
```

#### Way 2: Using loop
```javascript
function removeDuplicates() {
   var string = "India is my country";
   
   // Initialize an empty string to store the result
   let reversedString = "";
   
   // Reverse the whole string manually
   for (let i = string.length - 1; i >= 0; i--) {
       reversedString += string[i];
   }
   
   // Now we reverse the words manually
   let words = "";
   let tempWord = "";
   for (let i = reversedString.length - 1; i >= 0; i--) {
       if (reversedString[i] === ' ') {
           // Add the word to the words string with a space
           words = tempWord + ' ' + words;
           tempWord = "";  // Reset the temporary word
       } else {
           tempWord = reversedString[i] + tempWord;
       }
   }
   // Add the last word
   words = tempWord + ' ' + words;
   
   // Return the final result
   return words.trim();
}

console.log(removeDuplicates());
```

### Code 6: String reverse with reversing of individual words
#### Way 1: Using split, reverse and join
```javascript
function withoutReverse(){
   var string ="India is my country"
   let result = string.split('').reverse().join('')
   return result
}
console.log(withoutReverse())
output = "yrtnuoc ym si aidnI"
```
#### Way 2: Using for loop
```javascript
function Reverse(){
   var string ="India is my country";
   var result="";
   for( var i=string.length-1; i>=0 ; i-- ) {
      result = result+string[i] }
   return result
}
console.log(Reverse())
output = "yrtnuoc ym si aidnI"
```

------------------------------------------
### Code 7: Swapping of 2 numbers with third variable
```javascript
let a=10;
let b=20;
let c;
   c=a;
   a=b;
   b=c;
console.log (a,b,c)
// output : 20, 10, 10
```
------------------------------------------
### Code 8: Swapping of 2 numbers without third variable
```javascript
let a=10; 
let b=20;
   a=a+b //30
   b=a-b //10
   a=a-b //20
console.log (a,b)
// output : 20, 10
```
------------------------------------------
### Code 9: To check the string or number is palindrome or not( ex: 121,madam,anna) using diving length by 2 and then comparing
#### Way 1
```javascript
  function checkPalindrome() {
      const string = "12321";
      let isPalindrome = true;  // Initial assumption is that the string is a palindrome
      let len = string.length;
      let j = len - 1;

          for (let i = 0; i < len / 2; i++) {  // Only need to loop halfway through the string
              if (string[i] !== string[j]) {
                  isPalindrome = false;  // If a mismatch is found, set to false
                  break;  // Exit the loop early as we already know it's not a palindrome
              }
              j--;  // Move the pointer towards the middle
          }
      return isPalindrome;
  }

  console.log(checkPalindrome());  // Returns true if palindrome, false otherwise
```
#### Way 2
```javascript
function checkPalindrome(){
   const string = "12321"
   let len = string.length;
   for (i=0; i<len/2;i++){
     if (string[i]!==string[len-1-i]){
         console.log("Not Palindrome")
     }
     else{
         console.log(" Palindrome")
    }
   }
}
checkPalindrome()
// output: "Palindrome"
```
------------------------------------------
### Code 10: To find Max and Min num from array using functions
#### Way 1 to get max num using function
```javascript
function maxValue(arr) {
  let max = arr[0];

  for (let val of arr) {
    if (val > max) {
      max = val;
    }
  }
  return max;
}
console.log(maxValue([3,6,7,8,0]));
// output: 8
```
#### Way 2 to get min num using loop
```javascript
function minValue(arr) {
    let min = Infinity;  // Initialize min to a very large number
    for (let index = 0; index < arr.length; index++) {
        if (arr[index] < min) {  // Compare the current value with the current min
            min = arr[index];  // Update min if a smaller value is found
        }
    }
    console.log("min----", min);  // Log the minimum value
}

minValue([4, 5, 3, 1, 9]); // output: 1
```
### Code 11: To find longest snd shortesh word from a string using custom code

#### Way1 to get longest number using loop
```javascript
function longest() {
  var str ="Priya is a good girl and having hardworking skills"
  var words = str.split(' ');
  var longest = ''; 
  for (var i = 0; i < words.length; i++) {
    if (words[i].length > longest.length) {
      longest = words[i]; 
    }
  }
  console.log(longest)
  return longest;
}
longest();
// Output: hardworking
```
#### Way1 to get shortest number using loop
```javascript
function shortest() {
  var str ="Priya is a good girl and having hardworking skills"
  var words = str.split(' ');
  var shortest = ''; 
  let shortestNum = Infinity;
  for (var i = 0; i < words.length; i++) {
    if (words[i].length < shortestNum) {
        shortestNum = words[i].length; 
        shortest = words[i]
    }
  }
  console.log("====", shortest)
  return shortest;
}
shortest();
```

------------------------------------------
### Code 12: To find longest common string from array of strings
```javascript
function longestCommonString(){
 let array=["go","google","gosh"]
  var arr = array.sort((a,b)=>a.length-b.length)
  let result =""
  for(let i=0; i<arr[0].length; i++){
    if(arr[0][i]===arr[arr.length-1][i]){
      result+=arr[0][i]
    }
  }
  console.log("result---", result);
  return result
}
console.log(longestCommonString())
// output : go
```
------------------------------------------
### Code 13: To find vowels and its count in a given string
#### Way 1 using while loop
```javascript
function vowelCounts(){
  vowels=["a","i","e","o","u"]
  var str ="priya"
  count=0;
  for(var letter of str.toLowerCase())
  {
    if(vowels.includes(letter))
    {
      count++;
      console.log(letter)
    }
  }
  console.log(count)
  return count
}
vowelCounts()
// output
// "i"
// "a"
// 2

```
#### Way 2 using loop
```javascript
function countVowels(str) {
  let vowels = 'aeiouAEIOU'; // String containing all vowels (both lowercase and uppercase)
  let vowelCount = 0; // Variable to keep track of the count of vowels
  let vowelList = []; // Array to store vowels found in the string

  // Loop through each character of the string
  for (let i = 0; i < str.length; i++) {
    let char = str[i];

    // Check if the current character is a vowel
    if (vowels.includes(char)) {
      vowelCount++; // Increment the vowel count
      vowelList.push(char); // Add the vowel to the list
    }
  }

  // Return the count and the list of vowels found
  return {
    count: vowelCount,
    vowels: vowelList
  };
}

// Example usage:
let inputString = "Hello World!";
let result = countVowels(inputString);

console.log("Vowels found:", result.vowels.join(", "));
console.log("Total vowels count:", result.count);

```
------------------------------------------
### Code 14: sort array data in javascript using loop
### 1\. **Sort data suign simple way**
```javascript
let arr = [3, 5, 2, 5, 6, 2, 9, 0];

// Bubble Sort implementation
for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
            // Swap the elements
            let temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}

console.log(arr); // [0,2,2,3,5,5,6,9]
```

### Code 15: Fibonacci Series (0,1,1,2,3,5,8,13....) where keeping in array
```javascript
function listFibonacci(n) {
var arr = [0, 1]
  for (var  i = 1; i < n; i++) 
    arr.push(arr[i] + arr[i - 1])

  return arr
}
console.log(listFibonacci(4))
// output: [0, 1, 1, 2, 3]
```
-----------------------------------------------------------------------
```javascript
function listFibonacci(n) {
var arr = [0, 1]
  for (var  i = 0; i < n; i++) 
    arr.push(arr[i] + arr[i + 1])

  return arr
}
console.log(listFibonacci(4))
// output: [0, 1, 1, 2, 3, 5]
```
------------------------------------------
### Code 16: Find factorial of user input number
```javascript
const number = parseInt(prompt('Enter a positive integer: '));
if (number < 0) { console.log('Error! Factorial for negative number does not exist.')}
else if (number === 0) { console.log(`The factorial is 1.`)}
else {
    let fact = 1;
    for (i = 1; i <= number; i++) {
        fact *= i;
    }
    console.log(`The factorial is ${fact}.`);
}
```
------------------------------------------
### Code 17:Anagram
```javascript
function checkStringsAnagram() {
var a="Army";
var b="Mary"
   let str1 =  a.toLowerCase().split('').sort().join('');
   let str2 =  b.toLowerCase().split('').sort().join('');
   if(str1 === str2){
      console.log("True");
   } 
   else { 
      console.log("False");
   }
}
```

### 18. Reverse a string without using String inbuilt function:

```javascript
function reverseString(str) {
  let reversed = '';
  for (let i = str.length - 1; i >= 0; i--) {
    reversed += str[i];
  }
  return reversed;
}

console.log(reverseString("Hello")); // Output: "olleH"
```

This program manually iterates through the string from the last character to the first and appends each character to the `reversed` string.

### 19. Reverse a string without using String inbuilt function `reverse()`:

This is essentially the same problem as the previous one. So, the answer is the same:

```javascript
function reverseString(str) {
  let reversed = '';
  for (let i = str.length - 1; i >= 0; i--) {
    reversed += str[i];
  }
  return reversed;
}

console.log(reverseString("JavaScript")); // Output: "tpircSavaJ"
```

### 20. Swap two numbers using a third variable:

```javascript
function swapNumbers(a, b) {
  let temp = a;
  a = b;
  b = temp;
  return [a, b];
}

let [x, y] = swapNumbers(5, 10);
console.log(x, y); // Output: 10 5
```

Here, a temporary variable `temp` is used to swap the values of `a` and `b`.

### 21. Swap two numbers without using a third variable:

```javascript
function swapNumbersWithoutTemp(a, b) {
  a = a + b;
  b = a - b;
  a = a - b;
  return [a, b];
}

let [x, y] = swapNumbersWithoutTemp(5, 10);
console.log(x, y); // Output: 10 5
```

In this case, the values of `a` and `b` are swapped without using a third variable by performing arithmetic operations.

### 22. Count the number of words in a string using HashMap:

```javascript
function countWords(str) {
  const wordMap = new Map();
  const words = str.split(' ');

  for (let word of words) {
    word = word.toLowerCase();  // To make the count case-insensitive
    wordMap.set(word, (wordMap.get(word) || 0) + 1);
  }

  return wordMap;
}

const result = countWords("JavaScript is great and JavaScript is fun");
console.log(result); // Output: Map { 'javascript' => 2, 'is' => 2, 'great' => 1, 'and' => 1, 'fun' => 1 }
```

This program splits the string into words, then uses a `Map` to store the count of each word.

### 23. Iterate HashMap using `while` and `for` loop:

```javascript
// Iterating using a while loop
function iterateWithWhile(map) {
  let keys = Array.from(map.keys());
  let i = 0;
  while (i < keys.length) {
    console.log(keys[i] + ': ' + map.get(keys[i]));
    i++;
  }
}

// Iterating using a for loop
function iterateWithFor(map) {
  for (let [key, value] of map) {
    console.log(key + ': ' + value);
  }
}

const wordMap = new Map([
  ['javascript', 2],
  ['is', 2],
  ['great', 1],
  ['and', 1],
  ['fun', 1]
]);

iterateWithWhile(wordMap); // Output: 'javascript: 2', 'is: 2', ...
iterateWithFor(wordMap); // Output: 'javascript: 2', 'is: 2', ...
```

Here are the JavaScript programs for each of the problems you've listed:
---
### 1. Find whether a number is prime or not:

```javascript
function isPrime(num) {
  if (num <= 1) return false;
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) return false;
  }
  return true;
}

console.log(isPrime(7)); // Output: true
console.log(isPrime(10)); // Output: false
```

This program checks if a number is divisible by any number between 2 and the square root of the number to determine if it's prime.

### 2. Find whether a string or number is palindrome or not:

```javascript
function isPalindrome(input) {
  // Convert the input to string if it's a number
  const str = input.toString();

  // Loop through the string from start to the middle
  for (let i = 0; i < Math.floor(str.length / 2); i++) {
    // Compare the character from the start and the end
    if (str[i] !== str[str.length - 1 - i]) {
      return false; // If any character doesn't match, it's not a palindrome
    }
  }

  return true; // If the loop completes, it's a palindrome
}

console.log(isPalindrome(121)); // Output: true
console.log(isPalindrome('madam')); // Output: true
console.log(isPalindrome('hello')); // Output: false
```le.log(isPalindrome('hello')); // Output: false
```

This function converts the input to a string (if it's a number) and compares it with its reversed version to check for palindrome.

### 3. Fibonacci series:

```javascript
function fibonacci(n) {
  let a = 0, b = 1;
  let result = [];
  
  for (let i = 0; i < n; i++) {
    result.push(a);
    let nextTerm = a + b;
    a = b;
    b = nextTerm;
  }
  return result;
}

console.log(fibonacci(10)); // Output: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
```

This program generates the first `n` terms of the Fibonacci series by adding the previous two terms.

### 4. Iterate ArrayList using for-loop, while-loop, and advanced for-loop:

```javascript
let arr = [1, 2, 3, 4, 5];

// Using for-loop
for (let i = 0; i < arr.length; i++) {
  console.log(arr[i]);
}

// Using while-loop
let i = 0;
while (i < arr.length) {
  console.log(arr[i]);
  i++;
}

// Using advanced for-loop (for...of)
for (let value of arr) {
  console.log(value);
}
```

This code demonstrates the iteration of an array using a `for` loop, `while` loop, and an advanced `for...of` loop.

### 5. Find the duplicate characters in a string:

```javascript
function findDuplicates(str) {
  const charMap = new Map();
  const duplicates = [];

  for (let char of str) {
    if (charMap.has(char)) {
      charMap.set(char, charMap.get(char) + 1);
    } else {
      charMap.set(char, 1);
    }
  }

  for (let [key, value] of charMap) {
    if (value > 1) {
      duplicates.push(key);
    }
  }

  return duplicates;
}

console.log(findDuplicates("programming")); // Output: ['r', 'g']
```

This program counts occurrences of each character and stores those that appear more than once.

### 6. Find the second-highest number in an array:

```javascript
function secondHighest(arr) {
  let highest = -Infinity;
  let secondHighest = -Infinity;

  for (let num of arr) {
    if (num > highest) {
      secondHighest = highest;
      highest = num;
    } else if (num > secondHighest && num < highest) {
      secondHighest = num;
    }
  }

  return secondHighest;
}

console.log(secondHighest([10, 5, 8, 12, 7])); // Output: 10
```

This function iterates through the array and keeps track of the highest and second-highest numbers.

### 7. Check Armstrong number:

```javascript
function isArmstrong(num) {
  const str = num.toString();
  const length = str.length;
  let sum = 0;

  for (let digit of str) {
    sum += Math.pow(parseInt(digit), length);
  }

  return sum === num;
}

console.log(isArmstrong(153)); // Output: true
console.log(isArmstrong(370)); // Output: true
console.log(isArmstrong(123)); // Output: false
```

This function checks if a number is an Armstrong number by raising each digit to the power of the number of digits and summing them.

### 8. Remove all white spaces from a string using `replace()`:

```javascript
function removeWhitespaceWithReplace(str) {
  return str.replace(/\s+/g, '');
}

console.log(removeWhitespaceWithReplace("  JavaScript  is  awesome  ")); // Output: "JavaScriptisawesome"
```

This program uses the `replace()` method with a regular expression to remove all spaces from the string.

### 9. Remove all white spaces from a string without using `replace()`:

```javascript
function removeWhitespaceWithoutReplace(str) {
  let result = '';
  for (let char of str) {
    if (char !== ' ') {
      result += char;
    }
  }
  return result;
}

console.log(removeWhitespaceWithoutReplace("  JavaScript  is  awesome  ")); // Output: "JavaScriptisawesome"
`

### 1. Reverse a string without using the `reverse()` method:

```javascript
function reverseString(str) {
  let reversed = '';
  for (let i = str.length - 1; i >= 0; i--) {
    reversed += str[i];
  }
  return reversed;
}

console.log(reverseString("hello")); // Output: "olleh"
```

### 2. Swap two numbers using a third variable:

```javascript
function swapUsingThirdVariable(a, b) {
  let temp = a;
  a = b;
  b = temp;
  console.log('After swapping: a =', a, ', b =', b);
}

swapUsingThirdVariable(5, 10); // Output: After swapping: a = 10 , b = 5
```

### 3. Swap two numbers without using a third variable:

```javascript
function swapWithoutThirdVariable(a, b) {
  a = a + b; // Step 1: a becomes the sum of a and b
  b = a - b; // Step 2: b becomes the original value of a
  a = a - b; // Step 3: a becomes the original value of b
  console.log('After swapping: a =', a, ', b =', b);
}

swapWithoutThirdVariable(5, 10); // Output: After swapping: a = 10 , b = 5
```

### 4. Count the number of words in a string using a HashMap:

```javascript
function countWordsUsingHashMap(str) {
  const words = str.split(' '); // Split the string into words
  const wordCountMap = new Map();
  
  words.forEach(word => {
    word = word.trim().toLowerCase();
    wordCountMap.set(word, (wordCountMap.get(word) || 0) + 1);
  });

  console.log(wordCountMap);
}

countWordsUsingHashMap("JavaScript is awesome and JavaScript is fun."); 
// Output: Map { 'javascript' => 2, 'is' => 2, 'awesome' => 1, 'and' => 1, 'fun.' => 1 }
```

### 5. Iterate a HashMap using a `while` loop and an advanced `for` loop:

```javascript
function iterateHashMap() {
  const map = new Map([
    ['a', 1],
    ['b', 2],
    ['c', 3]
  ]);

  // Using while loop
  let iterator = map.entries();
  let result = iterator.next();
  while (!result.done) {
    console.log(result.value);  // Output: [ 'a', 1 ], [ 'b', 2 ], [ 'c', 3 ]
    result = iterator.next();
  }

  // Using advanced for loop
  for (let [key, value] of map) {
    console.log(key, value); // Output: a 1, b 2, c 3
  }
}

iterateHashMap();
```

### 6. Check if a number is prime or not:

```javascript
function isPrime(number) {
  if (number <= 1) return false;
  for (let i = 2; i <= Math.sqrt(number); i++) {
    if (number % i === 0) {
      return false;
    }
  }
  return true;
}

console.log(isPrime(7)); // Output: true
console.log(isPrime(10)); // Output: false
```

### 7. Find whether a string or number is a palindrome:

```javascript
function isPalindrome(input) {
  const str = input.toString(); // Convert the input to string if it's a number
  const reversed = str.split('').reverse().join(''); // Reverse the string
  return str === reversed;
}

console.log(isPalindrome("madam")); // Output: true
console.log(isPalindrome(121)); // Output: true
console.log(isPalindrome("hello")); // Output: false
```
Here are the answers to the questions you've asked:

### 8. Generate the Fibonacci series up to `n` terms:

```javascript
function fibonacciSeries(n) {
  let fib = [0, 1];
  
  for (let i = 2; i < n; i++) {
    fib[i] = fib[i - 1] + fib[i - 2];
  }

  return fib.slice(0, n); // Return first n terms
}

console.log(fibonacciSeries(10)); // Output: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
```

### 9. Iterate through an array using a `for` loop, `while` loop, and an advanced `for` loop:

```javascript
const arr = [10, 20, 30, 40, 50];

// Using for loop
for (let i = 0; i < arr.length; i++) {
  console.log(arr[i]);
}

// Using while loop
let i = 0;
while (i < arr.length) {
  console.log(arr[i]);
  i++;
}

// Using advanced for loop (for...of)
for (let element of arr) {
  console.log(element);
}
```

### 10. Find duplicate characters in a string:

```javascript
function findDuplicateCharacters(str) {
  const charCount = {};
  const duplicates = [];

  for (let char of str) {
    char = char.toLowerCase();
    if (charCount[char]) {
      if (charCount[char] === 1) {
        duplicates.push(char);
      }
      charCount[char]++;
    } else {
      charCount[char] = 1;
    }
  }

  return duplicates;
}

console.log(findDuplicateCharacters("programming")); // Output: ['r', 'g']
```

### 11. Find the second-highest number in an array:

```javascript
function secondHighest(arr) {
  let highest = -Infinity;
  let secondHighest = -Infinity;

  for (let num of arr) {
    if (num > highest) {
      secondHighest = highest;
      highest = num;
    } else if (num > secondHighest && num < highest) {
      secondHighest = num;
    }
  }

  return secondHighest;
}

console.log(secondHighest([10, 5, 30, 20, 50])); // Output: 30
```

### 12. Check if a number is an Armstrong number:

```javascript
function isArmstrongNumber(num) {
  const numStr = num.toString();
  const numLength = numStr.length;
  let sum = 0;

  for (let digit of numStr) {
    sum += Math.pow(parseInt(digit), numLength);
  }

  return sum === num;
}

console.log(isArmstrongNumber(153)); // Output: true
console.log(isArmstrongNumber(123)); // Output: false
```

### 13. Remove all whitespaces from a string using `replace()`:

```javascript
function removeWhitespaceUsingReplace(str) {
  return str.replace(/\s+/g, ''); // Remove all whitespaces
}

console.log(removeWhitespaceUsingReplace("  Hello   World  ")); // Output: "HelloWorld"
```

### 14. Remove all whitespaces from a string without using `replace()`:

```javascript
function removeWhitespaceWithoutReplace(str) {
  let result = '';
  for (let char of str) {
    if (char !== ' ') {
      result += char;
    }
  }
  return result;
}

console.log(removeWhitespaceWithoutReplace("  Hello   World  ")); // Output: "HelloWorld"
```

### 15. Find the largest number in an array:

```javascript
function findLargestNumber(arr) {
  let largest = arr[0];

  for (let num of arr) {
    if (num > largest) {
      largest = num;
    }
  }

  return largest;
}

console.log(findLargestNumber([10, 5, 30, 20, 50])); // Output: 50
```

Here are the answers to the new set of questions:

### 15. Find the largest number in an array:

```javascript
function findLargestNumber(arr) {
  let largest = arr[0]; // Assume the first element is the largest

  for (let num of arr) {
    if (num > largest) {
      largest = num;
    }
  }

  return largest;
}

console.log(findLargestNumber([10, 5, 30, 20, 50])); // Output: 50
```

### 16. Find the smallest number in an array:

```javascript
function findSmallestNumber(arr) {
  let smallest = arr[0]; // Assume the first element is the smallest

  for (let num of arr) {
    if (num < smallest) {
      smallest = num;
    }
  }

  return smallest;
}

console.log(findSmallestNumber([10, 5, 30, 20, 50])); // Output: 5
```

### 17. Check if an array contains a specific element:

```javascript
function containsElement(arr, element) {
  return arr.includes(element); // returns true if element is found, false otherwise
}

console.log(containsElement([10, 5, 30, 20, 50], 30)); // Output: true
console.log(containsElement([10, 5, 30, 20, 50], 100)); // Output: false
```

### 18. Create a string from an array of characters:

```javascript
function arrayToString(arr) {
  return arr.join(''); // Join array elements without any separator
}

console.log(arrayToString(['H', 'e', 'l', 'l', 'o'])); // Output: "Hello"
```

### 19. Check whether a string contains only digits:

```javascript
function isDigitsOnly(str) {
  return /^\d+$/.test(str); // Regular expression to check if the string contains only digits
}

console.log(isDigitsOnly("12345")); // Output: true
console.log(isDigitsOnly("123a5")); // Output: false
```

### 20. Convert a string to lowercase:

```javascript
function toLowerCase(str) {
  return str.toLowerCase(); // Converts all characters to lowercase
}

console.log(toLowerCase("Hello World!")); // Output: "hello world!"
```

### Intermediate JavaScript Questions:

Here are the solutions to the new set of questions:

### 21. Check if a string is an anagram of another string:

```javascript
function areAnagrams(str1, str2) {
  if (str1.length !== str2.length) return false;

  const sortedStr1 = str1.split('').sort().join('');
  const sortedStr2 = str2.split('').sort().join('');
  
  return sortedStr1 === sortedStr2;
}

console.log(areAnagrams("listen", "silent")); // Output: true
console.log(areAnagrams("hello", "world"));   // Output: false
```

### 22. Check if a number is a perfect number:

```javascript
function isPerfectNumber(num) {
  let sum = 0;
  
  for (let i = 1; i <= num / 2; i++) {
    if (num % i === 0) {
      sum += i;
    }
  }
  
  return sum === num;
}

console.log(isPerfectNumber(28)); // Output: true
console.log(isPerfectNumber(6));  // Output: true
console.log(isPerfectNumber(12)); // Output: false
```

### 23. Print a multiplication table for a number:

```javascript
function printMultiplicationTable(num) {
  for (let i = 1; i <= 10; i++) {
    console.log(`${num} x ${i} = ${num * i}`);
  }
}

printMultiplicationTable(5);
// Output:
// 5 x 1 = 5
// 5 x 2 = 10
// 5 x 3 = 15
// 5 x 4 = 20
// 5 x 5 = 25
// 5 x 6 = 30
// 5 x 7 = 35
// 5 x 8 = 40
// 5 x 9 = 45
// 5 x 10 = 50
```

### 24. Find the first non-repeating character in a string:

```javascript
function firstNonRepeatingCharacter(str) {
  const charCount = {};

  for (let char of str) {
    charCount[char] = (charCount[char] || 0) + 1;
  }

  for (let char of str) {
    if (charCount[char] === 1) {
      return char;
    }
  }

  return null; // No non-repeating character found
}

console.log(firstNonRepeatingCharacter("swiss")); // Output: "w"
console.log(firstNonRepeatingCharacter("aabbcc")); // Output: null
```

### 25. Flatten a nested array:

```javascript
function flattenArray(arr) {
  return arr.flat(Infinity); // Flatten array to any depth
}

console.log(flattenArray([1, [2, [3, [4]]]])); // Output: [1, 2, 3, 4]
```

### 26. Count the frequency of characters in a string:

```javascript
function countCharacterFrequency(str) {
  const frequency = {};
  
  for (let char of str) {
    frequency[char] = (frequency[char] || 0) + 1;
  }

  return frequency;
}

console.log(countCharacterFrequency("hello")); // Output: { h: 1, e: 1, l: 2, o: 1 }
```

### 27. Sort an array of numbers in ascending order:

```javascript
function sortArrayAscending(arr) {
  return arr.sort((a, b) => a - b); // Sort numbers in ascending order
}

console.log(sortArrayAscending([10, 5, 3, 8, 1])); // Output: [1, 3, 5, 8, 10]
```

Here are the solutions to the new set of JavaScript problems:

### 28. Merge two arrays:

```javascript
function mergeArrays(arr1, arr2) {
  return arr1.concat(arr2); // Merge the two arrays
}

console.log(mergeArrays([1, 2, 3], [4, 5, 6])); // Output: [1, 2, 3, 4, 5, 6]
```

### 29. Check if an object is empty:

```javascript
function isEmptyObject(obj) {
  return Object.keys(obj).length === 0; // Returns true if object has no keys
}

console.log(isEmptyObject({})); // Output: true
console.log(isEmptyObject({a: 1})); // Output: false
```

### 30. Capitalize the first letter of each word in a string:

```javascript
function capitalizeFirstLetter(str) {
  return str
    .split(' ') // Split string into words
    .map(word => word.charAt(0).toUpperCase() + word.slice(1)) // Capitalize first letter of each word
    .join(' '); // Join the words back into a string
}

console.log(capitalizeFirstLetter("hello world")); // Output: "Hello World"
```

### 31. Sum all the elements in an array:

```javascript
function sumArray(arr) {
  return arr.reduce((acc, num) => acc + num, 0); // Use reduce to sum the array elements
}

console.log(sumArray([1, 2, 3, 4, 5])); // Output: 15
```

### 32. Sum of the digits of a number:

```javascript
function sumDigits(num) {
  return num
    .toString() // Convert number to string
    .split('') // Split the string into individual digits
    .reduce((acc, digit) => acc + Number(digit), 0); // Sum the digits
}

console.log(sumDigits(12345)); // Output: 15
```

### 33. Count occurrences of a specific value in an array:

```javascript
function countOccurrences(arr, value) {
  return arr.filter(item => item === value).length; // Count occurrences using filter
}

console.log(countOccurrences([1, 2, 3, 2, 2, 4], 2)); // Output: 3
```

### 34. Check if an array is sorted in ascending order:

```javascript
function isArraySorted(arr) {
  for (let i = 1; i < arr.length; i++) {
    if (arr[i] < arr[i - 1]) {
      return false; // Return false if the array is not sorted
    }
  }
  return true; // Return true if the array is sorted
}

console.log(isArraySorted([1, 2, 3, 4, 5])); // Output: true
console.log(isArraySorted([5, 4, 3, 2, 1])); // Output: false
```

### 35. Remove duplicates from an array:

```javascript
function removeDuplicates(arr) {
  return [...new Set(arr)]; // Use Set to remove duplicates, then convert back to array
}

console.log(removeDuplicates([1, 2, 3, 2, 4, 5, 1])); // Output: [1, 2, 3, 4, 5]
```

Here are the solutions to your new set of JavaScript problems:

### 36. Implement a simple calculator (addition, subtraction, multiplication, division):

```javascript
function calculator(a, b, operation) {
  switch (operation) {
    case 'add':
      return a + b;
    case 'subtract':
      return a - b;
    case 'multiply':
      return a * b;
    case 'divide':
      if (b === 0) return 'Error: Division by zero';
      return a / b;
    default:
      return 'Invalid operation';
  }
}

console.log(calculator(10, 5, 'add'));      // Output: 15
console.log(calculator(10, 5, 'subtract')); // Output: 5
console.log(calculator(10, 5, 'multiply')); // Output: 50
console.log(calculator(10, 5, 'divide'));   // Output: 2
console.log(calculator(10, 0, 'divide'));   // Output: Error: Division by zero
```

### 37. Find the missing number in an array:

```javascript
function findMissingNumber(arr) {
  const n = arr.length + 1;
  const totalSum = (n * (n + 1)) / 2; // Sum of first n natural numbers
  const arrSum = arr.reduce((acc, num) => acc + num, 0); // Sum of elements in the array
  return totalSum - arrSum;
}

console.log(findMissingNumber([1, 2, 4, 5])); // Output: 3
```

### 38. Implement a simple text search (finding a substring in a string):

```javascript
function searchSubstring(str, subStr) {
  return str.includes(subStr); // Check if the string contains the substring
}

console.log(searchSubstring("Hello, World!", "World")); // Output: true
console.log(searchSubstring("Hello, World!", "Java"));  // Output: false
```

### 39. Count the number of vowels in a string:

```javascript
function countVowels(str) {
  const vowels = 'aeiouAEIOU';
  let count = 0;
  
  for (let char of str) {
    if (vowels.includes(char)) {
      count++;
    }
  }
  
  return count;
}

console.log(countVowels("Hello World")); // Output: 3
```

### 40. Convert a number to binary:

```javascript
function toBinary(num) {
  return num.toString(2); // Convert number to binary using toString with base 2
}

console.log(toBinary(10)); // Output: "1010"
```

### 41. Remove specific characters from a string:

```javascript
function removeSpecificCharacters(str, charsToRemove) {
  return str.split('').filter(char => !charsToRemove.includes(char)).join('');
}

console.log(removeSpecificCharacters("Hello World", "o")); // Output: "Hell Wrld"
```

### 42. Check if an array contains duplicates:

```javascript
function hasDuplicates(arr) {
  const uniqueElements = new Set(arr); // A Set will only contain unique values
  return uniqueElements.size !== arr.length; // If sizes differ, the array has duplicates
}

console.log(hasDuplicates([1, 2, 3, 4, 5])); // Output: false
console.log(hasDuplicates([1, 2, 3, 2, 4])); // Output: true
```

### 43. Sort an array of strings alphabetically:

```javascript
function sortStringsAlphabetically(arr) {
  return arr.sort(); // The default sort method sorts strings alphabetically
}

console.log(sortStringsAlphabetically(["banana", "apple", "cherry"])); // Output: ["apple", "banana", "cherry"]
```

Here are the solutions to the next set of JavaScript problems:

### 44. Implement the bubble sort algorithm:

```javascript
function bubbleSort(arr) {
  let n = arr.length;
  
  for (let i = 0; i < n - 1; i++) {
    for (let j = 0; j < n - 1 - i; j++) {
      if (arr[j] > arr[j + 1]) {
        // Swap elements if they are in the wrong order
        let temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }
  
  return arr;
}

console.log(bubbleSort([5, 3, 8, 4, 2])); // Output: [2, 3, 4, 5, 8]
```

### 45. Check if a string has balanced parentheses:

```javascript
function hasBalancedParentheses(str) {
  const stack = [];
  
  for (let char of str) {
    if (char === '(') {
      stack.push('('); // Push opening parenthesis onto the stack
    } else if (char === ')') {
      if (stack.length === 0) {
        return false; // No matching opening parenthesis
      }
      stack.pop(); // Pop the matching opening parenthesis
    }
  }
  
  return stack.length === 0; // If stack is empty, parentheses are balanced
}

console.log(hasBalancedParentheses("(())"));  // Output: true
console.log(hasBalancedParentheses("(()"))   // Output: false
```

### 46. Check if two strings are permutations of each other:

```javascript
function arePermutations(str1, str2) {
  if (str1.length !== str2.length) return false; // Strings must have the same length
  
  const sortedStr1 = str1.split('').sort().join('');
  const sortedStr2 = str2.split('').sort().join('');
  
  return sortedStr1 === sortedStr2;
}

console.log(arePermutations("listen", "silent")); // Output: true
console.log(arePermutations("hello", "world"));   // Output: false
```

### 47. Remove a specific element from an array:

```javascript
function removeElement(arr, element) {
  return arr.filter(item => item !== element); // Filter out the element from the array
}

console.log(removeElement([1, 2, 3, 4, 5], 3)); // Output: [1, 2, 4, 5]
```

### 48. Reverse the order of words in a string:

```javascript
function reverseWords(str) {
  return str.split(' ')  // Split the string into words
            .reverse()   // Reverse the order of words
            .join(' ');  // Join them back into a string
}

console.log(reverseWords("Hello World")); // Output: "World Hello"
```

### 49. Replace all occurrences of a substring in a string:

```javascript
function replaceSubstring(str, target, replacement) {
  const regex = new RegExp(target, 'g'); // Create a global regex for target
  return str.replace(regex, replacement); // Replace all occurrences
}

console.log(replaceSubstring("I love JavaScript, JavaScript is great", "JavaScript", "Python")); 
// Output: "I love Python, Python is great"
```

### 50. Get the current date and time:

```javascript
function getCurrentDateTime() {
  const now = new Date();
  return now.toString(); // Returns the current date and time as a string
}

console.log(getCurrentDateTime()); // Output: (e.g.) "Tue Dec 04 2024 10:30:00 GMT+0000 (Coordinated Universal Time)"
```

Here are the solutions to your JavaScript problems:

### 51. Find the factorial of a number using recursion:

```javascript
function factorial(n) {
  if (n === 0 || n === 1) {
    return 1; // Base case: factorial of 0 or 1 is 1
  }
  return n * factorial(n - 1); // Recursive call
}

console.log(factorial(5)); // Output: 120
console.log(factorial(0)); // Output: 1
```

### 52. Compare two arrays for equality:

```javascript
function arraysAreEqual(arr1, arr2) {
  if (arr1.length !== arr2.length) return false; // If lengths are not equal, they are not equal
  
  for (let i = 0; i < arr1.length; i++) {
    if (arr1[i] !== arr2[i]) return false; // If any element is different, return false
  }
  
  return true; // If no differences found, arrays are equal
}

console.log(arraysAreEqual([1, 2, 3], [1, 2, 3])); // Output: true
console.log(arraysAreEqual([1, 2, 3], [1, 2, 4])); // Output: false
```

### 53. Convert a number from decimal to hexadecimal:

```javascript
function decimalToHexadecimal(num) {
  return num.toString(16); // Convert the number to hexadecimal (base 16)
}

console.log(decimalToHexadecimal(255)); // Output: "ff"
console.log(decimalToHexadecimal(10));  // Output: "a"
```

### 54. Find the common elements in two arrays:

```javascript
function findCommonElements(arr1, arr2) {
  return arr1.filter(item => arr2.includes(item)); // Filter elements that are present in both arrays
}

console.log(findCommonElements([1, 2, 3], [2, 3, 4])); // Output: [2, 3]
console.log(findCommonElements([1, 5, 7], [2, 3, 4])); // Output: []
```

### 55. Get the nth Fibonacci number using recursion:

```javascript
function fibonacci(n) {
  if (n <= 1) {
    return n; // Base cases: fibonacci(0) = 0, fibonacci(1) = 1
  }
  return fibonacci(n - 1) + fibonacci(n - 2); // Recursive call
}

console.log(fibonacci(5)); // Output: 5 (Fibonacci sequence: 0, 1, 1, 2, 3, 5)
console.log(fibonacci(8)); // Output: 21
```

### 56. Sum the values of an array of objects:

```javascript
function sumArrayOfObjects(arr, key) {
  return arr.reduce((sum, obj) => sum + obj[key], 0); // Sum the values of a specific key in the objects
}

const arr = [{ price: 10 }, { price: 20 }, { price: 30 }];
console.log(sumArrayOfObjects(arr, 'price')); // Output: 60
```

### 57. Find the longest word in a string:

```javascript
function findLongestWord(str) {
  const words = str.split(' '); // Split string into words
  let longestWord = '';
  
  for (let word of words) {
    if (word.length > longestWord.length) {
      longestWord = word; // Update the longest word
    }
  }
  
  return longestWord;
}

console.log(findLongestWord("I love programming with JavaScript")); // Output: "JavaScript"
```

Here are the solutions to the JavaScript problems you've listed:

### 58. Calculate the area of a rectangle:

```javascript
function calculateArea(length, width) {
  return length * width; // Area of a rectangle = length * width
}

console.log(calculateArea(5, 3)); // Output: 15
console.log(calculateArea(7, 2)); // Output: 14
```

### 59. Find if a string contains only alphabetic characters:

```javascript
function isAlpha(str) {
  return /^[A-Za-z]+$/.test(str); // Regular expression checks if string contains only alphabetic characters
}

console.log(isAlpha("Hello")); // Output: true
console.log(isAlpha("Hello123")); // Output: false
```

### 60. Implement a simple to-do list:

```javascript
class TodoList {
  constructor() {
    this.todos = [];
  }
  
  addTask(task) {
    this.todos.push(task);
  }
  
  removeTask(task) {
    this.todos = this.todos.filter(todo => todo !== task);
  }
  
  showTasks() {
    console.log("To-Do List:");
    this.todos.forEach((task, index) => {
      console.log(`${index + 1}. ${task}`);
    });
  }
}

const myList = new TodoList();
myList.addTask("Learn JavaScript");
myList.addTask("Write code");
myList.showTasks();
myList.removeTask("Write code");
myList.showTasks();
```

### 61. Find the largest prime factor of a number:

```javascript
function largestPrimeFactor(num) {
  let factor = 2;
  let largest = 0;

  while (num > 1) {
    if (num % factor === 0) {
      largest = factor;
      num /= factor;
    } else {
      factor++;
    }
  }

  return largest;
}

console.log(largestPrimeFactor(56)); // Output: 7
```

### 62. Replace all vowels in a string with a specified character:

```javascript
function replaceVowels(str, replacement) {
  return str.replace(/[aeiouAEIOU]/g, replacement); // Replace vowels using regex
}

console.log(replaceVowels("Hello World", "*")); // Output: "H*ll* W*rld"
```

### 63. Convert a string into title case:

```javascript
function toTitleCase(str) {
  return str
    .split(' ') // Split the string into words
    .map(word => word.charAt(0).toUpperCase() + word.slice(1).toLowerCase()) // Capitalize first letter of each word
    .join(' '); // Join the words back into a string
}

console.log(toTitleCase("hello world")); // Output: "Hello World"
```

### 64. Create an array of even numbers from 1 to `n`:

```javascript
function getEvenNumbers(n) {
  const evenNumbers = [];
  for (let i = 2; i <= n; i += 2) {
    evenNumbers.push(i);
  }
  return evenNumbers;
}

console.log(getEvenNumbers(10)); // Output: [2, 4, 6, 8, 10]
```

### 65. Find the product of the elements in an array:

```javascript
function productOfArray(arr) {
  return arr.reduce((product, num) => product * num, 1); // Use reduce to multiply all elements
}

console.log(productOfArray([1, 2, 3, 4])); // Output: 24
```

Here are the solutions to your JavaScript problems:

### 66. Calculate the sum of numbers in a specific range:

```javascript
function sumInRange(start, end) {
  let sum = 0;
  for (let i = start; i <= end; i++) {
    sum += i;
  }
  return sum;
}

console.log(sumInRange(1, 5)); // Output: 15 (1 + 2 + 3 + 4 + 5)
console.log(sumInRange(10, 15)); // Output: 75 (10 + 11 + 12 + 13 + 14 + 15)
```

### 67. Validate an email address using a regular expression:

```javascript
function isValidEmail(email) {
  const regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
  return regex.test(email); // Use regex to validate the email format
}

console.log(isValidEmail("test@example.com")); // Output: true
console.log(isValidEmail("invalid-email")); // Output: false
```

### 68. Check if a given string is a valid palindrome:

```javascript
function isPalindrome(str) {
  const cleanedStr = str.replace(/[^a-zA-Z0-9]/g, '').toLowerCase(); // Remove non-alphanumeric characters and make lowercase
  const reversedStr = cleanedStr.split('').reverse().join(''); // Reverse the cleaned string
  return cleanedStr === reversedStr; // Check if the cleaned string equals its reversed version
}

console.log(isPalindrome("A man, a plan, a canal, Panama")); // Output: true
console.log(isPalindrome("Hello")); // Output: false
```

### 69. Create a function that accepts a string and returns a string with only the vowels:

```javascript
function extractVowels(str) {
  return str.replace(/[^aeiouAEIOU]/g, ''); // Remove all non-vowel characters using regex
}

console.log(extractVowels("Hello World")); // Output: "eoo"
console.log(extractVowels("JavaScript")); // Output: "AaI"
```

### 70. Find the index of the first occurrence of a value in an array:

```javascript
function indexOfFirstOccurrence(arr, value) {
  return arr.indexOf(value); // Use indexOf method to find the first occurrence
}

console.log(indexOfFirstOccurrence([1, 2, 3, 4, 5], 3)); // Output: 2
console.log(indexOfFirstOccurrence([1, 2, 3, 4, 5], 6)); // Output: -1
```

### 71. Find the greatest common divisor (GCD) of two numbers:

```javascript
function gcd(a, b) {
  while (b !== 0) {
    let temp = b;
    b = a % b;
    a = temp;
  }
  return a; // Return the greatest common divisor
}

console.log(gcd(56, 98)); // Output: 14
console.log(gcd(20, 30)); // Output: 10
```

### 72. Find the least common multiple (LCM) of two numbers:

```javascript
function lcm(a, b) {
  return (a * b) / gcd(a, b); // LCM = (a * b) / GCD
}

console.log(lcm(4, 5)); // Output: 20
console.log(lcm(12, 15)); // Output: 60
```

Here are the solutions to the JavaScript problems you've listed:

### 73. Perform a deep clone of an object:

```javascript
function deepClone(obj) {
  return JSON.parse(JSON.stringify(obj)); // Convert to string and back to create a deep copy
}

const originalObj = { name: "John", address: { city: "New York", zip: 10001 } };
const clonedObj = deepClone(originalObj);

console.log(clonedObj);
clonedObj.address.city = "Los Angeles"; // Modify cloned object
console.log(originalObj.address.city); // Output: "New York" (original object is not affected)
```

### 74. Check if a number is a power of two:

```javascript
function isPowerOfTwo(num) {
  return num > 0 && (num & (num - 1)) === 0; // If the number AND (number - 1) equals 0, it's a power of two
}

console.log(isPowerOfTwo(16)); // Output: true
console.log(isPowerOfTwo(18)); // Output: false
```

### 75. Print the prime numbers up to a given limit:

```javascript
function printPrimes(limit) {
  for (let num = 2; num <= limit; num++) {
    let isPrime = true;
    for (let i = 2; i <= Math.sqrt(num); i++) {
      if (num % i === 0) {
        isPrime = false;
        break;
      }
    }
    if (isPrime) console.log(num);
  }
}

printPrimes(20); // Output: 2, 3, 5, 7, 11, 13, 17, 19
```

### 76. Extract the keys of an object into an array:

```javascript
function extractKeys(obj) {
  return Object.keys(obj); // Use Object.keys() to get an array of keys
}

const person = { name: "Alice", age: 25, city: "Wonderland" };
console.log(extractKeys(person)); // Output: ["name", "age", "city"]
```

### 77. Find the sum of an arithmetic series:

```javascript
function sumArithmeticSeries(a, d, n) {
  return (n / 2) * (2 * a + (n - 1) * d); // Sum = n/2 * (2a + (n-1)d)
}

console.log(sumArithmeticSeries(1, 2, 5)); // Output: 25 (1 + 3 + 5 + 7 + 9)
```

### 78. Check if two strings are equal ignoring case:

```javascript
function areStringsEqualIgnoreCase(str1, str2) {
  return str1.toLowerCase() === str2.toLowerCase(); // Convert both strings to lowercase and compare
}

console.log(areStringsEqualIgnoreCase("hello", "HELLO")); // Output: true
console.log(areStringsEqualIgnoreCase("Hello", "world")); // Output: false
```

### 79. Count the number of elements in an array that are prime numbers:

```javascript
function isPrime(num) {
  if (num < 2) return false;
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) return false;
  }
  return true;
}

function countPrimes(arr) {
  return arr.filter(isPrime).length; // Filter prime numbers and count them
}

console.log(countPrimes([1, 2, 3, 4, 5, 6, 7, 8, 9])); // Output: 4 (2, 3, 5, 7)
```

### 80. Convert a string to an array of words:

```javascript
function stringToArray(str) {
  return str.split(' '); // Split string by spaces to convert it to an array of words
}

console.log(stringToArray("Hello world, this is JavaScript")); // Output: ["Hello", "world,", "this", "is", "JavaScript"]
```

### Advanced JavaScript Questions:

Here are the solutions to the JavaScript problems you've listed:

### 81. Create a simple promise:

```javascript
function createPromise() {
  return new Promise((resolve, reject) => {
    const success = true;
    if (success) {
      resolve("The promise was successful!");
    } else {
      reject("The promise failed!");
    }
  });
}

createPromise()
  .then(response => console.log(response))  // Output: The promise was successful!
  .catch(error => console.log(error));
```

### 82. Use `map()` to square every element in an array:

```javascript
const numbers = [1, 2, 3, 4, 5];
const squaredNumbers = numbers.map(num => num ** 2);

console.log(squaredNumbers); // Output: [1, 4, 9, 16, 25]
```

### 83. Implement the `reduce()` function on an array:

```javascript
const numbers = [1, 2, 3, 4, 5];
const sum = numbers.reduce((accumulator, currentValue) => accumulator + currentValue, 0);

console.log(sum); // Output: 15 (1 + 2 + 3 + 4 + 5)
```

### 84. Implement the `filter()` function on an array:

```javascript
const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9];
const evenNumbers = numbers.filter(num => num % 2 === 0);

console.log(evenNumbers); // Output: [2, 4, 6, 8]
```

### 85. Implement `forEach()` to iterate over an array:

```javascript
const numbers = [1, 2, 3, 4, 5];

numbers.forEach(num => {
  console.log(num); // Output: 1, 2, 3, 4, 5 (each element is logged on a new line)
});
```

### 86. Implement a simple event listener:

```javascript
// HTML code for the event listener (for demonstration purposes):
// <button id="myButton">Click Me</button>

document.getElementById("myButton").addEventListener("click", function() {
  alert("Button clicked!");
});
```

In the above example, when the button is clicked, it will display an alert with the message "Button clicked!".

### 87. Handle asynchronous operations using `async/await`:

```javascript
function fetchData() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("Data fetched successfully!");
    }, 2000);
  });
}

async function getData() {
  try {
    const response = await fetchData();
    console.log(response); // Output: Data fetched successfully!
  } catch (error) {
    console.log("Error:", error);
  }
}

getData();
```

In this example, the `fetchData` function returns a promise, and the `getData` function uses `async/await` to handle it. The message is logged after 2 seconds, demonstrating the asynchronous behavior.

Here are the solutions to the JavaScript problems you've listed:

### 88. Handle errors using `try/catch`:

```javascript
function handleError() {
  try {
    let result = someUndefinedFunction(); // This will throw an error
  } catch (error) {
    console.log("Error caught:", error.message); // Catch and handle the error
  }
}

handleError(); // Output: Error caught: someUndefinedFunction is not defined
```

In this example, the `try` block tries to execute a function that is not defined, and the `catch` block handles the error by logging the error message.

### 89. Debounce a function call:

```javascript
function debounce(func, delay) {
  let timeoutId;
  return function(...args) {
    clearTimeout(timeoutId);
    timeoutId = setTimeout(() => {
      func(...args);
    }, delay);
  };
}

function sayHello() {
  console.log("Hello!");
}

const debouncedHello = debounce(sayHello, 1000);

// Simulate multiple calls within a short time
debouncedHello();
debouncedHello();
debouncedHello(); // "Hello!" will be logged after 1 second of no further calls
```

The `debounce` function ensures that `sayHello` is called only once, even if multiple function calls are made within 1 second.

### 90. Create a class with a constructor and methods:

```javascript
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  greet() {
    console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
  }
}

const person = new Person("Alice", 30);
person.greet(); // Output: Hello, my name is Alice and I am 30 years old.
```

The class `Person` has a constructor to initialize `name` and `age` and a `greet` method that logs a greeting message.

### 91. Implement inheritance using classes:

```javascript
class Animal {
  constructor(name) {
    this.name = name;
  }

  speak() {
    console.log(`${this.name} makes a sound.`);
  }
}

class Dog extends Animal {
  constructor(name, breed) {
    super(name); // Call the parent class constructor
    this.breed = breed;
  }

  speak() {
    console.log(`${this.name} barks.`);
  }
}

const dog = new Dog("Rex", "German Shepherd");
dog.speak(); // Output: Rex barks.
```

Here, the `Dog` class inherits from the `Animal` class and overrides the `speak` method.

### 92. Clone an object using `Object.assign()`:

```javascript
const originalObj = { name: "John", age: 25 };
const clonedObj = Object.assign({}, originalObj);

console.log(clonedObj); // Output: { name: "John", age: 25 }
```

The `Object.assign()` method creates a shallow copy of the `originalObj` and stores it in `clonedObj`.

### 93. Create an object with getter and setter methods:

```javascript
const person = {
  firstName: "John",
  lastName: "Doe",

  get fullName() {
    return `${this.firstName} ${this.lastName}`;
  },

  set fullName(name) {
    const nameParts = name.split(" ");
    this.firstName = nameParts[0];
    this.lastName = nameParts[1];
  }
};

console.log(person.fullName); // Output: John Doe
person.fullName = "Alice Smith"; // Set new full name
console.log(person.firstName); // Output: Alice
console.log(person.lastName); // Output: Smith
```

In this example, `fullName` is a computed property with both a getter and setter to get and set the full name of the person.

### 94. Check if a variable is an array using `Array.isArray()`:

```javascript
const arr = [1, 2, 3];
const notArr = { a: 1, b: 2 };

console.log(Array.isArray(arr)); // Output: true
console.log(Array.isArray(notArr)); // Output: false
```

The `Array.isArray()` method checks if the given variable is an array.

Here are the solutions to the JavaScript problems you've listed:

### 95. Implement the event delegation pattern:

```javascript
// HTML code for demonstration:
// <ul id="parent">
//   <li>Item 1</li>
//   <li>Item 2</li>
//   <li>Item 3</li>
// </ul>

document.getElementById('parent').addEventListener('click', function(event) {
  if (event.target && event.target.nodeName === 'LI') {
    console.log('Item clicked: ' + event.target.textContent);
  }
});
```

In this example, the click event is handled by the parent `ul` element. When an `li` element inside it is clicked, the event handler detects it and logs the clicked item.

### 96. Convert a number into its Roman numeral representation:

```javascript
function toRoman(num) {
  const romanNumerals = [
    { value: 1000, numeral: 'M' },
    { value: 900, numeral: 'CM' },
    { value: 500, numeral: 'D' },
    { value: 400, numeral: 'CD' },
    { value: 100, numeral: 'C' },
    { value: 90, numeral: 'XC' },
    { value: 50, numeral: 'L' },
    { value: 40, numeral: 'XL' },
    { value: 10, numeral: 'X' },
    { value: 9, numeral: 'IX' },
    { value: 5, numeral: 'V' },
    { value: 4, numeral: 'IV' },
    { value: 1, numeral: 'I' }
  ];

  let result = '';

  for (let i = 0; i < romanNumerals.length; i++) {
    while (num >= romanNumerals[i].value) {
      result += romanNumerals[i].numeral;
      num -= romanNumerals[i].value;
    }
  }
  
  return result;
}

console.log(toRoman(1994)); // Output: "MCMXCIV"
```

This function converts a number into its Roman numeral representation by checking each value in descending order and appending the corresponding numeral.

### 97. Create a custom error class:

```javascript
class CustomError extends Error {
  constructor(message) {
    super(message);
    this.name = 'CustomError'; // Set the error name
  }
}

try {
  throw new CustomError("Something went wrong!");
} catch (error) {
  console.log(error.name + ': ' + error.message); // Output: CustomError: Something went wrong!
}
```

This custom error class extends the built-in `Error` class, allowing you to throw and catch custom error types.

### 98. Make an AJAX request:

```javascript
function makeRequest() {
  const xhr = new XMLHttpRequest();
  xhr.open("GET", "https://jsonplaceholder.typicode.com/posts", true);

  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      console.log("Response:", JSON.parse(xhr.responseText));
    }
  };

  xhr.send();
}

makeRequest();
```

This code makes an AJAX `GET` request to an API and logs the response when it is successfully received.

### 99. Manipulate the DOM by adding and removing elements:

```javascript
// Adding a new element
const newElement = document.createElement('div');
newElement.textContent = 'New Div Element';
document.body.appendChild(newElement);

// Removing an element
const elementToRemove = document.querySelector('div');
elementToRemove.remove(); // Removes the first div element found
```

In this example, a new `div` element is created and appended to the `body`, and then the first `div` element found on the page is removed.

### 100. Use `localStorage` to store data and retrieve it:

```javascript
// Store data in localStorage
localStorage.setItem('username', 'JohnDoe');

// Retrieve data from localStorage
const storedUsername = localStorage.getItem('username');
console.log(storedUsername); // Output: JohnDoe

// Remove data from localStorage
localStorage.removeItem('username');
```

Here, `localStorage.setItem()` is used to store a value, `localStorage.getItem()` retrieves it, and `localStorage.removeItem()` deletes the stored item.
