Here’s a list of 100 common JavaScript interview questions that may be asked by various companies. These questions cover a broad range of topics including basics, advanced concepts, and practical applications:

## Basic JavaScript Concepts
### 1. **What is JavaScript and how is it different from Java?**

JavaScript is a dynamic, interpreted programming language primarily used for creating interactive effects within web browsers. It is a multi-paradigm language, supporting event-driven, functional, and imperative programming styles. JavaScript is mainly used for client-side scripting in web applications, though it can also be used server-side with environments like Node.js.

Java, on the other hand, is a statically-typed, object-oriented programming language used for building standalone applications, server-side systems, and Android applications. It is compiled, whereas JavaScript is interpreted.

Key differences:
- Java is statically typed, while JavaScript is dynamically typed.
- Java is compiled into bytecode, JavaScript is interpreted or just-in-time compiled.
- Java is class-based; JavaScript is prototype-based (though it supports object-oriented programming).

---

### 2. **What are the differences between `var`, `let`, and `const`?**

- **`var`**:
  - Function-scoped or globally scoped (depending on where it is declared).
  - Can be re-declared and updated within its scope.
  - Hoisted, but initialized with `undefined`.

- **`let`**:
  - Block-scoped (limited to the block, statement, or expression where it is defined).
  - Can be updated, but not re-declared within the same scope.
  - Hoisted, but not initialized until execution reaches the declaration.

- **`const`**:
  - Block-scoped.
  - Cannot be updated or re-declared within its scope.
  - Hoisted, but not initialized.
  - Must be assigned a value at the time of declaration (value cannot be changed).

---

### 3. **What are JavaScript data types? Explain each one.**

JavaScript has two main categories of data types:

- **Primitive types** (immutable):
  1. **String**: A sequence of characters, e.g., `"Hello"`.
  2. **Number**: Represents both integer and floating-point numbers, e.g., `42`, `3.14`.
  3. **BigInt**: Large integers (used for numbers larger than `Number.MAX_SAFE_INTEGER`), e.g., `123456789012345678901234567890n`.
  4. **Boolean**: Represents logical values, e.g., `true`, `false`.
  5. **undefined**: A variable that has been declared but not assigned a value.
  6. **null**: Represents the intentional absence of any object value.
  7. **Symbol**: A unique identifier used to create object property keys that are unique, e.g., `Symbol('id')`.
  
- **Non-primitive types** (mutable):
  1. **Object**: A collection of key-value pairs, e.g., `{ name: 'Alice', age: 30 }`.
  2. **Array**: A special type of object used for ordered collections, e.g., `[1, 2, 3]`.

---

### 4. **What are primitive data types in JavaScript?**

Primitive data types in JavaScript are types that are immutable and hold a single value. These include:
- **String**
- **Number**
- **BigInt**
- **Boolean**
- **undefined**
- **null**
- **Symbol**

These types are immutable and compared by their value, not by reference.

---

### 5. **What is a variable in JavaScript? How do you declare a variable?**

A variable in JavaScript is a named container that holds data values. You can declare a variable using one of the following keywords:
- **`var`**: Declares a variable (function-scoped).
- **`let`**: Declares a block-scoped variable.
- **`const`**: Declares a block-scoped constant.

Example:
```javascript
let age = 25; // variable declared using let
const name = "Alice"; // constant declared using const
```

---

### 6. **What is hoisting in JavaScript?**

Hoisting is JavaScript's default behavior of moving variable and function declarations to the top of their containing scope during the compile phase, before the code has been executed. However, only the declarations are hoisted, not the initializations.

For example:
```javascript
console.log(x); // undefined, because the declaration is hoisted but not the initialization
var x = 5;
```
With `let` and `const`, the variables are hoisted but remain in a "temporal dead zone" (TDZ) until they are initialized, resulting in a ReferenceError if accessed before initialization.

---

### 7. **What is a closure in JavaScript? Can you give an example?**

A closure is a function that "remembers" the lexical environment in which it was created, even after the outer function has finished executing. This allows the inner function to access variables from its outer function.

Example:
```javascript
function outer() {
  let counter = 0;
  
  function inner() {
    counter++;
    console.log(counter);
  }

  return inner;
}

const increment = outer();
increment(); // 1
increment(); // 2
```
In this example, `inner()` is a closure that retains access to `counter` even after `outer()` has executed.

---

### 8. **What is the difference between `undefined` and `null`?**

- **`undefined`**:
  - Represents an uninitialized variable or a function that does not return a value.
  - Example: `let x; console.log(x); // undefined`.

- **`null`**:
  - Represents the intentional absence of any object value.
  - Example: `let y = null;`.

Both are falsy values but are not the same. `undefined` is a primitive value automatically assigned by JavaScript when a variable is declared but not initialized, while `null` is explicitly assigned to represent "no value".

---

### 9. **What are the different ways to create objects in JavaScript?**

There are several ways to create objects in JavaScript:
1. **Object literal**:
   ```javascript
   const obj = { name: 'Alice', age: 25 };
   ```

2. **Using `new Object()`**:
   ```javascript
   const obj = new Object();
   obj.name = 'Alice';
   obj.age = 25;
   ```

3. **Using `Object.create()`**:
   ```javascript
   const obj = Object.create(null);
   obj.name = 'Alice';
   obj.age = 25;
   ```

4. **Using a constructor function**:
   ```javascript
   function Person(name, age) {
     this.name = name;
     this.age = age;
   }
   const person1 = new Person('Alice', 25);
   ```

5. **Using a class (ES6)**:
   ```javascript
   class Person {
     constructor(name, age) {
       this.name = name;
       this.age = age;
     }
   }
   const person1 = new Person('Alice', 25);
   ```

---

### 10. **What is the difference between `==` and `===` in JavaScript?**

- **`==` (Loose equality)**: Compares two values for equality after performing type coercion. This means it converts the operands to the same type before comparing.
  - Example: `5 == '5'` is `true` because the string `'5'` is coerced into a number.

- **`===` (Strict equality)**: Compares both the value and the type, without type coercion.
  - Example: `5 === '5'` is `false` because one is a number and the other is a string.


### 11. **Explain the concept of “truthy” and “falsy” values in JavaScript.**

In JavaScript, values are evaluated as either **truthy** or **falsy** when they are used in a boolean context (such as an `if` statement). These values determine the flow of control based on their evaluation.

- **Falsy values** are values that are considered false when encountered in a boolean context. There are only 6 falsy values in JavaScript:
  - `false`
  - `0` (zero)
  - `""` (empty string)
  - `null`
  - `undefined`
  - `NaN`

- **Truthy values** are values that are considered true in a boolean context. Essentially, any value that is not falsy is truthy. For example:
  - `"hello"` (non-empty string)
  - `42` (any non-zero number)
  - `[]` (empty array)
  - `{}` (empty object)

Example:
```javascript
if (0) {
  console.log("This will not run");
}

if ("Hello") {
  console.log("This will run"); // "Hello" is truthy
}
```

---

### 12. **How does the `this` keyword work in JavaScript?**

In JavaScript, the **`this`** keyword refers to the context in which a function is called. The value of `this` depends on how a function is invoked:

- **In a regular function**: `this` refers to the global object (`window` in browsers) in non-strict mode, or `undefined` in strict mode.
  
- **In a method**: If the function is a method of an object, `this` refers to the object that called the method.

- **In an arrow function**: `this` is lexically inherited from the surrounding context (it does not have its own `this`).

- **With `call()`, `apply()`, or `bind()`**: You can explicitly set the value of `this`.

Example:
```javascript
const person = {
  name: 'Alice',
  greet: function() {
    console.log(this.name);
  }
};

person.greet(); // "Alice", 'this' refers to the 'person' object
```

---

### 13. **What is the event loop in JavaScript?**

The **event loop** is the mechanism that handles asynchronous operations in JavaScript. It allows JavaScript to execute code, handle events, and perform actions like I/O without blocking the main execution thread. JavaScript is single-threaded, meaning it can only execute one piece of code at a time, but the event loop allows it to handle multiple operations by using a call stack, event queue, and the task queue.

- **Call Stack**: Holds the currently executing function.
- **Event Queue**: Holds messages (callbacks) that are waiting to be executed when the stack is empty.

When a function (like a callback or event handler) is invoked, it's placed in the event queue. The event loop continuously checks the call stack; when the stack is empty, it dequeues the next message from the event queue and pushes it onto the call stack.

Example:
```javascript
console.log("Start");

setTimeout(() => {
  console.log("Timeout");
}, 0);

console.log("End");

// Output:
// Start
// End
// Timeout
```

---

### 14. **Explain the concept of JavaScript’s single-threaded model.**

JavaScript operates on a **single-threaded** model, meaning it can only execute one task at a time in a single execution thread. This is different from multi-threaded environments where multiple tasks can run simultaneously.

However, JavaScript uses an **event loop** and **asynchronous operations** (such as `setTimeout`, `Promises`, and AJAX) to handle tasks like I/O without blocking the main thread. These asynchronous tasks are queued and executed when the main thread is free, enabling non-blocking behavior while still being single-threaded.

This single-threaded nature can cause performance issues if long-running tasks block the event loop, which is why techniques like **web workers** (for parallelism) or breaking tasks into smaller chunks are used in JavaScript.

---

### 15. **What are the data types that are mutable in JavaScript?**

In JavaScript, **mutable** data types are those whose values can be changed after they are created. The mutable data types are:

- **Objects**: You can add, modify, or delete properties.
  ```javascript
  const obj = { name: "Alice", age: 25 };
  obj.age = 26; // mutable property
  ```

