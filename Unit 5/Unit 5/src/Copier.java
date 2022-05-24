import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Copier {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\racyedu000\\Desktop\\FileReader\\Copier.dat.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.format("%s %s\n", line, line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}