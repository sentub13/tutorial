# JavaScript Questions - Category-wise Organization

## 1. **Basic JavaScript Concepts** (Fundamentals)

### Data Types & Variables

#### What are the different data types in JavaScript?
JavaScript has **primitive** and **non-primitive** data types:
- **Primitive**: `string`, `number`, `bigint`, `boolean`, `undefined`, `symbol`, `null`
- **Non-primitive**: `object` (includes arrays, functions, objects)

```javascript
let str = "hello";        // string
let num = 42;             // number
let bool = true;          // boolean
let undef;                // undefined
let empty = null;         // null
let sym = Symbol('id');   // symbol
let obj = {name: 'John'}; // object
```

#### What is the difference between `var`, `let`, and `const`?
- **`var`**: Function-scoped, hoisted, can be redeclared
- **`let`**: Block-scoped, not hoisted, cannot be redeclared
- **`const`**: Block-scoped, not hoisted, cannot be reassigned

```javascript
var a = 1;    // Function scope
let b = 2;    // Block scope
const c = 3;  // Block scope, immutable
```

#### What is the `undefined` value in JavaScript?
`undefined` indicates a variable has been declared but not assigned a value.

```javascript
let x;
console.log(x); // undefined
```

#### What is the `null` value in JavaScript? How is it different from `undefined`?
- **`null`**: Intentional absence of value (explicitly assigned)
- **`undefined`**: Variable declared but not initialized

```javascript
let a = null;    // Explicitly no value
let b;           // Implicitly undefined
```

#### Explain the concept of "truthy" and "falsy" values in JavaScript
- **Falsy values**: `false`, `0`, `""`, `null`, `undefined`, `NaN`
- **Truthy values**: Everything else

```javascript
if (0) { /* won't run */ }
if ("hello") { /* will run */ }
```

#### What are the data types that are mutable in JavaScript?
Mutable types can be changed after creation:
- **Objects**, **Arrays**, **Functions**

```javascript
const obj = {name: 'John'};
obj.age = 25; // Mutable - can modify properties

const arr = [1, 2, 3];
arr.push(4); // Mutable - can modify elements
```

### Operators & Comparisons

#### What is the difference between `==` and `===` in JavaScript?
- **`==` (loose equality)**: Compares values after type coercion
- **`===` (strict equality)**: Compares values without type coercion (both value and type must match)

```javascript
5 == '5';   // true (string '5' converted to number)
5 === '5';  // false (different types: number vs string)

0 == false;   // true (false converted to 0)
0 === false;  // false (different types: number vs boolean)

null == undefined;   // true (special case)
null === undefined;  // false (different types)
```

### Hoisting & Scope

#### What is hoisting in JavaScript?
Hoisting moves variable and function declarations to the top of their scope during compilation.

```javascript
console.log(x); // undefined (not error)
var x = 5;

// Function declarations are fully hoisted
myFunc(); // Works
function myFunc() { console.log('Hello'); }

// let/const are hoisted but not initialized
console.log(y); // ReferenceError
let y = 10;
```

#### What is the difference between local scope and global scope in JavaScript?
- **Global scope**: Variables accessible throughout the entire program
- **Local scope**: Variables accessible only within the function/block where declared

```javascript
let globalVar = 'global'; // Global scope

function example() {
  let localVar = 'local'; // Local scope
  console.log(globalVar); // Accessible
}

console.log(localVar); // Error: not accessible
```

#### What is lexical scoping in JavaScript?
Lexical scoping means inner functions have access to variables in their outer scope.

```javascript
function outer() {
  let outerVar = 'outer';
  
  function inner() {
    console.log(outerVar); // Accessible due to lexical scoping
  }
  
  inner();
}
```

#### How does JavaScript handle scope and closures?
Closures allow functions to retain access to their lexical scope even after the outer function returns.

```javascript
function createCounter() {
  let count = 0;
  
  return function() {
    count++;
    return count;
  };
}

const counter = createCounter();
console.log(counter()); // 1
console.log(counter()); // 2
```

## 2. **Functions** (Function Concepts)

### Function Types & Declarations

#### What is a function in JavaScript? How do you declare one?
A function is a reusable block of code that performs a specific task. Functions can accept inputs (parameters) and return outputs.

```javascript
// Function declaration
function greet(name) {
  return `Hello, ${name}!`;
}

// Function expression
const add = function(a, b) {
  return a + b;
};

// Arrow function
const multiply = (a, b) => a * b;
```

#### What is the difference between function expressions and function declarations?
- **Function Declaration**: Hoisted, can be called before definition
- **Function Expression**: Not hoisted, must be defined before use

```javascript
// This works - function declaration is hoisted
sayHello(); // "Hello!"
function sayHello() {
  console.log("Hello!");
}

// This fails - function expression is not hoisted
sayBye(); // TypeError: sayBye is not a function
const sayBye = function() {
  console.log("Bye!");
};
```

#### What are arrow functions, and how do they differ from regular functions?
Arrow functions provide shorter syntax and lexically bind `this`.

```javascript
// Regular function
const obj1 = {
  name: 'John',
  greet: function() {
    console.log(this.name); // 'John'
  }
};

// Arrow function - inherits 'this' from surrounding context
const obj2 = {
  name: 'Jane',
  greet: () => {
    console.log(this.name); // undefined (no own 'this')
  }
};

// Shorter syntax
const square = x => x * x;
const add = (a, b) => a + b;
```

#### What is an IIFE (Immediately Invoked Function Expression)?
An IIFE is a function that executes immediately after creation, often used to create private scope.

```javascript
// IIFE with function expression
(function() {
  console.log('IIFE executed!');
})();

// IIFE with arrow function
(() => {
  let privateVar = 'hidden';
  console.log('Arrow IIFE!');
})();

// IIFE with parameters
((name) => {
  console.log(`Hello, ${name}!`);
})('World');
```

#### What is an anonymous function?
An anonymous function is a function without a name, often used as callbacks or in function expressions.

```javascript
// Anonymous function in array method
[1, 2, 3].map(function(x) {
  return x * 2;
});

// Anonymous arrow function
setTimeout(() => {
  console.log('Timer finished!');
}, 1000);

// Anonymous function assigned to variable
const myFunc = function() {
  console.log('Anonymous function');
};
```

### Function Features

#### What is the use of the `arguments` object in JavaScript?
The `arguments` object is an array-like object available in non-arrow functions that contains all arguments passed to the function.

```javascript
function sum() {
  let total = 0;
  for (let i = 0; i < arguments.length; i++) {
    total += arguments[i];
  }
  return total;
}

console.log(sum(1, 2, 3, 4)); // 10

// Modern alternative: rest parameters
function sumModern(...numbers) {
  return numbers.reduce((total, num) => total + num, 0);
}
```

#### What is the purpose of the `default` keyword in JavaScript functions?
Default parameters allow you to set default values for function parameters when no argument is provided.

```javascript
function greet(name = 'Guest', greeting = 'Hello') {
  return `${greeting}, ${name}!`;
}

console.log(greet()); // "Hello, Guest!"
console.log(greet('John')); // "Hello, John!"
console.log(greet('Jane', 'Hi')); // "Hi, Jane!"
```

#### How can you return multiple values from a function in JavaScript?
JavaScript functions can only return one value, but you can return multiple values using objects or arrays.

```javascript
// Using array destructuring
function getCoordinates() {
  return [10, 20];
}
const [x, y] = getCoordinates();

// Using object destructuring
function getPersonInfo() {
  return { name: 'John', age: 30, city: 'NYC' };
}
const { name, age } = getPersonInfo();

// Using array
function calculate(a, b) {
  return [a + b, a - b, a * b, a / b];
}
const [sum, diff, product, quotient] = calculate(10, 5);
```

#### What is recursion in JavaScript? Can you provide an example?
Recursion is when a function calls itself to solve a problem by breaking it into smaller subproblems.

```javascript
// Factorial example
function factorial(n) {
  if (n === 0 || n === 1) return 1; // Base case
  return n * factorial(n - 1); // Recursive case
}

console.log(factorial(5)); // 120

// Fibonacci example
function fibonacci(n) {
  if (n <= 1) return n;
  return fibonacci(n - 1) + fibonacci(n - 2);
}

console.log(fibonacci(6)); // 8
```

### Advanced Function Concepts

#### What are higher-order functions in JavaScript?
Higher-order functions are functions that either take other functions as arguments or return functions as results.

```javascript
// Function that takes another function as argument
function applyOperation(arr, operation) {
  return arr.map(operation);
}

const numbers = [1, 2, 3, 4];
const doubled = applyOperation(numbers, x => x * 2); // [2, 4, 6, 8]

// Function that returns another function
function createMultiplier(factor) {
  return function(number) {
    return number * factor;
  };
}

const double = createMultiplier(2);
console.log(double(5)); // 10
```

#### What is a callback function in JavaScript?
A callback function is a function passed as an argument to another function, executed after some operation completes.

```javascript
// Synchronous callback
function processData(data, callback) {
  const result = data.toUpperCase();
  callback(result);
}

processData('hello', function(result) {
  console.log(result); // "HELLO"
});

// Asynchronous callback
function fetchData(callback) {
  setTimeout(() => {
    callback('Data received');
  }, 1000);
}

fetchData(data => console.log(data)); // "Data received" after 1 second
```

#### What is a pure function in JavaScript? Can you give an example?
A pure function always returns the same output for the same input and has no side effects.

