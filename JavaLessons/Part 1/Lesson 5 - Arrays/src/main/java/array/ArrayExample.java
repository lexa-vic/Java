package array;

/**
 * Created by Алексей on 11.07.2016.
 */
public class ArrayExample {



    /**
     * Сортировка массива по возрастанию
     * @param array
     */
    public void sort(int array[]){

        for (int i = 0; i < (array.length-1); i++){
            for (int j = 0; j < (array.length-1); j++){
                if (array[j] > array[j+1])
                {
                    int tmp    = array[j+1];
                    array[j+1] = array[j];
                    array[j]   = tmp;
                }
            }
        }
    }

    /**
     * Поворот двумерного массива на 90 градусов
     * @param array
     */
    public int[][] rotate(int array[][]){

        final int stringNum =  array.length;
        final int columnNum =  array[0].length;
        // Транспонируем матрицу - заменяем все строки соответствующими по номера столбцами
        int[][] newArray = new int[columnNum][stringNum];

        for(int i = 0; i < columnNum; i++){
            for (int j = 0; j < stringNum; j++){
                newArray[i][j] = array[j][i];
            }
        }

        // Переворачиваем кажду строку нового массива
        for(int i = 0; i < columnNum; i++){
            for (int j = 0; j < stringNum/2; j++){
                int tmp                  = newArray[i][j];
                newArray[i][j]           = newArray[i][stringNum-1];
                newArray[i][stringNum-1] = tmp;
            }
        }



        return newArray;
    }

    /**
     * Удаление дубликатов строк
     * @param array
     */
    public void duplicateDelete(String[] array){

        int currentLines = array.length;
        for (int n = 0; n < currentLines; n++){

            for(int i = n+1; i < currentLines;){
                // Нашли совпадения
                if (array[n].equals(array[i])){
                    // Подвигаем все элементы
                    for(int j = i; j < (array.length-1);j++){
                        array[j] = array[j+1];
                    }
                    array[array.length-1] = "";
                    currentLines--;

                }else{
                    i++;
                }
            }
        }

    }
}
