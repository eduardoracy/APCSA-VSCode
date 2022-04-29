public class Performer {
    private String name;
    private int age;
    
    public Performer() {
        
    }

    public Performer(String name, int age) {
        this.name = name;
        this.age = age;
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

    public String toString() {
        return String.format("Name: %s\nAge: %s", name, age);
    }
}
