### **1. Basic JavaScript Concepts**

#### 1. **What are the different data types in JavaScript?**
   JavaScript has both **primitive** and **non-primitive** (or **reference**) data types:
   - **Primitive data types**: 
     - `string`: Represents a sequence of characters. Example: `"hello"`
     - `number`: Represents numeric values. Example: `42`
     - `bigint`: Represents large integers. Example: `123456789012345678901234567890n`
     - `boolean`: Represents `true` or `false`. Example: `true`
     - `undefined`: Represents an uninitialized variable or an absent value. Example: `let a;`
     - `symbol`: Represents a unique identifier, often used for object property keys. Example: `Symbol('description')`
     - `null`: Represents the intentional absence of any object value. Example: `let a = null;`
   - **Non-primitive data types**:
     - `object`: Includes collections of key-value pairs, such as arrays, functions, and plain objects. Example: `let obj = { key: 'value' };`

#### 2. **What is the difference between `var`, `let`, and `const`?**
   - **`var`**: Function or global scope, hoisted, can be reassigned and redeclared
   - **`let`**: Block-scoped, not hoisted (temporal dead zone), can be reassigned but not redeclared
   - **`const`**: Block-scoped, cannot be reassigned, must be assigned at declaration

#### 3. **What is a closure in JavaScript?**
   A **closure** is a function that retains access to variables from its lexical scope, even after the outer function has finished execution.
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

#### 4. **What is the difference between `==` and `===` in JavaScript?**
   - **`==` (loose equality)**: Compares values after type coercion
   - **`===` (strict equality)**: Compares values without type coercion (both value and type must match)
   ```javascript
   5 == '5';  // true (type coercion)
   5 === '5'; // false (different types)
   ```

#### 5. **Explain the concept of "truthy" and "falsy" values in JavaScript.**
   - **Falsy values** (6 total): `false`, `0`, `""`, `null`, `undefined`, `NaN`
   - **Truthy values**: Everything else (non-empty strings, non-zero numbers, objects, arrays)

#### 6. **What are the JavaScript data structures, and when would you use them?**
   - **Arrays**: Ordered collections, used when order matters
   - **Objects**: Key-value pairs, used for related data
   - **Sets**: Collection of unique values (no duplicates)
   - **Maps**: Key-value pairs where keys can be any type

#### 7. **What is hoisting in JavaScript?**
   Hoisting moves declarations to the top of their scope during compilation:
   - **Function declarations**: Fully hoisted (can be called before declaration)
   - **`var` variables**: Declaration hoisted, initialization not
   - **`let` and `const`**: Hoisted but in temporal dead zone

#### 8. **What are the different ways to create objects in JavaScript?**
   1. **Object literal**: `const obj = { name: 'Alice' };`
   2. **Constructor function**: `function Person(name) { this.name = name; }`
   3. **`Object.create()`**: `const obj = Object.create(null);`
   4. **ES6 Classes**: `class Person { constructor(name) { this.name = name; } }`

#### 9. **What is a pure function in JavaScript?**
   A function that:
   1. Always produces the same output for the same input
   2. Has no side effects
   ```javascript
   function add(a, b) {
     return a + b; // Pure function
   }
   ```

#### 10. **What are higher-order functions in JavaScript?**
   Functions that take other functions as arguments or return functions:
   ```javascript
   function multiplier(factor) {
     return function(number) {
       return number * factor;
     };
   }
   const double = multiplier(2);
   ```

#### 11. **What is a callback function in JavaScript?**
   A function passed as an argument to another function, executed after some operation:
   ```javascript
   function fetchData(callback) {
     setTimeout(() => {
       console.log('Data fetched');
       callback();
     }, 1000);
   }
   ```

#### 12. **How does the `this` keyword work in JavaScript?**
   The value of `this` depends on how a function is called:
   - **Regular function**: Global object or `undefined` (strict mode)
   - **Method**: The object that called the method
   - **Arrow function**: Lexically inherited from surrounding context
   - **`call/apply/bind`**: Explicitly set value

#### 13. **What is the difference between synchronous and asynchronous code?**
   - **Synchronous**: Executes line by line, blocking further execution
   - **Asynchronous**: Allows operations to run in background without blocking

#### 14. **What is the purpose of `call()`, `apply()` and `bind()` methods?**
   - **`call()`**: Invokes function with specific `this` and individual arguments
   - **`apply()`**: Invokes function with specific `this` and array of arguments
   - **`bind()`**: Returns new function with bound `this` context

#### 15. **What is `async/await` in JavaScript?**
   Syntax for working with promises in a more readable way:
   ```javascript
   async function fetchData() {
     const data = await someAsyncOperation();
     console.log(data);
   }
   ```

