import java.util.Scanner;

public class Utility {

    public static void clearScreen(int spaces) {
        for (int i = 0; i < spaces; i++) {
            System.out.println();
        }
    }

    public static void clearScreen() {
        clearScreen(30);
    }

    public static String sameLineTextCenter(String text, char symbol, int length) {
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
        return spacer.toString();
    }

    public static void sameLineTextCenter(String text, char symbol) {
        sameLineTextCenter(text, symbol, 100);
    }

    public static void textCenter(String text, char symbol, int length) {
        System.out.println(sameLineTextCenter(text, symbol, length));
    }

    public static void textCenter(String text, char symbol) {
        textCenter(text, symbol, 100);
    }

    public static String stringCenter(String text, char symbol, int length) {
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
        return spacer.toString();
    }

    public static String stringCenter(String text, char symbol) {
        return stringCenter(text, symbol, 100);
    }

    public static void printTurnHeader(String name, String secondLineTitle, int secondLineNumber) {
        Utility.textCenter(String.format(" %s ", name), '═');
        Utility.textCenter(String.format(" %s%s ", secondLineTitle, secondLineNumber), '─');
        System.out.println();
    }

    public static void printTurnHeader(String name, String secondLineTitle) {
        Utility.textCenter(String.format(" %s ", name), '═');
        Utility.textCenter(String.format(" %s ", secondLineTitle), '─');
        System.out.println();
    }

    public static String nameSelect(int playerNumber, Scanner console) {
        Utility.clearScreen();
        Utility.textCenter(" New game ", '═');
        Utility.textCenter(" Name Selection ", '─');
        System.out.println();

        Utility.textCenter("Please enter a name with 8 characters or less and no spaces", ' ');
        System.out.format("\nPlayer %s enter your name...\n", playerNumber);
        String input = console.next();
        if (input.length() > 8) {
            return nameSelect(playerNumber, console);
        }

        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static void startScreen(String gameName, String[] instructions, Scanner console) {
        Utility.clearScreen();

        Utility.textCenter(String.format(" Welcome to %s!! ", gameName), '═');
        Utility.textCenter(" Designed by Eduardo Racy ", '─');

        System.out.println("1. Start Game");
        System.out.println("2. Instructions");
        int input = console.nextInt();

        Utility.clearScreen();

        if (input == 1) {
            return;
        } else if (input == 2) {
            instructions(instructions, console);
            startScreen(gameName, instructions, console);
        } else {
            Utility.clearScreen();
            Utility.textCenter(String.format(" Welcome to %s!! ", gameName), '═');
            Utility.textCenter(" Designed by Eduardo Racy ", '─');
            System.out.println("Invalid Selection");
            System.out.println("Press ENTER to try again...");
            console.nextLine();
            console.nextLine();

            startScreen(gameName, instructions, console);
        }
    }

    public static void instructions(String[] instructions, Scanner console) {
        Utility.textCenter(" New game ", '═');
        Utility.textCenter(" Instructions ", '─');
        System.out.println();
        for (String line : instructions) {
            textCenter(line, ' ');
            if (instructions.length > 9 && line.equals(instructions[8])) {
                System.out.println();
                textCenter("Press ENTER to continue...", ' ');
                console.nextLine();
                console.nextLine();
            }
        }
        textCenter("Press ENTER to continue...", ' ');
        console.nextLine();
    }

    public static void enterToContinue(Scanner console) {
        textCenter("Press ENTER to continue", ' ');
        console.nextLine();
        console.nextLine();
    }
}
