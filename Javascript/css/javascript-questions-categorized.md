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

#### What is the difference between `import` and `require` in JavaScript?
`import` is ES6 module syntax (static), `require` is CommonJS (dynamic, Node.js).

```javascript
// ES6 Modules (import) - static, compile-time
import { add, subtract } from './math.js';
import Calculator from './calculator.js'; // default import
import * as MathUtils from './math.js'; // namespace import

// CommonJS (require) - dynamic, runtime
const { add, subtract } = require('./math.js');
const Calculator = require('./calculator.js');
const MathUtils = require('./math.js');

// Key differences:
// import: hoisted, static analysis, tree-shaking
// require: executed in place, dynamic loading

// Dynamic import (ES2020)
const module = await import('./dynamic-module.js');
```

#### What is the purpose of the `export` keyword in JavaScript?
`export` makes functions, objects, or values available to other modules.

```javascript
// Named exports
export const PI = 3.14159;
export function add(a, b) {
  return a + b;
}
export class Calculator {
  multiply(a, b) { return a * b; }
}

// Export list
const subtract = (a, b) => a - b;
const divide = (a, b) => a / b;
export { subtract, divide };

// Export with alias
export { subtract as minus, divide as split };

// Re-export from another module
export { default as MathLib } from './math-lib.js';
export * from './utilities.js';
```

#### How do you implement modules in JavaScript?
Create separate files with exports and import them where needed.

```javascript
// math.js - module file
export const add = (a, b) => a + b;
export const multiply = (a, b) => a * b;
export default class Calculator {
  constructor() {
    this.result = 0;
  }
  calculate(operation, a, b) {
    return operation(a, b);
  }
}

// app.js - using the module
import Calculator, { add, multiply } from './math.js';

const calc = new Calculator();
const sum = calc.calculate(add, 5, 3); // 8
const product = multiply(4, 7); // 28

// CommonJS style (Node.js)
// math.js
module.exports = {
  add: (a, b) => a + b,
  multiply: (a, b) => a * b
};

// app.js
const { add, multiply } = require('./math.js');
```

#### What is the `default` export in JavaScript modules?
Default export allows exporting a single main value from a module.

```javascript
// calculator.js - default export
export default class Calculator {
  add(a, b) { return a + b; }
}

// Or function default export
export default function calculate(a, b, operation) {
  return operation(a, b);
}

// Or value default export
const config = { apiUrl: 'https://api.example.com' };
export default config;

// Importing default exports
import Calculator from './calculator.js'; // No braces
import calculate from './calculate.js';
import config from './config.js';

// Mixed exports
export const helper = () => {}; // named export
export default class Main {} // default export

// Import both
import Main, { helper } from './module.js';
```

#### What are the benefits of using modules in JavaScript?
Modules provide code organization, reusability, encapsulation, and dependency management.

```javascript
// Benefits:
// 1. Code organization - separate concerns
// user.js
export class User {
  constructor(name) { this.name = name; }
}

// api.js
export const fetchUser = async (id) => {
  const response = await fetch(`/api/users/${id}`);
  return response.json();
};

// 2. Reusability - use across projects
// utils.js
export const formatDate = (date) => date.toLocaleDateString();
export const debounce = (fn, delay) => { /* implementation */ };

// 3. Encapsulation - private implementation
// counter.js
let count = 0; // private variable
export const increment = () => ++count;
export const getCount = () => count;
// count is not directly accessible

// 4. Dependency management
// app.js
import { User } from './user.js';
import { fetchUser } from './api.js';
import { formatDate } from './utils.js';

// Clear dependencies, easier testing and maintenance
```

## 11. **Network & APIs** (Web APIs)

### HTTP Requests

#### How do you make an AJAX request in JavaScript?
Use XMLHttpRequest or Fetch API to make asynchronous HTTP requests without page reload.

```javascript
// Using Fetch API (modern approach)
fetch('https://api.example.com/data')
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));

// Using async/await
async function fetchData() {
  try {
    const response = await fetch('https://api.example.com/data');
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Fetch error:', error);
  }
}

// Using XMLHttpRequest (older approach)
const xhr = new XMLHttpRequest();
xhr.open('GET', 'https://api.example.com/data');
xhr.onreadystatechange = function() {
  if (xhr.readyState === 4 && xhr.status === 200) {
    const data = JSON.parse(xhr.responseText);
    console.log(data);
  }
};
xhr.send();
```

#### What is the Fetch API in JavaScript?
Fetch API is a modern interface for making HTTP requests, returning promises.

```javascript
// Basic GET request
fetch('https://api.example.com/users')
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => console.log(data));

// POST request with data
fetch('https://api.example.com/users', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
  },
  body: JSON.stringify({
    name: 'John Doe',
    email: 'john@example.com'
  })
})
.then(response => response.json())
.then(data => console.log('Success:', data));

// With custom headers and options
fetch('https://api.example.com/protected', {
  method: 'GET',
  headers: {
    'Authorization': 'Bearer token123',
    'Accept': 'application/json'
  },
  credentials: 'include' // Include cookies
})
.then(response => response.json());
```

#### What are `XMLHttpRequest` and `Fetch` API in JavaScript?
XMLHttpRequest is the older API for HTTP requests, Fetch is the modern promise-based replacement.

```javascript
// XMLHttpRequest - older, callback-based
const xhr = new XMLHttpRequest();
xhr.open('POST', 'https://api.example.com/data');
xhr.setRequestHeader('Content-Type', 'application/json');
xhr.onload = function() {
  if (xhr.status === 200) {
    const data = JSON.parse(xhr.responseText);
    console.log(data);
  }
};
xhr.onerror = function() {
  console.error('Request failed');
};
xhr.send(JSON.stringify({ key: 'value' }));

// Fetch API - modern, promise-based
fetch('https://api.example.com/data', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({ key: 'value' })
})
.then(response => response.json())
.then(data => console.log(data))
.catch(error => console.error('Request failed:', error));

// Key differences:
// XMLHttpRequest: verbose, callback-based, older browser support
// Fetch: cleaner syntax, promise-based, modern browsers

// Fetch with timeout
const controller = new AbortController();
setTimeout(() => controller.abort(), 5000); // 5 second timeout

fetch('https://api.example.com/data', {
  signal: controller.signal
})
.then(response => response.json())
.catch(error => {
  if (error.name === 'AbortError') {
    console.log('Request timed out');
  }
});
```

