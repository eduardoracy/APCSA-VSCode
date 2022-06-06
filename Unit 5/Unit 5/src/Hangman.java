import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.underline("HELLO THERE"));
    }
    Scanner console = new Scanner(System.in);
    public void startGame() {
        boolean continuePlay = true;
        String[] arr = new String[0];
        while (continuePlay) {
            Utility.startScreen("Hangman", arr, console);
            logic();
        }
    }

    public void logic() {
        Utility.clearScreen();
        
        //String secretPhrase = phraseInputSelection();

    }

    public void playerTurn(int turnCounter) {
        Utility.clearScreen();
        Utility.printTurnHeader(String.format("Turn: &s", turnCounter), "Player");

        //printBoard();
    }

    public String phraseInputSelection() {
        Utility.printTurnHeader("Secret Phrase Selection", "Game Master");
        Utility.textCenter("Game Master please input secret phrase for player to guess", ' ');
        return console.nextLine().trim();
    }
}