```javascript
// Pure function - always returns same result, no side effects
function add(a, b) {
  return a + b;
}

function multiply(x, y) {
  return x * y;
}

// Impure function - has side effects
let counter = 0;
function impureIncrement() {
  counter++; // Modifies external state
  return counter;
}

// Pure version
function pureIncrement(value) {
  return value + 1; // No side effects
}
```

#### What is the concept of currying in JavaScript?
Currying transforms a function that takes multiple arguments into a sequence of functions that each take one argument.

```javascript
// Regular function
function add(a, b, c) {
  return a + b + c;
}

// Curried version
function curriedAdd(a) {
  return function(b) {
    return function(c) {
      return a + b + c;
    };
  };
}

// Usage
const addFive = curriedAdd(5);
const addFiveAndThree = addFive(3);
console.log(addFiveAndThree(2)); // 10

// Arrow function currying
const multiply = a => b => c => a * b * c;
const multiplyByTwo = multiply(2);
console.log(multiplyByTwo(3)(4)); // 24
```

## 3. **Objects & Classes** (Object-Oriented Programming)

### Object Creation & Manipulation

#### What are the different ways to create objects in JavaScript?
There are several ways to create objects in JavaScript:

```javascript
// 1. Object literal
const obj1 = { name: 'John', age: 30 };

// 2. Using new Object()
const obj2 = new Object();
obj2.name = 'Jane';
obj2.age = 25;

// 3. Constructor function
function Person(name, age) {
  this.name = name;
  this.age = age;
}
const obj3 = new Person('Bob', 35);

// 4. Using Object.create()
const obj4 = Object.create(null);
obj4.name = 'Alice';

// 5. ES6 Class
class Car {
  constructor(make, model) {
    this.make = make;
    this.model = model;
  }
}
const obj5 = new Car('Toyota', 'Camry');
```

#### How can you clone an object in JavaScript?
Objects can be cloned using shallow or deep copy methods:

```javascript
const original = { name: 'John', details: { age: 30, city: 'NYC' } };

// Shallow copy methods
const clone1 = { ...original }; // Spread operator
const clone2 = Object.assign({}, original);

// Deep copy methods
const clone3 = JSON.parse(JSON.stringify(original)); // Simple deep copy
const clone4 = structuredClone(original); // Modern deep copy

// Note: Shallow copies share nested object references
clone1.details.age = 31;
console.log(original.details.age); // 31 (affected)

// Deep copies create independent nested objects
clone3.details.city = 'LA';
console.log(original.details.city); // 'NYC' (not affected)
```

#### How do you merge two objects in JavaScript?
Objects can be merged using several methods:

```javascript
const obj1 = { a: 1, b: 2 };
const obj2 = { b: 3, c: 4 };

// Using spread operator (ES6)
const merged1 = { ...obj1, ...obj2 }; // { a: 1, b: 3, c: 4 }

// Using Object.assign()
const merged2 = Object.assign({}, obj1, obj2); // { a: 1, b: 3, c: 4 }

// Merging into existing object
Object.assign(obj1, obj2); // obj1 becomes { a: 1, b: 3, c: 4 }

// Multiple objects
const obj3 = { d: 5 };
const merged3 = { ...obj1, ...obj2, ...obj3 };
```

#### What is object destructuring in JavaScript?
Object destructuring allows extracting properties from objects into variables:

```javascript
const person = { name: 'John', age: 30, city: 'NYC', country: 'USA' };

// Basic destructuring
const { name, age } = person;
console.log(name, age); // 'John', 30

// Renaming variables
const { name: fullName, age: years } = person;
console.log(fullName, years); // 'John', 30

// Default values
const { name, salary = 50000 } = person;
console.log(salary); // 50000

// Nested destructuring
const user = { info: { name: 'Jane', details: { age: 25 } } };
const { info: { name: userName, details: { age } } } = user;

// Rest operator
const { name, ...rest } = person;
console.log(rest); // { age: 30, city: 'NYC', country: 'USA' }
```

### Prototypes & Inheritance

#### What is a prototype in JavaScript?
Every JavaScript object has a prototype - an object from which it inherits properties and methods. The prototype acts as a template for shared functionality.

```javascript
// Every function has a prototype property
function Person(name) {
  this.name = name;
}

// Adding methods to prototype
Person.prototype.greet = function() {
  return `Hello, I'm ${this.name}`;
};

const john = new Person('John');
console.log(john.greet()); // "Hello, I'm John"
console.log(john.__proto__ === Person.prototype); // true
```

#### Explain the concept of prototype inheritance in JavaScript
Prototype inheritance allows objects to inherit properties and methods from other objects through the prototype chain.

```javascript
// Parent constructor
function Animal(name) {
  this.name = name;
}

Animal.prototype.speak = function() {
  return `${this.name} makes a sound`;
};

// Child constructor
function Dog(name, breed) {
  Animal.call(this, name); // Call parent constructor
  this.breed = breed;
}

// Set up inheritance
Dog.prototype = Object.create(Animal.prototype);
Dog.prototype.constructor = Dog;

// Add child-specific method
Dog.prototype.bark = function() {
  return `${this.name} barks`;
};

const dog = new Dog('Rex', 'Labrador');
console.log(dog.speak()); // "Rex makes a sound" (inherited)
console.log(dog.bark());  // "Rex barks" (own method)
```

#### What are the different methods of creating objects in JavaScript?
JavaScript provides multiple approaches for object creation:

```javascript
// 1. Object literal
const obj1 = { name: 'John' };

// 2. Constructor function
function Person(name) {
  this.name = name;
}
const obj2 = new Person('Jane');

// 3. Object.create()
const proto = { greet() { return 'Hello'; } };
const obj3 = Object.create(proto);

// 4. Factory function
function createPerson(name) {
  return { name, greet() { return `Hi, ${name}`; } };
}
const obj4 = createPerson('Bob');

// 5. ES6 Class
class Car {
  constructor(make) { this.make = make; }
}
const obj5 = new Car('Toyota');
```

#### What is the difference between `Object.create()` and class-based inheritance?
`Object.create()` provides direct prototype-based inheritance, while classes offer syntactic sugar over prototype inheritance.

```javascript
// Object.create() - Direct prototype inheritance
const animal = {
  speak() { return `${this.name} makes a sound`; }
};

const dog = Object.create(animal);
dog.name = 'Rex';
dog.bark = function() { return `${this.name} barks`; };

// Class-based inheritance - Syntactic sugar
class Animal {
  constructor(name) { this.name = name; }
  speak() { return `${this.name} makes a sound`; }
}

class Dog extends Animal {
  constructor(name, breed) {
    super(name);
    this.breed = breed;
  }
  bark() { return `${this.name} barks`; }
}

const dog2 = new Dog('Max', 'Golden Retriever');

// Both achieve similar results but with different syntax
console.log(dog.speak());  // "Rex makes a sound"
console.log(dog2.speak()); // "Max makes a sound"
```

### Classes & Constructors

#### How can you create a class in JavaScript?
Classes in JavaScript are created using the `class` keyword (ES6) and provide a cleaner syntax for object-oriented programming.

```javascript
// Basic class
class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
  
  greet() {
    return `Hello, I'm ${this.name}`;
  }
  
  static species() {
    return 'Homo sapiens';
  }
}

// Class with inheritance
class Student extends Person {
  constructor(name, age, grade) {
    super(name, age); // Call parent constructor
    this.grade = grade;
  }
  
  study() {
    return `${this.name} is studying`;
  }
}

const john = new Person('John', 25);
const jane = new Student('Jane', 20, 'A');
```

#### What is the difference between `class` and `constructor` in JavaScript?
- **`class`**: A blueprint/template for creating objects with shared properties and methods
- **`constructor`**: A special method inside a class that initializes new instances

```javascript
class Car {  // This is the class - the blueprint
  constructor(make, model) {  // This is the constructor method
    this.make = make;   // Initialize properties
    this.model = model;
  }
  
  start() {  // Regular method
    return `${this.make} ${this.model} started`;
  }
}

// The class defines the structure, constructor initializes each instance
const car1 = new Car('Toyota', 'Camry');
const car2 = new Car('Honda', 'Civic');
```

#### What is the difference between `class` and `function` constructors in JavaScript?
Both create objects, but classes provide cleaner syntax and additional features.

```javascript
// Function constructor (ES5)
function PersonFunc(name, age) {
  this.name = name;
  this.age = age;
}

PersonFunc.prototype.greet = function() {
  return `Hello, I'm ${this.name}`;
};

// Class constructor (ES6)
class PersonClass {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
  
  greet() {
    return `Hello, I'm ${this.name}`;
  }
}

// Both work similarly
const person1 = new PersonFunc('John', 25);
const person2 = new PersonClass('Jane', 30);

// Key differences:
// - Classes have cleaner syntax
// - Classes are not hoisted
// - Classes enforce 'new' keyword
// - Classes support extends/super easily
```

#### What are getter and setter methods in JavaScript?
Getters and setters allow controlled access to object properties.

```javascript
class Rectangle {
  constructor(width, height) {
    this._width = width;
    this._height = height;
  }
  
  // Getter - access like a property
  get area() {
    return this._width * this._height;
  }
  
  get width() {
    return this._width;
  }
  
  // Setter - set like a property with validation
  set width(value) {
    if (value > 0) {
      this._width = value;
    } else {
      throw new Error('Width must be positive');
    }
  }
}

