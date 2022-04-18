import java.util.Scanner;

public class Jeopardy {
    Scanner console = new Scanner(System.in);
    String[] instructions = { "asdf" };
    JeopardyBoardCategory[] categories = new JeopardyBoardCategory[5];

    public static void main(String[] args) {
        new Jeopardy().startGame();
    }

    public void startGame() {
        Utilities.startScreen("Java Jeopardy", instructions, console);
        JeopardyBoard board = JeopardyBoard.createBoard();
        gameLogic(board, board.getCurrentPlayer());
    }

    public void gameLogic(JeopardyBoard board, JeopardyPlayer player) {
        board.setCurrentPlayer(board.getCurrentPlayer());
        if(!board.allQuestionsAnswered()) {
            gameLogic(board, questionSelection(board));
        } else {
            finalJeopardy(board);
        }
    }

    public JeopardyPlayer questionSelection(JeopardyBoard board) {
        String input = console.next();
        for (JeopardyBoardCategory category : board.getCategories()) {
            if (input.equals(category.getCategory())) {
                category.categoryQuestion(console.nextInt()).askQuestion(board, console);
            }
        }
        return board.getCurrentPlayer();
    }

    public void finalJeopardy(JeopardyBoard board) {
        
    }

}
