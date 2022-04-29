public class Student {
    private String name;
    private int numberOfCourses;
    public Student(String name, int numberOfCourses) {
        this.name = name;
        this.numberOfCourses = numberOfCourses;
    }

    public String toString() {
        return String.format("Student name: %s\nNumber of course: %s", name, numberOfCourses);
    }

    
}