#### How do you handle CORS (Cross-Origin Resource Sharing) in JavaScript?
CORS is handled by server configuration, but client can send appropriate headers and handle CORS errors.

```javascript
// CORS is primarily a server-side configuration
// Server must set appropriate headers:
// Access-Control-Allow-Origin: *
// Access-Control-Allow-Methods: GET, POST, PUT, DELETE
// Access-Control-Allow-Headers: Content-Type, Authorization

// Client-side CORS handling
fetch('https://api.different-domain.com/data', {
  method: 'POST',
  mode: 'cors', // Default mode
  credentials: 'include', // Send cookies cross-origin
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({ data: 'value' })
})
.then(response => {
  if (!response.ok) {
    throw new Error('CORS or network error');
  }
  return response.json();
})
.catch(error => {
  console.error('CORS error:', error);
});

// Preflight request handling (automatic for complex requests)
// Browser automatically sends OPTIONS request for:
// - Custom headers
// - Methods other than GET, POST, HEAD
// - Content-Type other than application/x-www-form-urlencoded, multipart/form-data, text/plain

// JSONP workaround for older browsers (avoid if possible)
function jsonp(url, callback) {
  const script = document.createElement('script');
  const callbackName = 'jsonp_callback_' + Math.round(100000 * Math.random());
  
  window[callbackName] = function(data) {
    delete window[callbackName];
    document.body.removeChild(script);
    callback(data);
  };
  
  script.src = url + '?callback=' + callbackName;
  document.body.appendChild(script);
}

// Proxy server approach for development
// Use a proxy server to avoid CORS during development
// Example: webpack dev server proxy configuration
```

### Web Technologies

#### Explain the concept of a single-page application (SPA)
SPA loads a single HTML page and dynamically updates content without full page reloads.

```javascript
// Basic SPA routing example
class Router {
  constructor() {
    this.routes = {};
    window.addEventListener('popstate', () => this.handleRoute());
  }
  
  addRoute(path, handler) {
    this.routes[path] = handler;
  }
  
  navigate(path) {
    history.pushState(null, null, path);
    this.handleRoute();
  }
  
  handleRoute() {
    const path = window.location.pathname;
    const handler = this.routes[path] || this.routes['/404'];
    if (handler) handler();
  }
}

// Usage
const router = new Router();
router.addRoute('/', () => {
  document.getElementById('app').innerHTML = '<h1>Home Page</h1>';
});
router.addRoute('/about', () => {
  document.getElementById('app').innerHTML = '<h1>About Page</h1>';
});

// SPA benefits:
// - Faster navigation (no full page reload)
// - Better user experience
// - Reduced server load
// - Mobile app-like feel

// SPA challenges:
// - SEO complexity
// - Initial load time
// - Browser history management
```

#### What are service workers in JavaScript, and how do they work?
Service workers are scripts that run in background, enabling offline functionality and push notifications.

```javascript
// Register service worker
if ('serviceWorker' in navigator) {
  navigator.serviceWorker.register('/sw.js')
    .then(registration => console.log('SW registered:', registration))
    .catch(error => console.log('SW registration failed:', error));
}

// sw.js - Service Worker file
const CACHE_NAME = 'my-app-v1';
const urlsToCache = [
  '/',
  '/styles/main.css',
  '/scripts/main.js'
];

// Install event - cache resources
self.addEventListener('install', event => {
  event.waitUntil(
    caches.open(CACHE_NAME)
      .then(cache => cache.addAll(urlsToCache))
  );
});

// Fetch event - serve from cache
self.addEventListener('fetch', event => {
  event.respondWith(
    caches.match(event.request)
      .then(response => {
        // Return cached version or fetch from network
        return response || fetch(event.request);
      })
  );
});

// Push notification
self.addEventListener('push', event => {
  const options = {
    body: event.data.text(),
    icon: '/icon.png',
    badge: '/badge.png'
  };
  
  event.waitUntil(
    self.registration.showNotification('New Message', options)
  );
});

// Service worker capabilities:
// - Offline caching
// - Background sync
// - Push notifications
// - Network proxy
```

#### What are Web Workers in JavaScript?
Web Workers run JavaScript in background threads, preventing UI blocking for heavy computations.

```javascript
// Main thread - create worker
const worker = new Worker('worker.js');

// Send data to worker
worker.postMessage({ numbers: [1, 2, 3, 4, 5] });

// Receive result from worker
worker.onmessage = function(event) {
  console.log('Result from worker:', event.data);
};

// Handle worker errors
worker.onerror = function(error) {
  console.error('Worker error:', error);
};

// Terminate worker when done
worker.terminate();

// worker.js - Worker script
self.onmessage = function(event) {
  const { numbers } = event.data;
  
  // Heavy computation (won't block UI)
  const result = numbers.reduce((sum, num) => {
    // Simulate heavy work
    for (let i = 0; i < 1000000; i++) {
      sum += num * Math.random();
    }
    return sum;
  }, 0);
  
  // Send result back to main thread
  self.postMessage(result);
};

// Shared Worker (shared between tabs)
const sharedWorker = new SharedWorker('shared-worker.js');
sharedWorker.port.postMessage('Hello from tab');
sharedWorker.port.onmessage = event => {
  console.log('Shared worker response:', event.data);
};

// Web Worker use cases:
// - Heavy calculations
// - Image/video processing
// - Data parsing
// - Background API calls
// - Cryptographic operations
```

## 12. **Built-in Objects & Methods** (JavaScript APIs)

### Built-in Objects

#### What are JavaScript's built-in objects?
JavaScript provides built-in objects like Object, Array, String, Number, Date, Math, RegExp, and JSON.

```javascript
// Object - base object type
const obj = new Object();
const literal = {}; // Object literal
Object.keys(obj); // Get object keys
Object.values(obj); // Get object values

// Array - ordered list of values
const arr = new Array();
const literal2 = []; // Array literal
arr.push(1); // Add element
arr.length; // Get length

// String - text manipulation
const str = new String('hello');
const literal3 = 'hello'; // String literal
str.toUpperCase(); // 'HELLO'
str.charAt(0); // 'h'

// Number - numeric operations
const num = new Number(42);
const literal4 = 42; // Number literal
Number.isInteger(42); // true
Number.parseFloat('3.14'); // 3.14

// Date - date and time
const now = new Date();
const specific = new Date('2023-01-01');
now.getFullYear(); // Current year
now.toISOString(); // ISO format

// Math - mathematical operations
Math.PI; // 3.14159...
Math.random(); // Random number 0-1
Math.max(1, 2, 3); // 3
Math.floor(3.7); // 3

// RegExp - regular expressions
const regex = new RegExp('pattern');
const literal5 = /pattern/; // Regex literal
regex.test('string'); // Boolean match
'string'.match(/pattern/); // Match result

// JSON - data serialization
JSON.stringify({key: 'value'}); // Convert to string
JSON.parse('{"key":"value"}'); // Parse from string
```

