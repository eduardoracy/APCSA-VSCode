import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        new Hangman().startGame();
    }

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

    public int logic() {
        Utility.clearScreen();

        String secretPhrase = phraseInputSelection();
        char[][] secretArr = new char[2][secretPhrase.length()];
        secretArr[0] = secretPhrase.toCharArray();
        int turnCounter = 1, incorrectGuesses = 0;

        while (true) {
            incorrectGuesses = playerTurn(secretArr, turnCounter++, incorrectGuesses);
            if (secretArr[0].equals(secretArr[1]) || turnCounter > 5) {
                break;
            }
        }
        return turnCounter;
    }

    public int playerTurn(char[][] secret, int turnCounter, int incorrectGuesses) {
        Utility.clearScreen();
        Utility.printTurnHeader(String.format("Turn: %s", turnCounter), "Player");

        printBoard(secret, incorrectGuesses);

        System.out.println("Enter a guess for a letter: ");

        return boardMarker(secret, console.next().charAt(0)) ? incorrectGuesses : incorrectGuesses++;
    }

    public boolean boardMarker(char[][] secret, char guess) {
        boolean marked = false;
        for (int i = 0; i < secret.length; i++) {
            if (secret[0][i] == guess) {
                secret[1][i] = guess;
                marked = true;
            }
        }
        return marked;
    }

    public void printBoard(char[][] secret, int incorrectGuesses) {
        System.out.printf("Incorrect Guesses: %s\n", incorrectGuesses);

        printSecretWordGuesses(secret);
    }

    public void printSecretWordGuesses(char[][] secret) {
        StringBuilder sb = new StringBuilder();
        for (char letter : secret[1]) {
            System.out.print(sb.underline(String.format("%s", letter)) + " ");
        }
        System.out.println();
    }

    public String phraseInputSelection() {
        Utility.printTurnHeader("Secret Phrase Selection", "Game Master");
        Utility.textCenter("Game Master please input secret phrase for player to guess", ' ');
        console.nextLine();
        return console.nextLine().trim();
    }

    public boolean endScreen(int turnCounter) {
        Utility.printTurnHeader("Hangman", "Game Over");
        System.out.println();

        String status = turnCounter > 5 ? "You lost..." : "Congratulations, you've won";
        Utility.textCenter(status, ' ');

        Utility.textCenter("Would you like to return to start screen?", ' ');
        if (console.next().equalsIgnoreCase("no")) {
            return false;
        } else {
            return true;
        }
    }
}
