import java.util.Arrays;

public class scratchpad {
    public static void main(String[] args) throws Exception {
        boolean[][] arr =new boolean[2][3];
        for (boolean row[] : arr)
        Arrays.fill(row, false);

        for(int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[0].length; i++) {
        System.out.println(arr[i][j]);
        }}
    }
}
