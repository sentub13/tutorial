Here are 60 common JavaScript interview questions for beginners, along with their answers:

### 1. **What is JavaScript?**
   **Answer:** JavaScript is a high-level, interpreted programming language primarily used for creating interactive web pages. It runs in the browser and allows developers to manipulate web page content and respond to user events.

### 2. **What is the difference between `var`, `let`, and `const`?**
   **Answer:**
   - `var`: Function-scoped or globally scoped; can be redeclared and updated.
   - `let`: Block-scoped; can be updated but not redeclared within the same scope.
   - `const`: Block-scoped; cannot be updated or redeclared after initialization.

### 3. **What is a closure in JavaScript?**
   **Answer:** A closure is a function that retains access to its lexical scope, even when the function is executed outside that scope.

### 4. **What is a callback function?**
   **Answer:** A callback function is a function passed as an argument to another function, which is then executed after the completion of an operation, often asynchronously.

### 5. **What is an IIFE (Immediately Invoked Function Expression)?**
   **Answer:** An IIFE is a function expression that is executed immediately after being defined, usually wrapped in parentheses.

   ```javascript
   (function() {
       console.log("I am executed!");
   })();
   ```

### 6. **What is the difference between `==` and `===`?**
   **Answer:**
   - `==` compares values for equality, performing type coercion if needed.
   - `===` compares both value and type, without coercion.

### 7. **What is an object in JavaScript?**
   **Answer:** An object is a collection of key-value pairs, where keys are strings (or Symbols), and values can be any data type, including functions.

   ```javascript
   let person = { name: "John", age: 30 };
   ```

### 8. **What is the purpose of the `this` keyword?**
   **Answer:** The `this` keyword refers to the object from which the function was called. Its value is determined by the context in which it is used.

### 9. **What is hoisting in JavaScript?**
   **Answer:** Hoisting is JavaScript's default behavior of moving variable and function declarations to the top of their containing scope during the compilation phase.

### 10. **What is event delegation?**
   **Answer:** Event delegation is a technique in which a single event listener is attached to a parent element to handle events on child elements, reducing the need to attach multiple listeners.

### 11. **What is the difference between `null` and `undefined`?**
   **Answer:**
   - `null`: Represents the intentional absence of any value.
   - `undefined`: Represents a variable that has been declared but not assigned a value.

### 12. **What are JavaScript data types?**
   **Answer:** JavaScript has 7 primitive data types: `String`, `Number`, `BigInt`, `Boolean`, `undefined`, `Symbol`, and `null`. It also has one non-primitive type: `Object`.

### 13. **What is a promise in JavaScript?**
   **Answer:** A promise is an object that represents the eventual completion (or failure) of an asynchronous operation and its resulting value.

### 14. **What are async and await?**
   **Answer:**
   - `async`: Declares a function that will return a promise.
   - `await`: Pauses the execution of an `async` function until the promise is resolved.

### 15. **What is the difference between `slice()` and `splice()`?**
   **Answer:**
   - `slice()`: Returns a shallow copy of a portion of an array.
   - `splice()`: Changes the content of an array by removing, replacing, or adding elements.

### 16. **What is the `bind()` method in JavaScript?**
   **Answer:** The `bind()` method creates a new function that, when called, has its `this` value set to a specific object, and can have pre-set arguments.

### 17. **What is a prototype in JavaScript?**
   **Answer:** A prototype is an object that is associated with every function and object in JavaScript. It allows objects to inherit properties and methods from another object.

### 18. **What is the difference between `forEach` and `map`?**
   **Answer:**
   - `forEach`: Iterates over an array and executes a function for each element; does not return a value.
   - `map`: Iterates over an array, applies a function to each element, and returns a new array of results.

### 19. **What is the `setTimeout()` function in JavaScript?**
   **Answer:** `setTimeout()` is used to execute a function after a specified delay (in milliseconds).

   ```javascript
   setTimeout(function() {
       console.log("Hello");
   }, 1000); // Executes after 1 second
   ```

### 20. **What is the `setInterval()` function in JavaScript?**
   **Answer:** `setInterval()` is used to repeatedly execute a function at specified intervals (in milliseconds).

   ```javascript
   setInterval(function() {
       console.log("Hello");
   }, 1000); // Executes every 1 second
   ```

### 21. **What is a "call stack"?**
   **Answer:** The call stack is a data structure that keeps track of function calls in JavaScript. When a function is called, it is added to the stack; once it finishes, it is removed from the stack.

