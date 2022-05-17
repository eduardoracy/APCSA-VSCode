public class scratchpad {
    /*
    public void printBoard() {
        printBoardPlayer();
        printBoardHeader();
        printBoardBody();
}

public void pTopPlayer() {
        
}

public void printBoardPlayer() {

        for (int i = 0; i <= 3; i++) {
                String str = "";
                for (int j = 0; j < ((categories.size() - 2) / 2) + 2; j++) {
                        
                        if (j == 2 || j == 3) {
                                if (i == 0 && j == 2) {
                                        Utility.textCenter(boardPlayerBox("╔", "╤", "═", "╗"), ' ');
                                } else {
                                        JeopardyPlayer player = getPlayer((j % 2) + 1);
                                        str += ((j == 2) ? "║" : "│");
                                        str += String.format("%s %s", player.getName(), player.getPoints());
                                }
                        }
                }
                str += "║";
                Utility.textCenter(wordsPerRow(str, i), ' ');
        }

        Utility.textCenter(boardPlayerBox("╚", "╧", "═", "╝"), ' ');
        System.out.println();
}

public String boardPlayerBox(String left, String intersection, String filler, String right) {
        String output = (left);
        for (int i = 0; i < 12; i++) {
                output += filler;
        }
        output += intersection;
        for (int i = 0; i < 12; i++) {
                output += filler;
        }
        return (output += right);
}

public void printBoardLine(String left, String intercepts, String filler, String right) {
        for (int i = 0; i < categories.size(); i++) {
                if (i == 0) {
                        System.out.print(left);
                } else {
                        System.out.print(intercepts);
                }
                for (int j = 0; j < 12; j++) {
                        System.out.print(filler);
                }
        }
        System.out.println(right);
}

public void printBoardBody() {
        for (int i = 0; i < categories.get(0).getQuestion().size(); i++) {
                System.out.print("║");

                for (int j = 0; j < categories.size(); j++) {
                        System.out.print((i > 0) ? "│" : "");
                        JeopardyQuestion question = categories.get(j).getQuestion().get(i);
                        printBoardCellSpacing(
                                        question.isAnswered() ? String.format("%s", question.getValue()) : " ");
                }
                System.out.println("║");
        }
        printBoardLine("╚", "╧", "═", "╝");
}

public void printBoardHeader() {
        printBoardLine("╔", "╤", "═", "╗");

        for (int i = 1; i <= 3; i++) {
                System.out.print("║");
                for (int j = 0; j < categories.size(); j++) {
                        System.out.print((i > 1) ? "│" : "");
                        printBoardCellSpacing(wordsPerRow(categories.get(j).getCategory(), i));
                }
                System.out.println("║");
        }

        printBoardLine("╠", "╪", "═", "╣");
}

public void printBoardCellSpacing(String str) {
        Utility.sameLineTextCenter(str, ' ', 12);
}

public String wordsPerRow(String category, int row) {
        int numberOfWords = detectNumberOfWords(category, 0, 0);
        if (numberOfWords == 1 && row == 2) {
                return category;
        } else if (numberOfWords == 2) {
                if (row == 1) {
                        return separateWords(category)[0];
                } else if (row == 3) {
                        return separateWords(category)[1];
                }
        } else if (numberOfWords == 3) {
                return separateWords(category)[row];
        }
        return " ";
}

public int detectNumberOfWords(String str, int index, int count) {
        if (index >= str.length()) {
                return count;
        } else {
                if (str.charAt(index) == ' ') {
                        count++;
                }
                return detectNumberOfWords(str, index + 1, count);
        }
}

public String[] separateWords(String category) {
        return category.split(" ");
}

public void setDailyDouble() {
        categories.get((int) (Math.random() * 6) + 1).getQuestion().get((int) (Math.random() * 6) + 1)
                        .dailyDouble();
        ;
}
*/

}
