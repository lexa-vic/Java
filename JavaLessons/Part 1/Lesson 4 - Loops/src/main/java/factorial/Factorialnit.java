package factorial;

/**
 * Created by Алексей on 11.07.2016.
 */
public class Factorialnit {
    public static void main(String[] args) {

        Factorial n = new Factorial(0);

        System.out.printf("Factorial 0: %d\n", n.calculate());
        n = new Factorial(5);
        System.out.printf("Factorial 5: %d\n", n.calculate());

    }
}
