public class StudentAthlete extends Student {
    private String sportName;

    public StudentAthlete(String name, int numberOfCourses, String sportName) {
        super(name, numberOfCourses);
        this.sportName = sportName;
    }

    public String toString() {
        return String.format("%s\nSport name: %s", super.toString(), sportName);
    }

    
}
