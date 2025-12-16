# Java Interview Questions - Basic Concepts

## 1. What is Java and what are its key features?

**Answer:**
Java is a high-level, object-oriented programming language developed by Sun Microsystems (now Oracle).

**Key Features:**
- **Platform Independent** - Write once, run anywhere (WORA)
- **Object-Oriented** - Everything is an object
- **Simple and Secure** - No pointers, automatic memory management
- **Multithreaded** - Can handle multiple tasks simultaneously
- **Robust** - Strong memory management and exception handling

**Example:**
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

---

## 2. Explain the difference between JDK, JRE, and JVM.

**Answer:**
- **JVM (Java Virtual Machine)** - Runtime environment that executes Java bytecode
- **JRE (Java Runtime Environment)** - JVM + libraries needed to run Java applications
- **JDK (Java Development Kit)** - JRE + development tools (compiler, debugger)

**Simple way to remember:**
- JDK = Development tools + JRE
- JRE = JVM + Runtime libraries
- JVM = Executes bytecode

---

## 3. What are the main principles of Object-Oriented Programming?

**Answer:**
The four main principles are:
- **Encapsulation** - Bundling data and methods together
- **Inheritance** - Creating new classes based on existing ones
- **Polymorphism** - One interface, multiple implementations
- **Abstraction** - Hiding complex implementation details

**Example:**
```java
// Encapsulation
class Car {
    private String engine; // Hidden data
    
    public void start() { // Public method
        engine = "running";
    }
}
```

---

## 4. What is polymorphism? Explain with examples.

**Answer:**
Polymorphism means "many forms" - same method name behaving differently based on the object.

**Two types:**
- **Compile-time** - Method overloading
- **Runtime** - Method overriding

**Examples:**
```java
// Method Overloading (Compile-time)
class Calculator {
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; }
}

// Method Overriding (Runtime)
class Animal {
    public void sound() { System.out.println("Animal sound"); }
}

class Dog extends Animal {
    public void sound() { System.out.println("Bark"); }
}

class Cat extends Animal {
    public void sound() { System.out.println("Meow"); }
}
```

---

## 5. What is encapsulation and how is it implemented in Java?

**Answer:**
Encapsulation is wrapping data and methods together and controlling access to them.

**Implementation:**
- Make variables **private**
- Provide **public getter/setter** methods
- Control access through methods

**Example:**
```java
class Student {
    private String name;
    private int age;
    
    // Getter
    public String getName() {
        return name;
    }
    
    // Setter with validation
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
```

---

## 6. What is inheritance and what are its types?

**Answer:**
Inheritance allows a class to acquire properties and methods from another class.

**Types in Java:**
- **Single** - One child, one parent
- **Multilevel** - Chain of inheritance
- **Hierarchical** - Multiple children, one parent

**Note:** Java doesn't support multiple inheritance with classes (but supports with interfaces)

**Example:**
```java
// Single Inheritance
class Vehicle {
    protected String brand = "Ford";
}

class Car extends Vehicle {
    private String model = "Mustang";
    
    public void display() {
        System.out.println(brand + " " + model);
    }
}
```

---

## 7. What is an abstract class?

**Answer:**
An abstract class is a class that cannot be instantiated and may contain abstract methods (methods without implementation).

**Key Points:**
- Use **abstract** keyword
- Can have both abstract and concrete methods
- Cannot create objects directly
- Must be extended by subclasses

**Example:**
```java
abstract class Shape {
    // Abstract method
    public abstract void draw();
    
    // Concrete method
    public void display() {
        System.out.println("This is a shape");
    }
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

// Usage
Circle c = new Circle(); // Valid
// Shape s = new Shape(); // Error - cannot instantiate
```

# Java Interview Questions - Data Types and Variables

## 1. What are primitive data types in Java?

**Answer:**
Primitive data types are the basic building blocks that store simple values directly in memory.

**8 Primitive Types:**
- **byte** - 8-bit integer (-128 to 127)
- **short** - 16-bit integer (-32,768 to 32,767)
- **int** - 32-bit integer (most commonly used)
- **long** - 64-bit integer (add 'L' suffix)
- **float** - 32-bit decimal (add 'f' suffix)
- **double** - 64-bit decimal (default for decimals)
- **char** - 16-bit Unicode character
- **boolean** - true or false

**Example:**
```java
int age = 25;
double salary = 50000.50;
char grade = 'A';
boolean isActive = true;
long population = 1000000L;
```

---

## 2. What is the difference between primitive and reference types?

**Answer:**
The main difference is how they store data and where they're stored in memory.

