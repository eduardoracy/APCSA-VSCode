public class MethodPractice {
    @SuppressWarnings("unused")

    public static void main(String[] args) {
        UT.clearScreen(20);
        String sentence = "Superbowl Sunday is coming.";
        String w1 = sentence.substring(6);
        String w2 = sentence.substring(11, 14);
        int len = sentence.length();
        int pos1 = sentence.indexOf("su");
        int pos2 = sentence.indexOf("su", 5);
        String w3 = sentence.substring(10, 13).toLowerCase();
        String w4 = sentence.substring(15, 16);
        int pos3 = sentence.indexOf("ravens");

        System.out.println();

        String mySentence = "Next monday is Valentine's Day";
        String mw1 = mySentence.substring(17, 21);
        String mw2 = mySentence.substring(27).toLowerCase();
        String mw3 = mySentence.substring(5, 7).concat(mySentence.substring(5, 6));

        System.out.println(mySentence);
        System.out.println(mw1);
        System.out.println(mw2);
        System.out.println(mw3);
    }
}
