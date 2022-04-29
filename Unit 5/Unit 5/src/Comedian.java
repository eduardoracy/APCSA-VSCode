public class Comedian extends Performer{
    private String joke;

    public Comedian(String name, int age, String joke) {
        super(name, age);
        this.joke = joke;
    }

    public String toString() {
        return String.format("%s\nJoke: %s", super.toString(), joke);
    }
}