**Primitive Types:**
- Store actual values directly
- Stored in stack memory
- Fixed size
- Default values (0, false, null)

**Reference Types:**
- Store memory addresses (references)
- Objects stored in heap memory
- Variable size
- Default value is null

**Example:**
```java
// Primitive
int x = 10; // Stores value 10 directly

// Reference
String name = "John"; // Stores reference to "John" object
Integer num = 20; // Wrapper class - reference type
```

---

## 3. What is autoboxing and unboxing?

**Answer:**
Automatic conversion between primitive types and their wrapper classes.

**Autoboxing:**
- Primitive → Wrapper class automatically

**Unboxing:**
- Wrapper class → Primitive automatically

**Example:**
```java
// Autoboxing - int to Integer
Integer num = 10; // Compiler converts int to Integer

// Unboxing - Integer to int
int value = num; // Compiler converts Integer to int

// In collections
List<Integer> list = new ArrayList<>();
list.add(5); // Autoboxing: int 5 becomes Integer
int first = list.get(0); // Unboxing: Integer becomes int
```

---

## 4. What is the difference between == and equals() method?

**Answer:**
They compare different things depending on the data type.

**== Operator:**
- Compares references for objects
- Compares values for primitives

**equals() Method:**
- Compares actual content/values
- Can be overridden in classes

**Example:**
```java
// Primitives
int a = 5, b = 5;
System.out.println(a == b); // true (same values)

// Objects
String s1 = new String("Hello");
String s2 = new String("Hello");
System.out.println(s1 == s2); // false (different references)
System.out.println(s1.equals(s2)); // true (same content)

// String literals
String s3 = "Hello";
String s4 = "Hello";
System.out.println(s3 == s4); // true (same reference in pool)
```

---

## 5. What is the difference between String, StringBuilder, and StringBuffer?

**Answer:**
They differ in mutability and thread safety.

**String:**
- Immutable (cannot be changed)
- Thread-safe (because immutable)
- Creates new object for each operation

**StringBuilder:**
- Mutable (can be modified)
- Not thread-safe
- Faster for single-threaded operations

**StringBuffer:**
- Mutable (can be modified)
- Thread-safe (synchronized methods)
- Slower due to synchronization

**Example:**
```java
// String - creates new objects
String str = "Hello";
str = str + " World"; // Creates new String object

// StringBuilder - modifies existing
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World"); // Modifies same object

// StringBuffer - thread-safe version
StringBuffer sbf = new StringBuffer("Hello");
sbf.append(" World"); // Thread-safe modification
```

---

## 6. Why are strings immutable in Java?

**Answer:**
Strings are immutable for security, performance, and design reasons.

**Reasons:**
- **Security** - Prevents malicious code from changing strings
- **String Pool** - Enables memory optimization through sharing
- **Thread Safety** - No synchronization needed
- **Hashcode Caching** - Hash value calculated once and reused
- **Class Loading** - Class names are strings, must be secure

**Example:**
```java
String original = "Hello";
String modified = original.concat(" World");

System.out.println(original); // Still "Hello"
System.out.println(modified); // "Hello World"
// Original string unchanged - new object created
```

---

## 7. What is string pooling?

**Answer:**
String pooling is Java's memory optimization technique where identical string literals share the same memory location.

**How it works:**
- JVM maintains a pool of unique strings
- String literals are stored in this pool
- Duplicate literals reference the same object
- Saves memory and improves performance

**Example:**
```java
// String literals - stored in pool
String s1 = "Hello";
String s2 = "Hello";
System.out.println(s1 == s2); // true (same reference)

// New String objects - not in pool initially
String s3 = new String("Hello");
System.out.println(s1 == s3); // false (different references)

// intern() method adds to pool
String s4 = s3.intern();
System.out.println(s1 == s4); // true (now same reference)
```

---

## 8. What is the difference between final, finally, and finalize?

**Answer:**
Three different keywords with completely different purposes.

**final:**
- Keyword for constants, preventing inheritance/override
- Variables: cannot be reassigned
- Methods: cannot be overridden
- Classes: cannot be extended

**finally:**
- Block that always executes after try-catch
- Used for cleanup code
- Executes even if exception occurs

**finalize:**
- Method called by garbage collector
- Used for cleanup before object destruction
- Deprecated since Java 9

**Example:**
```java
// final
final int MAX_SIZE = 100; // Cannot be changed
final class FinalClass {} // Cannot be extended

// finally
try {
    int result = 10/0;
} catch (Exception e) {
    System.out.println("Error occurred");
} finally {
    System.out.println("Always executes"); // Cleanup code
}

// finalize (deprecated)
class MyClass {
    protected void finalize() throws Throwable {
        // Cleanup before garbage collection
        super.finalize();
    }
}
```

