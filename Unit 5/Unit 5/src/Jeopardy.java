import java.util.Scanner;

public class Jeopardy {
    Scanner console = new Scanner(System.in);
    String[] instructions = { "asdf" };
    JeopardyBoardCategory[] categories = new JeopardyBoardCategory[5];

    public static void main(String[] args) {
        new Jeopardy().startGame();
    }

    public void startGame() {
        Utilities.startScreen("Jeopardy", instructions, console);
        JeopardyPlayer player1 = new JeopardyPlayer(Utilities.nameSelect(1, console), 0, 1);
        JeopardyPlayer player2 = new JeopardyPlayer(Utilities.nameSelect(2, console), 0, 2);
        JeopardyBoard board = JeopardyBoard.createBoard();

    }
    
}