#### How does `JSON.stringify()` and `JSON.parse()` work in JavaScript?
`JSON.stringify()` converts objects to JSON strings, `JSON.parse()` converts JSON strings back to objects.

```javascript
// JSON.stringify() - object to string
const obj = {
  name: 'John',
  age: 30,
  hobbies: ['reading', 'coding']
};

const jsonString = JSON.stringify(obj);
console.log(jsonString); // '{"name":"John","age":30,"hobbies":["reading","coding"]}'

// JSON.parse() - string to object
const parsedObj = JSON.parse(jsonString);
console.log(parsedObj.name); // 'John'

// With replacer function (stringify)
const filtered = JSON.stringify(obj, ['name', 'age']); // Only include specified keys
const transformed = JSON.stringify(obj, (key, value) => {
  return key === 'age' ? value + 1 : value; // Transform age
});

// With reviver function (parse)
const revived = JSON.parse(jsonString, (key, value) => {
  return key === 'age' ? value * 2 : value; // Transform age on parse
});

// With spacing (pretty print)
const prettyJson = JSON.stringify(obj, null, 2);
// {
//   "name": "John",
//   "age": 30,
//   "hobbies": [
//     "reading",
//     "coding"
//   ]
// }

// Handle special values
const special = {
  date: new Date(),
  func: function() {},
  undef: undefined,
  sym: Symbol('test')
};

JSON.stringify(special); // '{"date":"2023-01-01T00:00:00.000Z"}'
// Functions, undefined, and symbols are omitted

// Error handling
try {
  const circular = {};
  circular.self = circular;
  JSON.stringify(circular); // Throws error
} catch (error) {
  console.error('Circular reference error');
}

try {
  JSON.parse('invalid json'); // Throws SyntaxError
} catch (error) {
  console.error('Invalid JSON');
}
```

### Utility Methods

#### What is the use of `setTimeout()` and `setInterval()`?
`setTimeout()` executes code once after a delay, `setInterval()` executes code repeatedly at intervals.

```javascript
// setTimeout - execute once after delay
const timeoutId = setTimeout(() => {
  console.log('Executed after 2 seconds');
}, 2000);

// Cancel timeout
clearTimeout(timeoutId);

// setTimeout with parameters
setTimeout((name, age) => {
  console.log(`Hello ${name}, you are ${age}`);
}, 1000, 'John', 25);

// setInterval - execute repeatedly
const intervalId = setInterval(() => {
  console.log('Executed every 1 second');
}, 1000);

// Cancel interval
clearInterval(intervalId);

// Practical examples
// Countdown timer
let count = 10;
const countdown = setInterval(() => {
  console.log(count);
  count--;
  if (count < 0) {
    clearInterval(countdown);
    console.log('Done!');
  }
}, 1000);

// Delayed function execution
function delayedGreeting(name) {
  return new Promise(resolve => {
    setTimeout(() => {
      resolve(`Hello, ${name}!`);
    }, 1000);
  });
}

// Auto-save functionality
let autoSaveInterval;
function startAutoSave() {
  autoSaveInterval = setInterval(() => {
    saveData();
    console.log('Data auto-saved');
  }, 30000); // Every 30 seconds
}

function stopAutoSave() {
  clearInterval(autoSaveInterval);
}
```

#### How do you use regular expressions in JavaScript?
Regular expressions match and manipulate text patterns using special syntax.

```javascript
// Creating regex
const regex1 = /pattern/flags;
const regex2 = new RegExp('pattern', 'flags');

// Common flags
// g - global (find all matches)
// i - case insensitive
// m - multiline

// Basic pattern matching
const text = 'Hello World 123';
const hasNumbers = /\d+/.test(text); // true
const match = text.match(/\d+/); // ['123']

// String methods with regex
text.search(/world/i); // 6 (case insensitive)
text.replace(/\d+/, 'XXX'); // 'Hello World XXX'
text.split(/\s+/); // ['Hello', 'World', '123']

// Common patterns
const email = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const phone = /^\(?(\d{3})\)?[-. ]?(\d{3})[-. ]?(\d{4})$/;
const url = /^https?:\/\/.+/;

// Validation examples
function validateEmail(email) {
  return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

function extractNumbers(text) {
  return text.match(/\d+/g) || []; // Global match
}

// Replace with function
const formatted = 'hello world'.replace(/(\w+)/g, (match) => {
  return match.charAt(0).toUpperCase() + match.slice(1);
}); // 'Hello World'

// Groups and capturing
const dateRegex = /(\d{4})-(\d{2})-(\d{2})/;
const dateMatch = '2023-12-25'.match(dateRegex);
// dateMatch[0] = '2023-12-25' (full match)
// dateMatch[1] = '2023' (year)
// dateMatch[2] = '12' (month)
// dateMatch[3] = '25' (day)
```

#### How do you compare two objects in JavaScript?
Objects are compared by reference by default; use custom functions for deep comparison.

```javascript
// Reference comparison (default)
const obj1 = { a: 1 };
const obj2 = { a: 1 };
const obj3 = obj1;

console.log(obj1 === obj2); // false (different objects)
console.log(obj1 === obj3); // true (same reference)

// Shallow comparison
function shallowEqual(obj1, obj2) {
  const keys1 = Object.keys(obj1);
  const keys2 = Object.keys(obj2);
  
  if (keys1.length !== keys2.length) {
    return false;
  }
  
  for (let key of keys1) {
    if (obj1[key] !== obj2[key]) {
      return false;
    }
  }
  
  return true;
}

// Deep comparison
function deepEqual(obj1, obj2) {
  if (obj1 === obj2) return true;
  
  if (obj1 == null || obj2 == null) return false;
  
  if (typeof obj1 !== 'object' || typeof obj2 !== 'object') {
    return obj1 === obj2;
  }
  
  const keys1 = Object.keys(obj1);
  const keys2 = Object.keys(obj2);
  
  if (keys1.length !== keys2.length) return false;
  
  for (let key of keys1) {
    if (!keys2.includes(key)) return false;
    if (!deepEqual(obj1[key], obj2[key])) return false;
  }
  
  return true;
}

// Usage examples
const user1 = { name: 'John', age: 30, hobbies: ['reading'] };
const user2 = { name: 'John', age: 30, hobbies: ['reading'] };

console.log(shallowEqual(user1, user2)); // false (hobbies are different arrays)
console.log(deepEqual(user1, user2)); // true

// JSON comparison (limited)
function jsonEqual(obj1, obj2) {
  return JSON.stringify(obj1) === JSON.stringify(obj2);
}
// Note: JSON comparison has limitations with property order and special values

// Using Lodash library (external)
// const _ = require('lodash');
// _.isEqual(obj1, obj2); // Deep comparison
```

