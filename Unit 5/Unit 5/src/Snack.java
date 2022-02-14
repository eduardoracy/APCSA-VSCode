public class Snack {
    private String name;
    private int calories;

    public Snack(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }
    public String toString() {
        return "The snack " + name + " has " + calories + ".";
    }

    public static void main(String[] args) {
        UT.clearScreen();
        Snack s1 = new Snack("Kit-Kat", 300);
        s1.setName("Snickers");
        System.out.println(s1.getName());
        s1.setCalories(200);
        System.out.println(s1.getCalories());
        System.out.println(s1);
    }
}
