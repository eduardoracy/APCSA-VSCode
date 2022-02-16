public class Snack {

    private String name;
    private int calories;

    public Snack() {
        name = "Air";
        calories = 0;
    }

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

    public boolean isSameName(Snack s2) {
        return this.name.equals(s2.name);

    }

    public String toString() {
        String result = "The snack " + name;
        result.concat(" has " + calories + ".");

        // return result;
        // return String.format("The snack %s has %s calories.", name, calories);
        return new StringBuffer("The snack ").append(name).append(" has ").append(calories).toString();
    }

    public static void main(String[] args) {
        UT.clearScreen();
        Snack s1 = new Snack("Kit-Kat", 300);
        Snack s2 = new Snack("Snickers", 200);
        s1.setName("Snickers");
        System.out.println(s1.getName());
        s1.setCalories(200);
        System.out.println(s1.getCalories());
        System.out.println(s1);
        System.out.println();
        System.out.println(s2);
        System.out.println();
        System.out.println(s1.getName().equals(s2.getName()));
        System.out.println(s1.getCalories() == s2.getCalories());
        System.out.println(s1.isSameName(s2));
    }
}