## 13. **Testing & Quality** (Testing)

### Testing Concepts

#### What is unit testing in JavaScript?
Unit testing verifies individual functions or components work correctly in isolation.

```javascript
// Function to test
function add(a, b) {
  return a + b;
}

function divide(a, b) {
  if (b === 0) throw new Error('Division by zero');
  return a / b;
}

// Simple test without framework
function testAdd() {
  const result = add(2, 3);
  if (result !== 5) {
    throw new Error(`Expected 5, got ${result}`);
  }
  console.log('✓ add test passed');
}

// Test with Jest framework
describe('Math functions', () => {
  test('should add two numbers', () => {
    expect(add(2, 3)).toBe(5);
    expect(add(-1, 1)).toBe(0);
  });
  
  test('should divide two numbers', () => {
    expect(divide(10, 2)).toBe(5);
  });
  
  test('should throw error for division by zero', () => {
    expect(() => divide(10, 0)).toThrow('Division by zero');
  });
});

// Testing class methods
class Calculator {
  constructor() {
    this.result = 0;
  }
  
  add(value) {
    this.result += value;
    return this;
  }
  
  getResult() {
    return this.result;
  }
}

// Unit test for class
test('Calculator should add values', () => {
  const calc = new Calculator();
  calc.add(5).add(3);
  expect(calc.getResult()).toBe(8);
});
```

#### What are some popular testing frameworks in JavaScript?
Popular frameworks include Jest, Mocha, Jasmine, and Vitest for different testing needs.

```javascript
// Jest - most popular, built-in assertions
describe('Jest example', () => {
  test('should work with arrays', () => {
    expect([1, 2, 3]).toContain(2);
    expect([1, 2, 3]).toHaveLength(3);
  });
});

// Mocha with Chai - flexible, requires assertion library
const { expect } = require('chai');

describe('Mocha with Chai', () => {
  it('should work with objects', () => {
    expect({ name: 'John' }).to.have.property('name');
    expect({ name: 'John' }).to.deep.equal({ name: 'John' });
  });
});

// Jasmine - behavior-driven development
describe('Jasmine example', () => {
  it('should spy on functions', () => {
    const obj = { method: () => 'original' };
    spyOn(obj, 'method').and.returnValue('mocked');
    expect(obj.method()).toBe('mocked');
  });
});

// Vitest - fast, Vite-powered
import { describe, it, expect } from 'vitest';

describe('Vitest example', () => {
  it('should work like Jest', () => {
    expect(true).toBe(true);
  });
});

// Framework comparison:
// Jest: Zero config, built-in mocking, snapshot testing
// Mocha: Flexible, requires separate assertion library
// Jasmine: BDD style, built-in spies
// Vitest: Fast, modern, TypeScript support
```

#### What is TDD (Test-Driven Development)?
TDD writes tests first, then code to make tests pass, following Red-Green-Refactor cycle.

```javascript
// TDD Cycle: Red (fail) -> Green (pass) -> Refactor

// Step 1: Write failing test (Red)
test('should calculate user age from birth year', () => {
  const user = new User('John', 1990);
  expect(user.getAge()).toBe(34); // This will fail initially
});

// Step 2: Write minimal code to pass (Green)
class User {
  constructor(name, birthYear) {
    this.name = name;
    this.birthYear = birthYear;
  }
  
  getAge() {
    return 2024 - this.birthYear; // Minimal implementation
  }
}

// Step 3: Refactor for better code
class User {
  constructor(name, birthYear) {
    this.name = name;
    this.birthYear = birthYear;
  }
  
  getAge() {
    const currentYear = new Date().getFullYear();
    return currentYear - this.birthYear;
  }
}

// TDD Example: Building a shopping cart
// Test 1: Empty cart
test('new cart should be empty', () => {
  const cart = new ShoppingCart();
  expect(cart.getTotal()).toBe(0);
  expect(cart.getItemCount()).toBe(0);
});

// Test 2: Add item
test('should add item to cart', () => {
  const cart = new ShoppingCart();
  cart.addItem({ name: 'Book', price: 10 });
  expect(cart.getTotal()).toBe(10);
  expect(cart.getItemCount()).toBe(1);
});

// Implementation after tests
class ShoppingCart {
  constructor() {
    this.items = [];
  }
  
  addItem(item) {
    this.items.push(item);
  }
  
  getTotal() {
    return this.items.reduce((sum, item) => sum + item.price, 0);
  }
  
  getItemCount() {
    return this.items.length;
  }
}
```

#### How do you write asynchronous tests in JavaScript?
Use async/await, return promises, or done callbacks for testing asynchronous code.

```javascript
// Async function to test
async function fetchUser(id) {
  const response = await fetch(`/api/users/${id}`);
  return response.json();
}

function fetchUserCallback(id, callback) {
  setTimeout(() => {
    callback(null, { id, name: 'John' });
  }, 100);
}

// Method 1: async/await
test('should fetch user with async/await', async () => {
  const user = await fetchUser(1);
  expect(user.id).toBe(1);
});

// Method 2: return promise
test('should fetch user with promise', () => {
  return fetchUser(1).then(user => {
    expect(user.id).toBe(1);
  });
});

// Method 3: done callback (older style)
test('should fetch user with callback', (done) => {
  fetchUserCallback(1, (err, user) => {
    expect(err).toBeNull();
    expect(user.name).toBe('John');
    done(); // Signal test completion
  });
});

// Testing promises with resolves/rejects
test('should resolve promise', async () => {
  await expect(fetchUser(1)).resolves.toHaveProperty('id', 1);
});

test('should reject promise', async () => {
  await expect(fetchUser(-1)).rejects.toThrow('User not found');
});

// Mocking async functions
test('should mock async function', async () => {
  const mockFetch = jest.fn().mockResolvedValue({
    json: () => Promise.resolve({ id: 1, name: 'John' })
  });
  
  global.fetch = mockFetch;
  const user = await fetchUser(1);
  
  expect(mockFetch).toHaveBeenCalledWith('/api/users/1');
  expect(user.name).toBe('John');
});
```

