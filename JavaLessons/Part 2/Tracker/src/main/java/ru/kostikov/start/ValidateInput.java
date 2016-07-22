package ru.kostikov.start;

/**
 * Created by Алексей on 21.07.2016.
 */
public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range){
        int value          = -1;
        boolean valid_data = false;
        do{
            try {
                value = super.ask(question, range);
                valid_data = true;
            }catch (NumberFormatException nfe){
                System.out.println("Please enter correct data");
            }catch (MenuOutException moe){
                System.out.println("Please please select key from menu");
            }
        }while(valid_data != true);


        return value;
    }

}
