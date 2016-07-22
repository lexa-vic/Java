package ru.kostikov.start;

/**
 * Created by Алексей on 19.07.2016.
 */
public class StubInput implements Input {

    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers){
        this.answers = answers;
    }


    public String ask (String question){
        System.out.println(question);
        return this.answers[this.position++];
    }
    public int ask(String question, int[] range){
        int key  = Integer.valueOf(this.ask(question));
        boolean exist = false;

        for (int value: range){
            if (value == key){
                exist = true;
                break;
            }
        }
        if (!exist){
            throw new MenuOutException("Out of range menu");
        }
        return key;
    }

}
