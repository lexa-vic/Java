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
}
