# JavaScript Interview Questions and Concepts

## **1. Basic JavaScript Concepts**

### **1. What are the different data types in JavaScript?**
JavaScript has both **primitive** and **non-primitive** (or **reference**) data types:

**Primitive data types**: 
- `string`: Represents a sequence of characters. Example: `"hello"`
- `number`: Represents numeric values. Example: `42`
- `bigint`: Represents large integers. Example: `123456789012345678901234567890n`
- `boolean`: Represents `true` or `false`. Example: `true`
- `undefined`: Represents an uninitialized variable or an absent value. Example: `let a;`
- `symbol`: Represents a unique identifier, often used for object property keys. Example: `Symbol('description')`
- `null`: Represents the intentional absence of any object value. Example: `let a = null;`

**Non-primitive data types**:
- `object`: Includes collections of key-value pairs, such as arrays, functions, and plain objects. Example: `let obj = { key: 'value' };`
- `Array`: Ordered collections of data
- `Function`: Reusable blocks of code

### **2. What is the difference between `var`, `let`, and `const`?**
- **`var`**:
  - Declares variables with function or global scope
  - Variables are **hoisted** (the declaration is moved to the top of its scope)
  - Can be reassigned and redeclared

- **`let`**:
  - Declares block-scoped variables
  - Cannot be redeclared in the same scope, but can be reassigned
  - **Not hoisted** in the same way as `var` (temporal dead zone)

- **`const`**:
  - Declares block-scoped variables
  - **Cannot be reassigned** after initial assignment
  - Must be assigned at declaration time

### **3. What is hoisting in JavaScript?**
Hoisting is a JavaScript behavior where **declarations** (but not initializations) of variables and functions are moved to the top of their containing scope during compilation.

- **Function declarations** are hoisted with their definitions
- **`var` variables** are hoisted, but only their declarations, not their assignments
- **`let` and `const`** are hoisted but not initialized (temporal dead zone)

Example:
```javascript
console.log(a); // undefined (hoisted but not assigned)
var a = 5;

myFunction();   // works because function declarations are hoisted
function myFunction() {
  console.log('Hello');
}
```

### **4. What is the difference between `==` and `===` in JavaScript?**
- **`==` (loose equality)**: Compares values for equality **after type coercion**
- **`===` (strict equality)**: Compares values for equality **without type coercion**

Example:
```javascript
5 == '5';  // true (because '5' is converted to number)
5 === '5'; // false (different types: number vs string)
```

### **5. Explain the concept of "truthy" and "falsy" values in JavaScript.**
Values are evaluated as either **truthy** or **falsy** in boolean contexts.

**Falsy values** (only 6 in JavaScript):
- `false`
- `0` (zero)
- `""` (empty string)
- `null`
- `undefined`
- `NaN`

**Truthy values**: Any value that is not falsy
- `"hello"` (non-empty string)
- `42` (any non-zero number)
- `[]` (empty array)
- `{}` (empty object)

### **6. What is the `undefined` value in JavaScript?**
`undefined` is a primitive value indicating the absence of a value. It's automatically assigned to variables that are declared but not initialized.

Example:
```javascript
let a;
console.log(a); // undefined
```

### **7. What is the `null` value in JavaScript? How is it different from `undefined`?**
`null` represents the intentional absence of any object or value.

**Differences**:
- **`undefined`**: Default value when a variable is declared but not initialized
- **`null`**: Explicitly assigned to indicate absence of value

Example:
```javascript
let a = null;    // Explicitly assigned
let b;           // Implicitly undefined
```

## **2. Functions and Scope**

### **8. What is a function in JavaScript? How do you declare one?**
A **function** is a block of reusable code that performs a specific task.

**Declaration methods**:
- **Function declaration**:
  ```javascript
  function greet(name) {
    return `Hello, ${name}!`;
  }
  ```

- **Function expression**:
  ```javascript
  const greet = function(name) {
    return `Hello, ${name}!`;
  };
  ```

- **Arrow function** (ES6+):
  ```javascript
  const greet = (name) => `Hello, ${name}!`;
  ```

### **9. What is the difference between function declarations and function expressions?**
- **Function Declaration**: Hoisted to the top of scope, can be called before definition
- **Function Expression**: Not hoisted, can only be called after assignment

