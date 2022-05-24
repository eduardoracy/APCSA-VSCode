import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Rain {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\racyedu000\\Desktop\\FileReader\\Rain.dat.txt"));
            String lineReader;
            try {
                while ((lineReader = reader.readLine()) != null) {
                    String[] line = lineReader.split(" ");
                    int[] height = new int[line.length];
                    for (int i = 0; i < line.length; i++) {
                        height[i] = Integer.parseInt(line[i]);
                    }

                    int rain = 0;
                    for (int target = 1; target < height.length - 1; target++) {
                        int leftHeight = 0, rightHeight = 0;
                        for (int i = target; i >= 0; i--) {
                            leftHeight = Math.max(leftHeight, height[i]);
                        }
                        for (int j = target; j < height.length - 1; j++) {
                            rightHeight = Math.max(rightHeight, height[j]);
                        }
                        int totalWater = Math.min(leftHeight, rightHeight);
                        rain += totalWater - height[target];
                    }
                    System.out.println(rain);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}