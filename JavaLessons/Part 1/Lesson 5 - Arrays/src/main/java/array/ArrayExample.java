package array;

/**
 * This class implements different manipulations whis array.
 * Created by Алексей on 11.07.2016.
 */
public class ArrayExample {
    /**
     * Array sort ascending
     * @param array imnput array for sort
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
     * 90 degree rotates array
     * @param array input array
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
     * Deleting dublicate strings
     * @param array
     */
    public void duplicateDelete(String[] array){

        int currentLines = array.length;
        for (int n = 0; n < currentLines; n++){

            for(int i = n+1; i < currentLines;){
                if (array[n].equals(array[i])){
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
