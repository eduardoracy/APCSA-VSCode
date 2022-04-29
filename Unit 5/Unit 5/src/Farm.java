public class Farm {
    public static void main(String[] args) {
        Dog d = new Dog("Fido", true);
        System.out.println(d);
        System.out.format("%s says %s\n",d.getName(), d.speak());
        System.out.format("%s and moves like %s\n", d.getName(), d.speak());
        
        System.out.println();

        Snake s = new Snake("Ray", true);
        System.out.println(s);
        System.out.println(s.speak());
        System.out.println(s.move());
    }
}
