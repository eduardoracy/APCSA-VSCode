import java.util.Scanner;

public class TicTacToe {
    int[][] board = new int[3][3];
    int turnCounter = 0;
    int subTurnCounter = 0;
    int row, col;
    boolean startScreen = false;
    Scanner console = new Scanner(System.in);
    String UI;
    String p1, p2, nextP;
    boolean won = false;
    boolean continuePlay = true;
    String nameHeader;
    
    final int[][][] winPosibilities = {
        {{ 0, 0 }, { 0, 1 }, { 0, 2 }},
        {{ 1, 0 }, { 1, 1 }, { 1, 2 }},
        {{ 2, 0 }, { 2, 1 }, { 2, 2 }},
    
        {{ 0, 0 }, { 1, 0 }, { 2, 0 }},
        {{ 0, 1 }, { 1, 1 }, { 2, 1 }},
        {{ 0, 2 }, { 1, 2 }, { 2, 2 }},
    
        {{ 0, 0 }, { 1, 1 }, { 2, 2 }},
        {{ 2, 0 }, { 1, 1 }, { 0, 2 }}
    };

    public static void main(String[] args) {
        new TicTacToe().startScreen();
    }

    public void newGame() {
        while (!continuePlay) {
        p1 = p2 = " ";
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = 0;
            }
        }
        startScreen();


        }
    }

    public void turn() {
        while (!won) {
        if (turnCounter % 2 != 0) {
            nameHeader = p1;
            nextP = p2;
        } else {
            nameHeader = p2;
            nextP = p1;
        }

        turnHeader();
        System.out.println("Enter what cell you would like to mark:");
        System.out.print("Row: ");
        row = console.nextInt();
        System.out.print("\nColumn: ");
        col = console.nextInt();
        marker();

        UT.clearScreen();
        turnHeader();
        UT.textCenter("Press ENTER to continue...", ' ', 50);
        UI = console.nextLine();

        }
    } 

    public void turnHeader() {
        UT.textCenter(" " + nameHeader + " ", '═', 50);
		UT.textCenter(" Turn: " + turnCounter + " ", '─', 50);
        System.out.println();
    }

    public void marker() {
        
    }

    public boolean detection(int pNumber) {
        for (int[][] posib : winPosibilities) {
            int value = board[(posib[0][0])][(posib[0][1])];
            if (value == 0) {
                continue;
            } 

            for (int[] coordinate : posib) {
                if (board[coordinate[0]][coordinate[1]] != value) {
                    won = true;
                    break;
                }
            }
            if (won) {
                break;
            }
        }
        return true;
    }

    public void startScreen() {
		UT.clearScreen();
		if (!startScreen) {
			UT.textCenter("PreUI ENTER to start...", ' ', 50);// claUIic start screen
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
			//instructions();
			startScreen();
		} else {
            UT.clearScreen();
            UT.textCenter(" Welcome to Tic-Tac-Toe!! ", '═', 50);
		    UT.textCenter(" Designed by Eduardo Racy ", '─', 50);
            System.out.println("Invalid Selection");
            System.out.println("PreUI ENTER to try again...");
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
		UT.textCenter("PreUI ENTER to continue...", ' ', 50);
		UI = console.nextLine();
		UT.clearScreen();
	}

    public void pBoard() {
        turnHeader();
        for (int i = 1; i <= 5; i++){
        if (i % 2 == 0) { // 2 Middle croUI rows
            for (int col = 0; col < 3; col++) {
                System.out.print("───");
                if (col < 2) {
                    System.out.print("┼");
                }
            }
        } else { //Rows with user values
            char symb;
            int count = 0;
            int row = i;
            while (row % 2 > 1) {
            row /= 2;
            count++;
            }
            for (int col = 0; col < 3; col++) {
                switch (board[count][col]) {
                    case 1:
                    symb = 'X';
                    break;
                    case 2:
                    symb = 'O';
                    break;
                    default:
                    symb = ' ';
                    break;
                } 
                System.out.print(String.format(" %s ", symb));
                if (col < 2) {
                    System.out.print("│");
                }
            }
        }
        System.out.println();
    }
}
}


