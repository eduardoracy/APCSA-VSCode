public class Snake extends Pet{
    private boolean shedding;

    public Snake(String name, boolean shedding) {
        super(name);
        this.shedding = shedding;
    }

    public String speak() {
        return String.format("%s says %s", super.getName(), "hiss");
    }

    public String move() {
        return String.format("%s walks by %s", super.getName(), "slithering");
    }

    public String toString() {
        return String.format("%s\nIs shedding: %s", super.toString(), shedding);
    }
}
