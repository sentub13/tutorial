# JavaScript Interview Questions & Answers

## All 40 Interview Questions

1. What are JavaScript coercion rules? (Implicit vs Explicit)
2. What are the differences between let, var, and const? (Including TDZ, Reference Error, Hoisting)
3. What is hoisting in JavaScript?
4. What are primitive vs non-primitive data types?
5. How does async execution work? (Event Loop, Microtask Queue, Macrotask Queue)
6. What are closures?
7. What is currying? (Normal & Infinite)
8. What is an IIFE? (Immediately Invoked Function Expression)
9. What are the differences between normal and arrow functions?
10. How does the this keyword work?
11. What are prototypes and prototypal inheritance?
12. How do map, reduce, filter, and forEach work?
13. What are the differences between for...of vs for...in?
14. What is callback hell and how do callbacks differ from Higher-Order Functions?
15. How do Promises work? (Including .then, .catch, and static methods like Promise.all, Promise.allSettled, Promise.race, Promise.any)
16. What are bubbling, capturing, and event delegation?
17. What are the differences between Local Storage, Session Storage, and Cookies?
18. What is strict mode?
19. What are Web Workers?
20. How do call, apply, and bind work?
21. What is the difference between shallow and deep copy?
22. What are Object.freeze and Object.seal?
23. What are debouncing and throttling?
24. What are SOLID principles?
25. What are common design patterns? (Factory, Singleton, Observer)
26. What are important Array, String, and Object methods?
27. What is the nullish coalescing operator (??)?
28. What is the difference between null and undefined?
29. What are the different ways to write async code?
30. What is the difference between Promise and async-await?
31. What is the difference between DOM and BOM?
32. How do setTimeout and setInterval work?
33. What are generators and iterators?
34. How to increase JavaScript performance?
35. What are the new ES6 features?
36. How do class, constructor, and super work?
37. What are the differences between Fetch and Axios?
38. What is the difference between REST API and GraphQL?
39. What is the difference between Functional Programming and Object-Oriented Programming?
40. What are the main OOP concepts? (Class, Object, Encapsulation, Inheritance, Polymorphism, Abstraction)

---

## Detailed Answers (Questions 1-5)

### 1. What are JavaScript coercion rules? (Implicit vs Explicit)

**Answer:** JavaScript coercion is type conversion that happens automatically or manually. Implicit coercion happens behind the scenes, explicit coercion is when we manually convert types.

**Example:**
```javascript
// Implicit coercion
console.log("5" + 3); // "53" - number becomes string
console.log("5" - 3); // 2 - string becomes number
console.log(true + 1); // 2 - boolean becomes number

// Explicit coercion
console.log(Number("5")); // 5
console.log(String(123)); // "123"
console.log(Boolean(0)); // false
```

The key rule: JavaScript tries to convert values to make operations work. Addition with strings concatenates, other math operations convert to numbers.

### 2. What are the differences between let, var, and const? (Including TDZ, Reference Error, Hoisting)

**Answer:** These are three ways to declare variables with different scoping and behavior rules.

**Key differences:**
- `var`: Function-scoped, hoisted, can be redeclared
- `let`: Block-scoped, hoisted but in TDZ, cannot be redeclared
- `const`: Block-scoped, hoisted but in TDZ, cannot be reassigned or redeclared

**Example:**
```javascript
// var - function scoped
function example() {
  if (true) {
    var x = 1;
  }
  console.log(x); // 1 - accessible outside block
}

// let - block scoped
function example2() {
  if (true) {
    let y = 1;
  }
  console.log(y); // ReferenceError - not accessible
}

// const - cannot reassign
const z = 1;
z = 2; // TypeError

// TDZ (Temporal Dead Zone)
console.log(a); // undefined (var hoisting)
console.log(b); // ReferenceError (let in TDZ)
var a = 1;
let b = 2;
```

### 3. What is hoisting in JavaScript?

**Answer:** Hoisting means variable and function declarations are moved to the top of their scope during compilation. The declarations are hoisted, but not the assignments.

**Example:**
```javascript
// What you write:
console.log(x); // undefined (not error)
var x = 5;
sayHello(); // "Hello!" (works)

function sayHello() {
  console.log("Hello!");
}

// How JavaScript sees it:
var x; // hoisted declaration
function sayHello() { // function hoisted completely
  console.log("Hello!");
}
console.log(x); // undefined
x = 5; // assignment stays in place

// let/const are hoisted but in TDZ
console.log(y); // ReferenceError
let y = 10;
```

### 4. What are primitive vs non-primitive data types?

**Answer:** Primitives are basic data types stored by value. Non-primitives are objects stored by reference.

**Primitives (7 types):**
- string, number, boolean, undefined, null, symbol, bigint

**Non-primitives:**
- Objects (including arrays, functions, dates)

**Example:**
```javascript
// Primitives - stored by value
let a = 5;
let b = a;
b = 10;
console.log(a); // 5 (unchanged)

// Non-primitives - stored by reference
let obj1 = { name: "John" };
let obj2 = obj1;
obj2.name = "Jane";
console.log(obj1.name); // "Jane" (changed!)

// Checking types
console.log(typeof 42); // "number"
console.log(typeof "hello"); // "string"
console.log(typeof {}); // "object"
console.log(typeof []); // "object"
console.log(Array.isArray([])); // true
```

### 5. How does async execution work? (Event Loop, Microtask Queue, Macrotask Queue)

**Answer:** JavaScript is single-threaded but handles async operations through the event loop, which manages different queues for different types of tasks.

**Key components:**
- **Call Stack**: Where code executes
- **Microtask Queue**: Promises, queueMicrotask (higher priority)
- **Macrotask Queue**: setTimeout, setInterval, DOM events (lower priority)
- **Event Loop**: Moves tasks from queues to call stack

**Example:**
```javascript
console.log("1"); // Synchronous

setTimeout(() => console.log("2"), 0); // Macrotask

Promise.resolve().then(() => console.log("3")); // Microtask

console.log("4"); // Synchronous

// Output: 1, 4, 3, 2
// Explanation:
// 1. Sync code runs first (1, 4)
// 2. Microtasks run next (3)
// 3. Macrotasks run last (2)
```

The event loop prioritizes: Call Stack → Microtasks → Macrotasks. This is why promises resolve before setTimeout, even with 0 delay.