const rect = new Rectangle(5, 10);
console.log(rect.area);   // 50 (getter)
console.log(rect.width);  // 5 (getter)
rect.width = 8;           // Uses setter
console.log(rect.area);   // 80
```

#### How does the `new` keyword work in JavaScript?
The `new` keyword creates a new object instance and sets up the prototype chain.

```javascript
function Person(name) {
  this.name = name;
}

Person.prototype.greet = function() {
  return `Hello, ${this.name}`;
};

// What happens when you use 'new':
// 1. Creates a new empty object
// 2. Sets the object's prototype to Person.prototype
// 3. Calls Person function with 'this' bound to new object
// 4. Returns the new object (unless function returns an object)

const john = new Person('John');

// Equivalent to:
// const john = {};
// john.__proto__ = Person.prototype;
// Person.call(john, 'John');
// return john;

console.log(john.name);    // 'John'
console.log(john.greet()); // 'Hello, John'
```

### Object Methods & Properties

#### What are getter and setter methods in JavaScript?
Getters and setters provide controlled access to object properties.

```javascript
class Person {
  constructor(name) {
    this._name = name;
  }
  
  // Getter
  get name() {
    return this._name;
  }
  
  // Setter
  set name(value) {
    if (value.length > 0) {
      this._name = value;
    }
  }
}

const person = new Person('John');
console.log(person.name); // 'John' (getter)
person.name = 'Jane';     // Uses setter
```

#### What is the difference between `Object.freeze()` and `Object.seal()` in JavaScript?
- **`Object.freeze()`**: Makes object completely immutable (can't add, remove, or modify properties)
- **`Object.seal()`**: Prevents adding/removing properties but allows modifying existing ones

```javascript
const obj1 = { name: 'John', age: 30 };
Object.freeze(obj1);
obj1.name = 'Jane';  // Won't work
obj1.city = 'NYC';   // Won't work

const obj2 = { name: 'Bob', age: 25 };
Object.seal(obj2);
obj2.name = 'Alice'; // Works - can modify
obj2.city = 'LA';    // Won't work - can't add
```

### OOP Concepts

#### What are Object-Oriented Programming (OOP) in JavaScript?
OOP is a programming paradigm that organizes code around objects and classes, supporting encapsulation, inheritance, and polymorphism.

```javascript
// Encapsulation - bundling data and methods
class Car {
  constructor(make, model) {
    this.make = make;
    this.model = model;
  }
  
  start() {
    return `${this.make} ${this.model} started`;
  }
}

// Inheritance - extending functionality
class ElectricCar extends Car {
  constructor(make, model, battery) {
    super(make, model);
    this.battery = battery;
  }
  
  charge() {
    return 'Charging battery';
  }
}

// Polymorphism - same method, different behavior
const cars = [new Car('Toyota', 'Camry'), new ElectricCar('Tesla', 'Model 3', '75kWh')];
cars.forEach(car => console.log(car.start())); // Different implementations
```

#### What is an abstract class in JavaScript?
JavaScript doesn't have built-in abstract classes, but you can simulate them by preventing direct instantiation and requiring subclasses to implement methods.

```javascript
class Animal {
  constructor(name) {
    if (this.constructor === Animal) {
      throw new Error('Cannot instantiate abstract class');
    }
    this.name = name;
  }
  
  speak() {
    throw new Error('Method must be implemented by subclass');
  }
}

class Dog extends Animal {
  speak() {
    return `${this.name} barks`;
  }
}

// const animal = new Animal('Generic'); // Error
const dog = new Dog('Rex'); // Works
console.log(dog.speak()); // 'Rex barks'
```

## 4. **Arrays & Data Structures** (Collections)

### Array Manipulation

#### What are JavaScript arrays and how do you manipulate them?
Arrays are ordered collections of elements. Common manipulation methods:

```javascript
const arr = [1, 2, 3];

// Add elements
arr.push(4);        // [1, 2, 3, 4] - add to end
arr.unshift(0);     // [0, 1, 2, 3, 4] - add to start

// Remove elements
arr.pop();          // [0, 1, 2, 3] - remove from end
arr.shift();        // [1, 2, 3] - remove from start

// Transform arrays
const doubled = arr.map(x => x * 2);     // [2, 4, 6]
const filtered = arr.filter(x => x > 1);  // [2, 3]
const sum = arr.reduce((acc, x) => acc + x, 0); // 6
```

#### How can you merge two arrays in JavaScript?
Arrays can be merged using spread operator or concat method:

```javascript
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

// Using spread operator
const merged1 = [...arr1, ...arr2]; // [1, 2, 3, 4, 5, 6]

// Using concat
const merged2 = arr1.concat(arr2);   // [1, 2, 3, 4, 5, 6]
```

#### What is the difference between `slice()` and `splice()` in JavaScript?
- **`slice()`**: Returns a copy without modifying original array
- **`splice()`**: Modifies the original array

```javascript
const arr = [1, 2, 3, 4, 5];

// slice - doesn't modify original
const sliced = arr.slice(1, 3); // [2, 3]
console.log(arr); // [1, 2, 3, 4, 5] - unchanged

// splice - modifies original
const spliced = arr.splice(1, 2, 'a', 'b'); // [2, 3]
console.log(arr); // [1, 'a', 'b', 4, 5] - modified
```

#### How do you remove duplicates from an array in JavaScript?
Use Set or filter with indexOf:

```javascript
const arr = [1, 2, 2, 3, 3, 4];

// Using Set
const unique1 = [...new Set(arr)]; // [1, 2, 3, 4]

// Using filter
const unique2 = arr.filter((item, index) => arr.indexOf(item) === index);
```

#### How do you sort an array of objects based on a property in JavaScript?
Use the sort method with a comparison function:

```javascript
const people = [
  { name: 'John', age: 30 },
  { name: 'Jane', age: 25 },
  { name: 'Bob', age: 35 }
];

// Sort by age (ascending)
people.sort((a, b) => a.age - b.age);

// Sort by name (alphabetical)
people.sort((a, b) => a.name.localeCompare(b.name));
```

#### How do you check if an object is an array in JavaScript?
Use Array.isArray() method:

```javascript
const arr = [1, 2, 3];
const obj = { a: 1 };

console.log(Array.isArray(arr)); // true
console.log(Array.isArray(obj)); // false

// Alternative (less reliable)
console.log(arr instanceof Array); // true
```

### Array Iteration

#### What are the different ways to loop through an array in JavaScript?
There are several methods to iterate through arrays:

```javascript
const arr = [1, 2, 3, 4];

// 1. for loop
for (let i = 0; i < arr.length; i++) {
  console.log(arr[i]);
}

// 2. forEach
arr.forEach(item => console.log(item));

// 3. for...of (values)
for (const item of arr) {
  console.log(item);
}

// 4. for...in (indices)
for (const index in arr) {
  console.log(arr[index]);
}

// 5. map (for transformation)
const doubled = arr.map(item => item * 2);

// 6. while loop
let i = 0;
while (i < arr.length) {
  console.log(arr[i]);
  i++;
}
```

#### What is the difference between `for...in` and `for...of` loops in JavaScript?
- **`for...in`**: Iterates over object keys/array indices
- **`for...of`**: Iterates over iterable values

```javascript
const arr = ['a', 'b', 'c'];
const obj = { name: 'John', age: 30 };

// for...in - gets keys/indices
for (const index in arr) {
  console.log(index); // 0, 1, 2
}

for (const key in obj) {
  console.log(key); // 'name', 'age'
}

// for...of - gets values (only works with iterables)
for (const value of arr) {
  console.log(value); // 'a', 'b', 'c'
}

// for (const value of obj) {} // Error - objects are not iterable
```

### Advanced Data Structures

#### What is a set and a map in JavaScript?
- **Set**: Collection of unique values (no duplicates)
- **Map**: Collection of key-value pairs where keys can be any type

```javascript
// Set - unique values only
const mySet = new Set([1, 2, 2, 3, 3]);
console.log(mySet); // Set {1, 2, 3}
mySet.add(4);
mySet.has(2); // true
mySet.delete(1);

// Map - key-value pairs
const myMap = new Map();
myMap.set('name', 'John');
myMap.set(1, 'number key');
myMap.set(true, 'boolean key');

console.log(myMap.get('name')); // 'John'
console.log(myMap.size); // 3
myMap.has('name'); // true
```

#### What is the purpose of `WeakMap` and `WeakSet` in JavaScript?
- **WeakMap**: Like Map but keys must be objects and are weakly referenced (garbage collected when no other references exist)
- **WeakSet**: Like Set but only stores objects and they are weakly referenced

```javascript
// WeakMap - prevents memory leaks
let obj = { name: 'John' };
const weakMap = new WeakMap();
weakMap.set(obj, 'some data');

// When obj is set to null, the WeakMap entry is automatically garbage collected
obj = null;

// WeakSet - for object collections
let user = { id: 1 };
const weakSet = new WeakSet();
weakSet.add(user);
weakSet.has(user); // true

// No size property or iteration methods (not enumerable)
```

### Object vs Array Operations

#### What is the difference between `Object.assign()` and the spread operator (`...`)?
Both create shallow copies, but have different syntax and capabilities:

```javascript
const obj1 = { a: 1, b: 2 };
const obj2 = { c: 3 };

// Object.assign() - modifies target object
const result1 = Object.assign({}, obj1, obj2); // { a: 1, b: 2, c: 3 }
const result2 = Object.assign(obj1, obj2); // Modifies obj1

