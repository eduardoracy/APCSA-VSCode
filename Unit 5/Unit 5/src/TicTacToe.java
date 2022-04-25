import java.util.Scanner;

public class TicTacToe {
    char[] board = new char[9];
    Scanner console = new Scanner(System.in);

    final int[][][] winPosibilitiesCoordinates = {
            // Every possible combination to win for each of the 9 cells

            { // Cell 1
                    { 2, 3 }, // R1 horizontal
                    { 4, 7 }, // C1 vertical
                    { 5, 9 }  // 1-9 diagonal
            },

            { // Cell 2
                    { 1, 3 }, // R1 horizontal
                    { 5, 8 }, // C2 vertical
            },

            { // Cell 3
                    { 1, 2 }, // R1 horizontal
                    { 6, 9 }, // C3 vertical
                    { 7, 5 }  // 7-3 diagonal
            },

            { // Cell 4
                    { 5, 6 }, // R2 horizontal
                    { 1, 7 }, // C1 vertical
            },

            { // Cell 5
                    { 4, 6 }, // R2 horizontal
                    { 2, 8 }, // C2 vertical
                    { 1, 9 }, // 1-9 diagonal
                    { 7, 3 }  // 7-3 diagonal
            },

            { // Cell 6
                    { 4, 5 }, // R2 horizontal
                    { 3, 9 }  // C3 vertical
            },

            { // Cell 7
                    { 8, 9 }, // R3 horizontal
                    { 1, 4 }, // C1 vertical
                    { 5, 3 }  // 7-3 diagonal
            },

            { // Cell 8
                    { 7, 9 }, // R3 horizontal
                    { 2, 5 }  // C2 vertical
            },

            { // Cell 9
                    { 7, 8 }, // R3 horizontal
                    { 3, 6 }, // C3 vertical
                    { 1, 5 }  // 1-9 diagonal
            }
    };

    public static void main(String[] args) {
        new TicTacToe().startGame();
    }

    public void boardReset() {
        for (int i = 0; i < board.length; i++) {
            // board[i] = ' ';
            board[i] = String.format("%d", (i + 1)).charAt(0);
        }
    }

    public void startGame() {
        boolean continuePlay = true;

        while (continuePlay) {
            boardReset();
            startScreen();
            int turnCounter = 1;
            String playerName1 = nameSelect(1);
            String playerName2 = nameSelect(2);
            continuePlay = endScreen(gameLoop(turnCounter, playerName1, playerName2), playerName1, playerName2);
        }
        System.out.println();
        Utility.textCenter("Thank you for playing!!", ' ');
        console.close();
    }

    public int gameLoop(int turnCounter, String playerName1, String playerName2) {
        boolean won = gameLogic(turnCounter, playerName1, playerName2);
        if (won || (turnCounter >= 9)) {
            return turnCounter;
        }
        return gameLoop((turnCounter + 1), playerName1, playerName2);
    }

    public boolean gameLogic(int turnCounter, String playerName1, String playerName2) {
        Utility.clearScreen();
        int cellLocation = -1;
        boolean marked = false;

        while (!marked) { //Repeats until player marks a valid cell
            printBoard(turnCounter, playerName1, playerName2);
            System.out.println("Enter what cell you would like to mark:");
            cellLocation = (console.nextInt() - 1);
            marked = markBoard(cellLocation, getMarker(turnCounter));
            Utility.clearScreen();
        }
        printBoard(turnCounter, playerName1, playerName2);
        
        Utility.textCenter("Press ENTER to continue...", ' ');
        console.nextLine();
        console.nextLine();

        return checkWin(cellLocation, getMarker(turnCounter));
    }

    public void printTurnHeader(int turnCounter, String playerName1, String playerName2) {
        Utility.textCenter(" " + getName(turnCounter, playerName1, playerName2) + " ", '═');
        Utility.textCenter(" Turn: " + turnCounter + " ", '─');
        System.out.println();
    }

