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
       		gameLogic(board.getCurrentPlayer());
					continuePlay = endScreen();
					}
				Utilities.textCenter("Thank you for playing!!", ' ');
			}

    public void gameLogic(JeopardyPlayer player) {
        board.setCurrentPlayer(board.getCurrentPlayer());
        if(!board.allQuestionsAnswered()) {
            gameLogic(questionSelection());
        } else {
            finalJeopardy();
        }
    }

    public JeopardyPlayer questionSelection() {
        String input = console.next();
        for (JeopardyBoardCategory category : board.getCategories()) {
            if (input.equals(category.getCategory())) {
                category.categoryQuestion(console.nextInt()).askQuestion(board, console);
            }
        }
        return board.getCurrentPlayer();
    }

    public void finalJeopardy() {
        
    }
		public boolean endScreen() {
        Utilities.clearScreen();
        Utilities.textCenter(" Java Jeopardy ", '═');
        Utilities.textCenter(" Game Over ", '─');
			
				String winner = "";
				JeopardyPlayer player1 = board.getPlayer(1);
				JeopardyPlayer player2 = board.getPlayer(2);
				if (player1.getPoints() > player2.getPoints()) {
					winner = player1.getName();
				} else if (player1.getPoints() < player2.getPoints()) {
					winner = player2.getName();
				} else {
					
				}

				System.out.println();
        if (!winner.equals("")) {
            Utilities.textCenter("Game has ended in a tie", ' ');
        } else {
            Utilities.textCenter(winner + " is the winner!", ' ');
        }

        Utilities.textCenter("Would you like to return to start screen?", ' ');
        if (console.next().equalsIgnoreCase("no")) {
            return false;
        } else {
            return true;
        }
    }

}