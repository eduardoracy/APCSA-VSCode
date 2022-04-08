import java.util.Scanner;

public class TicTacToe {
    char[] board = new char[9];
    Scanner console = new Scanner(System.in);

    final int[][][] winPosibilitiesCoordinates = {
            // Every possible combination to win for each of the 9 cells

            { // Cell 1
                    { 2, 3 }, // R1 horizontal
                    { 4, 7 }, // C1 vertical
                    { 5, 9 } // 1-9 diagonal
            },

            { // Cell 2
                    { 1, 3 }, // R1 horizontal
                    { 5, 8 }, // C2 vertical
            },

            { // Cell 3
                    { 1, 2 }, // R1 horizontal
                    { 6, 9 }, // C3 vertical
                    { 7, 5 } // 7-3 diagonal
            },

            { // Cell 4
                    { 5, 6 }, // R2 horizontal
                    { 1, 7 }, // C1 vertical
            },

            { // Cell 5
                    { 4, 6 }, // R2 horizontal
                    { 2, 8 }, // C2 vertical
                    { 1, 9 }, // 1-9 diagonal
                    { 7, 3 } // 7-3 diagonal
            },

            { // Cell 6
                    { 4, 5 }, // R2 horizontal
                    { 3, 9 } // C3 vertical
            },

            { // Cell 7
                    { 8, 9 }, // R3 horizontal
                    { 1, 4 }, // C1 vertical
                    { 5, 3 } // 7-3 diagonal
            },

            { // Cell 8
                    { 7, 9 }, // R3 horizontal
                    { 2, 5 } // C2 vertical
            },

            { // Cell 9
                    { 7, 8 }, // R3 horizontal
                    { 3, 6 }, // C3 vertical
                    { 1, 5 } // 1-9 diagonal
            }
    };

    public static void main(String[] args) {
        new TicTacToe().newGame();
    }

    public void reset() {
        for (int i = 0; i < board.length; i++) {
            // board[i] = ' ';
            board[i] = String.format("%d", (i + 1)).charAt(0);
        }
    }

    public void newGame() {
        boolean continuePlay = true;

        while (continuePlay) {
            reset();
            startScreen();
            int turnCounter = 1;
            String p1 = nameSelect(1);
            String p2 = nameSelect(2);
            continuePlay = endScreen(gameLoop(turnCounter, p1, p2), p1, p2);
        }
        System.out.println();
        utilities.textCenter("Thank you for playing!!", ' ');
        console.close();
    }

    public int gameLoop(int turnCounter, String p1, String p2) {
        boolean won = gameLogic(turnCounter, p1, p2);
        if (won || (turnCounter >= 9)) {
            return turnCounter;
        }
        return gameLoop((turnCounter + 1), p1, p2);
    }

    public boolean gameLogic(int turnCounter, String p1, String p2) {
        utilities.clearScreen();
        int cellLocation = -1;
        boolean marked = false;
        while (!marked) {
            pBoard(turnCounter, p1, p2);
            System.out.println("Enter what cell you would like to mark:");
            cellLocation = (console.nextInt() - 1);
            marked = boardMarker(cellLocation, getMarker(turnCounter));
            utilities.clearScreen();
        }

        pBoard(turnCounter, p1, p2);
        utilities.textCenter("Press ENTER to continue...", ' ');
        console.nextLine();
        console.nextLine();
        boolean won = detection(cellLocation, getMarker(turnCounter));
        return won;
    }

    public void pTurnHeader(int turnCounter, String p1, String p2) {
        utilities.textCenter(" " + nameHeader(turnCounter, p1, p2) + " ", '═');
        utilities.textCenter(" Turn: " + turnCounter + " ", '─');
        System.out.println();
    }

    public boolean boardMarker(int cellLoc, char marker) {
        try {
            // if (board[cellLoc] == ' ') {
            if (board[cellLoc] != 'X' && board[cellLoc] != 'O') {
                board[cellLoc] = marker;
                return true;
            } else {
                utilities.textCenter("Location unavailable, please choose another cell to mark", ' ');
                utilities.textCenter("Press ENTER to continue", ' ');
                console.nextLine();
                console.nextLine();
            }
        } catch (ArrayIndexOutOfBoundsException asdf) {
            utilities.textCenter("Location out of bounds, please choose another cell to mark", ' ');
            utilities.textCenter("Press ENTER to continue", ' ');
            console.nextLine();
            console.nextLine();
        }
        return false;
    }