#### What is the difference between `assert` and `expect` in JavaScript testing?
`assert` throws errors on failure, `expect` provides fluent API with better error messages.

```javascript
// Node.js built-in assert
const assert = require('assert');

// assert - throws AssertionError on failure
function testWithAssert() {
  assert.strictEqual(2 + 2, 4); // Passes
  assert.strictEqual(2 + 2, 5); // Throws AssertionError
  assert.ok(true); // Passes
  assert.deepStrictEqual([1, 2], [1, 2]); // Deep comparison
}

// expect - fluent API, better error messages
function testWithExpect() {
  expect(2 + 2).toBe(4); // Passes
  expect(2 + 2).not.toBe(5); // Negation
  expect([1, 2, 3]).toContain(2); // Array contains
  expect({ name: 'John' }).toHaveProperty('name'); // Object property
}

// Comparison examples
// Assert style
try {
  assert.strictEqual('hello', 'world');
} catch (error) {
  console.log(error.message); // "Expected values to be strictly equal"
}

// Expect style (Jest)
test('expect provides better messages', () => {
  expect('hello').toBe('world');
  // Error: expect(received).toBe(expected)
  // Expected: "world"
  // Received: "hello"
});

// Custom assert function
function customAssert(condition, message) {
  if (!condition) {
    throw new Error(message || 'Assertion failed');
  }
}

// Usage patterns
// Assert - procedural style
assert.strictEqual(add(2, 3), 5);
assert.throws(() => divide(1, 0));

// Expect - fluent/chainable style
expect(add(2, 3)).toBe(5);
expect(() => divide(1, 0)).toThrow();
expect(users).toHaveLength(3);
expect(response).toMatchObject({ status: 200 });

// Key differences:
// assert: Built-in Node.js, throws errors, minimal API
// expect: Framework-specific, fluent API, better error messages, more matchers
```

## 14. **Design Patterns & Architecture** (Software Design)

### Programming Paradigms

#### What is functional programming in JavaScript? How is it different from object-oriented programming?
Functional programming uses pure functions and immutability, OOP uses objects and methods with state.

```javascript
// Functional Programming - pure functions, no side effects
const add = (a, b) => a + b;
const multiply = (a, b) => a * b;
const compose = (f, g) => (x) => f(g(x));

// Immutable data transformations
const numbers = [1, 2, 3, 4, 5];
const doubled = numbers.map(x => x * 2); // [2, 4, 6, 8, 10]
const evens = numbers.filter(x => x % 2 === 0); // [2, 4]
const sum = numbers.reduce((acc, x) => acc + x, 0); // 15

// Higher-order functions
const createMultiplier = (factor) => (number) => number * factor;
const double = createMultiplier(2);
const triple = createMultiplier(3);

// Object-Oriented Programming - objects with state and methods
class Calculator {
  constructor() {
    this.result = 0; // State
  }
  
  add(value) {
    this.result += value; // Mutates state
    return this;
  }
  
  multiply(value) {
    this.result *= value;
    return this;
  }
  
  getResult() {
    return this.result;
  }
}

// Usage comparison
// Functional approach
const fpResult = compose(
  x => x * 2,
  x => x + 5
)(10); // (10 + 5) * 2 = 30

// OOP approach
const calc = new Calculator();
const oopResult = calc.add(10).add(5).multiply(2).getResult(); // 30

// Key differences:
// FP: Immutable, pure functions, no side effects, composable
// OOP: Mutable state, encapsulation, inheritance, polymorphism

// Functional style with immutability
const updateUser = (user, changes) => ({ ...user, ...changes });
const user = { name: 'John', age: 30 };
const updatedUser = updateUser(user, { age: 31 }); // Original unchanged

// OOP style with mutation
class User {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
  
  updateAge(newAge) {
    this.age = newAge; // Mutates object
  }
}
```

#### What are design patterns in JavaScript?
Design patterns are reusable solutions to common programming problems.

```javascript
// 1. Singleton Pattern - single instance
class Singleton {
  constructor() {
    if (Singleton.instance) {
      return Singleton.instance;
    }
    Singleton.instance = this;
  }
}

const instance1 = new Singleton();
const instance2 = new Singleton();
console.log(instance1 === instance2); // true

// 2. Factory Pattern - create objects
class CarFactory {
  static createCar(type) {
    switch (type) {
      case 'sedan': return new Sedan();
      case 'suv': return new SUV();
      default: throw new Error('Unknown car type');
    }
  }
}

// 3. Observer Pattern - event system
class EventEmitter {
  constructor() {
    this.events = {};
  }
  
  on(event, callback) {
    if (!this.events[event]) {
      this.events[event] = [];
    }
    this.events[event].push(callback);
  }
  
  emit(event, data) {
    if (this.events[event]) {
      this.events[event].forEach(callback => callback(data));
    }
  }
}

// 4. Module Pattern - encapsulation
const CounterModule = (() => {
  let count = 0; // Private variable
  
  return {
    increment: () => ++count,
    decrement: () => --count,
    getCount: () => count
  };
})();

// 5. Strategy Pattern - interchangeable algorithms
class PaymentProcessor {
  constructor(strategy) {
    this.strategy = strategy;
  }
  
  process(amount) {
    return this.strategy.pay(amount);
  }
}

const creditCard = { pay: (amount) => `Paid $${amount} with credit card` };
const paypal = { pay: (amount) => `Paid $${amount} with PayPal` };

// 6. Decorator Pattern - add functionality
function withLogging(fn) {
  return function(...args) {
    console.log(`Calling ${fn.name} with`, args);
    return fn.apply(this, args);
  };
}

const add = (a, b) => a + b;
const loggedAdd = withLogging(add);
```

#### What are decorators in JavaScript?
Decorators modify or enhance classes and methods using the @ syntax (experimental feature).