- **Arrays**: You can add, remove, or change elements.
  ```javascript
  const arr = [1, 2, 3];
  arr[0] = 10; // mutable element
  ```

- **Functions**: Functions themselves are objects, and their properties can be modified.
  ```javascript
  function greet() { return "Hello"; }
  greet.message = "Welcome"; // Adding property to function
  ```

---

### 16. **What is a function in JavaScript? How do you declare one?**

A **function** in JavaScript is a block of reusable code that performs a specific task. Functions can accept inputs (parameters) and return outputs (values).

You can declare a function in several ways:

- **Function declaration (function statement)**:
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

---

### 17. **What is a callback function in JavaScript? Can you give an example?**

A **callback function** is a function passed as an argument to another function, which is then executed at a later time, usually in response to an event or when a task completes.

Example:
```javascript
function fetchData(callback) {
  const data = "Fetched data";
  callback(data);
}

function displayData(data) {
  console.log(data); // "Fetched data"
}

fetchData(displayData); // Callback function executed after fetchData
```

---

### 18. **What are arrow functions in JavaScript and how are they different from regular functions?**

**Arrow functions** (introduced in ES6) provide a shorter syntax for writing functions. They also have a different behavior for the `this` keyword:

- **Syntax**: Arrow functions have a more concise syntax, especially when there is a single expression.
  ```javascript
  const sum = (a, b) => a + b;
  ```

- **Differences**:
  1. **`this` binding**: Arrow functions **do not** have their own `this` context; instead, they inherit `this` from the surrounding scope (lexical scoping). Regular functions, on the other hand, bind their own `this`.
  2. **No `arguments` object**: Arrow functions do not have access to the `arguments` object, while regular functions do.
  3. **Cannot be used as constructors**: Arrow functions cannot be invoked with the `new` keyword.

Example:
```javascript
const obj = {
  name: "Alice",
  greet: function() {
    setTimeout(() => {
      console.log(this.name); // 'this' refers to 'obj'
    }, 1000);
  }
};

obj.greet(); // "Alice"
```

---

### 19. **What is a higher-order function in JavaScript?**

A **higher-order function** is a function that either:
1. Takes one or more functions as arguments.
2. Returns a function as its result.

Higher-order functions are often used for functional programming techniques such as mapping, filtering, and reducing collections.

Example:
```javascript
function greet(person, callback) {
  console.log(`Hello, ${person}`);
  callback();
}

function sayGoodbye() {
  console.log("Goodbye!");
}

greet("Alice", sayGoodbye); // Higher-order function
```

---

### 20. **What are template literals in JavaScript? Provide an example.**

**Template literals** (introduced in ES6) are a way to embed expressions within string literals. They are enclosed by backticks (` `) and allow for multi-line strings and string interpolation.

- **String interpolation**: You can embed expressions inside `${}`.
- **Multi-line strings**: No need to concatenate strings with `+` or escape newlines.

Example:
```javascript
const name = "Alice";
const age = 25;
const message = `Hello, my name is ${name} and I am ${age} years old.`;
console.log(message); // "Hello, my name is Alice and I am 25 years old."

const multiLineMessage = `This is line 1
This is line 2`;
console.log(multiLineMessage);
```


### 21. **What are the different ways to loop through an array in JavaScript?**

There are several ways to loop through an array in JavaScript:

1. **`for` loop**: Traditional loop that allows manual control over index.
   ```javascript
   const arr = [1, 2, 3];
   for (let i = 0; i < arr.length; i++) {
     console.log(arr[i]);
   }
   ```

2. **`forEach()`**: A higher-order function that executes a callback for each item in the array.
   ```javascript
   const arr = [1, 2, 3];
   arr.forEach(item => {
     console.log(item);
   });
   ```

3. **`for...of`**: Simplified iteration over array values.
   ```javascript
   const arr = [1, 2, 3];
   for (const item of arr) {
     console.log(item);
   }
   ```

4. **`for...in`**: Iterates over the array indices (not recommended for arrays).
   ```javascript
   const arr = [1, 2, 3];
   for (const index in arr) {
     console.log(arr[index]);
   }
   ```

5. **`map()`**: Creates a new array by applying a function to each element.
   ```javascript
   const arr = [1, 2, 3];
   const doubled = arr.map(item => item * 2);
   console.log(doubled);
   ```

6. **`filter()`**: Creates a new array with elements that pass a test.
   ```javascript
   const arr = [1, 2, 3, 4];
   const even = arr.filter(item => item % 2 === 0);
   console.log(even);
   ```

---

### 22. **What is the spread operator in JavaScript and how does it work?**

The **spread operator** (`...`) is used to expand elements of an iterable (like an array or object) into individual elements.

- **For Arrays**: It can be used to unpack elements of an array into a new array.
  ```javascript
  const arr1 = [1, 2, 3];
  const arr2 = [...arr1, 4, 5];
  console.log(arr2); // [1, 2, 3, 4, 5]
  ```

- **For Objects**: It can be used to create a shallow copy or merge objects.
  ```javascript
  const obj1 = { a: 1, b: 2 };
  const obj2 = { ...obj1, c: 3 };
  console.log(obj2); // { a: 1, b: 2, c: 3 }
  ```

The spread operator makes it easier to clone arrays/objects or merge them.

---

### 23. **How does destructuring work in JavaScript? Can you give an example?**

**Destructuring** is a shorthand syntax that allows you to unpack values from arrays or objects into variables.

- **Array Destructuring**:
  ```javascript
  const arr = [1, 2, 3];
  const [a, b] = arr;
  console.log(a); // 1
  console.log(b); // 2
  ```

- **Object Destructuring**:
  ```javascript
  const person = { name: 'Alice', age: 25 };
  const { name, age } = person;
  console.log(name); // Alice
  console.log(age);  // 25
  ```

Destructuring can also be used with default values and renaming:
```javascript
const person = { name: 'Alice', age: 25 };
const { name: fullName, age, address = 'Unknown' } = person;
console.log(fullName); // Alice
console.log(address);  // Unknown
```

---

### 24. **What are JavaScript promises and how do they work?**

A **Promise** in JavaScript represents a value that may not be available yet, but will be resolved at some point in the future, allowing asynchronous operations to be handled more effectively.

- **States of a Promise**:
  1. **Pending**: Initial state, neither fulfilled nor rejected.
  2. **Fulfilled**: Operation completed successfully, with a value.
  3. **Rejected**: Operation failed, with a reason (error).

Promises are created using the `new Promise()` constructor and use `.then()` for success and `.catch()` for failure.

Example:
```javascript
let myPromise = new Promise((resolve, reject) => {
  let success = true;
  if (success) {
    resolve("Operation successful");
  } else {
    reject("Operation failed");
  }
});

myPromise
  .then(result => console.log(result))   // "Operation successful"
  .catch(error => console.log(error));   // "Operation failed"
```

---

### 25. **What is async/await in JavaScript?**

**`async`** and **`await`** are syntactic sugar built on top of promises that allow asynchronous code to be written in a more synchronous-looking manner.

- **`async`**: Declares a function as asynchronous, meaning it always returns a promise.
- **`await`**: Can only be used inside an `async` function, and it pauses the execution of the function until the promise is resolved or rejected.

Example:
```javascript
async function fetchData() {
  let response = await fetch('https://api.example.com');
  let data = await response.json();
  console.log(data);
}

fetchData();
```
Here, `await` pauses the function until the promise from `fetch` is resolved.

---

### 26. **What is the difference between `forEach` and `map` in JavaScript?**

Both `forEach` and `map` are used to iterate over arrays, but they have key differences:

- **`forEach()`**:
  - Executes a provided function once for each element in the array.
  - Does **not** return a new array; it returns `undefined`.
  - Used for side-effects (e.g., modifying elements, logging).

  Example:
  ```javascript
  const arr = [1, 2, 3];
  arr.forEach(item => console.log(item)); // Outputs each item but returns undefined
  ```

- **`map()`**:
  - Creates a new array with the results of calling a function on every element.
  - Returns a new array, so it's useful when you need a transformed version of the original array.
  
  Example:
  ```javascript
  const arr = [1, 2, 3];
  const doubled = arr.map(item => item * 2);
  console.log(doubled); // [2, 4, 6]
  ```

---

### 27. **What are `setTimeout` and `setInterval` functions used for?**

Both **`setTimeout`** and **`setInterval`** are used to schedule tasks to be executed after a certain delay.

- **`setTimeout()`**:
  - Executes a function once after a specified delay (in milliseconds).
  - Returns a timer ID that can be used with `clearTimeout` to cancel the scheduled execution.

  Example:
  ```javascript
  setTimeout(() => {
    console.log("Executed after 2 seconds");
  }, 2000); // 2000ms = 2 seconds
  ```

- **`setInterval()`**:
  - Executes a function repeatedly at the specified interval (in milliseconds).
  - Returns a timer ID that can be used with `clearInterval` to stop the repeated execution.

  Example:
  ```javascript
  const intervalId = setInterval(() => {
    console.log("Executed every 2 seconds");
  }, 2000);

  // To stop the interval after 6 seconds
  setTimeout(() => {
    clearInterval(intervalId);
  }, 6000);
  ```

---

### 28. **How do you handle errors in JavaScript?**

In JavaScript, errors can be handled using **try...catch** blocks or **Promises**.

- **`try...catch`**: Used to handle synchronous errors.
  ```javascript
  try {
    let result = someFunction();
  } catch (error) {
    console.error("Error:", error.message);
  }
  ```

