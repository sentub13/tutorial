public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from 13-Custom-Exception");
		
		try {
			vote(11);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
	
	static void vote(int age) throws InvalidAgeException {
		if(age > 18) {
			System.out.println("Eligible for vote");
		} else {
			// System.out.println("Not Eligible for vote");
			throw new InvalidAgeException("Not Eligible for vote");
		}
	}
}


public class InvalidAgeException extends Exception {
	InvalidAgeException(String msg) {
		super(msg);
	}
}

