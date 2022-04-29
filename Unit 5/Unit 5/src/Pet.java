public abstract class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("Name: %s", name);
    }

    abstract public String speak();
    abstract public String move();
}
