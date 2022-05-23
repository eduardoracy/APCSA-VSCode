
import java.util.Scanner;

public class Jeopardy {
    Scanner console = new Scanner(System.in);
    String[] instructions = { "If you believe your incorrect response to any of the questions is correct", "write \"overwrite\" when prompted if you would like to continue" };
    JeopardyBoardCategory[] categories = new JeopardyBoardCategory[5];
    JeopardyBoard board;

    public static void main(String[] args) {
        new Jeopardy().startGame();
    }

    public void startGame() {
        boolean continuePlay = true;
        while (continuePlay) {
            Utility.startScreen("Java Jeopardy", instructions, console);
            board = new JeopardyBoard(Utility.nameSelect(1, console), Utility.nameSelect(2, console));
            gameLogic();
            continuePlay = endScreen();
        }
    }

    public void gameLogic() {
        while (!board.allQuestionsAnswered()) {
            questionSelection(categorySelection());
        }
        finalJeopardy();
    }

    public JeopardyBoardCategory categorySelection() {
        Utility.clearScreen();
        board.getCurrentPlayer().printTurnHeader();
        board.printBoard();

        String categories = "";
        for (int i = 0; i < board.getCategories().size(); i++) {
            JeopardyBoardCategory category = board.getCategories().get(i);
            if (!category.allCategoryQuestionsAnswered())
                System.out.format("%s. %s\n", i + 1, category.getCategoryName());
            categories += String.format("%s", i + 1);
        }

        String input = console.next();
        for (int i = 0; i < board.getCategories().size(); i++) {
            String categoryOptions = String.format("%s", i + 1);
            if (input.equals(categoryOptions) && categories.contains(categoryOptions)) {
                return board.getCategories().get(i);
            }
        }
        Utility.textCenter("Category unavailable, please choose another category", ' ');
        Utility.enterToContinue(console);
        return categorySelection();
    }

    public void questionSelection(JeopardyBoardCategory category) {
        Utility.clearScreen();
        Utility.printTurnHeader(board.getCurrentPlayer().getName(), category.getCategoryName());
        board.printBoard();

        System.out.println("Enter the question amount you would like to attempt: ");
        String input = console.next();

        for (JeopardyQuestion question : category.getQuestions()) {
            int inputValue = Integer.parseInt(input);
            if (inputValue == question.getValue()) {
                category.categoryQuestion(inputValue).askQuestion(board, category, console);
                return;
            }
        }
        
        Utility.textCenter("Category unavailable, please choose another category", ' ');
        Utility.enterToContinue(console);
        questionSelection(category);
    }

    public void finalJeopardy() {
        Utility.clearScreen();
        Utility.printTurnHeader("Final Jeopardy", "Instructions");

        Utility.textCenter("Players will take turns answering the Final Jeopardy Question", ' ');
        Utility.textCenter("The player not actively answering should look away from the screen", ' ');
        System.out.println();
        Utility.enterToContinue(console);

        JeopardyFinal finalJeopardy = board.getFinalJeopardy();
        finalJeopardy.playerWagers(board.getCurrentPlayer(), console);
        board.changeCurrentPlayer();
        finalJeopardy.playerWagers(board.getCurrentPlayer(), console);

        JeopardyPlayer player1 = board.getPlayer(1);
        JeopardyPlayer player2 = board.getPlayer(2);


        Utility.textCenter(String.format("%s waged %s points", player1.getName(), finalJeopardy.getWager(player1)), ' ');
        Utility.textCenter(String.format("%s waged %s points", player2.getName(), finalJeopardy.getWager(player2)), ' ');
    }

    public boolean endScreen() {
        Utility.clearScreen();
        Utility.textCenter(" Java Jeopardy ", '═');
        Utility.textCenter(" Game Over ", '─');

        String winner = null;
        JeopardyPlayer player1 = board.getPlayer(1);
        JeopardyPlayer player2 = board.getPlayer(2);
        
        if (player1.getPoints() > player2.getPoints()) {
            winner = player1.getName();
        } else if (player1.getPoints() < player2.getPoints()) {
            winner = player2.getName();
        }

        System.out.println();
        if (winner == null) {
            Utility.textCenter("Game has ended in a tie", ' ');
        } else {
            Utility.textCenter(winner + " is the winner!", ' ');
        }

        System.out.println();

        Utility.textCenter(String.format("%s has ended with %s points", player1.getName(), player1.getPoints()), ' ');
        Utility.textCenter(String.format("%s has ended with %s points", player2.getName(), player2.getPoints()), ' ');

        System.out.println();
        Utility.textCenter("Would you like to return to start screen?", ' ');
        if (console.next().equalsIgnoreCase("no")) {
            return false;
        } else {
            return true;
        }
    }
    
}
