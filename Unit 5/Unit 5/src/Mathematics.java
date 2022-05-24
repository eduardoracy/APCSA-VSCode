import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mathematics {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\racyedu000\\Desktop\\FileReader\\mathematics.dat.txt"));
            int sum = 0;
            int numLines = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numLines; i++) {
                sum += Integer.parseInt(reader.readLine());
            }
            System.out.println(sum);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
