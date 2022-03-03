import java.util.Scanner;

public class FoodArray2 {
    public static void main(String[] args) {
        UT.clearScreen();
        Scanner console = new Scanner(System.in);
        System.out.println("How long is your list?");
        int arrLength = console.nextInt();
        String[] food = new String[arrLength];
        int[] foodLength = new int[arrLength];
        for (int i = 0; i < food.length; i++) {
            System.out.println("Enter favorite food number " + (i + 1));
            food[i] = console.next();
            if (food[i].length() <= 4) {
                food[i] += " "; 

            }
        }
        for (int i = 0; i < food.length; i ++) {
            foodLength[i] = food[i].length();
        }
        System.out.println("Favorite Food Friday");
        for (int i = 0; i < food.length; i ++) {
            System.out.println((i+1) + ". " + food[i] + "\t" + foodLength[i]);
        }
        console.close();
    }
}