- **Promise `catch`**: Handles errors for asynchronous code in promises.
  ```javascript
  someAsyncFunction()
    .then(result => console.log(result))
    .catch(error => console.error("Error:", error));
  ```

- **Throwing errors**: You can also throw custom errors using `throw`.
  ```javascript
  throw new Error("Something went wrong");
  ```

---

### 29. **What is an IIFE (Immediately Invoked Function Expression) in JavaScript?**

An **IIFE** is a function that is defined and executed immediately after its declaration. It is commonly used to create a local scope to avoid polluting the global namespace.

Example:
```javascript
(function() {
  const x = 10;
  console.log(x); // 10
})(); // IIFE is invoked immediately
```

IIFEs are typically used to create modules and avoid variable name collisions in global scope.

---

### 30. **What is the difference between `call()`, `apply()`, and `bind()` in JavaScript?**

These three methods are used to control the value of `this` within a function:

- **`call()`**: Calls the function immediately and allows you to pass arguments one by

 one.
  ```javascript
  function greet(name) {
    console.log(`Hello, ${name}`);
  }
  greet.call(null, "Alice"); // Hello, Alice
  ```

- **`apply()`**: Similar to `call()`, but takes arguments as an array or array-like object.
  ```javascript
  function greet(name, age) {
    console.log(`Hello, ${name}, age ${age}`);
  }
  greet.apply(null, ["Alice", 25]); // Hello, Alice, age 25
  ```

- **`bind()`**: Returns a new function with `this` set to the provided value, and can optionally preset some arguments.
  ```javascript
  const greetAlice = greet.bind(null, "Alice");
  greetAlice(25); // Hello, Alice, age 25
  ```

The key difference is that `call()` and `apply()` invoke the function immediately, while `bind()` creates a new function with the specified `this` value.

### 31. **What is an object prototype in JavaScript?**

An **object prototype** in JavaScript refers to the prototype object that every object inherits methods and properties from. Every JavaScript object has an internal property called `[[Prototype]]`, which links to its prototype, and it forms the basis for inheritance in JavaScript.

- Objects inherit properties and methods from their prototype. For example, all arrays inherit from `Array.prototype`, and all objects inherit from `Object.prototype`.
  
- You can modify an object's prototype using `Object.create()`, or for function constructors, you can modify the `prototype` property.

Example:
```javascript
const person = { name: "Alice" };
console.log(person.toString()); // Inherited from Object.prototype
```

In the example above, `toString()` is inherited from `Object.prototype`.

---

### 32. **What are JavaScript’s built-in objects?**

JavaScript provides several built-in objects, which are available globally. Some of the commonly used built-in objects include:

1. **Object**: The base object for all objects in JavaScript.
2. **Array**: Used to store ordered collections of data.
3. **String**: Used to represent and manipulate sequences of characters.
4. **Number**: Used to represent numerical values.
5. **Boolean**: Represents a logical entity with `true` or `false`.
6. **Date**: Provides methods to work with dates and times.
7. **Math**: A math utility object that provides mathematical constants and functions (e.g., `Math.random()`, `Math.sqrt()`).
8. **RegExp**: Used for working with regular expressions.
9. **JSON**: Provides methods for working with JSON data (e.g., `JSON.stringify()`, `JSON.parse()`).
10. **Error**: Used for creating error objects.

Example:
```javascript
const date = new Date();
console.log(date.getFullYear()); // Built-in Date object
```

---

### 33. **How does `JSON.stringify()` and `JSON.parse()` work in JavaScript?**

- **`JSON.stringify()`**: Converts a JavaScript object or value to a JSON string. This is useful for sending data over the network or saving it to local storage.
  - Converts objects, arrays, and primitive values to JSON-formatted strings.

  Example:
  ```javascript
  const person = { name: "Alice", age: 25 };
  const jsonStr = JSON.stringify(person);
  console.log(jsonStr); // '{"name":"Alice","age":25}'
  ```

- **`JSON.parse()`**: Converts a JSON string back into a JavaScript object. This is useful when retrieving data from local storage or APIs.
  - Returns the corresponding JavaScript object or array.

  Example:
  ```javascript
  const jsonStr = '{"name":"Alice","age":25}';
  const obj = JSON.parse(jsonStr);
  console.log(obj); // { name: 'Alice', age: 25 }
  ```

---

### 34. **How can you create a class in JavaScript?**

In JavaScript, classes can be created using the `class` keyword (introduced in ES6). A class is a blueprint for creating objects with shared properties and methods.

Syntax:
```javascript
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  greet() {
    console.log(`Hello, my name is ${this.name}.`);
  }
}

const person1 = new Person('Alice', 25);
person1.greet(); // "Hello, my name is Alice."
```

- **`constructor()`**: A special method used for initializing new objects created from the class.
- Methods defined inside a class are automatically added to the prototype of the class.

---

### 35. **What is the difference between `class` and `constructor` in JavaScript?**

- **`class`**: A class is a blueprint for creating objects, defining properties and methods that can be shared by all instances of the class.
  
  - It is a syntactic sugar over JavaScript's existing prototype-based inheritance.
  - You can create instances of a class using the `new` keyword.
  
  Example:
  ```javascript
  class Animal {
    constructor(name) {
      this.name = name;
    }
    speak() {
      console.log(`${this.name} makes a sound.`);
    }
  }
  ```

- **`constructor`**: A special method inside a class, used to initialize a newly created object.
  - It is executed when an instance of the class is created using the `new` keyword.
  
  Example:
  ```javascript
  class Animal {
    constructor(name) {
      this.name = name; // Initializes 'name' property
    }
  }
  ```

In summary, `class` is the entire structure defining an object template, while `constructor` is a function used to initialize the properties of an object when an instance of the class is created.

---

### 36. **What are getter and setter methods in JavaScript?**

Getter and setter methods allow you to define how to access or modify the properties of an object.

- **Getter**: A method that gets the value of a property.
- **Setter**: A method that sets the value of a property.

Both are defined using `get` and `set` keywords.

Example:
```javascript
class Person {
  constructor(name) {
    this._name = name; // Private property
  }

  // Getter
  get name() {
    return this._name;
  }

  // Setter
  set name(value) {
    if (value.length > 0) {
      this._name = value;
    } else {
      console.log("Name cannot be empty.");
    }
  }
}

const person = new Person("Alice");
console.log(person.name); // "Alice" - Calls the getter
person.name = "Bob"; // Calls the setter
console.log(person.name); // "Bob"
```

Getters and setters provide control over how properties are accessed or modified.

---

### 37. **What are symbols in JavaScript? When would you use them?**

A **symbol** is a primitive data type introduced in ES6, used to create unique, immutable identifiers for object properties. Symbols are often used to add properties to objects without the risk of name clashes.

- **Uniqueness**: Each symbol is guaranteed to be unique.
- **Immutability**: Once created, a symbol cannot be altered.

Symbols are commonly used in situations like:
- Creating private properties.
- Adding unique keys to objects to avoid collisions in libraries or frameworks.

Example:
```javascript
const uniqueKey = Symbol("key");
const obj = {};
obj[uniqueKey] = "value";

console.log(obj[uniqueKey]); // "value"
```

Symbols provide a way to create property keys that don't conflict with other properties.

---

### 38. **What is a generator function in JavaScript?**

A **generator function** is a special type of function in JavaScript that can be paused and resumed. It is defined using the `function*` syntax and uses `yield` to pause and return values during the function's execution.

- The `yield` keyword is used to pause the function's execution and return a value. The function can be resumed later using the generator's `.next()` method.
- Generator functions return a **generator object**, which conforms to the iterator protocol.

Example:
```javascript
function* counter() {
  yield 1;
  yield 2;
  yield 3;
}

const gen = counter();
console.log(gen.next().value); // 1
console.log(gen.next().value); // 2
console.log(gen.next().value); // 3
console.log(gen.next().done);  // true
```

- **`next()`**: Resumes the generator function, returning an object with `value` (the yielded value) and `done` (indicates if the generator is finished).


## Intermediate JavaScript Concepts
### 39. **What is event delegation in JavaScript?**

**Event delegation** is a technique in JavaScript where instead of attaching an event listener to each individual element (e.g., each list item), you attach a single event listener to a parent element. This parent listens for events triggered by its child elements, taking advantage of event bubbling.

Event delegation improves performance, especially when dealing with a large number of elements, and makes it easier to handle events dynamically, even for elements added after the initial page load.

Example:
```javascript
// Attaching event listener to the parent
const parentElement = document.getElementById("parent");

parentElement.addEventListener("click", (event) => {
  // Only handle clicks on list items
  if (event.target && event.target.matches("li")) {
    console.log("List item clicked:", event.target.textContent);
  }
});
```
Here, the `click` event listener is added to the parent (`#parent`), but the event handler only triggers when a list item (`<li>`) is clicked.

---

### 40. **How does JavaScript handle asynchronous operations?**

JavaScript handles asynchronous operations using:

1. **Callbacks**: Functions passed as arguments to other functions, to be executed later.
   ```javascript
   function fetchData(callback) {
     setTimeout(() => {
       console.log("Data fetched");
       callback();
     }, 1000);
   }

   fetchData(() => {
     console.log("Callback executed");
   });
   ```

2. **Promises**: Represent the eventual completion (or failure) of an asynchronous operation and its resulting value. Promises allow chaining of asynchronous operations with `.then()`, `.catch()`, and `.finally()`.
   ```javascript
   const myPromise = new Promise((resolve, reject) => {
     setTimeout(() => resolve("Data fetched"), 1000);
   });

   myPromise.then(result => console.log(result)); // "Data fetched"
   ```

