/*
    Programmer: Eduardo Racy
    Date: 02/17/2022
    Purpose: to represent a snack
*/


public class Snack {

    private String name;
    private int calories;

    //Deafult constructor
    public Snack() {
        name = "Air";
        calories = 0;
    }
    //Overloaded constructor
    public Snack(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
    //Mutator
    public void setName(String name) {
        this.name = name;
    }
    //Accessor
    public String getName() {
        return name;
    }
    //Mutator
    public void setCalories(int calories) {
        this.calories = calories;
    }
    //Accessor
    public int getCalories() {
        return calories;
    }
    //Method
    public boolean isSameName(Snack s2) {
        return this.name.equals(s2.name);
    }
    /**
     * Method ot set value of calories
     * @param s2 - value to update number of calories
     * @return
     */
    //Method
    public boolean isSameCalories(Snack s2) {
        return this.calories == s2.calories;
    }
    //toString
    public String toString() {
        /* String result = "The snack " + name;
        result.concat(" has " + calories + ".");
        return result;
        */

        // return String.format("The snack %s has %s calories.", name, calories);

        // MessageFormat.format("The snack {0} has {1} calories.", name, calories);

        // return "The snack %s has %s calories".formatter

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

        if (s1.isSameCalories(s2)) {
            System.out.println("Both snacks have the same amount of calories");
        } else {
            System.out.println("Both snacks do not have the same amount of calories");
        }
    }
}
