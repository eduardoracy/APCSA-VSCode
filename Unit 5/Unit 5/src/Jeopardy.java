import java.util.Scanner;

public class Jeopardy {
    Scanner console = new Scanner(System.in);
    String[] instructions = { "asdf" };
    JeopardyBoardCategory[] categories = new JeopardyBoardCategory[5];
    JeopardyBoard board;

    public static void main(String[] args) {
        new Jeopardy().startGame();
    }

    public void startGame() {
        boolean continuePlay = true;
        while (continuePlay) {
            Utilities.startScreen("Java Jeopardy", instructions, console);
            board = JeopardyBoard.createBoard();
            gameLogic();
            continuePlay = endGame();
        }
    }

    public void gameLogic() {
        if (!board.allQuestionsAnswered()) {
            questionSelection(categorySelection());
            gameLogic();
        }
        finalJeopardy();
    }

    public JeopardyBoardCategory categorySelection() {
        Utilities.clearScreen();
        board.getCurrentPlayer().printTurnHeader();
        board.printBoard();

        String categories = "";
        for (int i = 0; i < board.getCategories().size(); i++) {
            JeopardyBoardCategory category = board.getCategories().get(i);
            if (!category.allCategoryQuestionsAnswered())
                System.out.println(String.format("%s. %s", i + 1, category.getCategory()));
            categories.concat(String.format("%s", i + 1));
        }

        String input = console.next();
        for (int i = 0; i < board.getCategories().size(); i++) {
            String categoryOptions = String.format("%s", i + 1);
            if (input.equals(categoryOptions) && categories.contains(categoryOptions)) {
                return board.getCategories().get(i);
            }
        }
        Utilities.textCenter("Category unavailable, please choose another category", ' ');
        Utilities.enterToContinue(console);
        return categorySelection();
    }

    public void questionSelection(JeopardyBoardCategory category) {
        Utilities.clearScreen();
        board.getCurrentPlayer().printTurnHeader();
        board.printBoard();

        System.out.println("Enter question amount you would like to attempt: ");
        String input = console.next();

        for (JeopardyQuestion question : category.getQuestion()) {
            int inputValue = Integer.valueOf(input);
            if (inputValue == question.getValue()) {
                category.categoryQuestion(inputValue).askQuestion(board, category, console);
                return;
            }
        }
        Utilities.textCenter("Category unavailable, please choose another category", ' ');
        Utilities.enterToContinue(console);
        questionSelection(category);
    }

    public void finalJeopardy() {
        boolean player1 = finalJeopardyPlayerTurn();
        board.setCurrentPlayer(board.getCurrentPlayer());
        boolean player2 = finalJeopardyPlayerTurn();

        Utilities.clearScreen();
        Utilities.printTurnHeader("Final Jeopardy", "Results");

        for (int i = 0; i < 2; i++) {
            JeopardyPlayer player = board.getCurrentPlayer();
            Utilities.textCenter(String.format("%s wagered %s points", player.getName(),
                    board.getFinalJeopardyWagers()[player.getPlayerNumber() - 1]), ' ');
            board.setCurrentPlayer(player);
        } // after loop player1 is currentPlayer

        if (player1 && player2) {
            Utilities.textCenter("Both players correctly answered the final question", ' ');
        } else {
            if (player2) {
                board.setCurrentPlayer(board.getCurrentPlayer());
            }
            Utilities.textCenter(String.format("%s is the only player that correctly answered the final question",
                    board.getCurrentPlayer().getName()), ' ');
        }
        Utilities.textCenter(String.format("The correct answer was %s", board.getFinalJeopardyAnswer()), ' ');
        System.out.println();
        Utilities.enterToContinue(console);
    }

    public boolean finalJeopardyPlayerTurn() {
        JeopardyPlayer player = board.getCurrentPlayer();
        Utilities.clearScreen();
        Utilities.printTurnHeader("Final Jeopardy", player.getName());

        int points = player.getPoints();
        System.out.println(String.format("Available points: %s", player.getPoints()));
        System.out.println("How many points would you like to wager?");
        int wager = board.getFinalJeopardyWagers()[player.getPlayerNumber() - 1] = console.nextInt();

        boolean correct = false;
        if (wager <= points) {
            correct = board.askFinalJeopardy();
            if (correct) {
                player.incrementPoints(wager);
            } else {
                player.decrementPoints(wager);
            }
        } else {
            Utilities.textCenter("Wager is greater than available points", ' ');
            Utilities.enterToContinue(console);
            finalJeopardyPlayerTurn();
        }
        return correct;
    }

    public boolean endGame() {
        Utilities.clearScreen();
        Utilities.printTurnHeader("Java Jeopardy", "End of Game");

        JeopardyPlayer player1 = board.getPlayer1();
        JeopardyPlayer player2 = board.getPlayer2();

        if (player1.getPoints() > player2.getPoints()) {
            Utilities.textCenter(String.format("%s is the winner!!", player1.getName()), ' ');
        } else if (player2.getPoints() > player1.getPoints()) {
            Utilities.textCenter(String.format("%s is the winner!!", player2.getName()), ' ');
        } else {
            Utilities.textCenter("The game has ended in a tie", ' ');
        }

        System.out.println();

        Utilities.textCenter(String.format("%s has ended with %s points", player1.getName(), player1.getPoints()), ' ');
        Utilities.textCenter(String.format("%s has ended with %s points", player2.getName(), player2.getPoints()), ' ');

        Utilities.textCenter("Would you like to play again?", ' ');
        if (console.next().equalsIgnoreCase("no")) {
            return false;
        } else {
            return true;
        }
    }
}
