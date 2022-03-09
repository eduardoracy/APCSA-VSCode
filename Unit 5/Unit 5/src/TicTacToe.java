public class TicTacToe {
    int[][] board = new int[3][3];

    public static void main(String[] args) {
        UT.clearScreen();
        new TicTacToe().pBoard();
    }

    public void pBoard() {
        for (int i = 1; i <= 11; i++){
        if (i % 4 == 0) {
            for (int j = 0; j < 3; j++) {
                System.out.print("\u2501\u2501\u2501");
                if (j < 3) {
                    System.out.print("\u254B");
                }
            }
        } else if (i % 2 == 0) {
            char symb;
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case 1:
                    symb = '\u2573';
                    break;
                    case 2:
                    symb = '\u2573';
                    break;
                    default:
                    symb = ' ';
                    break;
                }
                System.out.print(String.format(" %s ", symb));
                if (j < 3) {
                    System.out.print("\u2503");
                }
            }
        } else {
                for (int j = 0; j < 3; j++) {
                    System.out.print("   ");
                    if (j < 3) {
                        System.out.print("\u2503");
                    }
                }
                System.out.println();
        }
        System.out.println();
    }
}
}


