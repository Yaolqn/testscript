import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FIleIODemo {

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }

    public static void writeFile(String filePath, String content) throws IOException {
        File file = new File(filePath);

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(content);
        }
    }

    public static void main(String[] args){
        String FileInputPath = "C:/Users/80946/Desktop/JAVA/TEST/src/input.txt";
        String FileOutputPath = "C:/Users/80946/Desktop/JAVA/TEST/src/output.txt";

        try{
            String content = readFile(FileInputPath);
            System.out.println("File content:");
            System.out.println(content);

            writeFile(FileOutputPath, content);
            System.out.println("Content has been written to " + FileOutputPath);
        }catch (IOException e) {
            System.out.println("An error occurred while handling the file: " + e.getMessage());
        }
    }
}
