package ru.kostikov;

public class Coins {
    /* Достоинства разменых монет */
    static int[] cost = new int[] {1, 2, 5, 10};
    static int N = 4;
    static int[] count = new int[N];    /* число монет данного типа (коэффициенты ai) */
    static long nvar = 0;              /* число вариантов */

    /* sum монета, которую меняем */
    /* maxcoin индекс по массиву cost[] монеты максимального
     * достоинства, допустимой в данном размене.
     */
    private static void change(int maxcoin, int sum){
        if( sum == 0 ){  /* вся сумма разменяна */
        /* распечатать очередной вариант */

            for(int i = N-1 ; i >= 0 ; i-- )
                if( count[i] != 0 )
                    System.out.printf(" %3d |", count[ i ] );
                else
                    System.out.printf("     |" );
            System.out.printf("\n");
            nvar++;
            return;
        }
        if( sum >= cost [ maxcoin ] ){
        /* если можно выдать монету достоинством cost[maxcoin] ,
         * то выдать ее:
         */
            count[ maxcoin ] ++;   /* посчитали выданную монету */
       /* размениваем остаток суммы :
        * Первый аргумент - может быть можно дать еще одну такую монету ?
        * Второй аргумент - общая сумма убавилась на одну монету cost[maxcoin].
        */
            change( maxcoin, sum - cost[maxcoin] );
            count[ maxcoin ] --;   /* ... Теперь попробуем иной вариант ... */
        }
        /* попробовать размен более мелкими монетами */
        if( maxcoin != 0)
            change( maxcoin-1, sum );
    }



    public static void main(String[] args) {
        change(N-1, 10);
    }
}