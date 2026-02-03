import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Scanner;

public class Main {
    public static void main(String[] args) {
		// CreateFile obj1 = new CreateFile();
		// obj1.CreateFile();
		
		WriteFile obj2 = new WriteFile();
		obj2.WriteFile();
		
		ReadFile obj3 = new ReadFile();
		// obj3.ReadFile();	
		
		DeleteFile obj4 = new DeleteFile();
		// obj4.DeleteFile();
    }
}


class CreateFile {
	public void CreateFile() {
		try {
			File file = new File("test1.txt");
			if(file.createNewFile()) {
				System.out.println("File is create " + file.getName());
			} else {
				System.out.println("File is already exists");
			}            	
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			System.out.println("Completed");
		}	
	}	
}

class WriteFile {
	public void WriteFile() {	
		try {
			FileWriter file = new FileWriter("text.text");
			file.write("Hello World");
			file.close();
			System.out.println("Successfully wrote to the file");
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			System.out.println("Completed");
		}
	}
}

class ReadFile {
	void ReadFile () {
		File file = new File("text.text");
		try () {
			Scanner obj = new Scanner(file);
			if(obj.hasNextLIne()){
				String data = new hasNextLIne();
				System.out.println(data);
			}
			file.readFile("Hello World");
			file.close();
			System.out.println("Successfully wrote to the file");
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			System.out.println("Completed
	}
}

class DeleteFile {
	void DeleteFile () {
		try {
			FileWriter file = new FileWriter("text.text");
			file.write("Hello World");
			file.close();
			System.out.println("Successfully wrote to the file");
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			System.out.println("Completed
	}
}