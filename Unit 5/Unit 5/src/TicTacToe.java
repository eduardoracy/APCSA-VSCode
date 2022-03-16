import java.util.Scanner;

public class TicTacToe {
    int[][] board = new int[3][3];
    int turnCounter = 0;
    boolean startScreen = false;
    Scanner console = new Scanner(System.in);
    String SS;
    String p1, p2;
    boolean won = true;
    
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
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] =0;
            }
        }

        while (!won) {

        }
    }

    public void detection(int pNumber) {
        for (int[][] posib : winPosibilities) {
            if (board[(posib[0][0])][(posib[0][1])] == 0) {
                continue;
            } 

            for (int[] coordinate : posib) {
                if (board[coordinate[0]][coordinate[1]] != 0) {
                    //CAN YOU EMAIL ME YOUR CODE
                }
            }
        }
    }

    public void startScreen() {
		UT.clearScreen();
		if (!startScreen) {
			UT.textCenter("Press ENTER to start...", ' ', 25);// classic start screen
			SS = console.nextLine();

			UT.clearScreen();
			startScreen = true;
		}
		UT.textCenter(" Welcome to Tic-Tac-Toe!! ", '═', 25);
		UT.textCenter(" Designed by Eduardo Racy ", '─', 25);
		System.out.println("1. Start Game");
		System.out.println("2. Instructions");
		SS = console.next();
		UT.clearScreen();
		if (SS.equals("1")) {
			nameSelect();
		} else if (SS.equals("2")) {
			//instructions();
			startScreen();
		} else {
            UT.clearScreen();
            UT.textCenter(" Welcome to Tic-Tac-Toe!! ", '═', 25);
		    UT.textCenter(" Designed by Eduardo Racy ", '─', 25);
            System.out.println("Invalid Selection");
            System.out.println("Press ENTER to try again...");
            SS = console.nextLine();
            startScreen();
        }
	}

    public void nameSelect() {
		UT.textCenter(" New game ", '═', 25);
		UT.textCenter(" Name Selection ", '─', 25);
		System.out.println();
		UT.textCenter("Please enter a name with 9 characters or less.", ' ', 25);
		System.out.println("\nPlayer 1 enter your name...");
		SS = console.next();
		p1 = SS.substring(0, 1).toUpperCase() + SS.substring(1).toLowerCase();
		System.out.println("\nPlayer 2 enter your name...");
		SS = console.next();
		p2 = SS.substring(0, 1).toUpperCase() + SS.substring(1).toLowerCase();
		System.out.println();
		UT.textCenter("Press ENTER to continue...", ' ', 25);
		SS = console.nextLine();
		UT.clearScreen();
	}

    public void pBoard() {
        for (int i = 1; i <= 5; i++){
        if (i % 2 == 0) { // 2 Middle cross rows
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