### **10. What are arrow functions, and how do they differ from regular functions?**
Arrow functions provide concise syntax and have lexical `this` binding.

**Differences**:
- **Syntax**: More concise
- **`this` binding**: Arrow functions inherit `this` from surrounding context
- **No `arguments` object**: Cannot use `arguments` in arrow functions

Example:
```javascript
// Regular function:
const add = function(a, b) { return a + b; };

// Arrow function:
const add = (a, b) => a + b;
```

### **11. What is a closure in JavaScript?**
A **closure** is a function that retains access to variables from its lexical scope, even after the outer function has finished execution.

Example:
```javascript
function outer() {
  let count = 0;
  function inner() {
    return count++;
  }
  return inner;
}
const increment = outer();
console.log(increment()); // 0
console.log(increment()); // 1
```

### **12. What is lexical scoping in JavaScript?**
**Lexical scoping** means variable accessibility is determined by where they are defined in the source code. Inner functions can access variables from outer functions.

### **13. What is the difference between local scope and global scope?**
- **Local Scope**: Variables declared within a function, only accessible within that function
- **Global Scope**: Variables declared outside any function, accessible from anywhere

### **14. What is an IIFE (Immediately Invoked Function Expression)?**
An **IIFE** is a function that is defined and executed immediately after creation.

Example:
```javascript
(function() {
  console.log('I am an IIFE');
})();

// OR with arrow function:
(() => {
  console.log('I am an IIFE with arrow function');
})();
```

### **15. What are higher-order functions in JavaScript?**
A **higher-order function** is a function that:
- Takes one or more functions as arguments
- Returns a function as a result

Example:
```javascript
function multiplier(factor) {
  return function(number) {
    return number * factor;
  };
}
const double = multiplier(2);
console.log(double(5)); // 10
```

### **16. What is a callback function in JavaScript?**
A **callback function** is a function passed as an argument to another function, executed after some operation completes.

Example:
```javascript
function fetchData(callback) {
  setTimeout(() => {
    console.log('Data fetched');
    callback();
  }, 1000);
}

fetchData(function() {
  console.log('Callback executed');
});
```

### **17. What is a pure function in JavaScript?**
A **pure function**:
1. Always produces the same output for the same input
2. Has no side effects

Example:
```javascript
function add(a, b) {
  return a + b; // Always returns the same result for the same inputs
}
```

### **18. What is recursion in JavaScript?**
**Recursion** is when a function calls itself to solve a problem.

Example:
```javascript
function factorial(n) {
  if (n === 0) return 1; // base case
  return n * factorial(n - 1); // recursive case
}
console.log(factorial(5)); // 120
```

## **3. Objects and Arrays**

### **19. What are the different ways to create objects in JavaScript?**
1. **Object literal**:
   ```javascript
   const obj = { name: 'Alice', age: 25 };
   ```

2. **Using `new Object()`**:
   ```javascript
   const obj = new Object();
   obj.name = 'Alice';
   ```

3. **Using `Object.create()`**:
   ```javascript
   const obj = Object.create(null);
   obj.name = 'Alice';
   ```

4. **Using constructor function**:
   ```javascript
   function Person(name, age) {
     this.name = name;
     this.age = age;
   }
   const person1 = new Person('Alice', 25);
   ```

5. **Using class (ES6)**:
   ```javascript
   class Person {
     constructor(name, age) {
       this.name = name;
       this.age = age;
     }
   }
   const person1 = new Person('Alice', 25);
   ```

### **20. What is object destructuring in JavaScript?**
**Object destructuring** allows extracting properties from objects into variables.

Example:
```javascript
const person = { name: 'John', age: 25, city: 'New York' };
const { name, age } = person;
console.log(name, age); // 'John', 25
```

### **21. How can you merge two objects in JavaScript?**
- **`Object.assign()`**:
  ```javascript
  const obj1 = { a: 1, b: 2 };
  const obj2 = { b: 3, c: 4 };
  const merged = Object.assign({}, obj1, obj2);
  ```

- **Spread operator**:
  ```javascript
  const merged = { ...obj1, ...obj2 };
  ```

### **22. How can you merge two arrays in JavaScript?**
- **Using `concat()`**:
  ```javascript
  const array1 = [1, 2, 3];
  const array2 = [4, 5, 6];
  const merged = array1.concat(array2);
  ```