3. **Async/Await**: Makes asynchronous code look synchronous. The `async` function returns a promise, and `await` pauses execution until the promise is resolved.
   ```javascript
   async function fetchData() {
     let result = await myPromise;
     console.log(result); // "Data fetched"
   }

   fetchData();
   ```

JavaScript uses **event loop** to manage these asynchronous operations, allowing non-blocking behavior while executing other code.

---

### 41. **What is a promise chain in JavaScript?**

A **promise chain** is a sequence of `.then()` or `.catch()` methods chained together, allowing for a series of asynchronous operations to be executed in order. Each `.then()` receives the result of the previous promise.

Example:
```javascript
fetchData()
  .then(data => {
    console.log("Data received:", data);
    return processData(data);
  })
  .then(processedData => {
    console.log("Processed data:", processedData);
    return saveData(processedData);
  })
  .catch(error => {
    console.error("Error occurred:", error);
  });
```
Here, `fetchData` returns a promise, which is passed to the first `.then()`. The subsequent `.then()` methods chain the results of the previous promises.

---

### 42. **What is the difference between `null` and `undefined`?**

- **`undefined`**: A primitive value automatically assigned to a variable that has been declared but not yet assigned a value. It also indicates the absence of a value in function parameters when no value is passed.
  ```javascript
  let a;
  console.log(a); // undefined
  ```

- **`null`**: A special value used to indicate the intentional absence of any object value. It is explicitly assigned to variables to represent "no value."
  ```javascript
  let a = null;
  console.log(a); // null
  ```

In summary, `undefined` is the default value for uninitialized variables, while `null` is intentionally assigned to represent "no value."

---

### 43. **What are modules in JavaScript? How can you import and export modules?**

**Modules** in JavaScript allow you to break down your code into smaller, reusable pieces (files), improving maintainability and organization.

- **Export**: Use the `export` keyword to make variables, functions, or classes available to other files.

  Example (exporting a function):
  ```javascript
  // file1.js
  export function greet(name) {
    return `Hello, ${name}`;
  }
  ```

- **Import**: Use the `import` keyword to include the exported code into another file.

  Example (importing the function):
  ```javascript
  // file2.js
  import { greet } from './file1.js';
  console.log(greet('Alice')); // "Hello, Alice"
  ```

- **Default Export**: A module can have one default export, which can be imported without curly braces.
  ```javascript
  // file1.js
  export default function greet(name) {
    return `Hello, ${name}`;
  }
  ```

  ```javascript
  // file2.js
  import greet from './file1.js';
  console.log(greet('Alice')); // "Hello, Alice"
  ```

---

### 44. **What are JavaScript arrays and how do you manipulate them?**

An **array** is a collection of ordered values (elements). Arrays in JavaScript are dynamic, meaning they can store any type of data and grow or shrink in size.

Common array manipulation methods include:

1. **`push()`**: Adds elements to the end of an array.
   ```javascript
   let arr = [1, 2, 3];
   arr.push(4); // [1, 2, 3, 4]
   ```

2. **`pop()`**: Removes the last element from an array.
   ```javascript
   arr.pop(); // [1, 2, 3]
   ```

3. **`shift()`**: Removes the first element from an array.
   ```javascript
   arr.shift(); // [2, 3]
   ```

4. **`unshift()`**: Adds elements to the beginning of an array.
   ```javascript
   arr.unshift(0); // [0, 2, 3]
   ```

5. **`splice()`**: Adds or removes elements at a specific index.
   ```javascript
   arr.splice(1, 1, 10); // [0, 10, 3] (removes 2 and adds 10 at index 1)
   ```

6. **`map()`**: Creates a new array by applying a function to each element.
   ```javascript
   const doubled = arr.map(x => x * 2); // [0, 20, 6]
   ```

7. **`filter()`**: Creates a new array with elements that pass a test.
   ```javascript
   const even = arr.filter(x => x % 2 === 0); // [0, 10]
   ```

8. **`forEach()`**: Iterates over all elements in the array.
   ```javascript
   arr.forEach(item => console.log(item));
   ```

---

### 45. **How do you make an AJAX request in JavaScript?**

An **AJAX** (Asynchronous JavaScript and XML) request allows you to fetch data from a server without refreshing the page. In JavaScript, you can use the `XMLHttpRequest` object or the `Fetch API`.

- **Using `XMLHttpRequest`**:
  ```javascript
  const xhr = new XMLHttpRequest();
  xhr.open("GET", "https://api.example.com/data", true);
  xhr.onload = function() {
    if (xhr.status === 200) {
      console.log(xhr.responseText);
    }
  };
  xhr.send();
  ```

- **Using `Fetch API` (modern approach)**:
  ```javascript
  fetch("https://api.example.com/data")
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error("Error:", error));
  ```

---

### 46. **What is the Fetch API in JavaScript?**

The **Fetch API** is a modern and more flexible way to make HTTP requests in JavaScript. It returns a **Promise** and provides a simple interface to handle network requests.

Example:
```javascript
fetch('https://api.example.com/data')
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.log('Error:', error));
```

The `fetch()` function accepts the URL and an optional configuration object, which allows you to specify the HTTP method, headers, body, etc.

---

### 47. **Explain the concept of a single-page application (SPA).**

A **Single-Page Application (SPA)** is a web application or website that dynamically updates the content of a single HTML page, without loading a new page from the server. SPAs provide a smooth and fast user experience by avoiding full page reloads.

- **How it works**: SPAs use AJAX or Fetch API to load content and interact with the server asynchronously. The page is loaded once, and navigation happens by updating the URL and dynamically rendering new content via JavaScript.

- **Popular SPA frameworks**: React, Angular, and Vue.js.

Example:
- When you click on a navigation link, JavaScript updates the content without reloading the entire page.

---

### 48. **What are `localStorage` and `sessionStorage` in JavaScript?**

Both **`localStorage`** and **`sessionStorage`** are web storage objects that

 allow you to store data in the browser.

- **`localStorage`**: Stores data with no expiration time. The data remains in the browser even after the browser is closed.
  ```javascript
  localStorage.setItem('name', 'Alice');
  console.log(localStorage.getItem('name')); // "Alice"
  ```

- **`sessionStorage`**: Stores data for the duration of the page session. The data is cleared when the page is closed.
  ```javascript
  sessionStorage.setItem('name', 'Bob');
  console.log(sessionStorage.getItem('name')); // "Bob"
  ```

Both storage types store data as key-value pairs, but **`localStorage`** persists beyond the session, whereas **`sessionStorage`** is limited to the duration of the session.

### 49. **What is event bubbling and capturing in JavaScript?**

Event **bubbling** and **capturing** are two phases of event propagation in the DOM (Document Object Model).

- **Event Bubbling**: In this phase, when an event is triggered on an element, it first runs the event handler on the innermost element (the target element) and then bubbles up to the outer elements, running the handlers of each parent element in the hierarchy.
  
- **Event Capturing** (or trickling): In this phase, the event starts from the outermost element (document) and trickles down to the target element, invoking the event handler at each level before reaching the target.

By default, most events bubble (propagate upwards). You can control this behavior using `addEventListener` by specifying the third argument.

Example:
```javascript
// Bubbling example (default)
document.getElementById("parent").addEventListener("click", () => {
  console.log("Parent clicked");
});
document.getElementById("child").addEventListener("click", () => {
  console.log("Child clicked");
});

// This would log: "Child clicked" then "Parent clicked"

// Capturing example
document.getElementById("parent").addEventListener("click", () => {
  console.log("Parent clicked");
}, true); // true indicates capturing phase
```

---

### 50. **How do you prevent the default action of an event in JavaScript?**

To prevent the default behavior associated with an event (e.g., submitting a form or following a link), you use the `preventDefault()` method.

Example:
```javascript
document.getElementById("myLink").addEventListener("click", function(event) {
  event.preventDefault(); // Prevents the link from navigating
  console.log("Link clicked but not navigated.");
});
```

This prevents the default behavior (in this case, navigating to the URL) from occurring when the event is triggered.

---

### 51. **How do you attach multiple event listeners to the same event?**

You can attach multiple event listeners to the same event by calling `addEventListener` multiple times for the same event on the same element.

Example:
```javascript
const button = document.getElementById("myButton");

button.addEventListener("click", function() {
  console.log("First event listener");
});

button.addEventListener("click", function() {
  console.log("Second event listener");
});
```

Both event listeners will be executed when the button is clicked.

---

### 52. **What is the difference between `Object.freeze()` and `Object.seal()` in JavaScript?**

- **`Object.freeze()`**: Freezes an object, preventing new properties from being added, existing properties from being removed, and existing properties from being modified (i.e., making the object immutable).
  ```javascript
  const obj = { name: "Alice" };
  Object.freeze(obj);
  obj.name = "Bob"; // This will not change the property value
  console.log(obj.name); // "Alice"
  ```

- **`Object.seal()`**: Seals an object, preventing new properties from being added or existing properties from being deleted, but allows modification of the existing properties.
  ```javascript
  const obj = { name: "Alice" };
  Object.seal(obj);
  obj.name = "Bob"; // This will change the property value
  delete obj.name; // This will not delete the property
  console.log(obj.name); // "Bob"
  ```

In summary:
- **`freeze()`**: Prevents changes to properties, making them immutable.
- **`seal()`**: Prevents property addition/removal but allows modification of values.

---

### 53. **How do you remove an element from an array in JavaScript?**

There are several ways to remove elements from an array in JavaScript:

