import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) {
		// System.out.println("Hello World");
		FileInputStreamApi obj1 = new FileInputStreamApi();
		// obj1.ReadFile();
		// obj1.CopyFile();
		
		FileOutputStreamApi obj2 = new FileOutputStreamApi();
		// obj2.WriteFile();
		// obj2.CopyFile();
		// obj2.AppendFile();
		
		BufferedReaderApi obj3 = new BufferedReaderApi();		
		obj3.ReadFile();
		
		BufferedWriterApi obj4 = new BufferedWriterApi();
		// obj4.WriteFile();
		// obj4.AppendFile();
	}
}

class FileInputStreamApi {
	void ReadFile() {
		// System.out.println("Read input");
		// FileInputStream obj = new FileInputStream();
		try (FileInputStream input = new FileInputStream("test.txt")) {
			File file = new File("test.txt");
			if(file.createNewFile()){
				System.out.println("File created");
			} else {
				System.out.println("Not Created");
			}
			
			int i;
			while((i = input.read()) != -1) {
				System.out.print((char) i);
			}
			
			System.out.println("Try");
		} catch(IOException e) {
			System.out.println("Error read file.");
		} 
	}
	
	void CopyFile() {
		// System.out.println("Copy input");
		
		try (FileInputStream input = new FileInputStream("test.txt"); FileOutputStream output = new FileOutputStream("test1.txt")) {
			
			int i;
			while((i = input.read()) != -1) {
				output.write(i);
			}			
			System.out.println("Copied successfully.");
		} catch(IOException e) {
			System.out.println("Error reading file.");
		}
	}
}
// ==================================
class FileOutputStreamApi {
	void WriteFile() {
		System.out.println("Write output");
		try (FileOutputStream obj = new FileOutputStream("test.txt")){
			String str = "How are you";
			obj.write(str.getBytes());
			System.out.println("Succcesfully wrote the file");
		} catch (IOException e) {
			System.out.println("Error "+e);
		}
	}
	
	public void CopyFile() {
		System.out.println("Copy output");
		try (
			FileInputStream input = new FileInputStream("test.txt"); 
			FileOutputStream output = new FileOutputStream("hello.txt")
		){
			int b;
			while ((b = input.read()) != -1) {
				output.write(b);
			}
			System.out.println("File copied successfully");
		} catch (IOException e) {
			System.out.println("Error "+e);
		}
	}
	
	public static void AppendFile() {
		System.out.println("Append output");
		String str = " dasdad  ";
		try (FileOutputStream output = new FileOutputStream("hello.txt", true)){
			output.write(str.getBytes());
			System.out.println("Text appended Succcesfully");
		} catch (IOException e) {
			System.out.println("Error "+e);
		}
	}
}
// ==================================

class BufferedReaderApi {
	void ReadFile () {
		System.out.println("Read Buffer");
		try (BufferedReader buffer = new BufferedReader(
				new FileReader("hello.txt")
			)) {
			String line;
			while((line = buffer.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("File wrote successfully. ");
		} catch (IOException e) {
			System.out.println("Hello ");
		}
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