    public boolean markBoard(int cellLoc, char marker) {
        try {
            // if (board[cellLoc] == ' ') {
            if (board[cellLoc] != 'X' && board[cellLoc] != 'O') {
                board[cellLoc] = marker;
                return true;
            } else {
                Utility.textCenter("Location unavailable, please choose another cell to mark", ' ');
                Utility.textCenter("Press ENTER to continue", ' ');
                console.nextLine();
                console.nextLine();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Utility.textCenter("Location out of bounds, please choose another cell to mark", ' ');
            Utility.textCenter("Press ENTER to continue", ' ');
            console.nextLine();
            console.nextLine();
        }
        return false;
    }

    public boolean checkWin(int cellLoc, char marker) {
        if (marker != board[cellLoc]) {
            return false;
        }
        for (int[] coordinate : winPosibilitiesCoordinates[cellLoc]) {
            if (marker == board[(coordinate[0] - 1)] || marker == board[(coordinate[1] - 1)]) {
                return true;
            }
        }
        return false;
    }

    public String getName(int turnCounter, String playerName1, String playerName2) {
        if (turnCounter % 2 != 0) {
            return playerName1;
        } else {
            return playerName2;
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
        Utility.clearScreen();

        Utility.textCenter("Press ENTER to start...", ' ');
        console.nextLine();

        Utility.clearScreen();
    }

    public void startScreen() {
        Utility.clearScreen();

        Utility.textCenter(" Welcome to Tic-Tac-Toe!! ", '═');
        Utility.textCenter(" Designed by Eduardo Racy ", '─');

        System.out.println("1. Start Game");
        System.out.println("2. Instructions");
        int input = console.nextInt();

        Utility.clearScreen();

        if (input == 1) {
            return;
        } else if (input == 2) {
            instructions();
            startScreen();
        } else {
            Utility.clearScreen();
            Utility.textCenter(" Welcome to Tic-Tac-Toe!! ", '═');
            Utility.textCenter(" Designed by Eduardo Racy ", '─');
            System.out.println("Invalid Selection");
            System.out.println("Press ENTER to try again...");
            console.nextLine();
            console.nextLine();

            startScreen();
        }
    }

    public String nameSelect(int playerNumber) {
        Utility.clearScreen();
        Utility.textCenter(" New game ", '═');
        Utility.textCenter(" Name Selection ", '─');
        System.out.println();

        Utility.textCenter("Please enter a name with 9 characters or less and no spaces", ' ');
        System.out.println(String.format("\nPlayer %s enter your name...", playerNumber));
        String input = console.next();

        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public void instructions() {
        Utility.textCenter(" New game ", '═');
        Utility.textCenter(" Instructions ", '─');
        System.out.println();

        Utility.textCenter("Each playerName will be assigned either an X or O.", ' ');
        System.out.println();

        Utility.textCenter("The first playerName to get a 3 in a row wins,", ' ');
        Utility.textCenter("this can be achieved horizontally, vertically, or diagonally.", ' ');
        System.out.println();

        Utility.textCenter("If all 9 squares are marked, and neither playerName has won,", ' ');
        Utility.textCenter("the game ends in a tie.", ' ');
        System.out.println();

        Utility.textCenter("Press ENTER to continue...", ' ');
        console.nextLine();
        console.nextLine();

        Utility.clearScreen();

        Utility.textCenter(" New game ", '═');
        Utility.textCenter(" Instructions ", '─');
        System.out.println();

        Utility.textCenter("In order to mark a cell please select a digit 1-9,", ' ');
        Utility.textCenter("corresponding to the chart below.", ' ');
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
            Utility.textCenter(line, ' ');
        }
        System.out.println();

        Utility.textCenter("Press ENTER to continue...", ' ');
        console.nextLine();
    }

    public boolean endScreen(int turnCounter, String playerName1, String playerName2) {
        Utility.clearScreen();
        Utility.textCenter(" Game Over ", '═');
        Utility.textCenter(" Turn: " + turnCounter + " ", '─');
        boolean won = false;

        for (int i = 0; i < board.length; i++) {
            won = checkWin(i, getMarker(turnCounter));
            if (won) {
                break;
            }
        }

        if (won) {
            System.out.println();
            Utility.textCenter(getName(turnCounter, playerName1, playerName2) + " is the winner!", ' ');
        } else {
            Utility.textCenter("Game has ended in a tie", ' ');
        }

        Utility.textCenter("Would you like to return to start screen?", ' ');
        if (console.next().equalsIgnoreCase("no")) {
            return false;
        } else {
            return true;
        }
    }

    public void printBoard(int turnCounter, String playerName1, String playerName2) {
        printTurnHeader(turnCounter, playerName1, playerName2);
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
