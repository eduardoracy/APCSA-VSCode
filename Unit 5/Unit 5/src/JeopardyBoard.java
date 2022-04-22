import java.util.ArrayList;
import java.util.Scanner;

public class JeopardyBoard {
        private static Scanner console = new Scanner(System.in);
        private JeopardyPlayer currentPlayer, player1, player2;
        private ArrayList<JeopardyBoardCategory> categories = new ArrayList<JeopardyBoardCategory>();

        public JeopardyBoard(JeopardyPlayer player1, JeopardyPlayer player2, JeopardyBoardCategory... categories) {
                for (JeopardyBoardCategory category : categories) {
                        this.categories.add(category);
                }
                this.player1 = player1;
                this.player2 = player2;
        }

        public boolean allQuestionsAnswered() {
                for (JeopardyBoardCategory category : categories) {
                        if (!category.allCategoryQuestionsAnswered()) {
                                return false;
                        }
                }
                return true;
        }

        public ArrayList<JeopardyBoardCategory> getCategories() {
                return categories;
        }

        public void setCurrentPlayer(JeopardyPlayer player) {
                if (player.getName().equals(player1.getName())) {
                        player1 = currentPlayer;
                        currentPlayer = player2;
                } else {
                        player2 = currentPlayer;
                        currentPlayer = player1;
                }
        }

        public JeopardyPlayer getCurrentPlayer() {
                return currentPlayer;
        }

        public JeopardyPlayer getPlayer(int playerNumber) {
                return (playerNumber == 1) ? this.player1 : this.player2;
        }

        public void printBoardPlayer() { // FIX BROKEN
                printBoardLine("╔", "╤", "═", "╗");

                for (int i = 1; i <= 3; i++) {
                        for (int j = 0; j < categories.size(); j++) {
                                JeopardyPlayer player = getPlayer((j % 2) + 1);
                                String str = " ";
                                if (j == 2 || j == 3) {
                                        System.out.print((j == 2) ? "║" : "│");
                                        str = String.format("%s %s", player.getName(), player.getPoints());
                                }

                                printBoardCellSpacing(wordsPerRow(str, i));
                        }

                }

                printBoardLine("╠", "╪", "═", "╣");
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
                for (int i = 1; i <= categories.get(0).getQuestion().size(); i++) {
                        System.out.println("║");

                        for (int j = 0; j < categories.size(); j++) {
                                System.out.print("│");
                                JeopardyQuestion question = categories.get(j).getQuestion().get(i);
                                printBoardCellSpacing(
                                                question.isAnswered() ? String.format("%s", question.getValue()) : " ");
                        }
                        System.out.println("║");
                }
                printBoardLine("╔", "╤", "═", "╗"); // Change directions
        }

        public void printBoardHeader() {
                printBoardLine("╔", "╤", "═", "╗");

                for (int i = 1; i <= 3; i++) {
                        for (int j = 0; j < categories.size(); j++) {
                                System.out.print("│");
                                printBoardCellSpacing(wordsPerRow(categories.get(j).getCategory(), i));
                        }
                        System.out.println("║");
                }

                printBoardLine("╠", "╪", "═", "╣");
        }

        public void printBoardCellSpacing(String str) {
                Utilities.textCenter(str, ' ', 12);
        }