1. **Using `pop()`**: Removes the last element from an array.
   ```javascript
   const arr = [1, 2, 3];
   arr.pop(); // Removes 3
   console.log(arr); // [1, 2]
   ```

2. **Using `shift()`**: Removes the first element from an array.
   ```javascript
   const arr = [1, 2, 3];
   arr.shift(); // Removes 1
   console.log(arr); // [2, 3]
   ```

3. **Using `splice()`**: Removes elements at a specific index.
   ```javascript
   const arr = [1, 2, 3];
   arr.splice(1, 1); // Removes 2 (at index 1)
   console.log(arr); // [1, 3]
   ```

4. **Using `filter()`**: Creates a new array by filtering out the element you want to remove.
   ```javascript
   const arr = [1, 2, 3];
   const newArr = arr.filter(item => item !== 2); // Removes 2
   console.log(newArr); // [1, 3]
   ```

---

### 54. **How does JavaScript handle scope and closures?**

- **Scope**: Refers to the context in which variables are defined and accessible.
  - **Global scope**: Variables are accessible throughout the entire code.
  - **Local scope**: Variables defined inside functions or blocks are only accessible within that function/block.
  - **Block scope**: Variables defined using `let` or `const` are block-scoped, meaning they are confined to the block in which they are defined.

- **Closures**: A closure is a function that "remembers" its lexical scope, even when the function is executed outside that scope.
  - A closure allows a function to access variables from its outer (enclosing) function even after the outer function has finished executing.

Example:
```javascript
function outer() {
  let outerVar = "I am from outer";
  
  function inner() {
    console.log(outerVar); // Inner function has access to outerVar (closure)
  }

  return inner;
}

const closureFunc = outer();
closureFunc(); // "I am from outer"
```

---

### 55. **What is the use of the `window` object in JavaScript?**

The `window` object represents the global context in the browser and provides methods, properties, and events for interacting with the browser window. It is the top-level object in the browser's environment.

Key uses:
- **Global object**: Variables declared globally are properties of the `window` object.
- **Browser manipulation**: Methods like `alert()`, `setTimeout()`, `setInterval()`, `location`, etc.
- **Access to DOM**: Through `window.document`, you can manipulate the DOM.

Example:
```javascript
console.log(window.innerWidth); // Width of the window's content area
alert("Hello, world!"); // Uses window.alert() method
```

---

### 56. **How does the `new` keyword work in JavaScript?**

The `new` keyword is used to create an instance of an object from a constructor function or a class. It does the following:

1. Creates a new empty object.
2. Sets the `this` context of the constructor to that new object.
3. Executes the constructor function, assigning properties and methods to the new object.
4. Returns the new object, unless the constructor explicitly returns a different object.

Example:
```javascript
function Person(name, age) {
  this.name = name;
  this.age = age;
}

const person1 = new Person('Alice', 25);
console.log(person1); // Person { name: 'Alice', age: 25 }
```

---

### 57. **What is `setTimeout()` and `setInterval()`?**

- **`setTimeout()`**: Executes a function after a specified delay (in milliseconds).
  
  Example:
  ```javascript
  setTimeout(() => {
    console.log("Executed after 2 seconds");
  }, 2000);
  ```

- **`setInterval()`**: Executes a function repeatedly at a specified interval (in milliseconds) until stopped by `clearInterval()`.

  Example:
  ```javascript
  const intervalId = setInterval(() => {
    console.log("Executed every 2 seconds");
  }, 2000);

  // Stop the interval after 6 seconds
  setTimeout(() => clearInterval(intervalId), 6000);
  ```

---

### 58. **What are callbacks and promises used for in JavaScript?**

- **Callbacks**: Functions passed as arguments to other functions, used to handle asynchronous operations (e.g., after a data fetch or when an event occurs).
  - Callbacks are typically used for tasks like handling results after API calls, file reading, etc.
  
  Example:
  ```javascript
  function fetchData(callback) {
    setTimeout(() => {
      callback("Data fetched");
    }, 1000);
  }

  fetchData(result => {
    console.log(result); // "Data fetched"
  });
  ```

- **Promises**: Represent the result of an asynchronous operation, which may be completed in the future or fail.
  - Promises can be chained with `.then()` for success and `.catch()` for error handling.
  
  Example:
  ```javascript
  const myPromise = new Promise((resolve, reject) => {
    setTimeout(() => resolve("Data fetched"), 1000);
  });

  myPromise.then(result => console.log(result)); // "Data fetched"
  ```

Both callbacks and promises allow for handling asynchronous tasks without blocking the execution of other code. Promises are a more modern approach and help avoid "callback hell" (deeply nested callbacks).

### 59. **What is a JavaScript memory leak and how can you avoid it?**

A **memory leak** occurs when the JavaScript engine does not release memory that is no longer in use. This can cause the browser to slow down or even crash as unused objects and resources remain in memory.

Common causes of memory leaks:
- **Global variables**: Variables that are accidentally declared in the global scope.
- **Unclosed event listeners**: Not removing event listeners can prevent objects from being garbage-collected.
- **Detached DOM elements**: When elements are removed from the DOM but still referenced in JavaScript, they won't be garbage collected.
  
To avoid memory leaks:
- Use `let` and `const` to avoid unintentional global variables.
- Remove event listeners using `removeEventListener()` when they're no longer needed.
- Set DOM references to `null` when you no longer need them to allow garbage collection.
- Use `WeakMap` or `WeakSet` to hold references that don't prevent garbage collection.

---

### 60. **How do you use regular expressions in JavaScript?**

Regular expressions (regex) are used for pattern matching and text manipulation in JavaScript. They can be created using the `RegExp` constructor or using a literal syntax.

- **Creating a regex**:
  ```javascript
  const regex = /hello/; // regex literal
  const regex2 = new RegExp("hello"); // using RegExp constructor
  ```

- **Using regex with methods**:
  - `test()`: Tests if a pattern exists in a string.
  ```javascript
  const regex = /hello/;
  console.log(regex.test("hello world")); // true
  ```

  - `exec()`: Executes a search for a match in a string and returns detailed information.
  ```javascript
  const regex = /hello/;
  console.log(regex.exec("hello world")); // ["hello"]
  ```

  - `match()`: Matches a string against a regex pattern and returns the result.
  ```javascript
  const str = "hello world";
  console.log(str.match(/world/)); // ["world"]
  ```

  - `replace()`: Replaces part of a string that matches a pattern.
  ```javascript
  const str = "hello world";
  console.log(str.replace(/world/, "JavaScript")); // "hello JavaScript"
  ```

---

### 61. **What are Web Workers in JavaScript?**

Web Workers are JavaScript scripts that run in the background, separate from the main thread, enabling you to perform tasks like calculations, data processing, or making network requests without blocking the UI or affecting performance.

- **Creating a Worker**:
  ```javascript
  const worker = new Worker('worker.js'); // worker.js is the script file

  worker.onmessage = function(event) {
    console.log('Message from worker:', event.data);
  };

  worker.postMessage('Hello, worker!');
  ```

In `worker.js`:
```javascript
self.onmessage = function(event) {
  console.log('Message from main thread:', event.data);
  self.postMessage('Hello from worker!');
};
```

Web Workers are useful for offloading CPU-intensive tasks and keeping the user interface responsive.

---

### 62. **How do you compare two objects in JavaScript?**

In JavaScript, objects are compared by reference, not by value. To compare objects by their values, you need to compare their properties individually.

- **Shallow comparison**: Compare the properties of two objects.
  ```javascript
  function shallowEqual(obj1, obj2) {
    return JSON.stringify(obj1) === JSON.stringify(obj2);
  }

  const obj1 = { name: "Alice", age: 25 };
  const obj2 = { name: "Alice", age: 25 };

  console.log(shallowEqual(obj1, obj2)); // true
  ```

- **Deep comparison**: You can implement or use libraries for deep comparison, which compares nested objects or arrays.
  ```javascript
  function deepEqual(a, b) {
    if (typeof a !== 'object' || typeof b !== 'object' || a === null || b === null) {
      return a === b;
    }

    const keysA = Object.keys(a);
    const keysB = Object.keys(b);

    if (keysA.length !== keysB.length) return false;

    for (let key of keysA) {
      if (!keysB.includes(key) || !deepEqual(a[key], b[key])) {
        return false;
      }
    }

    return true;
  }
  ```

---

### 63. **What is the DOM in JavaScript and how do you interact with it?**

The **DOM (Document Object Model)** is a programming interface for web documents, allowing JavaScript to interact with the HTML and XML structures of a page. The DOM represents the page as a tree of nodes, where each node is an object representing part of the page (such as an element, attribute, or text).

- **Accessing DOM elements**:
  ```javascript
  const element = document.getElementById('myElement');
  const elements = document.querySelectorAll('.myClass');
  ```

- **Modifying the DOM**:
  ```javascript
  const div = document.createElement('div');
  div.textContent = 'Hello World';
  document.body.appendChild(div); // Adds div to the body
  ```

- **Event handling**:
  ```javascript
  const button = document.getElementById('myButton');
  button.addEventListener('click', function() {
    alert('Button clicked!');
  });
  ```

The DOM allows dynamic interaction with the webpage, such as modifying content, handling user input, or controlling animation.

---

### 64. **What are the differences between a function expression and a function declaration?**

- **Function Declaration**:
  ```javascript
  function greet() {
    console.log("Hello");
  }
  ```

  - Can be called before it's defined (due to hoisting).
  - Has function scope.

- **Function Expression**:
  ```javascript
  const greet = function() {
    console.log("Hello");
  };
  ```

  - Cannot be called before it's defined.
  - Is treated as an expression and can be anonymous.

