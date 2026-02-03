import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		CreateFile obj1 = new CreateFile();
		obj1.CreateFile();
		
		WriteFile obj2 = new WriteFile();
		obj2.WriteFile();
		
		ReadFile obj3 = new ReadFile();
		obj3.ReadFile();	
		
		DeleteFile obj4 = new DeleteFile();
		obj4.DeleteFile();
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
		
		try {
			File obj = new File("text.text");	
			Scanner scnObj = new Scanner(obj);
			while(scnObj.hasNextLine()) {
				String data = scnObj.nextLine();
				System.out.println(data);
			}
			scnObj.close();			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Hello");
		}
	}
}

class DeleteFile {
	void DeleteFile () {
		File obj = new File("test.txt");
		if(obj.delete()){
			System.out.println("File Deleted");
		} else {
			System.out.println("Not Deleted");
		}	
	}
}