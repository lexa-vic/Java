package factorial;

/**
 * This class implements calculation a factorial.
 * Created by Алексей on 11.07.2016.
 */
public class Factorial {
    private final int n;

    Factorial(int n){
        this.n = n;
    }

    /**
     * Factorial calculation
     * @return result of factorial
     */
    public int calculate(){
        int result = 1;

        if (n != 0){
            for(int cnt = 1; cnt <= n; cnt++)
            {
                result *= cnt;
            }
        }
        return result;
    }

}
