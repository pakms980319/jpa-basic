package hellojpa;

public class ValueMain {
    public static void main(String[] args) {

        int a = 10;
        int b = 10;

        System.out.println("a == b ? " + (a == b));

        Address addressA = new Address("city", "street", "10000");
        Address addressB = new Address("city", "street", "10000");

        System.out.println("addressA == addressB ? " + (addressA == addressB));
        System.out.println("addressA equals addressB ? " + (addressA.equals(addressB)));
    }
}