In summary, **function declarations** are hoisted and can be called before their declaration, while **function expressions** are not hoisted and must be defined before usage.

---

### 65. **What is the difference between `slice()` and `splice()` methods in JavaScript?**

- **`slice()`**: Creates a shallow copy of a portion of an array and returns a new array without modifying the original array.
  ```javascript
  const arr = [1, 2, 3, 4, 5];
  const newArr = arr.slice(1, 4); // [2, 3, 4]
  ```

- **`splice()`**: Changes the original array by adding/removing elements at a specified index.
  ```javascript
  const arr = [1, 2, 3, 4, 5];
  arr.splice(2, 2, 'a', 'b'); // Removes 3 and 4, and adds 'a', 'b'
  console.log(arr); // [1, 2, 'a', 'b', 5]
  ```

---

### 66. **What is the use of the `map()` method in JavaScript?**

The `map()` method creates a new array by applying a provided function to every element in the original array. It does not modify the original array.

Example:
```javascript
const arr = [1, 2, 3];
const newArr = arr.map(x => x * 2);
console.log(newArr); // [2, 4, 6]
```

---

### 67. **What are `map()`, `reduce()`, and `filter()` functions in JavaScript?**

- **`map()`**: Creates a new array with the results of calling a provided function on every element.
  ```javascript
  const arr = [1, 2, 3];
  const newArr = arr.map(x => x * 2); // [2, 4, 6]
  ```

- **`reduce()`**: Reduces an array to a single value by applying a function to each element (accumulator pattern).
  ```javascript
  const arr = [1, 2, 3];
  const sum = arr.reduce((acc, curr) => acc + curr, 0); // 6
  ```

- **`filter()`**: Creates a new array with elements that pass the provided test.
  ```javascript
  const arr = [1, 2, 3, 4, 5];
  const evenArr = arr.filter(x => x % 2 === 0); // [2, 4]
  ```

---

### 68. **What is the `Promise.all()` method used for?**

`Promise.all()` is used to execute multiple asynchronous operations concurrently and returns a promise that resolves when all the promises in the array have resolved or rejects if any promise is rejected.

Example:
```javascript
const promise1 = Promise.resolve(1);
const promise2 = Promise.resolve(2);

Promise.all([promise1, promise2]).then(values => {
  console.log(values); // [1, 2]
});
```

---

### 69. **What is the `finally()` method in JavaScript promises?**

The `finally()` method allows you to specify a block of code that will be executed after a promise settles (either resolved or rejected), regardless of the outcome.

Example:
```javascript
const promise = new

 Promise((resolve, reject) => {
  resolve('Success');
});

promise
  .then(result => {
    console.log(result); // Success
  })
  .finally(() => {
    console.log('Clean-up code runs');
  });
```

## Advanced JavaScript Concepts
### 70. **What is the concept of currying in JavaScript? Can you provide an example?**

**Currying** is a technique in functional programming where a function that takes multiple arguments is transformed into a sequence of functions, each taking one argument.

In simpler terms, currying allows you to break a function that takes multiple parameters into a series of functions that each take one parameter and return a new function until all parameters are provided.

**Example:**

```javascript
function multiply(a) {
  return function(b) {
    return a * b;
  };
}

const multiplyBy2 = multiply(2);
console.log(multiplyBy2(3)); // 6
```

Here, `multiply` is a curried function that first takes `a`, then returns a new function that takes `b` and performs the multiplication.

---

### 71. **What is the concept of memoization in JavaScript?**

**Memoization** is an optimization technique where the results of expensive function calls are cached, and when the same inputs occur again, the cached result is returned instead of recalculating it. This can greatly improve performance for functions that are called repeatedly with the same arguments.

**Example:**

```javascript
function memoize(fn) {
  const cache = {};
  return function(arg) {
    if (cache[arg]) {
      return cache[arg];
    }
    const result = fn(arg);
    cache[arg] = result;
    return result;
  };
}

const square = memoize(function(n) {
  console.log('Calculating...');
  return n * n;
});

console.log(square(4)); // Calculating... 16
console.log(square(4)); // 16 (cached)
```

Here, the `memoize` function caches results, so the second time `square(4)` is called, it returns the cached result without recalculating.

---

### 72. **What are decorators in JavaScript?**

**Decorators** are a special kind of declaration that can be used to modify the behavior of a class, method, accessor, property, or parameter in JavaScript. They are usually used in frameworks like TypeScript, Angular, or Babel, as part of the class syntax.

Decorators are functions that are applied to a class or method and can be used to add additional behavior or modify how things work.

**Example (in TypeScript):**

```typescript
function log(target: any, key: string) {
  console.log(`Method ${key} is called`);
}

class MyClass {
  @log
  sayHello() {
    console.log("Hello!");
  }
}

const obj = new MyClass();
obj.sayHello();
```

In the above example, the `@log` decorator is applied to the `sayHello` method, which will log every time the method is invoked.

---

### 73. **What is the purpose of `WeakMap` and `WeakSet` in JavaScript?**

- **`WeakMap`** is a collection of key-value pairs, where the keys are objects, and the values can be any arbitrary data type. The key objects are weakly held, meaning if there are no other references to a key, it will be garbage collected, preventing memory leaks.

**Use case**: Storing metadata associated with objects without preventing them from being garbage-collected.

**Example:**

```javascript
let obj = {};
let weakMap = new WeakMap();
weakMap.set(obj, 'value');
console.log(weakMap.get(obj)); // 'value'
```

- **`WeakSet`** is similar to `WeakMap` but only stores objects (no key-value pairs), and like `WeakMap`, its elements are weakly referenced.

**Use case**: Storing unique objects without preventing them from being garbage collected.

**Example:**

```javascript
let obj = {};
let weakSet = new WeakSet();
weakSet.add(obj);
console.log(weakSet.has(obj)); // true
```

Both `WeakMap` and `WeakSet` help manage memory more efficiently by not preventing garbage collection of objects.

---

### 74. **What are closures in JavaScript, and why are they important?**

A **closure** is a function that retains access to its lexical scope, even when the function is executed outside of that scope. In other words, closures allow a function to "remember" its environment.

Closures are important for:
- **Data encapsulation**: Protecting data from being directly accessed or modified by the outside code.
- **Function factories**: Generating functions dynamically with specific states.
  
**Example:**

```javascript
function outer() {
  let count = 0;
  return function inner() {
    count++;
    console.log(count);
  };
}

const increment = outer();
increment(); // 1
increment(); // 2
```

Here, `inner` has access to `count` even after `outer` has finished execution, demonstrating closure.

---

### 75. **How does JavaScript handle memory management and garbage collection?**

JavaScript automatically manages memory through **garbage collection**, which means it automatically frees up memory when objects are no longer in use. The garbage collector identifies and removes unreachable objects (those that are no longer referenced in the code) to avoid memory leaks.

- **Mark-and-sweep algorithm**: JavaScript uses the "mark-and-sweep" garbage collection algorithm. It first marks all the objects that are reachable (directly or indirectly) from the root (global scope or variables). Then, it sweeps through and deletes the unmarked objects.

**Example:**
```javascript
let obj = { name: "John" };
obj = null; // The object is now eligible for garbage collection since no references exist.
```

JavaScript's garbage collector handles this process automatically, ensuring efficient memory usage.

---

### 76. **Explain the concept of prototype inheritance in JavaScript.**

In JavaScript, every object has a prototype, which is another object from which it inherits properties and methods. This is known as **prototype inheritance**. If you try to access a property or method on an object, and it’s not found, JavaScript will look for it in the object's prototype.

This allows objects to share common functionality without having to duplicate code.

**Example:**

```javascript
function Animal(name) {
  this.name = name;
}

Animal.prototype.speak = function() {
  console.log(this.name + ' makes a noise.');
};

const dog = new Animal('Dog');
dog.speak(); // Dog makes a noise.
```

Here, the `dog` object inherits the `speak` method from `Animal.prototype`.

---

### 77. **What are the different methods of creating objects in JavaScript?**

In JavaScript, objects can be created in various ways:

1. **Object literal syntax**:
   ```javascript
   const obj = { name: 'John', age: 30 };
   ```

2. **Using a constructor function**:
   ```javascript
   function Person(name, age) {
     this.name = name;
     this.age = age;
   }
   const person1 = new Person('Alice', 25);
   ```

3. **Using `Object.create()`**:
   ```javascript
   const obj = Object.create(null); // Creates an object with no prototype
   ```

4. **Using `class` (ES6)**:
   ```javascript
   class Car {
     constructor(make, model) {
       this.make = make;
       this.model = model;
     }
   }
   const myCar = new Car('Toyota', 'Corolla');
   ```

---

### 78. **What is the difference between `Object.create()` and class-based inheritance?**

- **`Object.create()`**:
  - Creates a new object, optionally inheriting from another object.
  - Allows for more flexible and dynamic inheritance.
  - You can create an object with a custom prototype, but it does not involve constructors or class syntax.

**Example:**

```javascript
const person = { name: 'John' };
const student = Object.create(person);
student.age = 20;
console.log(student.name); // 'John' (inherited from person)
```

- **Class-based inheritance**:
  - Introduced in ES6, it provides a clearer and more structured way to create objects and handle inheritance using `class` and `extends`.
  - It involves constructors, methods, and inheritance using `extends`.

**Example:**

```javascript
class Person {
  constructor(name) {
    this.name = name;
  }
}

class Student extends Person {
  constructor(name, age) {
    super(name);
    this.age = age;
  }
}

const student = new Student('Alice', 20);
console.log(student.name); // 'Alice'
```

