import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.underline("HELLO THERE"));
    }
    Scanner console = new Scanner(System.in);
    public void startGame() {
        console.useDelimiter("");
        boolean continuePlay = true;
        String[] arr = new String[0];
        while (continuePlay) {
            Utility.startScreen("Hangman", arr, console);
            logic();
        }
    }

    public void logic() {
        Utility.clearScreen();
        
        String secretPhrase = phraseInputSelection();
        char[][] secretArr = new char[2][secretPhrase.length()];
        secretArr[0] = secretPhrase.toCharArray();
        int turnCounter = 1;

        boolean gameOver = true;
        while (gameOver) {
            gameOver = playerTurn(secretArr, turnCounter);
        }
    }

    public boolean playerTurn(char[][] secret, int turnCounter) {
        Utility.clearScreen();
        Utility.printTurnHeader(String.format("Turn: &s", turnCounter), "Player");

        //printBoard();
        //printSecretWordGuesses;

        System.out.println("Enter a guess for a letter: ");
        boardMarker(console.next());
        return false;
    }

    public void boardMarker(String guess) {
        
    }

    public String phraseInputSelection() {
        Utility.printTurnHeader("Secret Phrase Selection", "Game Master");
        Utility.textCenter("Game Master please input secret phrase for player to guess", ' ');
        return console.nextLine().trim();
    }
}
