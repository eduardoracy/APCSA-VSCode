public class Dog extends Pet {
    private boolean stink;

    public Dog(String name, boolean stink) {
        super(name);
        this.stink = stink;
    }

    public String speak() {
        return "woof";
    }

    public String move() {
        return "walk";
    }

    public String toString() {
        return String.format("%s\nHas an odor: %s", super.toString(), stink);
    }


}
