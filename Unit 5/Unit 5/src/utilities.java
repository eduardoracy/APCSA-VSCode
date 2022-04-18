import java.util.Scanner;

public class Utilities {

    public static void clearScreen(int spaces) {
        for (int i = 0; i < spaces; i++) {
            System.out.println();
        }
    }

    public static void clearScreen() {
        clearScreen(15);
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
        Utilities.textCenter(String.format(" %s ", name), '═');
        Utilities.textCenter(String.format(" %s %s ", secondLineTitle, secondLineNumber), '─');
        System.out.println();
    }

    public static String nameSelect(int playerNumber, Scanner console) {
        Utilities.clearScreen();
        Utilities.textCenter(" New game ", '═');
        Utilities.textCenter(" Name Selection ", '─');
        System.out.println();

        Utilities.textCenter("Please enter a name with 9 characters or less and no spaces", ' ');
        System.out.println(String.format("\nPlayer %s enter your name...", playerNumber));
        String input = console.next();

        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static void startScreen(String gameName, String[] instructions, Scanner console) {
        Utilities.clearScreen();

        Utilities.textCenter(String.format(" Welcome to %s!! ", gameName), '═');
        Utilities.textCenter(" Designed by Eduardo Racy ", '─');

        System.out.println("1. Start Game");
        System.out.println("2. Instructions");
        int input = console.nextInt();

        Utilities.clearScreen();

        if (input == 1) {
            return;
        } else if (input == 2) {
            instructions(instructions, console);
            startScreen(gameName, instructions, console);
        } else {
            Utilities.clearScreen();
            Utilities.textCenter(String.format(" Welcome to %s!! ", gameName), '═');
            Utilities.textCenter(" Designed by Eduardo Racy ", '─');
            System.out.println("Invalid Selection");
            System.out.println("Press ENTER to try again...");
            console.nextLine();
            console.nextLine();

            startScreen(gameName, instructions, console);
        }
    }

    public static void instructions(String[] instructions, Scanner console) {
        Utilities.textCenter(" New game ", '═');
        Utilities.textCenter(" Instructions ", '─');
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
