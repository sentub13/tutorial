public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from 04-Inheritance");
		C c = new C();
		// c.f();
		// c.g();
		// c.h();
		
		D d = new D();
		d.f();
		d.i();
    }
}

class A{
	void f() {
		System.out.println("a");
	}
}

class B extends A{
	void g() {
		System.out.println("B");
	}
}

class C extends B{
	void h() {
		System.out.println("C");
	}
}

class D extends A{
	void i() {
		System.out.println("D");
	}
	
}