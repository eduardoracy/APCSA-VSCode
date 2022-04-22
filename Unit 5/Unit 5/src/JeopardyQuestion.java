import java.util.Scanner;

class JeopardyQuestion {
    Scanner input = new Scanner(System.in);
    private String question;
    private String answer;
    private int value;
    private boolean answered;
    private int attempts;
    private String answerFormat;

    public JeopardyQuestion(String question, String answer, String answerFormat, int value, boolean answered) {
        this.question = question;
        this.answer = answer;
        this.value = value;
        this.answered = answered;
        this.answerFormat = answerFormat;
    }

    public int getValue() {
        return value;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void askQuestion(JeopardyBoard board, Scanner console) {
        JeopardyPlayer player = board.getCurrentPlayer();
        while (!answered || attempts <= 2) {
            attempts++;
            Utilities.clearScreen();
						
            Utilities.printTurnHeader(player.getName(), "Points:", player.getPoints());
            System.out.println(String.format("\n%s?", question));
            System.out.println(String.format("%s ", answerFormat));
					
            if (console.next().equalsIgnoreCase(answer)) {
                player.incrementPoints(value);
                answered = true;
            } else {
                player.decrementPoints(value);
                Utilities.textCenter("Incorrect Response!!", ' ');
                Utilities.textCenter(String.format("%s now has %s points", player.getName(), player.getPoints()), ' ');
                System.out.println();
                if (attempts == 1) { 
                    board.setCurrentPlayer(player);
                    player = board.getCurrentPlayer();
                    Utilities.textCenter(String.format("%s would you like to steal?", player.getName()), ' ');
                    if (console.next().equalsIgnoreCase("no")) {
                        answered = true;
                    }
                } else {
                    board.setCurrentPlayer(player);
                }
            }
        }
        Utilities.enterToContinue(console);
    }
}