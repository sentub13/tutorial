public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from 02-Constructor");
        Person person = new Person("Alice", 30);

        System.out.println(person.name + " is " + person.age + " years old.");
    }
}

class Person {
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}