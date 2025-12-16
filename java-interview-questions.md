# Java Interview Questions - Basic Concepts

## 1. What is Java and what are its key features?

**Answer:**
Java is a high-level, object-oriented programming language developed by Sun Microsystems (now Oracle).

**Key Features:**

• **Platform Independent** - Write once, run anywhere (WORA)
• **Object-Oriented** - Everything is an object
• **Simple and Secure** - No pointers, automatic memory management
• **Multithreaded** - Can handle multiple tasks simultaneously
• **Robust** - Strong memory management and exception handling

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

• **JVM (Java Virtual Machine)** - Runtime environment that executes Java bytecode
• **JRE (Java Runtime Environment)** - JVM + libraries needed to run Java applications
• **JDK (Java Development Kit)** - JRE + development tools (compiler, debugger)

**Simple way to remember:**

• JDK = Development tools + JRE
• JRE = JVM + Runtime libraries
• JVM = Executes bytecode

---

## 3. What are the main principles of Object-Oriented Programming?

**Answer:**

The four main principles are:

• **Encapsulation** - Bundling data and methods together
• **Inheritance** - Creating new classes based on existing ones
• **Polymorphism** - One interface, multiple implementations
• **Abstraction** - Hiding complex implementation details

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

• **Compile-time** - Method overloading

• **Runtime** - Method overriding

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

• Make variables **private**

• Provide **public getter/setter** methods

• Control access through methods

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

• **Single** - One child, one parent
• **Multilevel** - Chain of inheritance
• **Hierarchical** - Multiple children, one parent
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

• Use **abstract** keyword

• Can have both abstract and concrete methods

• Cannot create objects directly

• Must be extended by subclasses

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

---

## Quick Tips for Interviews:

• Keep answers concise and practical

• Always provide simple examples

• Mention real-world use cases when possible

• Practice coding these examples by hand