```javascript
// Method decorator
function log(target, propertyName, descriptor) {
  const method = descriptor.value;
  
  descriptor.value = function(...args) {
    console.log(`Calling ${propertyName} with`, args);
    const result = method.apply(this, args);
    console.log(`Result:`, result);
    return result;
  };
}

// Class decorator
function sealed(constructor) {
  Object.seal(constructor);
  Object.seal(constructor.prototype);
}

// Usage (requires experimental decorator support)
@sealed
class Calculator {
  @log
  add(a, b) {
    return a + b;
  }
  
  @log
  multiply(a, b) {
    return a * b;
  }
}

// Manual decorator implementation (current JavaScript)
function createDecorator(decoratorFn) {
  return function(target, propertyName, descriptor) {
    return decoratorFn(target, propertyName, descriptor);
  };
}

// Timing decorator
function timing(target, propertyName, descriptor) {
  const method = descriptor.value;
  
  descriptor.value = function(...args) {
    const start = performance.now();
    const result = method.apply(this, args);
    const end = performance.now();
    console.log(`${propertyName} took ${end - start} milliseconds`);
    return result;
  };
}

// Validation decorator
function validate(rules) {
  return function(target, propertyName, descriptor) {
    const method = descriptor.value;
    
    descriptor.value = function(...args) {
      for (let i = 0; i < rules.length; i++) {
        if (!rules[i](args[i])) {
          throw new Error(`Validation failed for argument ${i}`);
        }
      }
      return method.apply(this, args);
    };
  };
}

// Property decorator
function readonly(target, propertyName) {
  Object.defineProperty(target, propertyName, {
    writable: false,
    configurable: false
  });
}

// Functional decorator approach (current JavaScript)
const withRetry = (retries) => (fn) => {
  return async function(...args) {
    for (let i = 0; i <= retries; i++) {
      try {
        return await fn.apply(this, args);
      } catch (error) {
        if (i === retries) throw error;
        console.log(`Retry ${i + 1}/${retries}`);
      }
    }
  };
};

// Usage
const fetchWithRetry = withRetry(3)(fetch);
```

### Framework Concepts

#### What are JavaScript frameworks, and how do they differ from libraries?
Frameworks control application flow and call your code, libraries are tools you call from your code.

```javascript
// Library - you call library functions
// jQuery (library)
$('#button').click(function() {
  $('#content').hide(); // You control when to call jQuery
});

// Lodash (library)
const result = _.map([1, 2, 3], x => x * 2); // You call lodash functions

// Framework - framework calls your code
// React (framework)
function MyComponent() {
  const [count, setCount] = useState(0); // React calls your component
  
  return (
    <button onClick={() => setCount(count + 1)}>
      Count: {count}
    </button>
  );
}

// Angular (framework)
@Component({
  selector: 'app-counter',
  template: '<button (click)="increment()">{{count}}</button>'
})
class CounterComponent {
  count = 0;
  
  increment() { // Angular calls your methods
    this.count++;
  }
}

// Vue (framework)
const app = Vue.createApp({
  data() {
    return { count: 0 };
  },
  methods: {
    increment() { // Vue calls your methods
      this.count++;
    }
  }
});

// Key differences:
// Library: You are in control, call library when needed
// Framework: Framework is in control, calls your code when needed

// Inversion of Control example
// Library approach - you control the flow
function processData() {
  const data = fetchData(); // You call library
  const processed = transformData(data); // You call library
  saveData(processed); // You call library
}

// Framework approach - framework controls the flow
class DataProcessor {
  async process() {
    // Framework calls these methods at appropriate times
    const data = await this.fetchData();
    const processed = this.transformData(data);
    await this.saveData(processed);
  }
  
  fetchData() { /* your implementation */ }
  transformData(data) { /* your implementation */ }
  saveData(data) { /* your implementation */ }
}

// Examples:
// Libraries: Lodash, jQuery, Axios, Moment.js
// Frameworks: React, Angular, Vue, Express, Next.js
```

#### What are the differences between Callback Functions and Higher-Order Components?
Callback functions are passed to other functions, Higher-Order Components wrap React components with additional functionality.

```javascript
// Callback Functions - functions passed as arguments
function processArray(arr, callback) {
  return arr.map(callback); // callback is called for each element
}

const numbers = [1, 2, 3, 4, 5];
const doubled = processArray(numbers, x => x * 2); // Callback function
const squared = processArray(numbers, x => x * x); // Different callback

// Event handling with callbacks
button.addEventListener('click', function(event) {
  console.log('Button clicked!'); // This is a callback function
});

// Async callbacks
setTimeout(() => {
  console.log('Timer finished'); // Callback executed after delay
}, 1000);

// Higher-Order Components (HOCs) - React pattern
// HOC takes a component and returns a new enhanced component
function withLoading(WrappedComponent) {
  return function LoadingComponent(props) {
    if (props.isLoading) {
      return <div>Loading...</div>;
    }
    return <WrappedComponent {...props} />;
  };
}

// Original component
function UserProfile({ user }) {
  return <div>Hello, {user.name}!</div>;
}

// Enhanced component with loading functionality
const UserProfileWithLoading = withLoading(UserProfile);

// Usage
<UserProfileWithLoading user={user} isLoading={loading} />

// Another HOC example - authentication
function withAuth(WrappedComponent) {
  return function AuthComponent(props) {
    const { isAuthenticated } = props;
    
    if (!isAuthenticated) {
      return <div>Please log in</div>;
    }
    
    return <WrappedComponent {...props} />;
  };
}

// HOC for data fetching
function withData(url) {
  return function(WrappedComponent) {
    return function DataComponent(props) {
      const [data, setData] = useState(null);
      const [loading, setLoading] = useState(true);
      
      useEffect(() => {
        fetch(url)
          .then(response => response.json())
          .then(data => {
            setData(data);
            setLoading(false);
          });
      }, []);
      
      return (
        <WrappedComponent 
          {...props} 
          data={data} 
          loading={loading} 
        />
      );
    };
  };
}

// Usage
const UserListWithData = withData('/api/users')(UserList);

// Key differences:
// Callback Functions:
// - General JavaScript concept
// - Functions passed as arguments
// - Called by other functions
// - Used for events, async operations, array methods

// Higher-Order Components:
// - React-specific pattern
// - Components that wrap other components
// - Add functionality to components
// - Used for cross-cutting concerns (auth, loading, data fetching)

// Modern alternatives to HOCs
// Custom Hooks (preferred in modern React)
function useAuth() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  // auth logic
  return { isAuthenticated, login, logout };
}

function useData(url) {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  // data fetching logic
  return { data, loading };
}

// Usage with hooks (cleaner than HOCs)
function UserProfile() {
  const { isAuthenticated } = useAuth();
  const { data, loading } = useData('/api/user');
  
  if (!isAuthenticated) return <div>Please log in</div>;
  if (loading) return <div>Loading...</div>;
  
  return <div>Hello, {data.name}!</div>;
}
```

