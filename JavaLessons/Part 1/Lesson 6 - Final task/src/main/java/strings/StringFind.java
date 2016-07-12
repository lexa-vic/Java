package strings;

/**
 * Created by Алексей on 12.07.2016.
 */
public class StringFind {

    /**
     * Проверка, является ли sub подстрокой origin
     * @param origin Главная срока
     * @param sub    Подстрока
     * @return true - sub является подстрокой origin, false - не является
     */
    boolean contains(String origin, String sub){
        char[] originArray = origin.toCharArray();
        char[] subArray    = sub.toCharArray();
        boolean result     = false;

        if(originArray.length > 0 && subArray.length > 0 &&
           originArray.length >= subArray.length ){

            for(int i = 0; i < originArray.length; i++)
            {
                // Проверяем есть ли место в строке для подстроки
                if (originArray.length - i >= subArray.length){
                    // Первый элемент совпал
                    if (originArray[i] == subArray[0]){
                        int j;
                        for(j = 0; j < subArray.length; j++)
                        {
                            if(originArray[i+j] != subArray[j])
                            {
                                break;
                            }
                        }
                        // Подстрока совпала
                        if (j ==  subArray.length){
                            result = true;
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }
}
