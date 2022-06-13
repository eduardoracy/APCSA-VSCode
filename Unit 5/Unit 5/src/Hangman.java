import java.util.*;

public class Hangman {

    Scanner console = new Scanner(System.in);

    public void startGame() {
        boolean continuePlay = true;
        String[] arr = new String[0];
        while (continuePlay) {
            Utility.startScreen("Hangman", arr, console);
            continuePlay = endScreen(logic());
        }
        Utility.textCenter("Thank you for playing", ' ');
    }

    public boolean logic() {
        Utility.clearScreen();

        ArrayList<ArrayList<Character>> arr = createArrayList("cat");
        int turnCounter = 1;
        while (!checkEquals(arr) && arr.get(2).size() < 6 && !arr.get(2).contains('!')) {
            playerTurn(arr, turnCounter++);
        }
        System.out.println("Game has ended, press ENTER to continue to end screen...");
        console.nextLine();
        console.nextLine();
        return arr.get(2).size() < 6 && !arr.get(2).contains('!');
    }

    public void playerTurn(ArrayList<ArrayList<Character>> arr, int turnCounter) {
        Utility.clearScreen();
        Utility.printTurnHeader(String.format("Turn: %s", turnCounter), "Player");

        printBoard(arr);

        System.out.println("1. Guess a letter");
        System.out.println("2. Solve the phrase");
        int input = 0;
        try {
            input = console.nextInt();
        } catch (InputMismatchException e) {
        }
        Utility.clearScreen();
        Utility.printTurnHeader("Hangman", "Guessing");

        printBoard(arr);

        if (input == 1) {
            System.out.println("Enter a guess for a letter: ");
            boardMarker(arr, Character.toLowerCase(console.next().charAt(0)), turnCounter);
        } else if (input == 2) {
            System.out.println("Enter a guess for the phrase: ");
            console.nextLine();
            for (char letter : console.nextLine().trim().toCharArray()) {
                if (!arr.get(0).contains(letter)) {
                    arr.get(2).add('!');
                    break;
                }
            }
        } else {
            Utility.textCenter("Invalid selection, Press ENTER to try again...", ' ');
            console.nextLine();
            playerTurn(arr, turnCounter);
        }
    }

    public void boardMarker(ArrayList<ArrayList<Character>> arr, char guess, int turnCounter) {
        if (!arr.get(2).contains(guess) && !arr.get(1).contains(guess) && !Character.isDigit(guess)) {
            for (int i = 0; i < arr.get(0).size(); i++) {
                if (arr.get(0).get(i) == guess) {
                    arr.get(1).set(i, guess);
                }
            }
            if (!arr.get(0).contains(guess)) {
            arr.get(2).add(guess);
            }
        } else {
            System.out.println("You've already guessed this letter or the selection type  is invalid,");
            System.out.print("Press ENTER to try again...");
            console.nextLine();
            console.nextLine();
            playerTurn(arr, turnCounter);
        }
    }

    public void printSecretWordGuesses(ArrayList<ArrayList<Character>> arr) {
        System.out.print("Previous Guesses: ");
        for (char letter : arr.get(2)) {
            System.out.printf("%s ", letter);
        }
        System.out.println();
        for (char letter : arr.get(1)) {
            System.out.print(new StringBuilder().underline(Character.toString(letter)) + " ");
        }
        System.out.println();
    }

    public String phraseInputSelection() {
        // Utility.printTurnHeader("Secret Phrase Selection", "Game Master");
        // Utility.textCenter("Game Master please input secret phrase for player to
        // guess", ' ');
        // console.nextLine();
        // return console.nextLine().trim();
        String[] arr = { "umpire", "ball", "babolat", "net", "deuce", "advantage", "wilson", "game", "set", "match" };
        return arr[(int) (Math.random() * 5)];
    }

    public boolean endScreen(boolean won) {
        Utility.clearScreen();
        Utility.printTurnHeader("Hangman", "Game Over");
        System.out.println();

        String status = won ? "Congratulations, you've won" : "You lost...";
        Utility.textCenter(status, ' ');

        Utility.textCenter("Would you like to return to start screen?", ' ');
        if (console.next().equalsIgnoreCase("no")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkEquals(ArrayList<ArrayList<Character>> arr) {
        for (int i = 0; i < arr.get(0).size(); i++) {
            if (arr.get(0).get(i) != arr.get(1).get(i)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<ArrayList<Character>> createArrayList(String secretPhrase) {
        ArrayList<ArrayList<Character>> arr = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            arr.add(new ArrayList<>());
        }
        for (char letter : secretPhrase.toCharArray()) {
            arr.get(0).add(letter);
            arr.get(1).add(' ');
        }
        return arr;
    }

    public void printBoard(ArrayList<ArrayList<Character>> arr) {
        Top();
        switch (arr.get(2).size()) {

            case 0:
                Middle1();
                break;

            case 1:
                Head();
                Middle2();
                break;

            case 2:
                Head();
                Body();
                Middle3();
                break;

            case 3:
                Head();
                Arms1();
                Middle4();
                break;

            case 4:
                Head();
                Arms2();
                Middle4();
                break;

            case 5:
                Head();
                Arms2();
                Legs1();
                Middle4();
                break;

            case 6:
                Head();
                Arms2();
                Legs2();
                Middle4();
                System.out.println("Game over...");
                break;

            default:
                System.out.println("ERROR");
                break;
        }
        Bottom();
        printSecretWordGuesses(arr);
    }

    public void Top() {
        System.out.print("""
                _______________
                | |  //       |
                    """);
    }

    public void Middle1() {
        System.out.print("""
                | | //
                | |//
                | |/
                | |
                | |
                | |
                | |
                | |
                | |
                | |
                | |
                    """);
    }

    public void Middle2() {
        System.out.print("""
                | |
                | |
                | |
                | |
                | |
                | |
                | |
                | |
                    """);
    }

    public void Middle3() {
        System.out.print("""
                | |
                | |
                | |
                | |
                | |
                    """);
    }

    public void Middle4() {
        System.out.print("""
                | |
                | |
                | |
                    """);
    }

    public void Bottom() {
        System.out.print("""
                _______________
                |_____________|
                    """);
    }

    public void Head() {
        System.out.print("""
                | | //       _|_
                | |//       /x x\\
                | |/        \\_-_/
                    """);
    }

    public void Body() {
        System.out.print("""
                | |           |
                | |           |
                | |           |
                    """);
    }

    public void Arms1() {
        System.out.print("""
                | |           |
                | |          /|
                | |         / |
                    """);
    }

    public void Arms2() {
        System.out.print("""
                | |           |
                | |          /|\\
                | |         / | \\
                    """);
    }

    public void Legs1() {
        System.out.print("""
                | |          /
                | |         /
                    """);
    }

    public void Legs2() {
        System.out.print("""
                | |          / \\
                | |         /   \\
                    """);
    }

}