# Java Classes and Objects - Interview Q&A

## 1. What is a constructor in Java?

A constructor is a special method that initializes objects when they're created.

**Key Points:**
- Same name as the class
- No return type (not even void)
- Called automatically when object is created
- Can be overloaded

**Example:**
```java
public class Student {
    String name;
    int age;
    
    // Default constructor
    public Student() {
        name = "Unknown";
        age = 0;
    }
    
    // Parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

## 2. What is constructor chaining?

Constructor chaining is calling one constructor from another constructor in the same class or parent class.

**Key Points:**
- Use `this()` to call another constructor in same class
- Use `super()` to call parent class constructor
- Must be the first statement in constructor

**Example:**
```java
public class Employee {
    String name;
    int id;
    double salary;
    
    public Employee() {
        this("Unknown", 0); // Calls parameterized constructor
    }
    
    public Employee(String name, int id) {
        this(name, id, 0.0); // Calls three-parameter constructor
    }
    
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
}
```

## 3. What is the difference between this and super keywords?

**this keyword:**
- Refers to current object
- Access current class members
- Call current class constructors

**super keyword:**
- Refers to parent class object
- Access parent class members
- Call parent class constructors

**Example:**
```java
class Animal {
    String name = "Animal";
    
    public void eat() {
        System.out.println("Animal eating");
    }
}

class Dog extends Animal {
    String name = "Dog";
    
    public void display() {
        System.out.println(this.name);  // Prints "Dog"
        System.out.println(super.name); // Prints "Animal"
    }
    
    public void eat() {
        super.eat(); // Calls parent method
        System.out.println("Dog eating");
    }
}
```

## 4. What is method overloading?

Method overloading means having multiple methods with the same name but different parameters in the same class.

**Key Points:**
- Same method name, different parameters
- Compile-time polymorphism
- Parameters can differ by number, type, or order

**Example:**
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

## 5. What is method overriding?

Method overriding means redefining a parent class method in the child class with the same signature.

**Key Points:**
- Same method signature as parent
- Runtime polymorphism
- Use @Override annotation
- Child method is called at runtime

**Example:**
```java
class Vehicle {
    public void start() {
        System.out.println("Vehicle starting");
    }
}

class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car starting with key");
    }
}

class Bike extends Vehicle {
    @Override
    public void start() {
        System.out.println("Bike starting with kick");
    }
}
```

## 6. What is the difference between overloading and overriding?

| **Overloading** | **Overriding** |
|-----------------|----------------|
| Same class | Different classes (inheritance) |
| Different parameters | Same method signature |
| Compile-time | Runtime |
| Static polymorphism | Dynamic polymorphism |
| Can change return type | Must have same return type |

**Example:**
```java
// Overloading - Same class, different parameters
class MathUtils {
    public int multiply(int a, int b) { return a * b; }
    public double multiply(double a, double b) { return a * b; }
}

// Overriding - Different classes, same signature
class Shape {
    public void draw() { System.out.println("Drawing shape"); }
}

class Circle extends Shape {
    @Override
    public void draw() { System.out.println("Drawing circle"); }
}
```

## 7. What is dynamic method dispatch?

Dynamic method dispatch is the mechanism where the correct overridden method is called at runtime based on the actual object type, not the reference type.

**Key Points:**
- Runtime polymorphism
- Method call resolved at runtime
- Depends on actual object, not reference type
- Enables polymorphic behavior

**Example:**
```java
class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Cat(); // Reference type: Animal, Object type: Cat
        Animal animal2 = new Dog(); // Reference type: Animal, Object type: Dog
        
        animal1.makeSound(); // Prints "Cat meows" - Dynamic dispatch
        animal2.makeSound(); // Prints "Dog barks" - Dynamic dispatch
    }
}
```

# Java Inheritance Interview Questions & Answers

## 1. Why doesn't Java support multiple inheritance?

**Answer:**
• Java doesn't support multiple inheritance of classes to avoid complexity and ambiguity
• Main reasons:
  - **Diamond Problem**: Confusion when multiple parent classes have same method
  - **Complexity**: Makes code harder to understand and maintain
  - **Ambiguity**: Compiler can't decide which parent method to inherit

**Example:**
```java
// This is NOT allowed in Java
class A { void show() { } }
class B { void show() { } }
class C extends A, B { } // Compilation Error!
```

---

## 2. What is the diamond problem?

**Answer:**
• Diamond problem occurs when a class inherits from multiple classes that have a common parent
• Creates ambiguity about which method implementation to use
• Named "diamond" because the inheritance structure looks like a diamond shape

**Example Structure:**
```
    A
   / \
  B   C
   \ /
    D
