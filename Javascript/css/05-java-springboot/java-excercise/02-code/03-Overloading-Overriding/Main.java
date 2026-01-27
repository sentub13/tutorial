public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from 03-Overloading-Overriding");
        Person p = new Person();

        p.speak("English");

        p.speak();

        p.speak("French");

        p.speak("Spanish", "Mexico");

        p.speak("Spanish", "Colombia");
    }
}

class Person {
    String name;
    int age;

    void speak() {
        System.out.println("Person is speaking");
    }

    void speak(String language) {
        System.out.println("Person is speaking in " + language);
    }

}