    public boolean detection(int cellLoc, char marker) {
        boolean won = false;
        if (marker != board[cellLoc]) {
            return false;
        }
        for (int[] coordinate : winPosibilitiesCoordinates[cellLoc]) {

            if (marker != board[(coordinate[0] - 1)] || marker != board[(coordinate[1] - 1)]) {
                won = false;
            } else {
                won = true;
                break;
            }
        }

        if (won) {
            return true;
        } else {
            return false;
        }
    }

    public String nameHeader(int turnCounter, String p1, String p2) {
        if (turnCounter % 2 != 0) {
            return p1;
        } else {
            return p2;
        }
    }

    public char getMarker(int turnCounter) {
        if (turnCounter % 2 != 0) {
            return 'X';
        } else {
            return 'O';
        }
    }

    public void enterToStart() {
        utilities.clearScreen();
        utilities.textCenter("Press ENTER to start...", ' ');
        console.nextLine();

        utilities.clearScreen();
    }

    public void startScreen() {
        utilities.clearScreen();

        utilities.textCenter(" Welcome to Tic-Tac-Toe!! ", '═');
        utilities.textCenter(" Designed by Eduardo Racy ", '─');

        System.out.println("1. Start Game");
        System.out.println("2. Instructions");
        int input = console.nextInt();

        utilities.clearScreen();
        if (input == 1) {
            return;
        } else if (input == 2) {
            instructions();
            startScreen();
        } else {
            utilities.clearScreen();
            utilities.textCenter(" Welcome to Tic-Tac-Toe!! ", '═');
            utilities.textCenter(" Designed by Eduardo Racy ", '─');
            System.out.println("Invalid Selection");
            System.out.println("Press ENTER to try again...");
            console.nextLine();
            console.nextLine();
            startScreen();
        }
    }

    public String nameSelect(int num) {
        utilities.clearScreen();
        utilities.textCenter(" New game ", '═');
        utilities.textCenter(" Name Selection ", '─');
        System.out.println();
        utilities.textCenter("Please enter a name with 9 characters or less.", ' ');
        System.out.println(String.format("\nPlayer %s enter your name...", num));
        String input = console.next();
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public void instructions() {
        utilities.textCenter(" New game ", '═');
        utilities.textCenter(" Instructions ", '─');
        System.out.println();

        utilities.textCenter("Each player will be assigned either an X or O.", ' ');
        System.out.println();

        utilities.textCenter("The first player to get a 3 in a row wins,", ' ');
        utilities.textCenter("this can be achieved horizontally, vertically, or diagonally.", ' ');
        System.out.println();

        utilities.textCenter("If all 9 squares are marked, and neither player has won,", ' ');
        utilities.textCenter("the game ends in a tie.", ' ');
        System.out.println();

        utilities.textCenter("Press ENTER to continue...", ' ');
        console.nextLine();
        console.nextLine();

        utilities.clearScreen();

        utilities.textCenter(" New game ", '═');
        utilities.textCenter(" Instructions ", '─');
        System.out.println();

        utilities.textCenter("In order to mark a cell please select a digit 1-9,", ' ');
        utilities.textCenter("corresponding to the chart below.", ' ');
        System.out.println();

        int boardRow = 1;
        for (int i = 1; i <= 5; i++) {
            String line = "";
            for (int j = 0; j < 3; j++) {
                if (i % 2 == 0) { // 2 Middle intersection rows
                    line += "───";
                    if (j < 2) {
                        line += "┼";
                    }
                } else { // Rows with user values
                    line += String.format(" %s ", boardRow);
                    if (j < 2) {
                        line += "│";
                    }
                    boardRow++;
                }
            }
            utilities.textCenter(line, ' ');
        }
        System.out.println();

        utilities.textCenter("Press ENTER to continue...", ' ');
        console.nextLine();
    }

    public boolean endScreen(int turnCounter, String p1, String p2) {
        utilities.clearScreen();
        utilities.textCenter(" Game Over ", '═');
        utilities.textCenter(" Turn: " + turnCounter + " ", '─');
        boolean won = false;

        for (int i = 0; i < board.length; i++) {
            won = detection(i, getMarker(turnCounter));
            if (won) {
                break;
            }
        }

        if (won) {
            System.out.println();
            utilities.textCenter(nameHeader(turnCounter, p1, p2) + " is the winner!", ' ');
        } else {
            utilities.textCenter("Game has ended in a tie", ' ');
        }

        utilities.textCenter("Would you like to return to start screen?", ' ');
        if (console.next().equalsIgnoreCase("no")) {
            return false;
        } else {
            return true;
        }
    }

    public void pBoard(int turnCounter, String p1, String p2) {
        pTurnHeader(turnCounter, p1, p2);
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
