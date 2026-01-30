public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello from 12-throw-throws");
		System.out.println(Division(10, 2));
    }
	
	public static int Division(int a, int b) throws ArithmeticException {
		if(b == 0){
			throw new ArithmeticException("b cannot be zero zcddsdf");
		}
		return a / b;
	}
}

