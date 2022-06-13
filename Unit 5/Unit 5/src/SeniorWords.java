import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SeniorWords {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\racyedu000\\Desktop\\FileReader\\SeniorSummerWords.dat.txt"));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                System.out.format("%s %s\n", line.charAt(0), line.charAt(0));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
