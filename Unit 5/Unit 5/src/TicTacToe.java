import java.util.Scanner;

public class TicTacToe {
    boolean startScreen, marked, outBounds, continuePlay;
    char[] board = new char[9];
    char marker;
    int turnCounter, cellLoc;
    Scanner console = new Scanner(System.in);
    String UI;
    String p1, p2, nextP, nameHeader;
    int TCL = 75;

    final int[][][] winPosibilitiesCoordinates = {
            { { 2, 3 }, { 4, 7 }, { 5, 9 } }, // 1: horizontal, vertical, 1-9 diagonal
            { { 1, 3 }, { 5, 8 }, }, // 2: horizontal, vertical
            { { 1, 2 }, { 6, 9 }, { 7, 5 } }, // 3: horizontal, vertical, 7-3 diagonal
            { { 5, 6 }, { 1, 7 }, }, // 4: horizontal, vertical
            { { 4, 6 }, { 2, 8 }, { 1, 9 }, { 7, 3 } }, // 5: horizontal, vertical, 1-9 diagonal, 7-3 diagonal
            { { 4, 5 }, { 3, 9 } }, // 6: horizontal, vertical
            { { 8, 9 }, { 1, 4 }, { 5, 3 } }, // 7: horizontal, vertical, 7-3 diagonal
            { { 7, 9 }, { 2, 5 } }, // 8: horizontal, vertical
            { { 7, 8 }, { 3, 6 }, { 1, 5 } } // 9: horizontal, vertical, 1-9 diagonal
    };

    public static void main(String[] args) {
        new TicTacToe().newGame();
    }

    public void reset() {
        p1 = p2 = " ";
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
        turnCounter = cellLoc = 0;
        marked = startScreen = outBounds = false;
    }

    public void newGame() {
        continuePlay = true;
        while (continuePlay) {
            reset();
            startScreen();
            turn();
            endScreen();
        }
        UT.textCenter("Thank you for playing!!", ' ', TCL);
        console.close();
    }

    public void endScreen() {
        UT.textCenter(" Game Over ", '═', TCL);
        UT.textCenter(" Turn: " + turnCounter + " ", '─', TCL);

        if (turnCounter <= 9) {
            UT.textCenter("Game has ended in a tie", ' ', TCL);
        } else {
            System.out.println();
            UT.textCenter(nameHeader + " is the winner!", ' ', TCL);
        }

        UT.textCenter("Would you like to play again?", ' ', TCL);
        if (console.next().equalsIgnoreCase("no")) {
            continuePlay = false;
        }
    }

    public void turn() {
        while (!detection() || turnCounter <= 9) {
            UT.clearScreen();
            turnCounter++;
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
                pBoard();
                System.out.println("Enter what cell you would like to mark:");
                cellLoc = (console.nextInt() - 1);
                boardMarker();
                UT.clearScreen();
            }

            marked = outBounds = false;

            pBoard();
            UT.textCenter("Press ENTER to continue...", ' ', TCL);
            UI = console.nextLine();
            UI = console.nextLine();
        }
    }

    public void turnHeader() {
        UT.textCenter(" " + nameHeader + " ", '═', TCL);
        UT.textCenter(" Turn: " + turnCounter + " ", '─', TCL);
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
        for (int[] coordinate : winPosibilitiesCoordinates[cellLoc]) {
            if (marker != board[(coordinate[0] - 1)] && marker != board[(coordinate[1] - 1)]) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

    public void startScreen() {
        UT.clearScreen();
        if (!startScreen) {
            UT.textCenter("Press ENTER to start...", ' ', TCL);// classic start screen
            UI = console.nextLine();

            UT.clearScreen();
            startScreen = true;
        }
        UT.textCenter(" Welcome to Tic-Tac-Toe!! ", '═', TCL);
        UT.textCenter(" Designed by Eduardo Racy ", '─', TCL);
        System.out.println("1. Start Game");
        System.out.println("2. Instructions");
        UI = console.next();
        UT.clearScreen();
        if (UI.equals("1")) {
            nameSelect();
        } else if (UI.equals("2")) {
            instructions();
            startScreen();
        } else {
            UT.clearScreen();
            UT.textCenter(" Welcome to Tic-Tac-Toe!! ", '═', TCL);
            UT.textCenter(" Designed by Eduardo Racy ", '─', TCL);
            System.out.println("Invalid Selection");
            System.out.println("Press ENTER to try again...");
            UI = console.nextLine();
            UI = console.nextLine();
            startScreen();
        }
    }

    public void nameSelect() {
        UT.textCenter(" New game ", '═', TCL);
        UT.textCenter(" Name Selection ", '─', TCL);
        System.out.println();
        UT.textCenter("Please enter a name with 9 characters or leUI.", ' ', TCL);
        System.out.println("\nPlayer 1 enter your name...");
        UI = console.next();
        p1 = UI.substring(0, 1).toUpperCase() + UI.substring(1).toLowerCase();
        System.out.println("\nPlayer 2 enter your name...");
        UI = console.next();
        p2 = UI.substring(0, 1).toUpperCase() + UI.substring(1).toLowerCase();
        System.out.println();
        UT.textCenter("Press ENTER to continue...", ' ', TCL);
        UI = console.nextLine();
        UI = console.nextLine();
        UT.clearScreen();
    }

    public void instructions() {
        UT.textCenter(" New game ", '═', TCL);
        UT.textCenter(" Instructions ", '─', TCL);
        System.out.println();

        UT.textCenter("Each player will be assigned either an X or O.", ' ', TCL);
        System.out.println();

        UT.textCenter("The first player to get a 3 in a row wins,", ' ', TCL);
        UT.textCenter("this can be achieved horizontally, vertically, or diagonally.", ' ', TCL);
        System.out.println();

        UT.textCenter("If all 9 squares are marked, and neither player has won,", ' ', TCL);
        UT.textCenter("the game ends in a tie.", ' ', TCL);
        System.out.println();

        UT.textCenter("Press ENTER to continue...", ' ', TCL);
        UI = console.nextLine();
        UI = console.nextLine();

        UT.clearScreen();

        UT.textCenter(" New game ", '═', TCL);
        UT.textCenter(" Instructions ", '─', TCL);
        System.out.println();

        UT.textCenter("In order to mark a cell please select a digit 1-9,", ' ', TCL);
        UT.textCenter("corresponding to the chart below.", ' ', TCL);
        System.out.println();

        int boardRow = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (i % 2 == 0) { // 2 Middle cross rows
                    System.out.print("───");
                    if (j < 2) {
                        System.out.print("┼");
                    }
                } else { // Rows with user values
                    System.out.print(String.format(" %s ", boardRow));
                    if (j < 2) {
                        System.out.print("│");
                    }
                    boardRow++;
                }
            }
            System.out.println();
        }

        UT.textCenter("Press ENTER to continue...", ' ', TCL);
        UI = console.nextLine();
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
    }
}