## 15. **Event Loop & Execution** (JavaScript Engine)

### Event Loop

#### What is the event loop in JavaScript?
The event loop manages asynchronous operations by moving completed tasks from queues to the call stack when it's empty.

```javascript
// Event loop components:
// 1. Call Stack - where code executes
// 2. Web APIs - setTimeout, DOM events, fetch
// 3. Callback Queue - completed async operations
// 4. Microtask Queue - promises, queueMicrotask

// Example execution order
console.log('1'); // Call stack - executes immediately

setTimeout(() => {
  console.log('2'); // Callback queue - executes after stack is empty
}, 0);

Promise.resolve().then(() => {
  console.log('3'); // Microtask queue - higher priority than callback queue
});

console.log('4'); // Call stack - executes immediately

// Output: 1, 4, 3, 2

// Detailed example
function demonstrateEventLoop() {
  console.log('Start'); // 1. Call stack
  
  setTimeout(() => {
    console.log('Timeout 1'); // 5. Callback queue
  }, 0);
  
  Promise.resolve().then(() => {
    console.log('Promise 1'); // 3. Microtask queue (higher priority)
  }).then(() => {
    console.log('Promise 2'); // 4. Microtask queue
  });
  
  setTimeout(() => {
    console.log('Timeout 2'); // 6. Callback queue
  }, 0);
  
  console.log('End'); // 2. Call stack
}

// Output: Start, End, Promise 1, Promise 2, Timeout 1, Timeout 2

// Event loop phases:
// 1. Execute all synchronous code (call stack)
// 2. Process all microtasks (promises, queueMicrotask)
// 3. Process one callback from callback queue
// 4. Repeat

// Blocking vs non-blocking
// Blocking (bad) - blocks event loop
function blockingOperation() {
  const start = Date.now();
  while (Date.now() - start < 3000) {
    // Blocks for 3 seconds - nothing else can run
  }
  console.log('Blocking done');
}

// Non-blocking (good) - uses event loop
function nonBlockingOperation() {
  setTimeout(() => {
    console.log('Non-blocking done');
  }, 3000);
}

// Microtask vs Macrotask
setTimeout(() => console.log('Macrotask 1'), 0); // Macrotask (callback queue)
Promise.resolve().then(() => console.log('Microtask 1')); // Microtask (higher priority)
setTimeout(() => console.log('Macrotask 2'), 0); // Macrotask
Promise.resolve().then(() => console.log('Microtask 2')); // Microtask

// Output: Microtask 1, Microtask 2, Macrotask 1, Macrotask 2

// Event loop with async/await
async function asyncExample() {
  console.log('1');
  
  await Promise.resolve();
  console.log('2'); // Runs as microtask
  
  await new Promise(resolve => setTimeout(resolve, 0));
  console.log('3'); // Runs after timeout (macrotask)
}

console.log('Start');
asyncExample();
console.log('End');

// Output: Start, 1, End, 2, 3
```

### Observables

#### What is an observable?
An observable is a data stream that can emit multiple values over time and can be subscribed to.

```javascript
// Simple Observable implementation
class Observable {
  constructor(subscriber) {
    this.subscriber = subscriber;
  }
  
  subscribe(observer) {
    return this.subscriber(observer);
  }
}

// Creating an observable
const numberStream = new Observable(observer => {
  observer.next(1);
  observer.next(2);
  observer.next(3);
  observer.complete();
});

// Subscribing to observable
numberStream.subscribe({
  next: value => console.log('Received:', value),
  complete: () => console.log('Stream completed')
});
// Output: Received: 1, Received: 2, Received: 3, Stream completed

// Observable with async data
const timerStream = new Observable(observer => {
  let count = 0;
  const interval = setInterval(() => {
    observer.next(count++);
    if (count > 3) {
      observer.complete();
      clearInterval(interval);
    }
  }, 1000);
  
  // Return cleanup function
  return () => clearInterval(interval);
});

// RxJS Observable (popular library)
// import { Observable, of, interval } from 'rxjs';

// Simple observable
const simple$ = of(1, 2, 3);
simple$.subscribe(value => console.log(value));

// Interval observable
const timer$ = interval(1000);
const subscription = timer$.subscribe(value => console.log('Timer:', value));

// Unsubscribe after 5 seconds
setTimeout(() => subscription.unsubscribe(), 5000);

// Observable from events
const clickStream = new Observable(observer => {
  const button = document.getElementById('myButton');
  const handler = event => observer.next(event);
  
  button.addEventListener('click', handler);
  
  // Cleanup
  return () => button.removeEventListener('click', handler);
});

// Observable characteristics:
// - Lazy: doesn't execute until subscribed
// - Can emit multiple values
// - Can be cancelled (unsubscribed)
// - Supports operators for transformation
```

#### What are the differences between promises and observables?
Promises handle single async values, observables handle streams of multiple values over time.

