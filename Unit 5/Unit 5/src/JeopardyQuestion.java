import java.util.Scanner;

class JeopardyQuestion {
    Scanner input = new Scanner(System.in);
    private String question;
    private String answer;
    private int value;
    private boolean answered;
    private int attempts;
    private String answerFormat;

    public JeopardyQuestion(String question, String answer, String answerFormat, int value) {
        this.question = question;
        this.answer = answer;
        this.answerFormat = answerFormat;
        this.value = value;
        this.answered = false;
    }

    public int getValue() {
        return value;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void dailyDouble() {
        value *= 2;
    }

    public void askQuestion(JeopardyBoard board, JeopardyBoardCategory category, Scanner console) {
        JeopardyPlayer player = board.getCurrentPlayer();
        while (!answered && attempts <= 2) {
            attempts++;
            Utility.clearScreen();

            Utility.printTurnHeader(player.getName(), "Points:", player.getPoints());
            System.out.format("%s for %s\n", category.getCategory(), value);
            System.out.format("%s?\n", question);
            System.out.format("%s ", answerFormat);
            String response = console.next();

            if (response.equalsIgnoreCase(answer)) {
                answered = true;
                player.incrementPoints(value);
                Utility.textCenter("Correct Response!!", ' ');
                Utility.textCenter(String.format("%s now has %s points", player.getName(), player.getPoints()), ' ');
                System.out.println();
            } else {
                player.incrementPoints(value * (-1));
                Utility.textCenter("Incorrect Response!!", ' ');
                Utility.textCenter(String.format("%s now has %s points", player.getName(), player.getPoints()), ' ');
                System.out.println();
                board.setCurrentPlayer(player);
                if (attempts == 1) {
                    Utility.textCenter(String.format("%s would you like to steal?", player.getName()), ' ');
                    if (console.next().equalsIgnoreCase("no")) {
                        answered = true;
                    }
                }
            }
        }
        Utility.enterToContinue(console);
    }
} 