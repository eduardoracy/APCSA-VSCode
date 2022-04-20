public class SelectionSort {

    public static void main(String[] args) {
        int[] num = {12,56,1,4,835,3,78};

        selectionSort(num);

        for (int number : num) {
            System.out.println(number);
        }
    }

    public static void selectionSort(int[] arr) {
        selectionSort(arr, 0);
    }

    public static void selectionSort(int[] arr, int index) {
        int arrLength = arr.length - 1;
        if (index == arrLength) {
            return;
        }
        int min = index;
        for (int i = min + 1; i < arrLength; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }

        int temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;

        if (index++ <= min) {
            selectionSort(arr, index);
        }
    }
}