- **Using spread operator**:
  ```javascript
  const merged = [...array1, ...array2];
  ```

### **23. What is the difference between `slice()` and `splice()`?**
- **`slice()`**: Returns a shallow copy without modifying original array
  ```javascript
  const arr = [1, 2, 3, 4, 5];
  const sliced = arr.slice(1, 4); // [2, 3, 4]
  ```

- **`splice()`**: Modifies the original array by adding/removing elements
  ```javascript
  const arr = [1, 2, 3, 4, 5];
  arr.splice(2, 2, 'a', 'b'); // [1, 2, 'a', 'b', 5]
  ```

### **24. How do you remove duplicates from an array?**
- **Using Set**:
  ```javascript
  const arr = [1, 2, 3, 2, 4, 1];
  const unique = [...new Set(arr)];
  ```

- **Using filter and indexOf**:
  ```javascript
  const unique = arr.filter((value, index, self) => self.indexOf(value) === index);
  ```

### **25. What are the different ways to loop through an array?**
1. **For loop**:
   ```javascript
   for (let i = 0; i < arr.length; i++) {
     console.log(arr[i]);
   }
   ```

2. **For...of loop**:
   ```javascript
   for (const value of arr) {
     console.log(value);
   }
   ```

3. **forEach()**:
   ```javascript
   arr.forEach(value => console.log(value));
   ```

4. **map()** (for transforming):
   ```javascript
   const squared = arr.map(value => value * value);
   ```

### **26. What is the difference between `for...in` and `for...of` loops?**
- **`for...in`**: Iterates over **keys** (property names) of objects or indexes of arrays
- **`for...of`**: Iterates over **values** of iterable objects

Example:
```javascript
const arr = [1, 2, 3];
for (const index in arr) {
  console.log(index); // 0, 1, 2 (indexes)
}
for (const value of arr) {
  console.log(value); // 1, 2, 3 (values)
}
```

## **4. Asynchronous JavaScript**

### **27. What is the difference between synchronous and asynchronous code?**
- **Synchronous**: Executes line by line, each operation waits for the previous one
- **Asynchronous**: Allows operations to run in background without blocking main thread

Example:
```javascript
console.log('Start');
setTimeout(() => {
  console.log('Middle');
}, 1000);
console.log('End');
// Output: Start, End, Middle
```

### **28. What is a promise in JavaScript?**
A **Promise** represents the eventual completion (or failure) of an asynchronous operation.

**States**:
- **Pending**: Operation in progress
- **Fulfilled**: Operation completed successfully
- **Rejected**: Operation failed

Example:
```javascript
let promise = new Promise((resolve, reject) => {
  let success = true;
  if (success) {
    resolve('Operation successful');
  } else {
    reject('Operation failed');
  }
});

promise.then(result => console.log(result))
       .catch(error => console.log(error));
```

### **29. What is `async/await` in JavaScript?**
**`async/await`** provides cleaner syntax for working with promises.

- **`async`**: Defines a function that returns a promise
- **`await`**: Pauses execution until promise is resolved

Example:
```javascript
async function fetchData() {
  try {
    const data = await fetch('https://api.example.com');
    const json = await data.json();
    console.log(json);
  } catch (error) {
    console.log('Error:', error);
  }
}
```

### **30. What is the difference between `async/await` and promises?**
- **Promises**: Use `.then()` and `.catch()` for chaining
- **`async/await`**: Makes asynchronous code look synchronous, easier to read

### **31. What is callback hell, and how can you avoid it?**
**Callback hell** occurs when multiple nested callbacks create difficult-to-read code.

**Avoid with**:
- **Promises**: Allow chaining with `.then()`
- **`async/await`**: Flatten nested structure

### **32. What is the purpose of `Promise.all()` and `Promise.race()`?**
- **`Promise.all()`**: Waits for all promises to resolve
  ```javascript
  Promise.all([promise1, promise2])
    .then(results => console.log(results));
  ```

- **`Promise.race()`**: Returns result of first promise to resolve/reject
  ```javascript
  Promise.race([promise1, promise2])
    .then(result => console.log(result));
  ```

## **5. ES6 and Modern JavaScript**

### **33. What are template literals in JavaScript?**
**Template literals** allow string interpolation and multi-line strings using backticks.

