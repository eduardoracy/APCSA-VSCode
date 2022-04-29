public class Musician extends Performer{
    private String instrument;

    public String getInstrument() {
        return instrument;
    }

    public Musician() {
        
    }

    public Musician(String name, int age, String instrument) {
        super(name, age);
        this.instrument = instrument;
    }

    public void playInstrument() {
        System.out.println(String.format("Making music with my %s", instrument));
    }

    public String toString() {
        return String.format("%s\nInstrument: %s\n", super.toString(), instrument);
    }
}