```javascript
// Promise - single value, eager execution
const promise = new Promise(resolve => {
  console.log('Promise executing'); // Runs immediately
  setTimeout(() => resolve('Promise result'), 1000);
});

promise.then(value => console.log(value)); // 'Promise result'

// Observable - multiple values, lazy execution
const observable = new Observable(observer => {
  console.log('Observable executing'); // Only runs when subscribed
  observer.next('First value');
  setTimeout(() => observer.next('Second value'), 1000);
  setTimeout(() => observer.complete(), 2000);
});

observable.subscribe(value => console.log(value));

// Key differences comparison

// 1. Single vs Multiple values
// Promise - resolves once
fetch('/api/user').then(user => console.log(user));

// Observable - can emit multiple times
const userUpdates$ = new Observable(observer => {
  // Emit initial user
  observer.next({ name: 'John', status: 'online' });
  
  // Emit updates over time
  setTimeout(() => observer.next({ name: 'John', status: 'away' }), 5000);
  setTimeout(() => observer.next({ name: 'John', status: 'offline' }), 10000);
});

// 2. Eager vs Lazy execution
// Promise - starts immediately
const eagerPromise = new Promise(resolve => {
  console.log('Promise started'); // Logs immediately
  resolve('done');
});

// Observable - starts only when subscribed
const lazyObservable = new Observable(observer => {
  console.log('Observable started'); // Only logs when subscribed
  observer.next('done');
});

lazyObservable.subscribe(); // Now it logs

// 3. Cancellation
// Promise - cannot be cancelled
const uncancellablePromise = fetch('/api/data');
// No way to cancel this request

// Observable - can be unsubscribed
const cancellableObservable = new Observable(observer => {
  const timeoutId = setTimeout(() => {
    observer.next('Data loaded');
  }, 5000);
  
  return () => clearTimeout(timeoutId); // Cleanup function
});

const subscription = cancellableObservable.subscribe();
subscription.unsubscribe(); // Cancels the operation

// 4. Error handling
// Promise - single catch
promise
  .then(value => console.log(value))
  .catch(error => console.error(error));

// Observable - can recover and continue
observable.subscribe({
  next: value => console.log(value),
  error: error => console.error(error),
  complete: () => console.log('Done')
});

// 5. Operators and transformation
// Promise - limited chaining
promise
  .then(value => value.toUpperCase())
  .then(value => value + '!');

// Observable - rich operator ecosystem (RxJS)
// observable
//   .pipe(
//     map(value => value.toUpperCase()),
//     filter(value => value.length > 5),
//     debounceTime(300)
//   )
//   .subscribe(value => console.log(value));

// Summary:
// Promise: Single value, eager, not cancellable, simpler
// Observable: Multiple values, lazy, cancellable, more powerful

// When to use:
// Promise: HTTP requests, one-time async operations
// Observable: Event streams, real-time data, complex async flows
```

## 16. **Security & Best Practices** (Production Ready)

### Security

#### What are some security considerations when working with JavaScript?
Key security concerns include XSS, CSRF, data validation, secure storage, and dependency vulnerabilities.

```javascript
// 1. Cross-Site Scripting (XSS) Prevention
// Bad - vulnerable to XSS
document.getElementById('output').innerHTML = userInput; // Dangerous!

// Good - escape HTML
function escapeHtml(text) {
  const div = document.createElement('div');
  div.textContent = text;
  return div.innerHTML;
}

document.getElementById('output').innerHTML = escapeHtml(userInput);

// Better - use textContent
document.getElementById('output').textContent = userInput;

// 2. Input Validation and Sanitization
// Always validate on both client and server
function validateEmail(email) {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(email) && email.length <= 254;
}

function sanitizeInput(input) {
  return input.trim().replace(/[<>"'&]/g, '');
}

// 3. Secure Data Storage
// Bad - sensitive data in localStorage
localStorage.setItem('password', userPassword); // Never do this!

// Good - use secure storage for sensitive data
// Store tokens securely, use httpOnly cookies for auth
const token = getSecureToken(); // From secure source

// 4. HTTPS and Secure Communication
// Always use HTTPS for production
fetch('https://api.example.com/data', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${token}`
  },
  body: JSON.stringify(data)
});

// 5. Content Security Policy (CSP)
// Set CSP headers to prevent XSS
// <meta http-equiv="Content-Security-Policy" 
//       content="default-src 'self'; script-src 'self'">

// 6. Avoid eval() and similar functions
// Bad - code injection risk
eval(userCode); // Extremely dangerous!
new Function(userCode)(); // Also dangerous

// Good - use safe alternatives
const safeData = JSON.parse(jsonString); // For JSON data

// 7. Secure Authentication
// Implement proper session management
class AuthManager {
  static setToken(token) {
    // Use httpOnly cookies or secure storage
    document.cookie = `token=${token}; Secure; HttpOnly; SameSite=Strict`;
  }
  
  static logout() {
    // Clear all auth data
    document.cookie = 'token=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
    localStorage.clear();
    sessionStorage.clear();
  }
}

// 8. Dependency Security
// Regularly audit dependencies
// npm audit
// Use tools like Snyk or GitHub security alerts

// 9. Error Handling - Don't expose sensitive info
// Bad - exposes internal details
try {
  processPayment(cardData);
} catch (error) {
  alert(error.message); // Might expose sensitive info
}

// Good - generic error messages
try {
  processPayment(cardData);
} catch (error) {
  console.error('Payment error:', error); // Log for debugging
  alert('Payment failed. Please try again.'); // Generic message
}

// 10. Rate Limiting and DoS Protection
class RateLimiter {
  constructor(maxRequests = 100, timeWindow = 60000) {
    this.requests = new Map();
    this.maxRequests = maxRequests;
    this.timeWindow = timeWindow;
  }
  
  isAllowed(identifier) {
    const now = Date.now();
    const userRequests = this.requests.get(identifier) || [];
    
    // Remove old requests
    const validRequests = userRequests.filter(
      time => now - time < this.timeWindow
    );
    
    if (validRequests.length >= this.maxRequests) {
      return false;
    }
    
    validRequests.push(now);
    this.requests.set(identifier, validRequests);
    return true;
  }
}

// 11. Secure File Uploads
function validateFileUpload(file) {
  const allowedTypes = ['image/jpeg', 'image/png', 'image/gif'];
  const maxSize = 5 * 1024 * 1024; // 5MB
  
  if (!allowedTypes.includes(file.type)) {
    throw new Error('Invalid file type');
  }
  
  if (file.size > maxSize) {
    throw new Error('File too large');
  }
  
  return true;
}

// 12. Prevent Clickjacking
// Use X-Frame-Options header or CSP frame-ancestors
// X-Frame-Options: DENY
// Content-Security-Policy: frame-ancestors 'none'

// Security checklist:
// ✓ Validate all inputs
// ✓ Escape output
// ✓ Use HTTPS
// ✓ Implement CSP
// ✓ Secure authentication
// ✓ Regular dependency audits
// ✓ Error handling
// ✓ Rate limiting
// ✓ Secure file handling
// ✓ Prevent clickjacking
```

### Code Quality
- What is the importance of code minification in JavaScript?
- How do you manage JavaScript dependencies in a project?
- What is the importance of modularity in JavaScript development?
- How do you document JavaScript code effectively?
- How do you ensure cross-browser compatibility with JavaScript?
- How do you handle large-scale JavaScript applications?