Example:
```javascript
const name = 'Alice';
const age = 25;
const greeting = `Hello, my name is ${name} and I am ${age} years old.`;
```

### **34. What is destructuring in JavaScript?**
**Destructuring** allows unpacking values from arrays or properties from objects.

**Array destructuring**:
```javascript
const [a, b, c] = [1, 2, 3];
```

**Object destructuring**:
```javascript
const { name, age } = { name: 'Alice', age: 25 };
```

### **35. What is the spread operator?**
The **spread operator** (`...`) unpacks elements from arrays or objects.

Examples:
```javascript
// Arrays
const arr1 = [1, 2, 3];
const arr2 = [...arr1, 4, 5]; // [1, 2, 3, 4, 5]

// Objects
const obj1 = { a: 1, b: 2 };
const obj2 = { ...obj1, c: 3 }; // { a: 1, b: 2, c: 3 }
```

### **36. What is the rest parameter?**
The **rest parameter** (`...`) collects remaining arguments into an array.

Example:
```javascript
function sum(...numbers) {
  return numbers.reduce((acc, num) => acc + num, 0);
}
console.log(sum(1, 2, 3, 4)); // 10
```

### **37. What are symbols in JavaScript?**
A **symbol** is a primitive data type for creating unique identifiers.

Example:
```javascript
const uniqueKey = Symbol("key");
const obj = {};
obj[uniqueKey] = "value";
console.log(obj[uniqueKey]); // "value"
```

### **38. What are Set and Map in JavaScript?**
- **Set**: Collection of unique values
  ```javascript
  const mySet = new Set([1, 2, 3, 2, 1]);
  console.log(mySet); // Set {1, 2, 3}
  ```

- **Map**: Collection of key-value pairs where keys can be any type
  ```javascript
  const myMap = new Map();
  myMap.set('name', 'Alice');
  console.log(myMap.get('name')); // Alice
  ```

### **39. What are generator functions?**
**Generator functions** can yield multiple values over time using `function*` and `yield`.

Example:
```javascript
function* countUpTo(max) {
  let count = 0;
  while (count <= max) {
    yield count;
    count++;
  }
}

const counter = countUpTo(3);
console.log(counter.next().value); // 0
console.log(counter.next().value); // 1
```

## **6. Classes and OOP**

### **40. How do you create a class in JavaScript?**
Classes are created using the `class` keyword (ES6).

Example:
```javascript
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  greet() {
    console.log(`Hello, my name is ${this.name}`);
  }
}

const person1 = new Person('Alice', 25);
person1.greet();
```

### **41. What is the difference between `class` and constructor functions?**
- **Classes**: Modern ES6 syntax, cleaner and more structured
- **Constructor functions**: Traditional approach using functions and prototypes

### **42. What are getter and setter methods?**
**Getters** and **setters** control access to object properties.

Example:
```javascript
class Person {
  constructor(name) {
    this._name = name;
  }

  get name() {
    return this._name;
  }

  set name(value) {
    if (value.length > 0) {
      this._name = value;
    }
  }
}
```

### **43. What is inheritance in JavaScript?**
**Inheritance** allows classes to inherit properties and methods from other classes using `extends`.

Example:
```javascript
class Animal {
  constructor(name) {
    this.name = name;
  }
  speak() {
    console.log(`${this.name} makes a sound`);
  }
}

class Dog extends Animal {
  speak() {
    console.log(`${this.name} barks`);
  }
}
```

### **44. What is a prototype in JavaScript?**
Every JavaScript object has a **prototype** that allows objects to inherit properties and methods from other objects.

Example:
```javascript
function Person(name) {
  this.name = name;
}

Person.prototype.greet = function() {
  console.log('Hello ' + this.name);
};

const john = new Person('John');
john.greet(); // Hello John
```

## **7. DOM and Browser APIs**

### **45. What is the DOM (Document Object Model)?**
The **DOM** is an interface that allows JavaScript to interact with and manipulate HTML/XML documents. It represents the document as a tree of nodes.

### **46. How do you manipulate the DOM using JavaScript?**
Common DOM operations:
- **Selecting elements**: `getElementById()`, `querySelector()`
- **Changing content**: `textContent`, `innerHTML`
- **Changing attributes**: `setAttribute()`, `getAttribute()`
- **Creating elements**: `createElement()`, `appendChild()`
- **Event handling**: `addEventListener()`

