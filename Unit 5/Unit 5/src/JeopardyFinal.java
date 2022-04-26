import java.util.Scanner;

public class JeopardyFinal {
    private String question, answer;
    private int wager1, wager2;


    public JeopardyFinal(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public int getWager(JeopardyPlayer player) {
        if (player.getPlayerNumber() == 1) {
            return wager1;
        } else {
            return wager2;
        }
    }

    public boolean playerWagers(JeopardyPlayer player, Scanner console) {
        Utility.clearScreen();
        Utility.printTurnHeader("Final Jeopardy", player.getName());

        int points = player.getPoints();
        System.out.format("Available points: %s\n", player.getPoints());
        System.out.println("How many points would you like to wager?");
        int wager = console.nextInt();
        if (player.getPlayerNumber() == 1) {
            wager1 = wager;
        } else {
            wager2 = wager;
        }

        boolean correct = false;
        if (wager <= points) {
            correct = askFinalJeopardy(player, console);
            if (correct) {
                player.incrementPoints(wager);
            } else {
                player.decrementPoints(wager);
            }
        } else {
            Utility.textCenter("Wager is greater than available points", ' ');
            Utility.enterToContinue(console);
            playerWagers(player, console);
        }
        return correct;
    }

    public boolean askFinalJeopardy(JeopardyPlayer player, Scanner console) {
        Utility.clearScreen();
        Utility.printTurnHeader("Final Jeopardy", player.getName());

        System.out.println("You will have 30 seconds to read and answer the question");
        Utility.enterToContinue(console);

        Utility.textCenter(question, ' ');
        long startTime = System.currentTimeMillis();

        String input = console.next();
        long endTime = System.currentTimeMillis();

        if ((endTime - startTime) <= 30000) {
                if (input.equals(answer)) {
                        return true;
                }
        } else {
                Utility.textCenter("You ran out of time...", ' ');
                Utility.enterToContinue(console);
        }
        return false;
}
}
