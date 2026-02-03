import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CreateFile obj1 = new CreateFile();
        obj1.CreateFile();
    }
}

class CreateFile {
    public void CreateFile() {
        try {
            File file = new File("test.txt");

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("Completed");
        }
    }
}