```

**Code Example:**
```java
// If this was allowed (it's not in Java)
class Animal { void sound() { } }
class Dog extends Animal { void sound() { System.out.println("Bark"); } }
class Cat extends Animal { void sound() { System.out.println("Meow"); } }
class Hybrid extends Dog, Cat { } // Which sound() method to inherit?
```

---

## 3. How does Java solve the diamond problem?

**Answer:**
• Java solves it by **not allowing multiple inheritance of classes**
• Instead provides alternatives:
  - **Interfaces**: Can implement multiple interfaces
  - **Default methods**: Interface methods with implementation (Java 8+)
  - **Composition**: Use HAS-A relationship instead of IS-A

**Example:**
```java
interface Flyable { 
    default void fly() { System.out.println("Flying"); }
}
interface Swimmable { 
    default void swim() { System.out.println("Swimming"); }
}

class Duck implements Flyable, Swimmable {
    // Can implement both interfaces
    // If conflict, must override the method
}
```

---

## 4. Can you override static methods?

**Answer:**
• **No, you cannot override static methods**
• Static methods belong to the class, not to instances
• You can **hide** static methods (method hiding), but it's not overriding
• Static methods are resolved at compile time, not runtime

**Example:**
```java
class Parent {
    static void display() { System.out.println("Parent static"); }
}

class Child extends Parent {
    static void display() { System.out.println("Child static"); } // Method hiding, not overriding
}

// Usage:
Parent.display(); // Output: Parent static
Child.display();  // Output: Child static
Parent p = new Child();
p.display();      // Output: Parent static (not Child!)
```

---

## 5. What is covariant return type?

**Answer:**
• Covariant return type allows overriding method to return a **subtype** of the original return type
• Introduced in Java 5
• The return type can be more specific (narrower) than the parent's return type
• Must maintain IS-A relationship

**Example:**
```java
class Animal { }
class Dog extends Animal { }

class AnimalFactory {
    Animal createAnimal() {
        return new Animal();
    }
}

class DogFactory extends AnimalFactory {
    @Override
    Dog createAnimal() {  // Covariant return type - Dog is subtype of Animal
        return new Dog();
    }
}
```

**Another Example:**
```java
class Shape {
    Shape getShape() { return new Shape(); }
}

class Circle extends Shape {
    @Override
    Circle getShape() { return new Circle(); } // Valid covariant return
}
```

---

## 6. What is the difference between IS-A and HAS-A relationship?

**Answer:**

### IS-A Relationship (Inheritance)
• Represents **inheritance** relationship
• Uses `extends` keyword
• Child class IS-A type of parent class
• **"Kind of"** relationship

**Example:**
```java
class Vehicle { }
class Car extends Vehicle { } // Car IS-A Vehicle

class Animal { }
class Dog extends Animal { }  // Dog IS-A Animal
```

### HAS-A Relationship (Composition/Aggregation)
• Represents **composition** or **aggregation**
• One class contains reference to another class
• **"Part of"** or **"Has"** relationship
• More flexible than inheritance

**Example:**
```java
class Engine {
    void start() { System.out.println("Engine started"); }
}

class Car {
    private Engine engine; // Car HAS-A Engine
    
    public Car() {
        engine = new Engine();
    }
    
    void startCar() {
        engine.start();
    }
}

class Student {
    private Address address; // Student HAS-A Address
    private List<Course> courses; // Student HAS-A list of Courses
}
```

### Key Differences:
| IS-A | HAS-A |
|------|-------|
| Inheritance | Composition |
| Tight coupling | Loose coupling |
| "Kind of" | "Part of" |
| Less flexible | More flexible |
| Single inheritance limit | Multiple composition allowed |

**When to use:**
• **IS-A**: When there's a clear parent-child relationship
• **HAS-A**: When you need flexibility and want to avoid inheritance limitations

# Interfaces and Abstract Classes - Interview Questions & Answers

## 1. What is an interface in Java?

An interface is a contract that defines what methods a class must implement, without providing the implementation details.

**Key Points:**
• Contains abstract methods (by default)
• All variables are public, static, and final
• Classes implement interfaces using `implements` keyword
• Supports multiple inheritance
• Cannot be instantiated directly

**Example:**
```java
interface Animal {
    void makeSound();
    void move();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
    
