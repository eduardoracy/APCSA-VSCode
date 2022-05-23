import java.util.Scanner;

class JeopardyQuestion {
    private String question;
    private String answer;
    private int value;
    private boolean answered;
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
        int attempts = 0;
        while (!answered && attempts < 2) {
            attempts++;
            Utility.clearScreen();

            Utility.printTurnHeader(player.getName(), "Points:", player.getPoints());
            System.out.format("%s for %s\n", category.getCategoryName(), value);
            System.out.format("%s?\n", question);
            System.out.format("%s ", answerFormat);
            console.nextLine();
            String response = console.nextLine().toLowerCase();

            if (response.contains(answer)) {
                answered = true;
                player.incrementPoints(value);
                Utility.textCenter("Correct Response!!", ' ');
                Utility.textCenter(String.format("%s now has %s points", player.getName(), player.getPoints()), ' ');
                System.out.println();
            } else {
                player.decrementPoints(value);
                Utility.textCenter("Incorrect Response!!", ' ');
                Utility.textCenter(String.format("%s now has %s points", player.getName(), player.getPoints()), ' ');
                System.out.println();

                board.changeCurrentPlayer();
                player = board.getCurrentPlayer();
                if (attempts == 1) {
                    Utility.textCenter(String.format("%s would you like to steal?", player.getName()), ' ');
                    String input = console.next();
                    if (input.equalsIgnoreCase("no")) {
                        answered = true;
                    } else if (input.equalsIgnoreCase("overwrite")) {
                        board.changeCurrentPlayer();
                        player = board.getCurrentPlayer();
                        player.incrementPoints(value);
                        attempts--;
                    }
                }
            }
        }
        Utility.textCenter("Press ENTER to continue...", ' ');
        console.nextLine();
    }
} 