package ru.kostikov.players;

/**
 * Created by Алексей on 26.07.2016.
 */
public class White {
    private final int y_low = 5;
    private final int y_hi  = 8;


    /**
     * Проверка границы своего поля
     * @param y
     * @return
     */
    public boolean checkSelfSide(int y){
        boolean result = false;

        if (y >= y_low && y <= y_hi){
            result = true;
        }
        return result;
    }

}