In summary, `Object.create()` is more flexible and used for direct prototype-based inheritance, while class-based inheritance offers a more structured and syntactic approach to creating objects and managing inheritance.

### 79. **How does JavaScript's event loop handle promises and callbacks?**

JavaScript uses an **event loop** to manage asynchronous operations such as promises and callbacks. The event loop works in conjunction with the **call stack** and the **message queue** (or task queue):

- **Callbacks** are pushed to the call stack directly after their event is triggered (like an `onclick` event).
- **Promises** and their `.then()` or `.catch()` handlers are not executed immediately. They are placed in a **microtask queue** (or job queue). The event loop prioritizes the microtask queue before moving to the next event in the regular message queue (such as `setTimeout`).

**Order of execution**:
1. The call stack executes synchronous code.
2. Promises' `.then()` or `.catch()` handlers are executed after the synchronous code, from the microtask queue.
3. Once the microtask queue is cleared, the event loop will process the message queue, which includes tasks like callbacks from `setTimeout`, event listeners, etc.

**Example**:

```javascript
console.log('Start');

setTimeout(() => {
  console.log('setTimeout');
}, 0);

Promise.resolve().then(() => {
  console.log('Promise');
});

console.log('End');
```

**Output**:

```
Start
End
Promise
setTimeout
```

- `Promise` is processed first because it is in the microtask queue, even though it was created after `setTimeout`.

---

### 80. **What are `async` and `await` used for in JavaScript?**

**`async`** and **`await`** are used to handle asynchronous operations more easily and readably, making asynchronous code look and behave like synchronous code.

- **`async`**: A function declared with `async` always returns a promise. If the function returns a value, that value is wrapped in a promise. If it throws an error, the promise is rejected.
- **`await`**: Can only be used inside an `async` function. It pauses the execution of the `async` function and waits for the promise to resolve or reject before continuing.

**Example**:

```javascript
async function fetchData() {
  let data = await fetch('https://api.example.com');
  let jsonData = await data.json();
  console.log(jsonData);
}

fetchData();
```

This makes asynchronous code easier to write and read, avoiding callback hell and promise chains.

---

### 81. **How does JavaScript handle multiple callback functions?**

JavaScript handles multiple callback functions by adding them to the **call stack** sequentially. When an asynchronous event occurs, callbacks are added to the event queue, and the event loop processes them one at a time.

In case of **nested callbacks**, JavaScript will add each function to the call stack in the order they are invoked. However, callbacks can be executed in parallel in asynchronous functions like `setTimeout` or with promises.

**Example with `setTimeout`:**

```javascript
setTimeout(() => console.log('First'), 1000);
setTimeout(() => console.log('Second'), 500);

console.log('Third');
```

**Output**:

```
Third
Second
First
```

The event loop handles `setTimeout` and logs `Second` after 500ms, followed by `First` after 1000ms.

---

### 82. **What is the significance of `requestAnimationFrame()` in JavaScript?**

**`requestAnimationFrame()`** is used for creating smooth animations in the browser. It tells the browser to call a specified function before the next repaint, which is typically around 60 frames per second (fps). Using `requestAnimationFrame()` helps improve performance and ensures that animations are synchronized with the display refresh rate.

It is more efficient than using `setTimeout` or `setInterval`, as it allows the browser to optimize the frame rate and avoid unnecessary repaints.

**Example**:

```javascript
function animate() {
  // Update animation logic
  console.log("Animating...");
  requestAnimationFrame(animate);
}

requestAnimationFrame(animate);
```

This continuously animates by calling the `animate` function before each repaint.

---

### 83. **How can you optimize performance in JavaScript?**

Performance optimization in JavaScript can be achieved in several ways:

1. **Avoid memory leaks**: Use tools like Chrome DevTools to identify memory leaks.
2. **Minimize DOM manipulation**: Batch DOM changes and avoid reflow/repaint.
3. **Use event delegation**: Instead of adding event listeners to many elements, delegate events to a parent element.
4. **Debouncing and throttling**: Limit the frequency of function executions (e.g., for scroll or resize events).
5. **Lazy loading**: Load resources only when they are needed, such as images or scripts.
6. **Use Web Workers**: Offload intensive computations to background threads.
7. **Minify code**: Minify and compress JavaScript files to reduce file size and loading time.
8. **Leverage caching**: Cache static assets and data to reduce redundant network requests.
9. **Use `requestAnimationFrame`** for animations instead of `setTimeout`.

---

### 84. **What is the `Function.prototype.bind()` method in JavaScript?**

**`bind()`** creates a new function that, when called, has its `this` value set to the specified context, and any initial arguments passed to `bind()` are pre-set.

**Use case**: Changing the context of a function while preserving its original behavior.

**Example**:

```javascript
const person = {
  name: 'John',
  greet() {
    console.log('Hello, ' + this.name);
  }
};

const greetJohn = person.greet.bind(person);
greetJohn(); // 'Hello, John'
```

Here, `bind()` ensures that the `this` inside `greetJohn` refers to the `person` object.

---

### 85. **What is the difference between `localStorage` and `cookies` in JavaScript?**

- **`localStorage`**:
  - Stores data on the client-side with no expiration time.
  - Data persists even after the browser is closed and reopened.
  - Can store up to 5-10 MB of data.
  - Data is only accessible from the same origin.
  - Syntax: `localStorage.setItem('key', 'value')`.

- **Cookies**:
  - Store small pieces of data (max 4KB).
  - Can have an expiration date.
  - Sent with every HTTP request to the server, making them slower than `localStorage`.
  - Often used for session management or storing user preferences.
  - Syntax: `document.cookie = "key=value; expires=date; path=/"`.

---

### 86. **What is a pure function in JavaScript? Can you give an example?**

A **pure function** is a function that:
1. Always produces the same output for the same input.
2. Has no side effects (it does not modify external state).

**Example**:

```javascript
function add(a, b) {
  return a + b; // Always returns the same result for the same inputs
}
```

Here, the `add()` function is pure because it always returns the same result and does not modify any external variables.

---

### 87. **How do you handle CORS (Cross-Origin Resource Sharing) in JavaScript?**

**CORS** is a security feature that restricts web pages from making requests to a domain other than the one from which the page was served. To handle CORS in JavaScript, you must configure the server to allow cross-origin requests.

- **On the server-side**: Add appropriate CORS headers, like `Access-Control-Allow-Origin`, to the HTTP response.
  
- **In the browser**: If you are making a request from the client, you can set the `mode` of the request to `'cors'` or `'no-cors'` depending on the scenario.

**Example (fetch with CORS):**

```javascript
fetch('https://api.example.com/data', {
  method: 'GET',
  headers: {
    'Content-Type': 'application/json'
  },
  mode: 'cors'
})
.then(response => response.json())
.then(data => console.log(data))
.catch(error => console.error('Error:', error));
```

### 88. **How can you implement inheritance in JavaScript without using classes?**

In JavaScript, inheritance can be implemented using **prototypes**. You can create an object and link it to another object’s prototype to inherit its properties and methods.

**Example**:

```javascript
function Animal(name) {
  this.name = name;
}

Animal.prototype.speak = function() {
  console.log(this.name + ' makes a sound');
};

function Dog(name) {
  Animal.call(this, name); // Inherit properties
}

Dog.prototype = Object.create(Animal.prototype); // Inherit methods
Dog.prototype.constructor = Dog; // Set correct constructor

const dog = new Dog('Rex');
dog.speak(); // Rex makes a sound
```

Here, `Dog` inherits from `Animal` by using `Object.create()` to set `Dog`'s prototype to `Animal.prototype`.

---

### 89. **What is the difference between synchronous and asynchronous code in JavaScript?**

- **Synchronous code**: Executes line by line. Each operation waits for the previous one to finish before continuing, blocking further code execution.

  **Example**:
  
  ```javascript
  console.log('Start');
  console.log('End');
  ```

  Both `console.log()` statements are executed one after the other.

- **Asynchronous code**: Allows operations to run in the background without blocking the main execution thread. It continues executing other code while waiting for the asynchronous operation (like fetching data, setTimeout) to complete.

  **Example**:

  ```javascript
  console.log('Start');
  setTimeout(() => {
    console.log('Middle');
  }, 1000);
  console.log('End');
  ```

  Output: 
  ```
  Start
  End
  Middle
  ```

  Here, `setTimeout` runs asynchronously, and the `console.log('End')` statement executes before the `setTimeout` callback.

---

### 90. **What is the `debugger` keyword in JavaScript?**

The `debugger` keyword is used to pause the execution of JavaScript code at a specific point, allowing you to inspect variables and the call stack. It acts like a breakpoint in the code. When the `debugger` statement is encountered, the browser’s developer tools open, and execution is paused.

**Example**:

```javascript
function testDebugger() {
  let x = 10;
  debugger; // Code will pause here
  console.log(x);
}

testDebugger();
```

When the code hits the `debugger` statement, the execution stops, and you can inspect `x` and other parts of the code in the developer tools.

---

### 91. **How does JavaScript handle errors in a try/catch block?**

In JavaScript, errors can be caught and handled using the `try...catch` block. The `try` block contains the code that may throw an error, while the `catch` block handles the error.

**Example**:

```javascript
try {
  let result = riskyFunction();
  console.log(result);
} catch (error) {
  console.error('An error occurred:', error.message);
}
```

- If an error occurs inside the `try` block, JavaScript jumps to the `catch` block.
- The `catch` block receives the error object, which contains details about the error (e.g., message, stack trace).

You can also use `finally`, which will always run regardless of whether an error occurred:

