import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFolders {
    public static void main(String[] args) {
        // Base directory
        String baseDir = "java-exercise\\02-code";

        // List of folder names
        String[] folders = {
            "01-ClassAndObject",
            "02-Constructor",
            "03-Overloading-Overriding",
            "04-Inheritance",
            "05-Abstract",
            "06-Interface",
            "07-Encapsulation",
            "08-Polymorphism",
            "09-Static-Keyword",
            "10-This-Super",
            "11-Try–Catch–Finally",
            "12-throw-throws",
            "13-Custom-Exception",
            "14-Read-Write-File",
            "15-Count-Words-in-File",
            "16-Copy-Content-File",
            "17-ArrayList",
            "18-LinkedList",
            "19-HashSet-TreeSet",
            "20-HashMap-TreeMap",
            "21-Iterate-Through-HashMap",
            "22-Sort-Elements-Using-`Collections.sort()`",
            "23-Convert Array to List and Vice Versa",
            "24-Frequency of Elements Using HashMap",
            "25-Remove Duplicates from List Using Set",
            "26-Reverse Words in a Sentence",
            "27-Check Balanced Parentheses Using Stack",
            "28-Find Factorial Using Recursion",
            "29-Search Implementation",
            "30-LRU Cache Implementation using `LinkedHashMap`",
            "31-Producer–Consumer Problem using Threads",
            "32-Deadlock Example in Java",
            "33-Singleton Design Pattern (Thread-Safe)"
        };

        // Create folders and Main.java files
        for (String folder : folders) {
            File dir = new File(baseDir + "\\" + folder);
            if (!dir.exists()) {
                if (dir.mkdirs()) {
                    System.out.println("Created folder: " + dir.getPath());
                } else {
                    System.out.println("Failed to create folder: " + dir.getPath());
                    continue;
                }
            } else {
                System.out.println("Folder already exists: " + dir.getPath());
            }

            // Create Main.java file in the folder
            File mainFile = new File(dir, "Main.java");
            if (!mainFile.exists()) {
                try (FileWriter writer = new FileWriter(mainFile)) {
                    writer.write("public class Main {\n");
                    writer.write("    public static void main(String[] args) {\n");
                    writer.write("        System.out.println(\"Hello from " + folder + "\");\n");
                    writer.write("    }\n");
                    writer.write("}\n");
                    System.out.println("Created file: " + mainFile.getPath());
                } catch (IOException e) {
                    System.out.println("Failed to create file: " + mainFile.getPath());
                    e.printStackTrace();
                }
            } else {
                System.out.println("File already exists: " + mainFile.getPath());
            }
        }
    }
}