#### 16. **What is a promise in JavaScript?**
   An object representing eventual completion/failure of an asynchronous operation:
   - **States**: Pending, Fulfilled, Rejected
   ```javascript
   const promise = new Promise((resolve, reject) => {
     // async operation
   });
   ```

#### 17. **What is the event loop in JavaScript?**
   The mechanism that handles asynchronous operations in JavaScript's single-threaded environment by managing the call stack and message queue.

#### 18. **What is event delegation in JavaScript?**
   Technique where you attach a single event listener to a parent element to handle events from child elements:
   ```javascript
   document.getElementById('parent').addEventListener('click', function(event) {
     if (event.target.matches('button')) {
       console.log('Button clicked');
     }
   });
   ```

#### 19. **What is the difference between `Object.freeze()` and `Object.seal()`?**
   - **`freeze()`**: Makes object immutable (no changes to properties)
   - **`seal()`**: Prevents adding/removing properties but allows modification

### **2. ES6 and Modern JavaScript**

#### 20. **What are template literals in JavaScript?**
   String literals with embedded expressions and multi-line support:
   ```javascript
   const name = 'Alice';
   const greeting = `Hello, ${name}!`;
   ```

#### 21. **What is destructuring in JavaScript?**
   Syntax to unpack values from arrays or properties from objects:
   ```javascript
   const [a, b] = [1, 2];
   const {name, age} = person;
   ```

#### 22. **What is the spread operator?**
   Syntax (`...`) to expand iterables or copy objects/arrays:
   ```javascript
   const arr2 = [...arr1, 4, 5];
   const obj2 = {...obj1, c: 3};
   ```

#### 23. **What is the rest parameter?**
   Syntax to collect remaining arguments into an array:
   ```javascript
   function sum(...numbers) {
     return numbers.reduce((acc, num) => acc + num, 0);
   }
   ```

#### 24. **What are arrow functions and how do they differ from regular functions?**
   - **Syntax**: More concise (`const add = (a, b) => a + b`)
   - **`this` binding**: Lexically bound (inherits from surrounding context)
   - **No `arguments` object**

#### 25. **What are Set and Map in JavaScript?**
   - **Set**: Collection of unique values
   - **Map**: Collection of key-value pairs where keys can be any type

#### 26. **What are generator functions?**
   Functions that can pause and resume execution using `yield`:
   ```javascript
   function* countUpTo(max) {
     let count = 0;
     while (count <= max) {
       yield count++;
     }
   }
   ```

### **3. Arrays and Objects**

#### 27. **How can you merge two arrays?**
   - **`concat()`**: `array1.concat(array2)`
   - **Spread operator**: `[...array1, ...array2]`

#### 28. **What is the difference between `slice()` and `splice()`?**
   - **`slice()`**: Returns new array, doesn't modify original
   - **`splice()`**: Modifies original array, can add/remove elements

#### 29. **How do you remove duplicates from an array?**
   ```javascript
   const unique = [...new Set(array)];
   ```

#### 30. **How do you sort an array of objects?**
   ```javascript
   people.sort((a, b) => a.age - b.age); // Sort by age
   ```

#### 31. **What are the different ways to loop through an array?**
   - `for` loop, `forEach()`, `for...of`, `map()`, `filter()`, `reduce()`

### **4. Functions and Scope**

#### 32. **What is the difference between function declaration and function expression?**
   - **Declaration**: Hoisted, can be called before definition
   - **Expression**: Not hoisted, must be defined before use

#### 33. **What is an IIFE (Immediately Invoked Function Expression)?**
   Function that executes immediately after creation:
   ```javascript
   (function() {
     console.log('IIFE executed');
   })();
   ```

#### 34. **What is lexical scoping?**
   Variable accessibility determined by where they are defined in the source code.

#### 35. **What is recursion?**
   When a function calls itself:
   ```javascript
   function factorial(n) {
     if (n === 0) return 1;
     return n * factorial(n - 1);
   }
   ```

### **5. Asynchronous JavaScript**

#### 36. **What is callback hell and how to avoid it?**
   Deeply nested callbacks that are hard to read. Avoid with:
   - Promises
   - `async/await`
   - Modular functions

#### 37. **What is the purpose of `Promise.all()` and `Promise.race()`?**
   - **`Promise.all()`**: Waits for all promises to resolve
   - **`Promise.race()`**: Returns first promise to resolve/reject

#### 38. **How do you handle errors in async functions?**
   Use `try/catch` blocks:
   ```javascript
   async function fetchData() {
     try {
       const data = await fetch('/api');
       return data.json();
     } catch (error) {
       console.error('Error:', error);
     }
   }
   ```

### **6. DOM and Browser APIs**

#### 39. **What is the DOM?**
   Document Object Model - interface for interacting with HTML/XML documents as a tree of nodes.