        public String wordsPerRow(String category, int row) {
                int numberOfWords = detectNumberOfWords(category, 0, 0);
                if (numberOfWords == 1 && row == 2) {
                        return category;
                } else if (numberOfWords == 2) {
                        if (row == 1) {
                                return seperateWords(category)[0];
                        } else if (row == 3) {
                                return seperateWords(category)[1];
                        }
                } else if (numberOfWords == 3) {
                        return seperateWords(category)[row];
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

        public String[] seperateWords(String category) {
                return category.split(" ");
        }

        public void dailyDouble() {
								categories.get((int)(Math.random() *6) +1).get((int)(Math.random() *6) +1);
				}

        public static JeopardyBoard createBoard() {
                return new JeopardyBoard(
                                new JeopardyPlayer(Utilities.nameSelect(1, console), 0, 1),
                                new JeopardyPlayer(Utilities.nameSelect(2, console), 0, 2),
                                new JeopardyBoardCategory[] {
                                                new JeopardyBoardCategory("Variability",
                                                                new JeopardyQuestion[] {
                                                                                new JeopardyQuestion(
                                                                                                "Another name for a static variable",
                                                                                                "constant",
                                                                                                "What is a", 200,
                                                                                                false),
                                                                                new JeopardyQuestion(
                                                                                                "A variable declared in body of a method",
                                                                                                "local variable",
                                                                                                "What is a", 400,
                                                                                                false),
                                                                                new JeopardyQuestion(
                                                                                                "A variable declared in the header of a method",
                                                                                                "parameter",
                                                                                                "What is a ", 600,
                                                                                                false),
                                                                                new JeopardyQuestion(
                                                                                                "A variable declared in a class, not within a method",
                                                                                                "instance variable",
                                                                                                "What is a", 800,
                                                                                                false),
                                                                                new JeopardyQuestion(
                                                                                                "Variable that belongs to a class, not to an object of a class",
                                                                                                "static variable",
                                                                                                "What is a", 1000,
                                                                                                false)
                                                                }),

                                                new JeopardyBoardCategory("Methodology",
                                                                new JeopardyQuestion[] {
                                                                                new JeopardyQuestion(
                                                                                                "public static void main (String[] args)",
                                                                                                "main",
                                                                                                "What is", 200, false),
                                                                                new JeopardyQuestion(
                                                                                                "Method used to determine if two objects have the same content",
                                                                                                ".equals()",
                                                                                                "What is", 400, false),
                                                                                new JeopardyQuestion(
                                                                                                "Method used to get the length of a String",
                                                                                                ".length()",
                                                                                                "What is", 600, false),
                                                                                new JeopardyQuestion(
                                                                                                "Method used to get the next input from a scanner",
                                                                                                ".next()",
                                                                                                "What is", 800, false),
                                                                                new JeopardyQuestion(
                                                                                                "A class that has no mutator method can be described as",
                                                                                                "immutable",
                                                                                                "What is", 1000, false)
                                                                }),

                                                new JeopardyBoardCategory("Strings & Things",
                                                                new JeopardyQuestion[] {
                                                                                new JeopardyQuestion(
                                                                                                "Primitive data type of which Strings are made",
                                                                                                "char",
                                                                                                "What is", 200, false),
                                                                                new JeopardyQuestion(
                                                                                                "Descriptive text to explain portions of code",
                                                                                                "comment",
                                                                                                "What is a", 400,
                                                                                                false),
                                                                                new JeopardyQuestion(
                                                                                                "The escape sequence used to print \"Hello, World\" on two lines using one S.O.P.",
                                                                                                "\\n",
                                                                                                "What is", 600, false),
                                                                                new JeopardyQuestion(
                                                                                                "Method used to get a String representation of an object's state",
                                                                                                ".toString()",
                                                                                                "What is", 800, false),
                                                                                new JeopardyQuestion(
                                                                                                "Method used to extract a part of a String from the first position to the 4th position",
                                                                                                ".substring(0,4)",
                                                                                                "What is", 1000, false)
                                                                }),

                                                new JeopardyBoardCategory("Daytaa Types",
                                                                new JeopardyQuestion[] {
                                                                                new JeopardyQuestion(
                                                                                                "Most commonly used numberic data type in Java",
                                                                                                "integer",
                                                                                                "What is", 200, false),
                                                                                new JeopardyQuestion(
                                                                                                "This data type is commonly used in conditional statements",
                                                                                                "boolean",
                                                                                                "What is", 400, false),
                                                                                new JeopardyQuestion(
                                                                                                "Primitive data types used for a whole number with 2,147,483,649 ",
                                                                                                "long",
                                                                                                "What is", 600, false),
                                                                                new JeopardyQuestion(
                                                                                                "The sum of all whole numbers a byte can store",
                                                                                                "256",
                                                                                                "What is", 800, false),
                                                                                new JeopardyQuestion(
                                                                                                "Used in array lists to allow storage of a primitive data type",
                                                                                                "wrapper class",
                                                                                                "What is a", 1000,
                                                                                                false)
                                                                }),

                                                new JeopardyBoardCategory("Loop Conditionals",
                                                                new JeopardyQuestion[] {
                                                                                new JeopardyQuestion(
                                                                                                "Loop that never ends, casuing a run-time error",
                                                                                                "infinite loop",
                                                                                                "What is a", 200,
                                                                                                false),
                                                                                new JeopardyQuestion(
                                                                                                "Conditional loop with only known conditions",
                                                                                                "while loop",
                                                                                                "What is a", 400,
                                                                                                false),
                                                                                new JeopardyQuestion(
                                                                                                "Conditional loop with known parameters and increments/decrements",
                                                                                                "for loop",
                                                                                                "What is a", 600,
                                                                                                false),
                                                                                new JeopardyQuestion(
                                                                                                "Loop used when the body needs to be executed at least once regardless of conditions",
                                                                                                "do-while loop",
                                                                                                "What is", 800, false),
                                                                                new JeopardyQuestion(
                                                                                                "Local parameter, within a for loop, that is not required",
                                                                                                "initialized varible",
                                                                                                "What is", 1000, false)
                                                                }),

                                                new JeopardyBoardCategory("Classy Arrays",
                                                                new JeopardyQuestion[] {
                                                                                new JeopardyQuestion(
                                                                                                "The major difference between an array and an arraylist",
                                                                                                "mutability",
                                                                                                "What is", 200, false),
                                                                                new JeopardyQuestion(
                                                                                                "A collection of 2D arrays",
                                                                                                "3D array",
                                                                                                "What is a", 400,
                                                                                                false),
                                                                                new JeopardyQuestion(
                                                                                                "keyword used to create a restricted class that cannot be used to create objects",
                                                                                                "abstract",
                                                                                                "What is", 600, false),
                                                                                new JeopardyQuestion(
                                                                                                "Any externally observable data modification caused by a method",
                                                                                                "side effect",
                                                                                                "What is a", 800,
                                                                                                false),
                                                                                new JeopardyQuestion(
                                                                                                "A Class that is designed with a single, well-focussed purpose is said to be",
                                                                                                "cohesive",
                                                                                                "What is", 1000, false)
                                                                })
                                });
                // Final ASSUMING NUMBER ARE INTEGERS, USING JAVA MATH RULES, COMPUTE THE
                // ANSWER: (5 - 2) + 4 / 3 * 2 = answer 5
        }
}