// Spread operator - creates new object
const result3 = { ...obj1, ...obj2 }; // { a: 1, b: 2, c: 3 }
const result4 = { ...obj1, d: 4 }; // Can add new properties easily

// Key differences:
// - Spread is more concise and readable
// - Spread always creates new object
// - Object.assign can modify existing object
```

#### What is the difference between shallow copy and deep copy in JavaScript?
- **Shallow copy**: Copies only the top-level properties (nested objects are still referenced)
- **Deep copy**: Creates completely independent copy including all nested objects

```javascript
const original = {
  name: 'John',
  address: { city: 'NYC', zip: '10001' }
};

// Shallow copy - nested objects are still referenced
const shallow1 = { ...original };
const shallow2 = Object.assign({}, original);

shallow1.address.city = 'LA';
console.log(original.address.city); // 'LA' - original affected!

// Deep copy - completely independent
const deep1 = JSON.parse(JSON.stringify(original));
const deep2 = structuredClone(original); // Modern method

deep1.address.city = 'Chicago';
console.log(original.address.city); // 'NYC' - original not affected
```

## 5. **Asynchronous JavaScript** (Async Programming)

### Synchronous vs Asynchronous

#### What is the difference between synchronous and asynchronous code in JavaScript?
- **Synchronous**: Code executes line by line, blocking further execution until current operation completes
- **Asynchronous**: Code can run in background without blocking the main thread

```javascript
// Synchronous - blocks execution
console.log('Start');
console.log('Middle');
console.log('End');
// Output: Start, Middle, End (in order)

// Asynchronous - doesn't block
console.log('Start');
setTimeout(() => {
  console.log('Middle');
}, 1000);
console.log('End');
// Output: Start, End, Middle (after 1 second)
```

#### Explain the concept of JavaScript's single-threaded model
JavaScript runs on a single main thread, meaning it can only execute one task at a time. However, it uses an event loop and callback queue to handle asynchronous operations without blocking.

```javascript
// Single thread - only one operation at a time
function heavyTask() {
  for (let i = 0; i < 1000000000; i++) {
    // This blocks the thread
  }
  console.log('Heavy task done');
}

console.log('Before heavy task');
heavyTask(); // Blocks everything
console.log('After heavy task');

// Better approach with async operations
console.log('Before async task');
setTimeout(() => {
  console.log('Async task done');
}, 0); // Doesn't block
console.log('After async task');
```

#### How does JavaScript handle asynchronous operations?
JavaScript uses the Event Loop, Call Stack, and Callback Queue to manage async operations:

```javascript
// Event loop handles async operations
console.log('1');

setTimeout(() => {
  console.log('2'); // Goes to callback queue
}, 0);

Promise.resolve().then(() => {
  console.log('3'); // Goes to microtask queue (higher priority)
});

console.log('4');

// Output: 1, 4, 3, 2
// Microtasks (Promises) have higher priority than macrotasks (setTimeout)

// Common async patterns
fetch('https://api.example.com/data')
  .then(response => response.json())
  .then(data => console.log(data));

// Or with async/await
async function fetchData() {
  const response = await fetch('https://api.example.com/data');
  const data = await response.json();
  console.log(data);
}
```

### Callbacks & Promises

#### What is a callback function in JavaScript?
A callback is a function passed as an argument to another function, executed after some operation completes.

```javascript
// Simple callback
function greet(name, callback) {
  console.log('Hello ' + name);
  callback();
}

greet('John', function() {
  console.log('Greeting completed!');
});

// Async callback
function fetchData(callback) {
  setTimeout(() => {
    callback('Data received');
  }, 1000);
}

fetchData(data => console.log(data)); // "Data received" after 1 second
```

#### What is a promise in JavaScript? How does it work?
A Promise represents the eventual completion (or failure) of an asynchronous operation and its resulting value.

```javascript
// Creating a promise
const myPromise = new Promise((resolve, reject) => {
  const success = true;
  
  setTimeout(() => {
    if (success) {
      resolve('Operation successful!');
    } else {
      reject('Operation failed!');
    }
  }, 1000);
});

// Using the promise
myPromise
  .then(result => console.log(result)) // Success handler
  .catch(error => console.log(error)); // Error handler
```

#### What is a promise chain in JavaScript?
Promise chaining allows you to execute multiple asynchronous operations in sequence.

```javascript
fetch('/api/user')
  .then(response => response.json())
  .then(user => {
    console.log('User:', user);
    return fetch(`/api/posts/${user.id}`);
  })
  .then(response => response.json())
  .then(posts => console.log('Posts:', posts))
  .catch(error => console.log('Error:', error));
```

#### What are the states of a promise?
A promise has three possible states:

```javascript
// 1. Pending - initial state, neither fulfilled nor rejected
const pendingPromise = new Promise(() => {});

// 2. Fulfilled - operation completed successfully
const fulfilledPromise = Promise.resolve('Success!');

// 3. Rejected - operation failed
const rejectedPromise = Promise.reject('Error!');

console.log(pendingPromise);   // Promise { <pending> }
console.log(fulfilledPromise); // Promise { 'Success!' }
console.log(rejectedPromise);  // Promise { <rejected> 'Error!' }
```

#### What is the difference between callback and promise?
- **Callbacks**: Functions passed as arguments, can lead to callback hell
- **Promises**: Objects representing future values, chainable and more readable

```javascript
// Callback approach
getData(function(a) {
  getMoreData(a, function(b) {
    getEvenMoreData(b, function(c) {
      // Callback hell!
    });
  });
});

// Promise approach
getData()
  .then(a => getMoreData(a))
  .then(b => getEvenMoreData(b))
  .then(c => console.log(c))
  .catch(error => console.log(error));
```

#### What is a callback hell, and how can you avoid it?
Callback hell occurs when multiple nested callbacks make code hard to read and maintain.

```javascript
// Callback hell example
getUser(function(user) {
  getPosts(user.id, function(posts) {
    getComments(posts[0].id, function(comments) {
      getAuthor(comments[0].authorId, function(author) {
        // Deep nesting makes code hard to read
        console.log(author);
      });
    });
  });
});

// Solutions:
// 1. Using Promises
getUser()
  .then(user => getPosts(user.id))
  .then(posts => getComments(posts[0].id))
  .then(comments => getAuthor(comments[0].authorId))
  .then(author => console.log(author));

// 2. Using async/await
async function getUserData() {
  try {
    const user = await getUser();
    const posts = await getPosts(user.id);
    const comments = await getComments(posts[0].id);
    const author = await getAuthor(comments[0].authorId);
    console.log(author);
  } catch (error) {
    console.log(error);
  }
}
```

### Async/Await

#### What is `async/await` in JavaScript?
`async/await` is syntactic sugar over promises that makes asynchronous code look and behave more like synchronous code.

```javascript
// Promise approach
function fetchUserData() {
  return fetch('/api/user')
    .then(response => response.json())
    .then(user => {
      console.log(user);
      return user;
    });
}

// Async/await approach
async function fetchUserData() {
  const response = await fetch('/api/user');
  const user = await response.json();
  console.log(user);
  return user;
}

// Async functions always return a promise
const result = fetchUserData(); // Returns a promise
```

#### What is the difference between `async/await` and promises?
- **Promises**: Use `.then()` and `.catch()` for chaining
- **Async/await**: Makes async code look synchronous, easier to read and debug

```javascript
// Promise chaining
getUser()
  .then(user => getPosts(user.id))
  .then(posts => getComments(posts[0].id))
  .then(comments => console.log(comments))
  .catch(error => console.log(error));

// Async/await - more readable
async function getUserComments() {
  try {
    const user = await getUser();
    const posts = await getPosts(user.id);
    const comments = await getComments(posts[0].id);
    console.log(comments);
  } catch (error) {
    console.log(error);
  }
}

// Key differences:
// - async/await has cleaner syntax
// - Better error handling with try/catch
// - Easier debugging (can set breakpoints)
// - No callback/promise chaining
```

#### How do you handle errors in an async function?
Use `try/catch` blocks to handle errors in async functions:

```javascript
async function fetchData() {
  try {
    const response = await fetch('/api/data');
    
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error fetching data:', error.message);
    throw error; // Re-throw if needed
  } finally {
    console.log('Cleanup operations');
  }
}

// Multiple async operations
async function processMultipleRequests() {
  try {
    const [users, posts, comments] = await Promise.all([
      fetch('/api/users').then(r => r.json()),
      fetch('/api/posts').then(r => r.json()),
      fetch('/api/comments').then(r => r.json())
    ]);
    
    return { users, posts, comments };
  } catch (error) {
    console.error('One or more requests failed:', error);
  }
}
```

### Promise Methods

#### What is the purpose of `Promise.all()` and `Promise.race()`?
- **`Promise.all()`**: Waits for all promises to resolve, fails if any promise rejects
- **`Promise.race()`**: Returns the first promise to settle (resolve or reject)

```javascript
// Promise.all() - all must succeed
const promise1 = fetch('/api/users');
const promise2 = fetch('/api/posts');
const promise3 = fetch('/api/comments');

Promise.all([promise1, promise2, promise3])
  .then(responses => {
    // All requests completed successfully
    console.log('All data loaded');
  })
  .catch(error => {
    // If any request fails, this catch runs
    console.log('One or more requests failed:', error);
  });

// Promise.race() - first to finish wins
const slowRequest = new Promise(resolve => setTimeout(() => resolve('slow'), 3000));
const fastRequest = new Promise(resolve => setTimeout(() => resolve('fast'), 1000));