### 22. **What is the `new` keyword in JavaScript?**
   **Answer:** The `new` keyword is used to create an instance of an object that is based on a constructor function or class.

### 23. **What is JSON and how is it used?**
   **Answer:** JSON (JavaScript Object Notation) is a lightweight data format used for representing structured data. It can be used to transfer data between a server and a web application.

   ```javascript
   let json = '{"name": "John", "age": 30}';
   let obj = JSON.parse(json);
   ```

### 24. **What is the difference between `function` and `arrow function` in JavaScript?**
   **Answer:**
   - `function`: Can be called using `this`, which depends on the context of where it is called.
   - `arrow function`: Does not have its own `this` context and inherits `this` from its surrounding lexical scope.

### 25. **What is the `typeof` operator?**
   **Answer:** The `typeof` operator returns a string indicating the type of a variable or expression.

   ```javascript
   typeof "Hello"; // "string"
   typeof 5; // "number"
   ```

### 26. **What is the `instanceof` operator?**
   **Answer:** The `instanceof` operator checks whether an object is an instance of a specified class or constructor function.

   ```javascript
   let date = new Date();
   console.log(date instanceof Date); // true
   ```

### 27. **What are template literals in JavaScript?**
   **Answer:** Template literals are a way to embed expressions inside string literals, using backticks (`` ` ``) and `${}` syntax.

   ```javascript
   let name = "John";
   let greeting = `Hello, ${name}!`;
   ```

### 28. **What is the difference between `var` and `let`?**
   **Answer:** `var` is function-scoped or globally scoped and can be redeclared, whereas `let` is block-scoped and cannot be redeclared within the same block.

### 29. **What is the difference between `null` and an empty string `""`?**
   **Answer:** 
   - `null`: Represents no value or object.
   - `""`: Represents an empty string, which is a string type with no characters.

### 30. **What are higher-order functions in JavaScript?**
   **Answer:** Higher-order functions are functions that can take other functions as arguments or return functions as results.

### 31. **What is the `for...in` loop in JavaScript?**
   **Answer:** The `for...in` loop iterates over the enumerable properties of an object.

   ```javascript
   let obj = { a: 1, b: 2 };
   for (let key in obj) {
       console.log(key, obj[key]);
   }
   ```

### 32. **What is the `for...of` loop in JavaScript?**
   **Answer:** The `for...of` loop iterates over the values of iterable objects like arrays.

   ```javascript
   let arr = [1, 2, 3];
   for (let value of arr) {
       console.log(value);
   }
   ```

### 33. **What is destructuring in JavaScript?**
   **Answer:** Destructuring is a way to extract values from arrays or objects into distinct variables.

   ```javascript
   let [a, b] = [1, 2]; // Array destructuring
   let { name, age } = { name: "John", age: 30 }; // Object destructuring
   ```

### 34. **What is the spread operator (`...`) in JavaScript?**
   **Answer:** The spread operator is used to expand elements of an array

 or object into individual elements.

   ```javascript
   let arr = [1, 2, 3];
   let newArr = [...arr, 4, 5];
   ```

### 35. **What is the rest parameter (`...`) in JavaScript?**
   **Answer:** The rest parameter allows you to collect a variable number of arguments into an array.

   ```javascript
   function sum(...numbers) {
       return numbers.reduce((acc, num) => acc + num, 0);
   }
   ```

### 36. **What is a JavaScript module?**
   **Answer:** A JavaScript module is a way to structure and organize code by breaking it into smaller, reusable pieces, and managing the import/export of functionality between files.

### 37. **What is a `set` in JavaScript?**
   **Answer:** A `set` is a collection of unique values. It does not allow duplicates.

   ```javascript
   let mySet = new Set([1, 2, 3, 3]);
   ```

### 38. **What is the `Map` object in JavaScript?**
   **Answer:** A `Map` is a collection of key-value pairs where keys can be any value (not just strings).

   ```javascript
   let myMap = new Map();
   myMap.set("key1", "value1");
   ```

### 39. **What is the `localStorage` in JavaScript?**
   **Answer:** `localStorage` allows you to store data persistently in the browser. The data is retained even after the browser is closed.

   ```javascript
   localStorage.setItem("name", "John");
   let name = localStorage.getItem("name");
   ```

### 40. **What is the `sessionStorage` in JavaScript?**
   **Answer:** `sessionStorage` stores data for the duration of the page session. The data is lost when the page is closed.

   ```javascript
   sessionStorage.setItem("name", "John");
   ```

### 41. **What is an arrow function expression in JavaScript?**
   **Answer:** An arrow function is a shorthand way of defining a function in JavaScript. It does not have its own `this` context.

   ```javascript
   const add = (a, b) => a + b;
   ```

### 42. **What is the `JSON.stringify()` method?**
   **Answer:** `JSON.stringify()` converts a JavaScript object or value to a JSON string.

   ```javascript
   let obj = { name: "John", age: 30 };
   let json = JSON.stringify(obj);
   ```

### 43. **What is the `JSON.parse()` method?**
   **Answer:** `JSON.parse()` parses a JSON string and converts it into a JavaScript object.

   ```javascript
   let json = '{"name": "John", "age": 30}';
   let obj = JSON.parse(json);
   ```

### 44. **What is the difference between `call()` and `apply()` in JavaScript?**
   **Answer:**
   - `call()`: Invokes a function with a specified `this` value and arguments passed individually.
   - `apply()`: Invokes a function with a specified `this` value and arguments passed as an array.

### 45. **What is the `Object.assign()` method?**
   **Answer:** `Object.assign()` copies the values of all enumerable properties from one or more source objects to a target object.

   ```javascript
   let target = {};
   let source = { a: 1, b: 2 };
   Object.assign(target, source);
   ```

### 46. **What is the difference between `Object.freeze()` and `Object.seal()`?**
   **Answer:**
   - `Object.freeze()` prevents modification of an object's properties and prevents adding new properties.
   - `Object.seal()` prevents adding or removing properties, but allows modification of existing properties.

### 47. **What is the `Number` object in JavaScript?**
   **Answer:** The `Number` object is a wrapper around the primitive number type and provides methods to work with numbers.

   ```javascript
   let num = new Number(5);
   ```

### 48. **What is the `Math` object in JavaScript?**
   **Answer:** The `Math` object provides mathematical functions and constants.

   ```javascript
   Math.max(1, 2, 3); // 3
   Math.random(); // random number between 0 and 1
   ```

### 49. **What is the difference between a `deep copy` and a `shallow copy`?**
   **Answer:**
   - **Shallow copy**: Copies the top-level properties but does not copy nested objects (references are copied).
   - **Deep copy**: Copies the entire structure, including nested objects, so changes do not affect the original.

### 50. **What is the purpose of the `eval()` function?**
   **Answer:** `eval()` executes a string of JavaScript code, but it is generally not recommended due to security risks.

### 51. **What is a `Symbol` in JavaScript?**
   **Answer:** A `Symbol` is a primitive data type used to create unique identifiers for object properties.

   ```javascript
   const sym = Symbol("description");
   ```

### 52. **What is the `window` object?**
   **Answer:** The `window` object represents the browser's window and is the global object in a browser environment.

### 53. **What is an event loop in JavaScript?**
   **Answer:** The event loop is a mechanism that allows JavaScript to handle asynchronous operations by executing code, events, and messages in the order they are added to the event queue.

### 54. **What are Web APIs?**
   **Answer:** Web APIs are interfaces provided by the browser that allow JavaScript to interact with the underlying browser and system, such as DOM manipulation, AJAX requests, and local storage.

### 55. **What is AJAX?**
   **Answer:** AJAX (Asynchronous JavaScript and XML) is a technique for sending and receiving data from a server asynchronously without refreshing the web page.

### 56. **What is CORS in JavaScript?**
   **Answer:** CORS (Cross-Origin Resource Sharing) is a security feature that allows or restricts resources to be requested from a different domain.

### 57. **What are event listeners in JavaScript?**
   **Answer:** Event listeners are functions that listen for and respond to events on DOM elements.

   ```javascript
   document.getElementById("myButton").addEventListener("click", function() {
       alert("Button clicked!");
   });
   ```

### 58. **What is a `Promise.all()` in JavaScript?**
   **Answer:** `Promise.all()` accepts an array of promises and returns a new promise that resolves when all input promises have resolved or rejects if any of the input promises rejects.

### 59. **What is the `debugger` keyword in JavaScript?**
   **Answer:** The `debugger` keyword is used to pause the execution of code and allows you to inspect variables and the call stack during development.

### 60. **What is the `location` object in JavaScript?**
   **Answer:** The `location` object is used to get or set the current URL of the browser window.

   ```javascript
   console.log(location.href); // Current URL
   location.href = "https://www.example.com"; // Navigate to a new URL
   ```

These answers should help you prepare for a beginner-level JavaScript interview!