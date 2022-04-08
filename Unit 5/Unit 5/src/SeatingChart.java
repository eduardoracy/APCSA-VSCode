public class SeatingChart {
    public static void main(String[] args) {
        utilities.clearScreen();
        String[][] chart = {{"Maverick", "Goose", "Charlie"},
                            {"Viper", "IceMan", "Hollywood"},
                            {"Annalise", "Wes", "Frank"}};

        for (int row = 0; row < chart.length; row++) {
            for (int col = 0; col < chart[0].length; col++) {
                System.out.print(chart[row][col] + " ");
            }
            System.out.println();
        }
    }
}
