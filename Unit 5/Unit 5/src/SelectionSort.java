public class SelectionSort {

    public static void main(String[] args) {
        int[] num = {12,56,1,4,3,78,83};
        System.out.println("Unsorted: ");

        for (int number : num) {
            System.out.println(number + " ");
        }

        selectionSort(num);

        System.out.println("Sorted: ");

        for (int number : num) {
            System.out.print(number + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        selectionSort(arr, 0);
    }

    public static void selectionSort(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        int min = index;
        for (int i = min + 1; i < arr.length; i++) {
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

    public static void selectionSort(String[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        int min = index;
        for (int i = min + 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[min])) {
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

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int pos = i;
            while(pos >0 && arr[pos - 1] > key) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = key;
        }
}
}
