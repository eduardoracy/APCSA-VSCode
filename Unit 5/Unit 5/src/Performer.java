public class Performer {
    private String name;
    private int age;
    
    public Performer() {
        
    }
    
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void practice() {
        System.out.println("Honing my craft!");
    }

    public void perform() {
        System.out.println("performing for an audience!");
    }
}
