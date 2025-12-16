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

---

## Quick Tips for Interviews:
- Remember the 8 primitive types and their sizes
- Understand memory allocation (stack vs heap)
- Practice string manipulation examples
- Know when to use StringBuilder vs StringBuffer
- Understand the string pool concept clearly