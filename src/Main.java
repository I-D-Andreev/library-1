import java.util.Date;

class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world");
        Address ad1 = new Address("Bay Campus, Fabian Way, Crymlyn Burrows", "Swansea", "UK", "SA1 8EP");
        Address ad2 = new Address("Bay Campus, Fabian Way", "Crymlyn Burrows", "Swansea", "UK", "SA1 8EP");

        System.out.println(ad1.toString());
        System.out.println("--------");
        System.out.println(ad2);

        Date d = new Date();
        System.out.println(d);
    }
}