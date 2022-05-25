import java.util.ArrayList;
import java.util.Arrays;

public class JeopardyBoard {
        private JeopardyPlayer currentPlayer, player1, player2;
        private ArrayList<JeopardyBoardCategory> categories;
        private JeopardyFinal finalJeopardy;

        public JeopardyBoard(String player1, String player2) {
                this.categories = createBoard();
                this.player1 = new JeopardyPlayer(player1, 0, 1);
                this.player2 = new JeopardyPlayer(player2, 0, 2);
                currentPlayer = this.player1;
                this.finalJeopardy = createFinal();
                setDailyDouble();
        }

        public boolean allQuestionsAnswered() {
                for (JeopardyBoardCategory category : categories) {
                        if (!category.allCategoryQuestionsAnswered()) {
                                return false;
                        }
                }
                return true;
        }

        public void setDailyDouble() {
                categories.get((int) (Math.random() * 6) + 1).getQuestions().get((int) (Math.random() * 6) + 1)
                                .dailyDouble();
                ;
        }

        public ArrayList<JeopardyBoardCategory> getCategories() {
                return categories;
        }

        public void changeCurrentPlayer() {
                if (currentPlayer.getName().equals(player1.getName())) {
                        currentPlayer = player2;
                } else {
                        currentPlayer = player1;
                }
        }

        public JeopardyPlayer getCurrentPlayer() {
                return currentPlayer;
        }

        public JeopardyPlayer getPlayer(int playerNumber) {
                return (playerNumber == 1) ? this.player1 : this.player2;
        }

        public JeopardyFinal getFinalJeopardy() {
                return finalJeopardy;
        }

        public void printBoard() {
                printPlayerInformation();
                printCategoryInformation();
                printQuestionsInformation();
        }

        public void printPlayerInformation() {
                printRow(2, '╔', '═', '╦', '╗');

                Utility.textCenter(String.format("║%s║%s║", Utility.sameLineTextCenter(player1.getName(), ' ', 12),
                                Utility.sameLineTextCenter(player2.getName(), ' ', 12)), ' ');

                Utility.textCenter(String.format("║%s║%s║",
                                Utility.sameLineTextCenter(String.format("%s ", player1.getPoints()), ' ', 12),
                                Utility.sameLineTextCenter(String.format("%s ", player2.getPoints()), ' ', 12)), ' ');

                printRow(2, '╚', '═', '╩', '╝');

        }

        public void printCategoryInformation() {
                printRow(6, '╔', '═', '╦', '╗');
                for (int i = 0; i < 3; i++) {
                        String print = "║";
                        for (JeopardyBoardCategory category : categories) {
                                print += String.format("%s║", Utility.sameLineTextCenter(
                                                wordsPerRow(category.getCategoryName(), i), ' ', 12));
                        }
                        Utility.textCenter(print, ' ');
                }
                printRow(6, '╠', '═', '╬', '╣');

        }

        public void printQuestionsInformation() {
                int numberOfQuestions = categories.get(0).getQuestions().size();
                for (int i = 0; i < numberOfQuestions; i++) {
                        String print = "║";
                        for (JeopardyBoardCategory category : categories) {
                                JeopardyQuestion question = category.getQuestions().get(i);
                                String information = question.isAnswered() ? "X"
                                                : String.format("%s", question.getValue());
                                print += String.format("%s║", Utility.sameLineTextCenter(information, ' ', 12));
                        }
                        Utility.textCenter(print, ' ');
                        if (i < numberOfQuestions - 1) {
                                printRow(6, '╟', '─', '╫', '╢');
                        } else {
                                printRow(6, '╚', '═', '╩', '╝');
                        }
                }
        }

        public void printRow(int columns, char right, char filler, char intercept, char left) {
                String print = String.format("%S", right);
                for (int i = 0; i < columns; i++) {
                        for (int j = 0; j < 12; j++) {
                                print += filler;
                        }
                        if (i < columns - 1) {
                                print += intercept;
                        } else {
                                print += left;
                        }
                }
                Utility.textCenter(print, ' ');
        }

        public String wordsPerRow(String category, int row) {
                row++;
                String[] arr = separateWords(category);
                int numberOfWords = arr.length;

                if (numberOfWords == 1 && row == 2) {
                        return category;
                } else if (numberOfWords == 2) {
                        if (row == 1) {
                                return arr[0];
                        } else if (row == 3) {
                                return arr[1];
                        }
                } else if (numberOfWords == 3) {
                        return arr[row - 1];
                }
                return " ";
        }

        public String[] separateWords(String category) {
                return category.split(" ");
        }