Promise.race([slowRequest, fastRequest])
  .then(result => console.log(result)); // 'fast' (first to resolve)
```

#### What are `Promise.allSettled()`, `Promise.any()`, and `Promise.finally()`?
These are additional Promise methods for different use cases:

```javascript
// Promise.allSettled() - waits for all, doesn't fail
const promises = [
  Promise.resolve('success'),
  Promise.reject('error'),
  Promise.resolve('another success')
];

Promise.allSettled(promises)
  .then(results => {
    results.forEach(result => {
      if (result.status === 'fulfilled') {
        console.log('Success:', result.value);
      } else {
        console.log('Error:', result.reason);
      }
    });
  });

// Promise.any() - first successful promise
Promise.any([
  Promise.reject('error 1'),
  Promise.resolve('success'),
  Promise.reject('error 2')
])
.then(result => console.log(result)) // 'success'
.catch(error => console.log('All failed'));

// Promise.finally() - always runs
fetch('/api/data')
  .then(response => response.json())
  .catch(error => console.log('Error:', error))
  .finally(() => {
    console.log('Cleanup - always runs');
    // Hide loading spinner, etc.
  });
```

### Advanced Async Concepts

#### How does JavaScript handle multiple asynchronous operations in sequence?
JavaScript can handle sequential async operations using promises, async/await, or chaining:

```javascript
// Sequential execution with async/await
async function processInSequence() {
  try {
    const user = await fetchUser();
    const profile = await fetchProfile(user.id);
    const posts = await fetchPosts(profile.id);
    const comments = await fetchComments(posts[0].id);
    return { user, profile, posts, comments };
  } catch (error) {
    console.error('Sequence failed:', error);
  }
}

// Sequential execution with promise chaining
function processWithPromises() {
  return fetchUser()
    .then(user => fetchProfile(user.id))
    .then(profile => fetchPosts(profile.id))
    .then(posts => fetchComments(posts[0].id))
    .catch(error => console.error('Chain failed:', error));
}

// Parallel execution (faster when operations are independent)
async function processInParallel() {
  try {
    const [users, posts, comments] = await Promise.all([
      fetchUsers(),
      fetchPosts(),
      fetchComments()
    ]);
    return { users, posts, comments };
  } catch (error) {
    console.error('Parallel execution failed:', error);
  }
}
```

#### How does JavaScript handle multiple callback functions?
JavaScript executes callbacks through the event loop and callback queue:

```javascript
// Multiple callbacks with different timing
console.log('Start');

setTimeout(() => console.log('Timeout 1'), 0);
setTimeout(() => console.log('Timeout 2'), 0);

setImmediate(() => console.log('Immediate')); // Node.js only

Promise.resolve().then(() => console.log('Promise 1'));
Promise.resolve().then(() => console.log('Promise 2'));

console.log('End');

// Output: Start, End, Promise 1, Promise 2, Timeout 1, Timeout 2
// Microtasks (Promises) have higher priority than macrotasks (setTimeout)

// Event listeners - multiple callbacks for same event
const button = document.getElementById('myButton');

button.addEventListener('click', () => console.log('Handler 1'));
button.addEventListener('click', () => console.log('Handler 2'));
button.addEventListener('click', () => console.log('Handler 3'));

// All three handlers will execute when button is clicked
```

## 6. **Event Handling & DOM** (Browser APIs)

### DOM Manipulation

#### What is the DOM (Document Object Model) in JavaScript?
The DOM is a programming interface that represents HTML/XML documents as a tree structure of objects that JavaScript can interact with and modify.

```javascript
// HTML structure becomes DOM tree:
// document
//   └── html
//       ├── head
//       │   └── title
//       └── body
//           ├── div (id="container")
//           └── p (class="text")

// Accessing DOM elements
const container = document.getElementById('container');
const paragraph = document.querySelector('.text');
const allDivs = document.querySelectorAll('div');
```

#### How do you manipulate the DOM using JavaScript?
DOM manipulation involves selecting, modifying, creating, and removing elements:

```javascript
// Selecting elements
const element = document.getElementById('myId');
const elements = document.getElementsByClassName('myClass');
const firstDiv = document.querySelector('div');

// Modifying content
element.textContent = 'New text';
element.innerHTML = '<strong>Bold text</strong>';

// Modifying attributes and styles
element.setAttribute('data-value', '123');
element.style.color = 'red';
element.classList.add('active');
element.classList.remove('inactive');

// Creating and adding elements
const newDiv = document.createElement('div');
newDiv.textContent = 'New element';
document.body.appendChild(newDiv);

// Removing elements
element.remove();
// or
element.parentNode.removeChild(element);

// Event handling
element.addEventListener('click', function() {
  console.log('Element clicked!');
});
```

### Event Handling

#### Explain event delegation in JavaScript
Event delegation uses a single event listener on a parent element to handle events for multiple child elements, leveraging event bubbling.

```javascript
// Instead of adding listeners to each button
// <div id="container">
//   <button>Button 1</button>
//   <button>Button 2</button>
//   <button>Button 3</button>
// </div>

// Event delegation - one listener handles all buttons
document.getElementById('container').addEventListener('click', function(event) {
  if (event.target.tagName === 'BUTTON') {
    console.log('Button clicked:', event.target.textContent);
  }
});

// Benefits: Works for dynamically added elements, better performance
```

#### What is event propagation in JavaScript?
Event propagation is the process of how events travel through the DOM tree in three phases: capturing, target, and bubbling.

```javascript
// Event flow: Document → HTML → Body → Div → Button (capturing)
//            Button (target phase)
//            Button → Div → Body → HTML → Document (bubbling)

document.addEventListener('click', () => console.log('Document'), true); // Capturing
document.body.addEventListener('click', () => console.log('Body')); // Bubbling
button.addEventListener('click', () => console.log('Button')); // Target

// Output when button clicked: Document, Button, Body
```

#### What is event bubbling and capturing in JavaScript?
- **Bubbling**: Events travel from target element up to the document root
- **Capturing**: Events travel from document root down to target element

```javascript
const parent = document.getElementById('parent');
const child = document.getElementById('child');

// Bubbling (default)
parent.addEventListener('click', () => console.log('Parent bubbling'));
child.addEventListener('click', () => console.log('Child bubbling'));

// Capturing (third parameter = true)
parent.addEventListener('click', () => console.log('Parent capturing'), true);
child.addEventListener('click', () => console.log('Child capturing'), true);

// Click child output: Parent capturing, Child capturing, Child bubbling, Parent bubbling
```

#### How do you prevent the default action of an event in JavaScript?
Use `preventDefault()` to stop the browser's default behavior for an event.

```javascript
// Prevent form submission
document.querySelector('form').addEventListener('submit', function(event) {
  event.preventDefault();
  console.log('Form submission prevented');
});

// Prevent link navigation
document.querySelector('a').addEventListener('click', function(event) {
  event.preventDefault();
  console.log('Link click prevented');
});

// Stop event propagation
element.addEventListener('click', function(event) {
  event.stopPropagation(); // Stops bubbling/capturing
});
```

#### How do you attach multiple event listeners to the same event?
Use `addEventListener()` multiple times - each listener will execute when the event occurs.

```javascript
const button = document.getElementById('myButton');

// Multiple listeners for the same event
button.addEventListener('click', function() {
  console.log('First listener');
});

button.addEventListener('click', function() {
  console.log('Second listener');
});

button.addEventListener('click', () => {
  console.log('Third listener');
});

// All three will execute when button is clicked
```

#### What is the difference between `addEventListener()` and `onclick`?
- **`addEventListener()`**: Can attach multiple listeners, more flexible
- **`onclick`**: Can only have one handler, simpler syntax

```javascript
const button = document.getElementById('myButton');

// onclick - only one handler allowed
button.onclick = function() {
  console.log('First handler');
};
button.onclick = function() {
  console.log('Second handler'); // This overwrites the first
};

// addEventListener - multiple handlers allowed
button.addEventListener('click', () => console.log('Handler 1'));
button.addEventListener('click', () => console.log('Handler 2'));

// addEventListener advantages:
// - Multiple listeners
// - Can specify capturing/bubbling
// - Can remove specific listeners
button.removeEventListener('click', handlerFunction);
```

### Browser APIs

#### What is the use of the `window` object in JavaScript?
The `window` object represents the browser window and serves as the global object in browsers, providing access to browser features and APIs.

```javascript
// Global object - all global variables are properties of window
var globalVar = 'Hello';
console.log(window.globalVar); // 'Hello'

// Browser information
console.log(window.innerWidth);  // Window width
console.log(window.innerHeight); // Window height
console.log(window.location.href); // Current URL

// Navigation
window.open('https://example.com'); // Open new window
window.close(); // Close current window
window.history.back(); // Go back in history

// Dialogs
window.alert('Hello!');
window.confirm('Are you sure?');
window.prompt('Enter your name:');

// Timers
window.setTimeout(() => console.log('Delayed'), 1000);
window.setInterval(() => console.log('Repeated'), 1000);
```

#### What is `localStorage` and `sessionStorage` in JavaScript?
Both are web storage APIs for storing data in the browser:
- **`localStorage`**: Persists until manually cleared
- **`sessionStorage`**: Persists only for the browser session

```javascript
// localStorage - persists across browser sessions
localStorage.setItem('username', 'john');
localStorage.setItem('preferences', JSON.stringify({theme: 'dark'}));

