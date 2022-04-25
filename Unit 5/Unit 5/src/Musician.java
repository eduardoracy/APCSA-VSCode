public class Musician extends Performer{
    private String instrument;

    public String getInstrument() {
        return instrument;
    }


    public Musician(String instrument) {
        this.instrument = instrument;
    }

    public void playInstrument() {
        System.out.println(String.format("Making music with my %s", instrument));
    }
}
