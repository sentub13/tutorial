public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello from 11-Try–Catch–Finally");
		try {
			System.out.println("Hello try");
		} catch(ArithmeticException  e) {
			System.out.println("Hello from Catch" + e);
		} finally {
			System.out.println("Hello from Finally");
		}
    }
}