Example:
```javascript
const button = document.querySelector('button');
button.addEventListener('click', () => {
  const div = document.createElement('div');
  div.textContent = 'New content';
  document.body.appendChild(div);
});
```

### **47. What is event delegation?**
**Event delegation** attaches a single event listener to a parent element to handle events from child elements, improving performance.

Example:
```javascript
document.getElementById('parent').addEventListener('click', function(event) {
  if (event.target && event.target.matches('button.classname')) {
    console.log('Button clicked:', event.target);
  }
});
```

### **48. What is the event loop in JavaScript?**
The **event loop** enables JavaScript's concurrency model by continuously checking the call stack and message queue, allowing asynchronous operations without blocking the main thread.

### **49. What is `localStorage` and `sessionStorage`?**
Both store data client-side but differ in persistence:

- **`localStorage`**: Data persists until explicitly cleared
  ```javascript
  localStorage.setItem('name', 'Alice');
  const name = localStorage.getItem('name');
  ```

- **`sessionStorage`**: Data cleared when tab/browser closes
  ```javascript
  sessionStorage.setItem('name', 'Alice');
  const name = sessionStorage.getItem('name');
  ```

### **50. How do you make an AJAX request?**
**Using Fetch API** (modern approach):
```javascript
fetch('https://api.example.com/data')
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));
```

**Using XMLHttpRequest**:
```javascript
const xhr = new XMLHttpRequest();
xhr.open('GET', 'https://api.example.com/data', true);
xhr.onload = () => {
  if (xhr.status === 200) {
    console.log(xhr.responseText);
  }
};
xhr.send();
```

## **8. Error Handling and Debugging**

### **51. What is try-catch in JavaScript?**
**`try...catch`** handles exceptions gracefully.

Example:
```javascript
try {
  let result = riskyFunction();
  console.log(result);
} catch (error) {
  console.error('An error occurred:', error.message);
} finally {
  console.log('This always runs');
}
```

### **52. What is the difference between `throw` and `return`?**
- **`throw`**: Raises an exception, stops execution
- **`return`**: Returns a value from function, normal execution flow

### **53. What are some common debugging techniques?**
- **Console logging**: `console.log()`, `console.error()`
- **Debugger statement**: `debugger;` pauses execution
- **Browser DevTools**: Set breakpoints, inspect variables
- **Error stack traces**: Track error origins
- **Linting tools**: ESLint for code quality

## **9. Modules and Build Tools**

### **54. What is the difference between `import` and `require`?**
- **`import`**: ES6 modules, asynchronous, hoisted
  ```javascript
  import { myFunction } from './myModule.js';
  ```

- **`require`**: CommonJS, synchronous, not hoisted
  ```javascript
  const myModule = require('./myModule');
  ```

### **55. What is the purpose of the `export` keyword?**
**`export`** makes functions, objects, or variables accessible to other modules.

**Named export**:
```javascript
export const name = 'Alice';
export function greet() {
  console.log('Hello!');
}
```

**Default export**:
```javascript
export default function() {
  console.log('Default export');
}
```

## **10. Performance and Best Practices**

### **56. What are memory leaks and how do you prevent them?**
**Memory leaks** occur when unused memory isn't released.

**Prevention**:
- Remove event listeners when not needed
- Clear intervals/timeouts
- Avoid global variables
- Proper variable scoping

### **57. What is debounce and throttle?**
- **Debounce**: Limits function execution until after delay
- **Throttle**: Ensures function executes at most once per interval

### **58. What is lazy loading?**
**Lazy loading** loads resources only when needed, improving initial load time.

### **59. How do you optimize JavaScript performance?**
- Minimize DOM manipulations
- Use event delegation
- Implement debouncing/throttling
- Use `requestAnimationFrame` for animations
- Leverage caching
- Minify and bundle code

### **60. What are design patterns in JavaScript?**
Common patterns include:
- **Singleton**: Single instance of a class
- **Module**: Organize code into reusable modules
- **Observer**: Objects observe state changes
- **Factory**: Create objects without specifying exact class

This completes the comprehensive JavaScript tutorial with proper organization and sequential numbering.