const username = localStorage.getItem('username'); // 'john'
const prefs = JSON.parse(localStorage.getItem('preferences'));

localStorage.removeItem('username');
localStorage.clear(); // Remove all items

// sessionStorage - cleared when tab closes
sessionStorage.setItem('tempData', 'temporary');
const tempData = sessionStorage.getItem('tempData');
sessionStorage.removeItem('tempData');

// Check storage availability
if (typeof(Storage) !== 'undefined') {
  // Storage supported
}
```

#### What is the difference between `localStorage` and `cookies` in JavaScript?
Key differences in storage, size, and usage:

```javascript
// localStorage
// - 5-10MB storage limit
// - Data stays until manually cleared
// - Not sent to server automatically
// - Simple API
localStorage.setItem('data', 'value');
const data = localStorage.getItem('data');

// Cookies
// - 4KB limit per cookie
// - Can set expiration date
// - Sent with every HTTP request
// - More complex API
document.cookie = 'username=john; expires=Thu, 18 Dec 2024 12:00:00 UTC; path=/';

// Reading cookies (more complex)
function getCookie(name) {
  const value = `; ${document.cookie}`;
  const parts = value.split(`; ${name}=`);
  if (parts.length === 2) return parts.pop().split(';').shift();
}

// Comparison:
// localStorage: Client-side only, larger storage, simpler API
// Cookies: Sent to server, smaller storage, can expire, more complex
```

## 7. **Advanced JavaScript Concepts** (Modern JS)

### ES6+ Features

#### What are template literals in JavaScript?
Template literals use backticks (`) for string interpolation and multi-line strings.

```javascript
// String interpolation
const name = 'John';
const age = 30;
const message = `Hello, my name is ${name} and I am ${age} years old.`;

// Multi-line strings
const multiLine = `
  This is a
  multi-line
  string
`;

// Expression evaluation
const result = `The sum is: ${5 + 3}`; // "The sum is: 8"

// Tagged templates
function highlight(strings, ...values) {
  return strings.reduce((result, string, i) => {
    return result + string + (values[i] ? `<mark>${values[i]}</mark>` : '');
  }, '');
}
const highlighted = highlight`Hello ${name}, you are ${age} years old!`;
```

#### What are the new features introduced in ES6?
ES6 introduced many modern JavaScript features:

```javascript
// 1. let and const
let variable = 'can change';
const constant = 'cannot change';

// 2. Arrow functions
const add = (a, b) => a + b;

// 3. Classes
class Person {
  constructor(name) { this.name = name; }
}

// 4. Destructuring
const {name, age} = person;
const [first, second] = array;

// 5. Default parameters
function greet(name = 'Guest') { return `Hello ${name}`; }

// 6. Rest/Spread operators
const newArray = [...oldArray, newItem];

// 7. Promises
const promise = new Promise((resolve, reject) => {});

// 8. Modules
import { module } from './file.js';
export default myFunction;

// 9. Map and Set
const map = new Map();
const set = new Set();
```

#### What are symbols in JavaScript? When would you use them?
Symbols are unique, immutable primitive values used as object property keys.

```javascript
// Creating symbols
const sym1 = Symbol();
const sym2 = Symbol('description');
const sym3 = Symbol('description');

console.log(sym2 === sym3); // false - each symbol is unique

// Using symbols as object keys
const obj = {
  [sym1]: 'value1',
  [sym2]: 'value2'
};

// Symbols are not enumerable
for (let key in obj) {
  console.log(key); // Won't log symbol keys
}

// Use cases:
// 1. Private properties
const _private = Symbol('private');
class MyClass {
  constructor() {
    this[_private] = 'hidden value';
  }
}

// 2. Well-known symbols
class MyArray {
  [Symbol.iterator]() {
    // Custom iterator
  }
}
```

#### What are generator functions in JavaScript?
Generator functions can pause and resume execution, yielding multiple values over time.

```javascript
// Generator function syntax
function* numberGenerator() {
  yield 1;
  yield 2;
  yield 3;
  return 'done';
}

const gen = numberGenerator();
console.log(gen.next()); // {value: 1, done: false}
console.log(gen.next()); // {value: 2, done: false}
console.log(gen.next()); // {value: 3, done: false}
console.log(gen.next()); // {value: 'done', done: true}

// Infinite generator
function* fibonacci() {
  let a = 0, b = 1;
  while (true) {
    yield a;
    [a, b] = [b, a + b];
  }
}

const fib = fibonacci();
console.log(fib.next().value); // 0
console.log(fib.next().value); // 1
console.log(fib.next().value); // 1
```

#### How does destructuring work in JavaScript?
Destructuring extracts values from arrays or properties from objects into variables.

```javascript
// Array destructuring
const arr = [1, 2, 3, 4, 5];
const [first, second, ...rest] = arr;
console.log(first, second, rest); // 1, 2, [3, 4, 5]

// Object destructuring
const person = { name: 'John', age: 30, city: 'NYC' };
const { name, age, country = 'USA' } = person;
console.log(name, age, country); // 'John', 30, 'USA'

// Renaming variables
const { name: fullName, age: years } = person;

// Nested destructuring
const user = { info: { name: 'Jane', details: { age: 25 } } };
const { info: { name: userName, details: { age } } } = user;

// Function parameters
function greet({ name, age }) {
  return `Hello ${name}, you are ${age} years old`;
}
greet(person);
```

#### What is the spread operator, and how do you use it?
The spread operator (...) expands iterables into individual elements.

```javascript
// Array spreading
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
const combined = [...arr1, ...arr2]; // [1, 2, 3, 4, 5, 6]

// Object spreading
const obj1 = { a: 1, b: 2 };
const obj2 = { c: 3, d: 4 };
const merged = { ...obj1, ...obj2 }; // {a: 1, b: 2, c: 3, d: 4}

// Function arguments
function sum(a, b, c) {
  return a + b + c;
}
const numbers = [1, 2, 3];
console.log(sum(...numbers)); // 6

// Copying arrays/objects
const arrCopy = [...arr1];
const objCopy = { ...obj1 };

// Converting NodeList to Array
const elements = [...document.querySelectorAll('div')];
```

#### What is the rest parameter in JavaScript?
The rest parameter (...) collects multiple arguments into an array.

```javascript
// Rest parameters in functions
function sum(...numbers) {
  return numbers.reduce((total, num) => total + num, 0);
}
console.log(sum(1, 2, 3, 4)); // 10

// Mixed parameters
function greet(greeting, ...names) {
  return `${greeting} ${names.join(', ')}!`;
}
console.log(greet('Hello', 'John', 'Jane', 'Bob')); // "Hello John, Jane, Bob!"

// Rest in destructuring
const [first, ...remaining] = [1, 2, 3, 4, 5];
console.log(first, remaining); // 1, [2, 3, 4, 5]

const { name, ...otherProps } = { name: 'John', age: 30, city: 'NYC' };
console.log(name, otherProps); // 'John', {age: 30, city: 'NYC'}
```

### Context & Binding

#### How does the `this` keyword work in JavaScript?
The `this` keyword refers to the context in which a function is called, and its value depends on how the function is invoked.

```javascript
// 1. Global context
console.log(this); // Window object (browser) or global (Node.js)

// 2. Object method
const person = {
  name: 'John',
  greet() {
    console.log(this.name); // 'John' - this refers to person object
  }
};
person.greet();

// 3. Regular function
function regularFunction() {
  console.log(this); // Window (non-strict) or undefined (strict mode)
}

// 4. Arrow function - lexically bound
const obj = {
  name: 'Jane',
  regularMethod() {
    const arrowFunc = () => {
      console.log(this.name); // 'Jane' - inherits from regularMethod
    };
    arrowFunc();
  }
};

// 5. Constructor function
function Person(name) {
  this.name = name; // this refers to new instance
}
const john = new Person('John');

// 6. Event handler
button.addEventListener('click', function() {
  console.log(this); // button element
});
```

#### What is the purpose of the `call()`, `apply()` and `bind()` methods in JavaScript?
These methods allow you to explicitly set the `this` context and invoke functions with specific arguments.

```javascript
const person1 = { name: 'John' };
const person2 = { name: 'Jane' };

function greet(greeting, punctuation) {
  console.log(`${greeting}, ${this.name}${punctuation}`);
}

// call() - arguments passed individually
greet.call(person1, 'Hello', '!'); // "Hello, John!"
greet.call(person2, 'Hi', '.'); // "Hi, Jane."

// apply() - arguments passed as array
greet.apply(person1, ['Hello', '!']); // "Hello, John!"
greet.apply(person2, ['Hi', '.']); // "Hi, Jane."

// bind() - returns new function with bound context
const greetJohn = greet.bind(person1);
greetJohn('Hey', '?'); // "Hey, John?"

// Practical use case - borrowing methods
const numbers = { data: [1, 2, 3] };
const result = Array.prototype.join.call(numbers.data, '-'); // "1-2-3"
```

#### What is the `Function.prototype.bind()` method in JavaScript?
`bind()` creates a new function with a permanently bound `this` value and optionally pre-set arguments.

```javascript
const module = {
  value: 42,
  getValue() {
    return this.value;
  }
};

// Without bind - loses context
const getValue = module.getValue;
console.log(getValue()); // undefined (this is not module)

// With bind - preserves context
const boundGetValue = module.getValue.bind(module);
console.log(boundGetValue()); // 42

// Partial application with bind
function multiply(a, b) {
  return a * b;
}

const double = multiply.bind(null, 2); // Pre-set first argument
console.log(double(5)); // 10 (2 * 5)

// Event handlers - common use case
class Counter {
  constructor() {
    this.count = 0;
    // Bind to preserve 'this' context
    this.increment = this.increment.bind(this);
  }
  
  increment() {
    this.count++;
    console.log(this.count);
  }
}

const counter = new Counter();
document.getElementById('btn').addEventListener('click', counter.increment);
```