#### 40. **How do you manipulate the DOM?**
   - Select elements: `getElementById()`, `querySelector()`
   - Modify content: `textContent`, `innerHTML`
   - Add/remove elements: `appendChild()`, `removeChild()`

#### 41. **What is event bubbling and capturing?**
   - **Bubbling**: Event propagates from target to root
   - **Capturing**: Event propagates from root to target

#### 42. **What is `localStorage` and `sessionStorage`?**
   - **`localStorage`**: Persistent storage (survives browser restart)
   - **`sessionStorage`**: Session-only storage (cleared when tab closes)

### **7. Error Handling**

#### 43. **What is try-catch in JavaScript?**
   Mechanism to handle exceptions:
   ```javascript
   try {
     // risky code
   } catch (error) {
     // handle error
   } finally {
     // cleanup code
   }
   ```

#### 44. **What is the difference between `throw` and `return`?**
   - **`throw`**: Raises an exception, stops execution
   - **`return`**: Returns a value, exits function normally

### **8. Modules**

#### 45. **What is the difference between `import` and `require`?**
   - **`import`**: ES6 modules, asynchronous, hoisted
   - **`require`**: CommonJS, synchronous, not hoisted

#### 46. **What is the purpose of `export`?**
   Makes functions, objects, or variables accessible to other modules:
   ```javascript
   export const name = 'Alice';
   export default function() { /* ... */ }
   ```

### **9. Performance and Best Practices**

#### 47. **What are memory leaks and how to prevent them?**
   Unreleased memory that's no longer needed. Prevent by:
   - Removing event listeners
   - Clearing intervals/timeouts
   - Avoiding global variables
   - Breaking circular references

#### 48. **What is debounce and throttle?**
   - **Debounce**: Delays function execution until after idle time
   - **Throttle**: Limits function execution to regular intervals

#### 49. **What is lazy loading?**
   Loading resources only when needed to improve initial load time.

#### 50. **How to optimize JavaScript performance?**
   - Minimize DOM manipulation
   - Use event delegation
   - Implement debouncing/throttling
   - Use `requestAnimationFrame` for animations
   - Minify and bundle code

### **10. Advanced JavaScript Concepts**

#### 51. **What is prototypal inheritance?**
   JavaScript uses prototype-based inheritance where objects inherit from other objects:
   ```javascript
   function Animal(name) {
     this.name = name;
   }
   Animal.prototype.speak = function() {
     console.log(this.name + ' makes a sound');
   };
   ```

#### 52. **What is the prototype chain?**
   The chain of prototypes that JavaScript traverses when looking for properties/methods on an object.

#### 53. **What are symbols in JavaScript?**
   Primitive data type for creating unique identifiers:
   ```javascript
   const sym = Symbol('description');
   const obj = { [sym]: 'value' };
   ```

#### 54. **What is currying in JavaScript?**
   Transforming a function with multiple arguments into a sequence of functions:
   ```javascript
   const multiply = (a) => (b) => a * b;
   const double = multiply(2);
   ```

#### 55. **What is memoization?**
   Caching function results to improve performance:
   ```javascript
   function memoize(fn) {
     const cache = {};
     return function(arg) {
       return cache[arg] || (cache[arg] = fn(arg));
     };
   }
   ```

#### 56. **What are WeakMap and WeakSet?**
   - **WeakMap**: Key-value pairs with object keys, allows garbage collection
   - **WeakSet**: Collection of objects, allows garbage collection

#### 57. **What is the difference between `null` and `undefined`?**
   - **`null`**: Intentional absence of value
   - **`undefined`**: Variable declared but not assigned

#### 58. **What is function composition?**
   Combining multiple functions to create a new function:
   ```javascript
   const compose = (f, g) => (x) => f(g(x));
   ```

#### 59. **What are JavaScript classes?**
   ES6 syntax for creating constructor functions:
   ```javascript
   class Person {
     constructor(name) {
       this.name = name;
     }
     greet() {
       return `Hello, ${this.name}`;
     }
   }
   ```

#### 60. **What is inheritance in JavaScript classes?**
   Using `extends` keyword to inherit from parent class:
   ```javascript
   class Student extends Person {
     constructor(name, grade) {
       super(name);
       this.grade = grade;
     }
   }
   ```

### **11. Web APIs and Browser Features**

#### 61. **What is the Fetch API?**
   Modern way to make HTTP requests:
   ```javascript
   fetch('/api/data')
     .then(response => response.json())
     .then(data => console.log(data));
   ```

#### 62. **What are Web Workers?**
   Scripts that run in background threads for heavy computations without blocking UI.

#### 63. **What is Service Worker?**
   Script that runs in background, enables offline functionality and push notifications.

#### 64. **What is CORS?**
   Cross-Origin Resource Sharing - security feature that restricts cross-domain requests.

