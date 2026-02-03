import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
	public static void main(String[] args) {
		// System.out.println("Hello World");
		FileInputStream obj1 = new FileInputStream();
		obj1.ReadFile();
		obj1.CopyFile();
		
		FileOutputStream obj2 = new FileOutputStream();
		obj2.WriteFile();
		obj2.CopyFile();
		obj2.AppendFile();
		
		BufferedReader obj3 = new BufferedReader();		
		obj3.ReadFile();
		
		BufferedWriter obj4 = new BufferedWriter();
		obj4.WriteFile();
		obj4.AppendFile();
	}
}

class FileInputStream {
	void ReadFile() {
		System.out.println("Read input");
	}
	
	void CopyFile() {
		System.out.println("Copy input");
	}
}
// ==================================
class FileOutputStream {
	void WriteFile() {
		System.out.println("Write output");
	}
	
	public void CopyFile() {
		System.out.println("Copy output");
	}
	
	public static void AppendFile() {
		System.out.println("Append output");
	}
}
// ==================================

class BufferedReader {
	void ReadFile () {
		System.out.println("Read Buffer");
	}
}
// ==================================
class BufferedWriter {
	void WriteFile () {
		System.out.println("Write Buffer");
	}
	void AppendFile () {
		System.out.println("Append Buffer");
	}
}