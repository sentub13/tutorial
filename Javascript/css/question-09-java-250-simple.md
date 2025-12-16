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