```javascript
try {
  let result = riskyFunction();
} catch (error) {
  console.error('Error:', error);
} finally {
  console.log('This will run no matter what');
}
```

---

### 92. **What are JavaScript frameworks, and how do they differ from libraries?**

- **JavaScript frameworks**: A framework is a collection of prewritten code that provides a structure for building applications. It usually dictates the structure of your code and is opinionated about how things should be done. Frameworks provide a lot of functionality out of the box and are generally used to build large-scale applications (e.g., **Angular**, **Vue.js**, **React**).

  **Example**: Angular is a framework because it provides structure, conventions, and tools for building applications.

- **JavaScript libraries**: A library is a collection of functions and utilities that you can use to perform specific tasks (e.g., manipulating the DOM, making AJAX requests). Libraries are not opinionated, meaning they allow you to structure your application as you choose (e.g., **Lodash**, **jQuery**).

  **Example**: Lodash is a library because it provides utility functions, but it doesn't dictate how your app should be structured.

---

### 93. **What is the `bind()` method used for in JavaScript?**

The **`bind()`** method creates a new function that, when called, has its `this` value set to the specified context (object), and any provided arguments are pre-set (partial application).

**Example**:

```javascript
const person = {
  name: 'Alice',
  greet() {
    console.log('Hello, ' + this.name);
  }
};

const greetAlice = person.greet.bind(person);
greetAlice(); // Hello, Alice
```

Here, `greetAlice` is bound to the `person` object, so `this` inside the `greet()` method refers to `person`.

---

### 94. **What are service workers in JavaScript, and how do they work?**

**Service workers** are a type of web worker that runs in the background, separate from the web page, enabling features like caching, push notifications, and background synchronization. They allow for offline-first web experiences and can intercept network requests, enabling you to cache resources or serve content while offline.

**How they work**:
1. **Registration**: The service worker is registered in the browser via `navigator.serviceWorker.register()`.
2. **Installation**: After registration, the service worker goes through the installation phase, where it caches resources.
3. **Activation**: Once installed, it activates and begins intercepting network requests, allowing caching or returning responses from the cache.
4. **Fetching**: The service worker intercepts network requests and serves cached data, allowing for offline functionality.

**Example**:

```javascript
if ('serviceWorker' in navigator) {
  navigator.serviceWorker.register('/service-worker.js').then(function(registration) {
    console.log('Service Worker registered with scope:', registration.scope);
  }).catch(function(error) {
    console.log('Service Worker registration failed:', error);
  });
}
```

Service workers enable powerful features like offline support, caching strategies, and background tasks for modern web applications.

---

### 95. **What are `Object.assign()` and its uses?**

**`Object.assign()`** is a method used to copy values from one or more source objects to a target object. It is typically used to clone objects or merge multiple objects.

**Syntax**:
```javascript
Object.assign(target, ...sources);
```

- **Target**: The object that will receive the properties.
- **Sources**: The objects whose properties will be copied to the target.

**Example**:

```javascript
const obj1 = { a: 1, b: 2 };
const obj2 = { c: 3, d: 4 };

const mergedObj = Object.assign({}, obj1, obj2);
console.log(mergedObj); // { a: 1, b: 2, c: 3, d: 4 }
```

- It **shallow copies** properties, meaning that if the properties are objects, the references are copied, not the values.
- It’s useful for merging objects, copying properties, or creating a shallow clone of an object.


### 96. **What is a `Map` and `Set` in JavaScript?**

- **Map**:
  A `Map` is a collection of key-value pairs where both keys and values can be any type of data (objects, functions, etc.). The keys in a `Map` are ordered, and you can iterate over them in insertion order. It maintains the order of the inserted keys.

  **Example**:

  ```javascript
  const map = new Map();
  map.set('name', 'John');
  map.set(1, 'one');
  map.set(true, 'yes');
  
  console.log(map.get('name'));  // 'John'
  console.log(map.size);         // 3
  ```

- **Set**:
  A `Set` is a collection of unique values. It stores values without duplicates, and the values in a `Set` are ordered. It can store any type of data and doesn’t allow duplicate entries.

  **Example**:

  ```javascript
  const set = new Set();
  set.add(1);
  set.add(2);
  set.add(2);  // Duplicate value, won't be added
  
  console.log(set);  // Set { 1, 2 }
  console.log(set.has(1));  // true
  console.log(set.size);    // 2
  ```

---

### 97. **What is the difference between shallow copy and deep copy in JavaScript?**

- **Shallow Copy**:
  A shallow copy means creating a new object, but nested objects or arrays within it are still referenced (not copied). It only copies the top-level properties.

  **Example**:

  ```javascript
  const obj1 = { a: 1, b: { c: 2 } };
  const shallowCopy = { ...obj1 };
  
  shallowCopy.b.c = 3;  // Modifying nested object
  console.log(obj1.b.c);  // 3, both obj1 and shallowCopy share the same reference to b
  ```

- **Deep Copy**:
  A deep copy means creating a completely independent copy of the original object, including all nested objects. It ensures that no references are shared between the copied object and the original.

  **Example**:

  ```javascript
  const obj1 = { a: 1, b: { c: 2 } };
  const deepCopy = JSON.parse(JSON.stringify(obj1));  // Simple deep copy method
  
  deepCopy.b.c = 3;
  console.log(obj1.b.c);  // 2, obj1 and deepCopy are independent
  ```

---

### 98. **What is functional programming in JavaScript? How is it different from object-oriented programming?**

- **Functional Programming**:
  Functional programming (FP) is a programming paradigm where you treat computation as the evaluation of mathematical functions and avoid changing state and mutable data. It focuses on immutability, higher-order functions, pure functions, and declarative code.

  **Features of FP**:
  - **Pure functions**: Functions that always return the same output for the same input and have no side effects.
  - **Immutability**: Data is not modified, but instead, new data is returned.
  - **First-class functions**: Functions can be passed as arguments and returned as values.
  - **Higher-order functions**: Functions that take other functions as arguments or return functions.

  **Example**:

  ```javascript
  const add = (a, b) => a + b;
  const multiply = (a, b) => a * b;

  const result = multiply(add(2, 3), 4);  // Using FP
  ```

- **Object-Oriented Programming (OOP)**:
  OOP is based on objects and classes. It focuses on data and methods that operate on that data, organizing code around objects that represent real-world entities.

  **Features of OOP**:
  - **Classes and objects**: Encapsulating data and behavior into objects.
  - **Inheritance**: Allowing classes to inherit properties and methods from other classes.
  - **Encapsulation**: Hiding the internal state and requiring all interaction to be done through methods.
  - **Polymorphism**: Allowing objects of different classes to be treated as objects of a common superclass.

  **Example**:

  ```javascript
  class Animal {
    constructor(name) {
      this.name = name;
    }
    speak() {
      console.log(this.name + ' makes a sound');
    }
  }

  const dog = new Animal('Rex');
  dog.speak();
  ```

**Key Differences**:
- **OOP** is about organizing code into objects and their interactions, while **FP** is about using pure functions and avoiding shared state.
- OOP typically uses mutable state, while FP emphasizes immutability.

---

### 99. **What is an abstract class in JavaScript?**

JavaScript does not have built-in support for **abstract classes** in the same way that languages like Java or C# do. However, you can simulate abstract classes by creating a class with methods that are not implemented, and then using subclasses to implement those methods.

**Example**:

```javascript
class Animal {
  constructor(name) {
    if (this.constructor === Animal) {
      throw new Error("Abstract class cannot be instantiated.");
    }
    this.name = name;
  }

  speak() {
    throw new Error("Method 'speak()' must be implemented.");
  }
}

class Dog extends Animal {
  speak() {
    console.log(`${this.name} barks`);
  }
}

const dog = new Dog('Rex');
dog.speak();  // Rex barks

// const animal = new Animal('Generic');  // Error: Abstract class cannot be instantiated.
```

Here, `Animal` is treated as an abstract class by throwing an error if you try to instantiate it directly. Subclasses like `Dog` implement the abstract `speak()` method.

---

### 100. **How do you use JavaScript for manipulating the DOM?**

JavaScript allows you to interact with and manipulate the DOM (Document Object Model) to dynamically change the content and structure of a webpage. You can use various DOM methods to access elements and modify their properties, styles, or events.

- **Selecting elements**:
  You can select elements using methods like `getElementById()`, `querySelector()`, and `querySelectorAll()`.

  **Example**:

  ```javascript
  const element = document.getElementById('myElement');
  const allItems = document.querySelectorAll('.items');
  ```

- **Changing content**:
  You can modify the text or HTML content of an element using `textContent` or `innerHTML`.

  **Example**:

  ```javascript
  element.textContent = 'New Content';
  ```

- **Modifying attributes**:
  Use methods like `setAttribute()` to change element attributes.

  **Example**:

  ```javascript
  element.setAttribute('src', 'newImage.jpg');
  ```

- **Adding/removing classes**:
  Use `classList` to add, remove, or toggle CSS classes.

  **Example**:

  ```javascript
  element.classList.add('active');
  element.classList.remove('inactive');
  element.classList.toggle('highlight');
  ```

- **Creating and appending elements**:
  You can create new elements and append them to the DOM.

  **Example**:

  ```javascript
  const newElement = document.createElement('div');
  newElement.textContent = 'Hello, World!';
  document.body.appendChild(newElement);
  ```

- **Handling events**:
  You can attach event listeners to elements using `addEventListener()`.

  **Example**:

  ```javascript
  element.addEventListener('click', () => {
    alert('Element clicked!');
  });
  ```
