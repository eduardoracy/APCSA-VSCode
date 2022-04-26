
public class CommonAlgorithms {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Utility.clearScreen();

        System.out.println("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        int minIndex = findMin(arr);
        System.out.println(String.format("Min: %s on index %s", arr[minIndex], minIndex));
        int maxIndex = findMax(arr);
        System.out.println(String.format("Max: %s on index %s", arr[maxIndex], maxIndex));        
        int sumIndex = findSum(arr);
        System.out.println(String.format("Sum: %s", sumIndex));
    }

    public static int findMin(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return min;
    }

    public static int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int nextIndex = i +1;
            if (arr[i] < arr[nextIndex]) {
                max = nextIndex;
            }
        }
        return max;
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