### Closures & Memory

#### What are closures in JavaScript, and why are they important?
A closure is a function that retains access to its lexical scope even after the outer function has finished executing.

```javascript
// Basic closure example
function outer() {
  let count = 0;
  
  return function inner() {
    count++;
    console.log(count);
  };
}

const counter = outer();
counter(); // 1
counter(); // 2
counter(); // 3

// Why closures are important:
// 1. Data encapsulation
function createBankAccount(initialBalance) {
  let balance = initialBalance;
  
  return {
    deposit(amount) {
      balance += amount;
      return balance;
    },
    withdraw(amount) {
      if (amount <= balance) {
        balance -= amount;
        return balance;
      }
      return 'Insufficient funds';
    },
    getBalance() {
      return balance;
    }
  };
}

const account = createBankAccount(100);
console.log(account.deposit(50)); // 150
// balance is private - cannot be accessed directly

// 2. Function factories
function createMultiplier(multiplier) {
  return function(x) {
    return x * multiplier;
  };
}

const double = createMultiplier(2);
const triple = createMultiplier(3);
console.log(double(5)); // 10
console.log(triple(5)); // 15
```

#### How does JavaScript handle memory management and garbage collection?
JavaScript automatically manages memory through garbage collection, which removes objects that are no longer reachable.

```javascript
// Memory allocation and deallocation
function createObjects() {
  let obj1 = { name: 'Object 1' }; // Memory allocated
  let obj2 = { name: 'Object 2' }; // Memory allocated
  
  obj1.ref = obj2; // Reference created
  obj2.ref = obj1; // Circular reference
  
  return obj1;
} // obj2 becomes unreachable when function ends

let myObj = createObjects();
myObj = null; // Now both objects become unreachable

// Garbage collection process:
// 1. Mark-and-sweep algorithm
// 2. Marks all reachable objects from root
// 3. Sweeps (deletes) unmarked objects
// 4. Compacts memory

// WeakMap/WeakSet help with garbage collection
let weakMap = new WeakMap();
let obj = { data: 'some data' };

weakMap.set(obj, 'metadata');
obj = null; // Object can be garbage collected even if in WeakMap

// Memory management best practices:
// - Avoid global variables
// - Remove event listeners when not needed
// - Clear intervals/timeouts
// - Use WeakMap/WeakSet for temporary associations
```

#### What are memory leaks in JavaScript, and how do you prevent them?
Memory leaks occur when objects that are no longer needed remain in memory because they're still referenced.

```javascript
// Common memory leak causes:

// 1. Global variables
function createLeak() {
  // Accidentally creates global variable
  leakedVar = 'This creates a global variable';
}
// Fix: Use 'let' or 'const'
function fixed() {
  let properVar = 'This is properly scoped';
}

// 2. Event listeners not removed
function setupEventListener() {
  const button = document.getElementById('myButton');
  const handler = () => console.log('Clicked');
  
  button.addEventListener('click', handler);
  
  // Memory leak - handler keeps reference to button
  // Fix: Remove listener when done
  // button.removeEventListener('click', handler);
}

// 3. Timers not cleared
function createTimer() {
  const data = new Array(1000000).fill('data');
  
  const intervalId = setInterval(() => {
    console.log('Timer running');
  }, 1000);
  
  // Memory leak - interval keeps running
  // Fix: Clear timer when done
  // clearInterval(intervalId);
}

// 4. Closures holding references
function createClosure() {
  const largeData = new Array(1000000).fill('data');
  
  return function smallFunction() {
    return 'small result';
  };
  // largeData is kept in memory due to closure
}

// Prevention strategies:
// 1. Use proper scoping
// 2. Remove event listeners
// 3. Clear timers and intervals
// 4. Nullify references when done
// 5. Use WeakMap/WeakSet for temporary data
// 6. Monitor memory usage with DevTools

// Example of proper cleanup
class Component {
  constructor() {
    this.handleClick = this.handleClick.bind(this);
    this.intervalId = null;
  }
  
  mount() {
    document.addEventListener('click', this.handleClick);
    this.intervalId = setInterval(() => {
      // Do something
    }, 1000);
  }
  
  unmount() {
    document.removeEventListener('click', this.handleClick);
    if (this.intervalId) {
      clearInterval(this.intervalId);
      this.intervalId = null;
    }
  }
  
  handleClick() {
    console.log('Clicked');
  }
}
```

## 8. **Performance & Optimization** (Performance)

### Performance Techniques

#### How can you optimize the performance of a JavaScript application?
Optimize JavaScript performance through code efficiency, DOM manipulation, and resource management.

```javascript
// 1. Minimize DOM access
// Bad
for (let i = 0; i < 1000; i++) {
  document.getElementById('list').innerHTML += '<li>Item ' + i + '</li>';
}

// Good
let html = '';
for (let i = 0; i < 1000; i++) {
  html += '<li>Item ' + i + '</li>';
}
document.getElementById('list').innerHTML = html;

// 2. Use efficient loops
// Cache array length
const arr = [1, 2, 3, 4, 5];
for (let i = 0, len = arr.length; i < len; i++) {
  // Process arr[i]
}

// 3. Debounce expensive operations
function debounce(func, delay) {
  let timeoutId;
  return function(...args) {
    clearTimeout(timeoutId);
    timeoutId = setTimeout(() => func.apply(this, args), delay);
  };
}

const expensiveSearch = debounce(function(query) {
  // Expensive search operation
}, 300);

// 4. Use Web Workers for heavy computations
const worker = new Worker('heavy-computation.js');
worker.postMessage({data: largeDataSet});
worker.onmessage = function(e) {
  console.log('Result:', e.data);
};

// 5. Optimize object creation
// Use object pools for frequently created objects
class ObjectPool {
  constructor(createFn, resetFn) {
    this.createFn = createFn;
    this.resetFn = resetFn;
    this.pool = [];
  }
  
  get() {
    return this.pool.length > 0 ? this.pool.pop() : this.createFn();
  }
  
  release(obj) {
    this.resetFn(obj);
    this.pool.push(obj);
  }
}
```

#### What is lazy loading in JavaScript?
Lazy loading defers loading of resources until they're actually needed, improving initial page load time.

```javascript
// 1. Lazy loading images
const images = document.querySelectorAll('img[data-src]');
const imageObserver = new IntersectionObserver((entries) => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      const img = entry.target;
      img.src = img.dataset.src;
      img.removeAttribute('data-src');
      imageObserver.unobserve(img);
    }
  });
});

images.forEach(img => imageObserver.observe(img));

// 2. Lazy loading JavaScript modules
const loadModule = async () => {
  const module = await import('./heavy-module.js');
  module.initialize();
};

// Load module only when needed
document.getElementById('button').addEventListener('click', loadModule);

// 3. Lazy loading components
class LazyComponent {
  constructor(selector) {
    this.element = document.querySelector(selector);
    this.loaded = false;
  }
  
  async load() {
    if (!this.loaded) {
      const { default: Component } = await import('./Component.js');
      this.component = new Component(this.element);
      this.loaded = true;
    }
    return this.component;
  }
}

// 4. Lazy loading with Intersection Observer
const lazyElements = document.querySelectorAll('.lazy-load');
const observer = new IntersectionObserver((entries) => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      entry.target.classList.add('loaded');
      observer.unobserve(entry.target);
    }
  });
});

lazyElements.forEach(el => observer.observe(el));
```

#### How do you improve the rendering performance of a website using JavaScript?
Optimize rendering by minimizing reflows, repaints, and using efficient animation techniques.

```javascript
// 1. Batch DOM updates
// Bad - causes multiple reflows
element.style.width = '100px';
element.style.height = '100px';
element.style.background = 'red';

// Good - single reflow
element.style.cssText = 'width: 100px; height: 100px; background: red;';

// 2. Use DocumentFragment for multiple insertions
const fragment = document.createDocumentFragment();
for (let i = 0; i < 100; i++) {
  const div = document.createElement('div');
  div.textContent = `Item ${i}`;
  fragment.appendChild(div);
}
document.body.appendChild(fragment); // Single DOM update

// 3. Use transform and opacity for animations (GPU accelerated)
// Bad - triggers layout
element.style.left = '100px';

// Good - uses compositor
element.style.transform = 'translateX(100px)';

// 4. Avoid layout thrashing
// Bad - reading and writing alternately
for (let i = 0; i < elements.length; i++) {
  elements[i].style.left = elements[i].offsetLeft + 10 + 'px';
}

// Good - batch reads and writes
const positions = [];
for (let i = 0; i < elements.length; i++) {
  positions[i] = elements[i].offsetLeft; // Read phase
}
for (let i = 0; i < elements.length; i++) {
  elements[i].style.left = positions[i] + 10 + 'px'; // Write phase
}

// 5. Use CSS containment
element.style.contain = 'layout style paint';
```

#### What is the significance of `requestAnimationFrame()` in JavaScript?
`requestAnimationFrame()` synchronizes animations with the browser's refresh rate for smooth, efficient animations.

