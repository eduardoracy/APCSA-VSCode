import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.Scanner;


public class Pups {
    //C:\Users\racyedu000\Desktop\FileReader
    public static void main(String[] args) {
        try {
            NumberFormat money = NumberFormat.getCurrencyInstance();
            Scanner reader = new Scanner(new FileReader("C:\\Users\\racyedu000\\Desktop\\FileReader\\Pups.dat.txt"));
            int totalPupSets = reader.nextInt();
            for (int i = 0; i < totalPupSets; i++) {
                int dog= reader.nextInt();
                double food = reader.nextDouble();
                double price = reader.nextDouble();
                System.out.println(money.format(dog*food*price));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
