public class Show {

    public static void main(String[] args) {
        Performer p1 = new Performer();
        Performer p2 = new Performer("andrew", 17);

        System.out.println(p1);
        System.out.println(p2);

        Musician m1 = new Musician();
        Musician m2 = new Musician("Samena", 17, "bagpipies");

        System.out.println(m1);
        System.out.println(m2);

        

    }
}
