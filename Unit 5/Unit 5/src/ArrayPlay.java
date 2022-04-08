
public class ArrayPlay {
    public static void main(String[] args) {
        Utilities.clearScreen(20);
        int[] scores = new int[8];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = 0;
            System.out.print(scores[i] + " ");
        }
        scores[0] = 60;
        scores[7] = 92;
        System.out.println();
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        scores[1] = (int) (Math.random() * 100);
        System.out.println();
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println("\n"); 
    }
}