    public void move() {
        System.out.println("Running");
    }
}
```

---

## 2. What is an abstract class?

An abstract class is a class that cannot be instantiated and may contain both abstract and concrete methods.

**Key Points:**
• Uses `abstract` keyword
• Can have constructors, instance variables
• Can contain both abstract and concrete methods
• Classes extend abstract classes using `extends` keyword
• Supports single inheritance only

**Example:**
```java
abstract class Vehicle {
    String brand;
    
    public Vehicle(String brand) {
        this.brand = brand;
    }
    
    abstract void start();
    
    public void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }
    
    void start() {
        System.out.println("Car started");
    }
}
```

---

## 3. What is the difference between interface and abstract class?

**Interface:**
• Multiple inheritance supported
• Only public abstract methods (before Java 8)
• Variables are public, static, final
• No constructors
• 100% abstraction (before Java 8)

**Abstract Class:**
• Single inheritance only
• Can have concrete and abstract methods
• Can have any type of variables
• Can have constructors
• 0-100% abstraction

**Example:**
```java
// Interface - multiple inheritance
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() { System.out.println("Flying"); }
    public void swim() { System.out.println("Swimming"); }
}

// Abstract class - single inheritance
abstract class Bird {
    abstract void makeSound();
    public void sleep() { System.out.println("Sleeping"); }
}
```

---

## 4. What are default methods in interfaces?

Default methods allow interfaces to have method implementations without breaking existing code.

**Key Points:**
• Introduced in Java 8
• Use `default` keyword
• Provide backward compatibility
• Can be overridden in implementing classes

**Example:**
```java
interface Calculator {
    int add(int a, int b);
    
    default int multiply(int a, int b) {
        return a * b;
    }
}

class SimpleCalculator implements Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    // multiply method is inherited from interface
}
```

---

## 5. What are static methods in interfaces?

Static methods in interfaces belong to the interface itself and cannot be overridden.

**Key Points:**
• Introduced in Java 8
• Called using interface name
• Cannot be overridden in implementing classes
• Provide utility methods

**Example:**
```java
interface MathUtils {
    static int square(int number) {
        return number * number;
    }
    
    static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

// Usage
int result = MathUtils.square(5); // 25
boolean even = MathUtils.isEven(4); // true
```

---

## 6. What is marker interface?

A marker interface is an empty interface with no methods, used to mark or tag classes for special treatment.

**Key Points:**
• Contains no methods or constants
• Provides metadata about the class
• Used by JVM or frameworks for special processing
• Examples: Serializable, Cloneable, Remote

**Example:**
```java
// Marker interface
interface Printable {
    // No methods - just marks the class
}

class Document implements Printable {
    String content;
    
    public Document(String content) {
        this.content = content;
    }
}

// Usage in framework code
public void printDocument(Object obj) {
    if (obj instanceof Printable) {
        System.out.println("Printing: " + obj);
    }
}
```

---

## 7. What is functional interface?

A functional interface has exactly one abstract method and can be used with lambda expressions.

**Key Points:**
• Contains exactly one abstract method
• Can have default and static methods
• Annotated with `@FunctionalInterface` (optional)
• Used with lambda expressions and method references
• Examples: Runnable, Callable, Comparator

**Example:**
```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
    
    // Can have default methods
    default void printResult(int result) {
        System.out.println("Result: " + result);
    }
}

// Usage with lambda
Calculator add = (a, b) -> a + b;
Calculator multiply = (a, b) -> a * b;

int sum = add.calculate(5, 3); // 8
int product = multiply.calculate(5, 3); // 15
```

---

## 8. Can an interface extend another interface?

Yes, an interface can extend one or more interfaces using the `extends` keyword.

**Key Points:**
• Interface can extend multiple interfaces
• Inherits all abstract methods from parent interfaces
• Implementing class must provide implementation for all methods
• Creates interface hierarchy

**Example:**
```java
interface Animal {
    void eat();
}

interface Mammal extends Animal {
    void breathe();
}

interface Pet extends Animal {
    void play();
}

// Multiple interface inheritance
interface Dog extends Mammal, Pet {
    void bark();
}

class GoldenRetriever implements Dog {
    public void eat() { System.out.println("Eating"); }
    public void breathe() { System.out.println("Breathing"); }
    public void play() { System.out.println("Playing"); }
    public void bark() { System.out.println("Barking"); }
}
```

---

## Quick Summary

**Remember:**
• Interface = Contract (what to do)
• Abstract Class = Partial implementation (what and how)
• Default methods = Backward compatibility
• Static methods = Utility functions
• Marker interface = Tagging mechanism
• Functional interface = Lambda expressions
• Interface inheritance = Multiple extends allowed