#### 65. **What are cookies in JavaScript?**
   Small data stored in browser:
   ```javascript
   document.cookie = "name=value; expires=date; path=/";
   ```

#### 66. **What is the History API?**
   Allows manipulation of browser history:
   ```javascript
   history.pushState(state, title, url);
   ```

#### 67. **What is Geolocation API?**
   Gets user's geographical location:
   ```javascript
   navigator.geolocation.getCurrentPosition(callback);
   ```

#### 68. **What is IndexedDB?**
   Client-side database for storing large amounts of structured data.

#### 69. **What are Progressive Web Apps (PWA)?**
   Web applications that use modern web capabilities to provide app-like experience.

#### 70. **What is WebSocket?**
   Protocol for real-time, bidirectional communication between client and server.

### **12. Testing and Debugging**

#### 71. **What is unit testing?**
   Testing individual components/functions in isolation.

#### 72. **What are popular JavaScript testing frameworks?**
   Jest, Mocha, Jasmine, Cypress, Playwright

#### 73. **What is Test-Driven Development (TDD)?**
   Writing tests before writing the actual code.

#### 74. **How do you debug JavaScript?**
   - Browser DevTools
   - `console.log()`
   - `debugger` statement
   - Breakpoints

#### 75. **What is code coverage?**
   Measure of how much code is executed during testing.

### **13. Security**

#### 76. **What is XSS (Cross-Site Scripting)?**
   Security vulnerability where malicious scripts are injected into web pages.

#### 77. **How to prevent XSS attacks?**
   - Sanitize user input
   - Use Content Security Policy (CSP)
   - Escape HTML characters

#### 78. **What is CSRF (Cross-Site Request Forgery)?**
   Attack that forces users to execute unwanted actions on authenticated web applications.

#### 79. **What is Content Security Policy (CSP)?**
   Security header that helps prevent XSS attacks by controlling resource loading.

#### 80. **How to handle sensitive data in JavaScript?**
   - Never store secrets in client-side code
   - Use HTTPS
   - Implement proper authentication

### **14. Design Patterns**

#### 81. **What is the Module pattern?**
   Pattern for creating encapsulated modules:
   ```javascript
   const Module = (function() {
     let privateVar = 0;
     return {
       publicMethod() {
         return privateVar++;
       }
     };
   })();
   ```

#### 82. **What is the Observer pattern?**
   Pattern where objects observe and react to state changes in other objects.

#### 83. **What is the Singleton pattern?**
   Ensures a class has only one instance:
   ```javascript
   class Singleton {
     constructor() {
       if (Singleton.instance) {
         return Singleton.instance;
       }
       Singleton.instance = this;
     }
   }
   ```

#### 84. **What is the Factory pattern?**
   Creates objects without specifying exact classes:
   ```javascript
   function createUser(type) {
     if (type === 'admin') return new Admin();
     if (type === 'user') return new User();
   }
   ```

#### 85. **What is the Decorator pattern?**
   Adds new functionality to objects dynamically without altering structure.

### **15. Build Tools and Workflow**

#### 86. **What is Webpack?**
   Module bundler that packages JavaScript files and assets for deployment.

#### 87. **What is Babel?**
   JavaScript compiler that transforms modern JS code to be compatible with older browsers.

#### 88. **What is npm?**
   Node Package Manager for installing and managing JavaScript packages.

#### 89. **What is package.json?**
   File that contains project metadata and dependency information.

#### 90. **What is the difference between dependencies and devDependencies?**
   - **dependencies**: Required for production
   - **devDependencies**: Only needed for development

### **16. Modern JavaScript Ecosystem**

#### 91. **What is Node.js?**
   JavaScript runtime environment that allows running JavaScript on the server.

#### 92. **What are JavaScript frameworks vs libraries?**
   - **Framework**: Provides structure and controls flow (Angular, Vue)
   - **Library**: Collection of functions you call (React, Lodash)

#### 93. **What is TypeScript?**
   Superset of JavaScript that adds static type checking.

#### 94. **What is JSX?**
   Syntax extension for JavaScript used in React to write HTML-like code.

#### 95. **What is Virtual DOM?**
   In-memory representation of real DOM elements used by libraries like React for efficient updates.

### **17. Performance and Optimization**

#### 96. **What is tree shaking?**
   Eliminating unused code from final bundle to reduce file size.

#### 97. **What is code splitting?**
   Breaking code into smaller chunks that can be loaded on demand.

#### 98. **What is the Critical Rendering Path?**
   Sequence of steps browser takes to render a page.

#### 99. **What are Web Vitals?**
   Google's metrics for measuring user experience: LCP, FID, CLS.

#### 100. **What are best practices for JavaScript performance?**
   - Minimize HTTP requests
   - Use CDN for static assets
   - Implement caching strategies
   - Optimize images and assets
   - Use performance monitoring tools