```javascript
// Bad - using setTimeout for animation
function animateWithTimeout() {
  let position = 0;
  function move() {
    position += 2;
    element.style.left = position + 'px';
    if (position < 300) {
      setTimeout(move, 16); // ~60fps, but not synchronized
    }
  }
  move();
}

// Good - using requestAnimationFrame
function animateWithRAF() {
  let position = 0;
  function move() {
    position += 2;
    element.style.left = position + 'px';
    if (position < 300) {
      requestAnimationFrame(move); // Synchronized with refresh rate
    }
  }
  requestAnimationFrame(move);
}

// Advanced usage with timing
function smoothAnimation() {
  let start = null;
  const duration = 1000; // 1 second
  
  function animate(timestamp) {
    if (!start) start = timestamp;
    const progress = (timestamp - start) / duration;
    
    if (progress < 1) {
      // Easing function
      const easeOut = 1 - Math.pow(1 - progress, 3);
      element.style.transform = `translateX(${easeOut * 300}px)`;
      requestAnimationFrame(animate);
    } else {
      element.style.transform = 'translateX(300px)';
    }
  }
  
  requestAnimationFrame(animate);
}

// Benefits of requestAnimationFrame:
// 1. Synchronized with display refresh rate (usually 60fps)
// 2. Pauses when tab is not visible (saves CPU/battery)
// 3. Optimized by browser for smooth animations
// 4. Better performance than setTimeout/setInterval

// Animation loop pattern
class AnimationLoop {
  constructor() {
    this.isRunning = false;
    this.callbacks = [];
  }
  
  start() {
    if (!this.isRunning) {
      this.isRunning = true;
      this.loop();
    }
  }
  
  stop() {
    this.isRunning = false;
  }
  
  addCallback(callback) {
    this.callbacks.push(callback);
  }
  
  loop() {
    if (this.isRunning) {
      this.callbacks.forEach(callback => callback());
      requestAnimationFrame(() => this.loop());
    }
  }
}
```

### Optimization Patterns

#### What is the concept of memoization in JavaScript?
Memoization caches function results to avoid expensive recalculations for the same inputs.

```javascript
// Simple memoization
function memoize(fn) {
  const cache = {};
  return function(...args) {
    const key = JSON.stringify(args);
    if (key in cache) {
      return cache[key];
    }
    const result = fn.apply(this, args);
    cache[key] = result;
    return result;
  };
}

// Usage
const expensiveFunction = (n) => {
  console.log('Computing...');
  return n * n;
};

const memoizedFunction = memoize(expensiveFunction);
console.log(memoizedFunction(5)); // Computing... 25
console.log(memoizedFunction(5)); // 25 (cached)

// Fibonacci with memoization
const fibonacci = memoize((n) => {
  if (n <= 1) return n;
  return fibonacci(n - 1) + fibonacci(n - 2);
});
```

#### What is debounce and throttle in JavaScript?
Debounce delays execution until after calls stop. Throttle limits execution frequency.

```javascript
// Debounce - waits for pause in calls
function debounce(func, delay) {
  let timeoutId;
  return function(...args) {
    clearTimeout(timeoutId);
    timeoutId = setTimeout(() => func.apply(this, args), delay);
  };
}

// Throttle - limits call frequency
function throttle(func, limit) {
  let inThrottle;
  return function(...args) {
    if (!inThrottle) {
      func.apply(this, args);
      inThrottle = true;
      setTimeout(() => inThrottle = false, limit);
    }
  };
}

// Usage examples
const debouncedSearch = debounce((query) => {
  console.log('Searching for:', query);
}, 300);

const throttledScroll = throttle(() => {
  console.log('Scroll event');
}, 100);

// Input search with debounce
input.addEventListener('input', (e) => {
  debouncedSearch(e.target.value);
});

// Scroll with throttle
window.addEventListener('scroll', throttledScroll);
```

## 9. **Error Handling & Debugging** (Error Management)

### Error Handling

#### How do you handle errors in JavaScript?
Use try-catch blocks, error callbacks, and promise rejection handling to manage errors gracefully.

```javascript
// Synchronous error handling
try {
  const result = riskyOperation();
  console.log(result);
} catch (error) {
  console.error('Error occurred:', error.message);
}

// Asynchronous error handling
async function handleAsync() {
  try {
    const data = await fetchData();
    return data;
  } catch (error) {
    console.error('Fetch failed:', error);
    return null;
  }
}

// Promise error handling
fetchData()
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));
```

#### What is try-catch in JavaScript? How does it work?
try-catch executes code in try block and catches any thrown errors in catch block.

```javascript
// Basic try-catch
try {
  // Code that might throw an error
  let result = JSON.parse(invalidJSON);
} catch (error) {
  // Handle the error
  console.log('Parsing failed:', error.message);
} finally {
  // Always executes (optional)
  console.log('Cleanup code');
}

// Multiple catch scenarios
try {
  someOperation();
} catch (error) {
  if (error instanceof TypeError) {
    console.log('Type error occurred');
  } else if (error instanceof ReferenceError) {
    console.log('Reference error occurred');
  } else {
    console.log('Unknown error:', error);
  }
}
```

#### What is the difference between `throw` and `return` in JavaScript?
`throw` stops execution and passes error to catch block. `return` exits function with a value.

```javascript
// Using return - normal function exit
function divide(a, b) {
  if (b === 0) {
    return null; // Function exits, returns null
  }
  return a / b;
}

// Using throw - error propagation
function safeDivide(a, b) {
  if (b === 0) {
    throw new Error('Division by zero'); // Stops execution, throws error
  }
  return a / b;
}

// Usage
const result1 = divide(10, 0); // result1 = null

try {
  const result2 = safeDivide(10, 0); // Throws error
} catch (error) {
  console.log(error.message); // "Division by zero"
}

// Custom error types
class ValidationError extends Error {
  constructor(message) {
    super(message);
    this.name = 'ValidationError';
  }
}

function validateAge(age) {
  if (age < 0) {
    throw new ValidationError('Age cannot be negative');
  }
  return age;
}
```

#### How do you handle exceptions in JavaScript?
Use try-catch for synchronous code, .catch() for promises, and error boundaries for React components.

```javascript
// Global error handling
window.addEventListener('error', (event) => {
  console.error('Global error:', event.error);
});

// Unhandled promise rejection
window.addEventListener('unhandledrejection', (event) => {
  console.error('Unhandled promise rejection:', event.reason);
  event.preventDefault(); // Prevent default browser behavior
});

// Function with error handling
function safeExecute(fn, ...args) {
  try {
    return fn(...args);
  } catch (error) {
    console.error('Function execution failed:', error);
    return null;
  }
}

// Async function error handling
async function processData(data) {
  try {
    const validated = validateData(data);
    const processed = await processValidData(validated);
    return processed;
  } catch (error) {
    if (error instanceof ValidationError) {
      throw new Error(`Validation failed: ${error.message}`);
    }
    throw error; // Re-throw unknown errors
  }
}
```

### Debugging
- What are some common JavaScript debugging techniques?
- What is the difference between `Error` and `TypeError` in JavaScript?

## 10. **Modules & Code Organization** (Modularity)

### Module Systems
- What is the difference between `import` and `require` in JavaScript?
- What is the purpose of the `export` keyword in JavaScript?
- How do you implement modules in JavaScript?
- What is the `default` export in JavaScript modules?
- What are the benefits of using modules in JavaScript?

## 11. **Network & APIs** (Web APIs)

### HTTP Requests
- How do you make an AJAX request in JavaScript?
- What is the Fetch API in JavaScript?
- What are `XMLHttpRequest` and `Fetch` API in JavaScript?
- How do you handle CORS (Cross-Origin Resource Sharing) in JavaScript?

### Web Technologies
- Explain the concept of a single-page application (SPA)
- What are service workers in JavaScript, and how do they work?
- What are Web Workers in JavaScript?

## 12. **Built-in Objects & Methods** (JavaScript APIs)

### Built-in Objects
- What are JavaScript's built-in objects?
- How does `JSON.stringify()` and `JSON.parse()` work in JavaScript?

### Utility Methods
- What is the use of `setTimeout()` and `setInterval()`?
- How do you use regular expressions in JavaScript?
- How do you compare two objects in JavaScript?

## 13. **Testing & Quality** (Testing)

### Testing Concepts
- What is unit testing in JavaScript?
- What are some popular testing frameworks in JavaScript?
- What is TDD (Test-Driven Development)?
- How do you write asynchronous tests in JavaScript?
- What is the difference between `assert` and `expect` in JavaScript testing?

## 14. **Design Patterns & Architecture** (Software Design)

### Programming Paradigms
- What is functional programming in JavaScript? How is it different from object-oriented programming?
- What are design patterns in JavaScript?
- What are decorators in JavaScript?

### Framework Concepts
- What are JavaScript frameworks, and how do they differ from libraries?
- What are the differences between Callback Functions and Higher-Order Components?

## 15. **Event Loop & Execution** (JavaScript Engine)

### Event Loop
- What is the event loop in JavaScript?

### Observables
- What is an observable?
- What are the differences between promises and observables?

## 16. **Security & Best Practices** (Production Ready)

### Security
- What are some security considerations when working with JavaScript?

### Code Quality
- What is the importance of code minification in JavaScript?
- How do you manage JavaScript dependencies in a project?
- What is the importance of modularity in JavaScript development?
- How do you document JavaScript code effectively?
- How do you ensure cross-browser compatibility with JavaScript?
- How do you handle large-scale JavaScript applications?
