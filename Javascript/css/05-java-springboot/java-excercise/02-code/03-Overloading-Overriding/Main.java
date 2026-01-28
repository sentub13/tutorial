public class Main {
	public static void main (String[] args) {
		// System.out.println("Hello World");
		Calculator obj1 = new Calculator();
		CalculatorExt Obj2 = new CalculatorExt();
		
		System.out.println(obj1.add(4, 6));
		// System.out.println(obj1.add(4, 6, 5));
		
		System.out.println(Obj2.add(6, 5));
	}		
}

class Calculator {   
	public int add(int a, int b) {
		return a + b;
	}
	
	/*
	public int add(int a, int b, int c) {
		return a + b + c;
	}
	*/
}

class CalculatorExt extends Calculator {
	@Override
	public int add(int a, int b) {
		return a + b;
	}
}


/*
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
*/
