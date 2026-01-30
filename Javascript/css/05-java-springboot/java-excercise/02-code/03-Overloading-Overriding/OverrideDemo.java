public class OverrideDemo {
    public static void main(String[] args) {
        System.out.println("Hello ");
		Person obj1 = new Person();
		Details obj2 = new Details();
		
		// obj1.info();
		obj2.info();
    }
}

class Person {
	String name = "Sentu Biswas";
    int age = 23;
	
    void info () {
		System.out.println(this.name + " --- " + this.age);
	}
}

class Details extends Person{
	@Override
	void info () {
		System.out.println("Hello World");
	}
}