


public class sUT {
    public static void clearScreen(int spaces) {
        for (int i = 0; i < spaces; i++) {
            System.out.println();
        }
    }
    public static void textCenter(String text, char symbol, int length) {
        StringBuffer spacer = new StringBuffer();
        int numberChar = length - text.length();
        int leftLength = numberChar / 2;
        int rightLength = numberChar - leftLength;

        for (int i = 0; i < leftLength; i++) {
            spacer.append(symbol);
        }
        spacer.append(text);
        for (int i = 0; i < rightLength; i++) {
            spacer.append(symbol);
        }
        System.out.println(spacer.toString());
    }
}
