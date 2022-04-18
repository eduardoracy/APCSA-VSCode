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
        gameLogic(board, player1, player1, player2);

    }

    public void gameLogic(JeopardyBoard board, JeopardyPlayer nextQuestionPlayer, JeopardyPlayer currentPlayer, JeopardyPlayer otherPlayer) {
        boolean allQuestionsAnswered = board.allQuestionsAnswered();
        if(!allQuestionsAnswered) {
            if (nextQuestionPlayer.equals(otherPlayer)) {
                nextQuestionPlayer = otherPlayer;
                otherPlayer = currentPlayer;
            }
            gameLogic(board, questionSelection(board, currentPlayer, otherPlayer), currentPlayer, otherPlayer);
        } else {
            //Final Jeopardy
        }
    }

    public JeopardyPlayer questionSelection(JeopardyBoard board, JeopardyPlayer currentPlayer, JeopardyPlayer otherPlayer) {
        String input = console.next();
        for (JeopardyBoardCategory category : board.getCategories()) {
            if (input.equals(category.getCategory())) {
                category.categoryQuestion(console.nextInt()).askQuestion(currentPlayer, otherPlayer, console);
            }
        }
        return currentPlayer;
    }

}
