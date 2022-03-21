import java.util.Scanner;

public class TicTacToe {
    char[] board = new char[9];
    int turnCounter = 1;
    int subTurnCounter = 0;
    boolean startScreen = false;
    boolean marked = false;
    Scanner console = new Scanner(System.in);
    String UI;
    String p1, p2, nextP;
    boolean won = false;
    boolean continuePlay = true;
    String nameHeader;
    char marker;
    int cellLoc = 0;
    int row, col;
    boolean outBounds;

    final int[][][] winPosibilitiesCoordinates = {
            { { 0, 0 }, { 0, 1 }, { 0, 2 } },
            { { 1, 0 }, { 1, 1 }, { 1, 2 } },
            { { 2, 0 }, { 2, 1 }, { 2, 2 } },

            { { 0, 0 }, { 1, 0 }, { 2, 0 } },
            { { 0, 1 }, { 1, 1 }, { 2, 1 } },
            { { 0, 2 }, { 1, 2 }, { 2, 2 } },

            { { 0, 0 }, { 1, 1 }, { 2, 2 } },
            { { 2, 0 }, { 1, 1 }, { 0, 2 } }
    };

    public static void main(String[] args) {
        new TicTacToe().newGame();
    }

    public void newGame() {
        while (continuePlay) {
            p1 = p2 = " ";
            for (int i = 0; i < board.length; i++) {
                board[i] = ' ';
            }
            startScreen();
            turn();
        }
    }

    public void turn() {
        while (!won || turnCounter <= 9) {
            if (turnCounter % 2 != 0) {
                nameHeader = p1;
                nextP = p2;
                marker = 'X';
            } else {
                nameHeader = p2;
                nextP = p1;
                marker = 'O';
            }
            while (!marked) {
                turnHeader();
                System.out.println("Enter what cell you would like to mark:");
                cellLoc = (console.nextInt() - 1);
                boardMarker();
                UT.clearScreen();
            }

            turnCounter++;
            marked = outBounds = false;
            detection();

            turnHeader();
            pBoard();
            UT.textCenter("Press ENTER to continue...", ' ', 50);
            UI = console.nextLine();
            UI = console.nextLine();


        }
    }

    public void turnHeader() {
        UT.textCenter(" " + nameHeader + " ", '═', 50);
        UT.textCenter(" Turn: " + turnCounter + " ", '─', 50);
        System.out.println();
    }

    public void boardMarker() {
        try {
            if (board[cellLoc] == ' ') {
                board[cellLoc] = marker;

                marked = true;
            } else {
                System.out.println("Location unavailable, please choose another cell to mark");
                System.out.print("Press ENTER to continue");
                UI = console.nextLine();
                UI = console.nextLine();
                outBounds = false;
            }
        } catch (ArrayIndexOutOfBoundsException asdf) {
            System.out.println("Location out of bounds, please choose another cell to mark");
            System.out.print("Press ENTER to continue");
            UI = console.nextLine();
            UI = console.nextLine();
            return;
        }
    }

    public boolean detection() {
        for (int[][] posib : winPosibilitiesCoordinates) {
            for (int[] coordinate : posib) {
                if (marker != board[coordinate[0]] && marker != board[coordinate[1]]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void startScreen() {
        UT.clearScreen();
        if (!startScreen) {
            UT.textCenter("Press ENTER to start...", ' ', 50);// claUIic start screen
            UI = console.nextLine();

            UT.clearScreen();
            startScreen = true;
        }
        UT.textCenter(" Welcome to Tic-Tac-Toe!! ", '═', 50);
        UT.textCenter(" Designed by Eduardo Racy ", '─', 50);
        System.out.println("1. Start Game");
        System.out.println("2. Instructions");
        UI = console.next();
        UT.clearScreen();
        if (UI.equals("1")) {
            nameSelect();
        } else if (UI.equals("2")) {
            // instructions();
            startScreen();
        } else {
            UT.clearScreen();
            UT.textCenter(" Welcome to Tic-Tac-Toe!! ", '═', 50);
            UT.textCenter(" Designed by Eduardo Racy ", '─', 50);
            System.out.println("Invalid Selection");
            System.out.println("Press ENTER to try again...");
            UI = console.nextLine();
            UI = console.nextLine();
            startScreen();
        }
    }

    public void nameSelect() {
        UT.textCenter(" New game ", '═', 50);
        UT.textCenter(" Name Selection ", '─', 50);
        System.out.println();
        UT.textCenter("Please enter a name with 9 characters or leUI.", ' ', 50);
        System.out.println("\nPlayer 1 enter your name...");
        UI = console.next();
        p1 = UI.substring(0, 1).toUpperCase() + UI.substring(1).toLowerCase();
        System.out.println("\nPlayer 2 enter your name...");
        UI = console.next();
        p2 = UI.substring(0, 1).toUpperCase() + UI.substring(1).toLowerCase();
        System.out.println();
        UT.textCenter("Press ENTER to continue...", ' ', 50);
        UI = console.nextLine();
        UI = console.nextLine();
        UT.clearScreen();
    }

    public void pBoard() {
        turnHeader();
        int boardRow = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (i % 2 == 0) { // 2 Middle cross rows
                    System.out.print("───");
                    if (j < 2) {
                        System.out.print("┼");
                    }
                } else { // Rows with user values
                    System.out.print(String.format(" %s ", board[boardRow]));
                    if (j < 2) {
                        System.out.print("│");
                    }
                    boardRow++;
                }
            }
            System.out.println();
        }
        System.out.println();
        if (won) {
            UT.textCenter(nameHeader + " is the winner", ' ', 50);
            UT.textCenter("Would you like to play again?", ' ', 50);
            if (console.next().equalsIgnoreCase("no")) {
                continuePlay = false;
            }
        } else if (turnCounter >= 9) {
            UT.textCenter("Game has ended in a tie", ' ', 50);
        }
    }
}
