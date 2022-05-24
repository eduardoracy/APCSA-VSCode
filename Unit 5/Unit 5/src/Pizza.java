import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pizza {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\racyedu000\\Desktop\\FileReader\\Pizza.dat.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] line1 = line.split(" ");
                String[] line2 = reader.readLine().split(" ");
                double ap1 = Integer.parseInt(line1[0]) / Integer.parseInt(line1[1]);
                double ap2 = Math.pow(Integer.parseInt(line2[0]), 2) * Math.PI / Integer.parseInt(line2[1]);
                if (ap1 > ap2) {
                    System.out.println("Slice of Pizza");
                } else {
                    System.out.println("Whole Pizza");
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
