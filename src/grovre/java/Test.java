package grovre.java;

public class Test {

    public static void main(String[] args) {
        Deck d = new Deck();
        d.moveTopCardTo(3);
        System.out.println(d.toStringClean());
    }

}