        public static ArrayList<JeopardyBoardCategory> createBoard() {
                return new ArrayList<JeopardyBoardCategory>(Arrays.asList(
                                new JeopardyBoardCategory("Variability",
                                                new JeopardyQuestion(
                                                                "Another name for a static variable",
                                                                "constant",
                                                                "What is a", 200),
                                                new JeopardyQuestion(
                                                                "A variable declared in body of a method",
                                                                "local",
                                                                "What is a", 400),
                                                new JeopardyQuestion(
                                                                "A variable declared in the header of a method",
                                                                "parameter",
                                                                "What is a", 600),
                                                new JeopardyQuestion(
                                                                "A variable declared in a class, not within a method",
                                                                "instance",
                                                                "What is a", 800),
                                                new JeopardyQuestion(
                                                                "Variable that belongs to a class, not to an object of a class",
                                                                "static",
                                                                "What is a", 1000)),

                                new JeopardyBoardCategory("Methodology",
                                                new JeopardyQuestion(
                                                                "public static void main (String[] args)",
                                                                "main",
                                                                "What is", 200),
                                                new JeopardyQuestion(
                                                                "Method used to determine if two objects have the same content",
                                                                "equals",
                                                                "What is", 400),
                                                new JeopardyQuestion(
                                                                "Method used to get the length of a String",
                                                                "length",
                                                                "What is", 600),
                                                new JeopardyQuestion(
                                                                "Method used to get the next input from a scanner",
                                                                "next",
                                                                "What is", 800),
                                                new JeopardyQuestion(
                                                                "A class that has no mutator method can be described as",
                                                                "immutable",
                                                                "What is", 1000)),

                                new JeopardyBoardCategory("Strings & Things",
                                                new JeopardyQuestion(
                                                                "Primitive data type of which Strings are made",
                                                                "char",
                                                                "What is", 200),
                                                new JeopardyQuestion(
                                                                "Descriptive text to explain portions of code",
                                                                "comment",
                                                                "What is a", 400),
                                                new JeopardyQuestion(
                                                                "The escape sequence used to print \"Hello, World\" on two lines using one S.O.P.",
                                                                "\\n",
                                                                "What is", 600),
                                                new JeopardyQuestion(
                                                                "Method used to get a String representation of an object's state",
                                                                "toString",
                                                                "What is", 800),
                                                new JeopardyQuestion(
                                                                "Method used to extract a part of a String from the first position to the 4th position",
                                                                ".substring(0,4)",
                                                                "What is", 1000)),

                                new JeopardyBoardCategory("Daytaa Types",
                                                new JeopardyQuestion(
                                                                "Most commonly used numeric data type in Java",
                                                                "integer",
                                                                "What is", 200),
                                                new JeopardyQuestion(
                                                                "This data type is commonly used in conditional statements",
                                                                "boolean",
                                                                "What is", 400),
                                                new JeopardyQuestion(
                                                                "Primitive data types used for a whole number with 2,147,483,649 ",
                                                                "long",
                                                                "What is", 600),
                                                new JeopardyQuestion(
                                                                "The sum of all whole numbers a byte can store",
                                                                "256",
                                                                "What is", 800),
                                                new JeopardyQuestion(
                                                                "Used in array lists to allow storage of a primitive data type",
                                                                "wrapper",
                                                                "What is a", 1000)),

                                new JeopardyBoardCategory("Loop Conditionals",
                                                new JeopardyQuestion(
                                                                "Loop that never ends, causing a run-time error",
                                                                "infinite",
                                                                "What is a", 200),
                                                new JeopardyQuestion(
                                                                "Conditional loop with only known conditions",
                                                                "while",
                                                                "What is a", 400),
                                                new JeopardyQuestion(
                                                                "Conditional loop with known parameters and increments/decrements",
                                                                "for",
                                                                "What is a", 600),
                                                new JeopardyQuestion(
                                                                "Loop used when the body needs to be executed at least once regardless of conditions",
                                                                "do while",
                                                                "What is", 800),
                                                new JeopardyQuestion(
                                                                "Local parameter, within a for loop, that is not required",
                                                                "initialized",
                                                                "What is", 1000)),

                                new JeopardyBoardCategory("Classy Arrays",
                                                new JeopardyQuestion(
                                                                "The major difference between an array and an arraylist",
                                                                "mutability",
                                                                "What is", 200),
                                                new JeopardyQuestion(
                                                                "A collection of 2D arrays",
                                                                "3D",
                                                                "What is a", 400),
                                                new JeopardyQuestion(
                                                                "keyword used to create a restricted class that cannot be used to create objects",
                                                                "abstract",
                                                                "What is", 600),
                                                new JeopardyQuestion(
                                                                "Any externally observable data modification caused by a method",
                                                                "side effect",
                                                                "What is a", 800),
                                                new JeopardyQuestion(
                                                                "A Class that is designed with a single, well-focussed purpose is said to be",
                                                                "cohesive",
                                                                "What is", 1000))

                ));

                // Final ASSUMING NUMBER ARE INTEGERS, USING JAVA MATH RULES, COMPUTE THE
                // ANSWER: (5 - 2) + 4 / 3 * 2 = answer 5
        }

        public static JeopardyFinal createFinal() {
                return new JeopardyFinal("(5 - 2) + 4 / 3 * 2 =", "5");
        }
}