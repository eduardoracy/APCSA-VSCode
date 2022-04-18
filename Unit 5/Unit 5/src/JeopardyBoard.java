public class JeopardyBoard {
    JeopardyBoardCategory[] categories = new JeopardyBoardCategory[6];

    public JeopardyBoard(JeopardyBoardCategory category1, JeopardyBoardCategory category2,
            JeopardyBoardCategory category3,
            JeopardyBoardCategory category4, JeopardyBoardCategory category5, JeopardyBoardCategory category6) {
        categories[0] = category1;
        categories[1] = category2;
        categories[2] = category3;
        categories[3] = category4;
        categories[4] = category5;
        categories[5] = category6;
    }

    public static JeopardyBoard createBoard() {

        return new JeopardyBoard(
                new JeopardyBoardCategory("Variables",
                        new JeopardyQuestion("Another name for a static variable", "constant", "What is a", 200, false),
                        new JeopardyQuestion("A variable declared in body of a method", "local variable", "What is a",
                                400, false),
                        new JeopardyQuestion("A variable declared in the header of a method", "parameter", "What is a ",
                                600, false),
                        new JeopardyQuestion("A variable declared in a class, not within a method", "instance variable",
                                "What is a", 800, false),
                        new JeopardyQuestion("Variable that belongs to a class, not to an object of a class",
                                "static variable", "What is a", 1000, false)),

                new JeopardyBoardCategory("Methods",
                        new JeopardyQuestion("public static void main (String[] args)", "main", "What is", 200, false),
                        new JeopardyQuestion("Method used to determine if two objects have the same content",
                                ".equals()", "What is", 400, false),
                        new JeopardyQuestion("Method used to get the length of a String", ".length()", "What is", 600,
                                false),
                        new JeopardyQuestion("Method used to get the next input from a scanner", ".next()", "What is",
                                800, false),
                        new JeopardyQuestion("A class that has no mutator method can be described as", "immutable",
                                "What is", 1000, false)),

                new JeopardyBoardCategory("Strings & Things",
                        new JeopardyQuestion("Primitive data type of which Strings are made", "char", "What is", 200,
                                false),
                        new JeopardyQuestion("Descriptive text to explain portions of code", "comment", "What is a",
                                400, false),
                        new JeopardyQuestion(
                                "The escape sequence used to print \"Hello, World\" on two lines using S.O.Pln", "\n",
                                "What is", 600, false),
                        new JeopardyQuestion("Method used to get a String representation of an object's state",
                                ".toString()", "What is", 800, false),
                        new JeopardyQuestion(
                                "Method used to extract a part of a String from the first position to the 4th position",
                                "What is", ".substring(0,4)", 1000, false)),

                new JeopardyBoardCategory("Data Types",
                        new JeopardyQuestion("Most commonly used numberic data type in Java", "integer", "What is", 200,
                                false),
                        new JeopardyQuestion("This data type is commonly used in conditional statements", "boolean",
                                "What is", 400, false),
                        new JeopardyQuestion("Primitive data types used for a whole number with 2,147,483,649 ", "long",
                                "What is", 600, false),
                        new JeopardyQuestion("The sum of all whole numbers a byte can store", "256", "What is", 800,
                                false),
                        new JeopardyQuestion("Used in array lists to allow storage of a primitive data type",
                                "wrapper class", "What is a", 1000, false)),

                new JeopardyBoardCategory("Loop Conditionals",
                        new JeopardyQuestion("Loop that never ends, casuing a run-time error", "infinite loop",
                                "What is a", 200, false),
                        new JeopardyQuestion("Conditional loop with only known conditions", "while loop", "What is a",
                                400, false),
                        new JeopardyQuestion("Conditional loop with known parameters and increments/decrements",
                                "for loop", "What is a", 600, false),
                        new JeopardyQuestion(
                                "Loop used when the body needs to be executed at least once regardless of conditions",
                                "do-while loop", "What is", 800, false),
                        new JeopardyQuestion("Local parameter, within a for loop, that is not required",
                                "initialized varible", "What is", 1000, false)),

                new JeopardyBoardCategory("Arrays and Classes",
                        new JeopardyQuestion("The major difference between an array and an arraylist", "mutability", "What is", 200, false),
                        new JeopardyQuestion("A collection of 2D arrays", "3D array", "What is a", 400, false),
                        new JeopardyQuestion("keyword used to create a restricted class that cannot be used to create objects", "abstract", "What is", 600, false),
                        new JeopardyQuestion("Any externally observable data modification caused by a method", "side effect", "What is a", 800, false),
                        new JeopardyQuestion("A Class that is designed with a single, well-focussed purpose is said to be", "cohesive", "What is", 1000, false))

        );
        //Final ASSUMING NUMBER ARE INTEGERS, USING JAVA MATH RULES, COMPUTE THE ANSWER: (5 - 2) + 4 / 3 * 2 = answer 5
    }

    public boolean allQuestionsAnswered() {
        for (JeopardyBoardCategory category : categories) {
            if (!category.allCategoryQuestionsAnswered()) {
                return false;
            }
        }
        return true;
    }

    public JeopardyBoardCategory[] getCategories() {
        return categories;
    }

}