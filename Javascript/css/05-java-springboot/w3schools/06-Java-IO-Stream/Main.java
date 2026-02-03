import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		// System.out.println("Hello World");
		FileInputStreamApi obj1 = new FileInputStreamApi();
		obj1.ReadFile();
		obj1.CopyFile();
		
		FileOutputStreamApi obj2 = new FileOutputStreamApi();
		obj2.WriteFile();
		obj2.CopyFile();
		obj2.AppendFile();
		
		BufferedReaderApi obj3 = new BufferedReaderApi();		
		obj3.ReadFile();
		
		BufferedWriterApi obj4 = new BufferedWriterApi();
		obj4.WriteFile();
		obj4.AppendFile();
	}
}

class FileInputStreamApi {
	void ReadFile() {
		System.out.println("Read input");
		
	}
	
	void CopyFile() {
		System.out.println("Copy input");
	}
}
// ==================================
class FileOutputStreamApi {
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

class BufferedReaderApi {
	void ReadFile () {
		System.out.println("Read Buffer");
	}
}
// ==================================
class BufferedWriterApi {
	void WriteFile () {
		System.out.println("Write Buffer");
	}
	void AppendFile () {
		System.out.println("Append Buffer");
	}
}