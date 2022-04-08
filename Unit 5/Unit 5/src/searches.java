import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class searches {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        String[] names = {"John", "Paul", "George", "Ringo"};
        ArrayList<String> namesList = new ArrayList<>(Arrays.asList("Eduardo", "Sophie", "Jonnalynn", "Caden"));
        Scanner console = new Scanner(System.in);
        
        for (int num : numbers) {
            System.out.println(num + " is found at position " + linearSearch(numbers, num));
        }
        System.out.println();

        for (String name : names) {
            System.out.println(name + " is found at position " + linearSearch(names, name));
        }
        System.out.println();

        int target = 15;
        System.out.println(target + " found at position " + linearSearch(numbers, target));
        System.out.println();

        target = 3;
        System.out.println(target + " found at position " + linearSearch(numbersList, target));
        System.out.println();

        System.out.println("Enter the name of a member of the Beattles");
        String nameTarger = console.next();
        System.out.println(nameTarger + " found at position " + linearSearch(names, nameTarger));
        System.out.println();

        System.out.println("Enter the name of a person in the row by the door");
        nameTarger = console.next();
        System.out.println(nameTarger + " found at position " + linearSearch(namesList, nameTarger));
        System.out.println();

        System.out.println(target + " found at position " + binarySearch(numbers, target));

        console.close();
    }

    public static int linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch(ArrayList<Integer> arr, int num) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == num) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch(String[] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch(ArrayList<String> arr, String name) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int num) {
        int low = 0, high = arr.length - 1, middle = (low+high) / 2;
        while (arr[middle] != num && low <= high) {
            if (num < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
            middle = (low + high) / 2;
        }

        if (num == arr[middle]) {
            return middle;
        } else {
            return -1;
        }
    }

}
