package hellojpa;

public class ValueMain {
    public static void main(String[] args) {

        Integer a = 10;
        Integer b = a;

        a = 7;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        String nameA = "HelloA";
        String nameB = nameA;
        
        nameA = "ByeA";

        System.out.println("nameB = " + nameB);
    }
}
