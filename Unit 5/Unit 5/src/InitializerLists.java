import java.util.Arrays;

public class InitializerLists {
    public static void main(String[] args) {
        Utilities.clearScreen();
        String[] colors = {"red", "blue", "green", "purple"};
        System.out.println("The array of colors: ");
        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i].toUpperCase());
        }
        for(String color: colors) {
            System.out.println(color);
        }
        System.out.println(Arrays.toString(colors));

        System.out.println("\n");

        boolean[] values = {true, false, false, true};
        for (boolean bol: values) {
            System.out.println(bol);
        }
        boolean[] newValues = new boolean[4];
        for (int i = 0; i < values.length; i ++) {
            newValues[i] = !values[i];
            System.out.println(newValues[i]);
        }
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i] + " " + newValues[i]);
        }

        System.out.println("\n");

        int[] intValues = {2, 4, 6, 8};
        int sum = 0;
        for(int num: intValues) {
            System.out.println(num);
            sum += num;
        }
        System.out.println("The sum of the array of digits " + Arrays.toString(intValues) + " is " + sum);
        double avg = sum / intValues.length;
        System.out.println("The average of the array of digits " + Arrays.toString(intValues) + " is " + avg);

        int[] intCopy = intValues.clone();
        Arrays.sort(intCopy);
        System.out.println("The smallest number in the array of digits " + Arrays.toString(intValues) + " is " + intCopy[0]);
        System.out.println("The largest number in the array of digits " + Arrays.toString(intValues) + " is " + intCopy[intCopy.length - 1]);


    }
}
