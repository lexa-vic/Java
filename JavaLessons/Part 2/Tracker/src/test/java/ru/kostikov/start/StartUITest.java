package ru.kostikov.start;

import org.junit.Before;
import org.junit.Test;
import ru.kostikov.models.Comment;
import ru.kostikov.models.Item;
import ru.kostikov.models.Task;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * Created by Алексей on 20.07.2016.
 */
public class StartUITest {
    private Tracker tracker;

    public StartUITest(){
        this.tracker = new Tracker();
    }

    /**
     * Тест добавления заявки в терекер через консольное меню
     * @throws Exception
     */
    @Test
    public void addTaskTest() throws Exception {
        boolean expect = true;
        boolean result = false;
        Input input = new StubInput( new String[]{
                "1",                    // Main menu: "1. Add task."
                "Problem with printer", // Add menu: "Please enter task's name "
                "Printer do not print", // Add menu: "Please enter task's description "
                "n",                    // Add menu: "Would you like add comment?(y/n) "
                "4",                    // Main menu: "4. Exit."

        });

        StartUI ui = new StartUI(input, this.tracker);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream             ps = new PrintStream(baos);

        System.setOut(ps);
        ui.run();

        for (Item task: this.tracker.getAll()){
            if(task.getName().equals("Problem with printer") &&
               task.getDescription().equals("Printer do not print")){
                result = true;
            }
        }

        assertThat(expect,  is(result));
    }

    /**
     * Тест отображения задач
     * @throws Exception
     */
    @Test
    public void showAllTest() throws Exception {
        String resultString   = null;
        String expectedString = null;

        Input input = new StubInput( new String[]{
                "2",                    // Main menu: "2. Show all tasks."
                "y",                    // Show all menu: "Please enter any key... "
                "4",                    // Main menu: "4. Exit."

        });
        Item task = new Task("Problem with printer", "Printer do not print");
        this.tracker.add(task);

        //Jointer.on

        expectedString = "1. Add the new item.\r\n" +
                         "2. Show all items.\r\n" +
                         "3. Find item.\r\n" +
                         "4. Exit.\r\n" +
                         "Select: \r\n" +
                         "Task id: "+ task.getId() +
                         " name: Problem with printer, description: Printer do not print \n" +
                         "Please enter any key... \r\n"+
                         "1. Add the new item.\r\n" +
                         "2. Show all items.\r\n" +
                         "3. Find item.\r\n" +
                         "4. Exit.\r\n" +
                         "Select: \r\n";

        StartUI ui = new StartUI(input, this.tracker);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream             ps = new PrintStream(baos);

        System.setOut(ps);
        ui.run();

        resultString = baos.toString();

        assertThat(expectedString,  is(resultString));
    }

    /**
     * Тест поиска заявки
     * @throws Exception
     */
    @Test
    public void findTaskTest() throws Exception {
        boolean expect = true;
        boolean result = false;
        String resultString   = null;
        String findString     = null;

        Input input = new StubInput( new String[]{
                "3",                    // Main menu: "3. Find task."
                "Problem with printer", // Find menu: "Please enter task's name or description: "
                "1",                    // Find menu: "Please choose the task: "
                "5",                    // Find menu: "5. Exit."
                "4",                    // Main menu: "4. Exit."

        });
        Item task = new Task("Problem with printer", "Printer do not print");
        this.tracker.add(task);

        findString = "1. Task id: "+ task.getId() + " name: Problem with printer, description: Printer do not print \n";

        StartUI ui = new StartUI(input, this.tracker);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream             ps = new PrintStream(baos);

        System.setOut(ps);
        ui.run();

        resultString = baos.toString();

        result = resultString.contains(findString);

        assertThat(expect,  is(result));
    }

    /**
     * Тест изменения имени заявки
     * @throws Exception
     */
    @Test
    public void changeNameTest() throws Exception {
        String resultString   = null;
        String expectString   = null;

        Input input = new StubInput( new String[]{
                "3",                    // Main menu: "3. Find task."
                "Problem with printer", // Find menu: "Please enter task's name or description: "
                "1",                    // Find menu: "Please choose the task: "
                "1",                    // Find menu: "1. Change name.: "
                "Printer crashed",      // Find menu: "Please enter new task's name : "
                "5",                    // Find menu: "5. Exit."
                "4",                    // Main menu: "4. Exit."

        });
        Item task = new Task("Problem with printer", "Printer do not print");
        this.tracker.add(task);

        expectString = "Printer crashed";

        StartUI ui = new StartUI(input, this.tracker);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream             ps = new PrintStream(baos);

        System.setOut(ps);
        ui.run();

        resultString = task.getName();//baos.toString();

        assertThat(expectString,  is(resultString));
    }

    /**
     * Тест изменения описания заявки
     * @throws Exception
     */
    @Test
    public void changeDescriptionTest() throws Exception {
        String resultString   = null;
        String expectString   = null;

        Input input = new StubInput( new String[]{
                "3",                    // Main menu: "3. Find task."
                "Problem with printer", // Find menu: "Please enter task's name or description: "
                "1",                    // Find menu: "Please choose the task: "
                "2",                    // Find menu: "2. Change description.: "
                "Printer do not work",  // Find menu: "Please enter new task's description : "
                "5",                    // Find menu: "5. Exit."
                "4",                    // Main menu: "4. Exit."

        });
        Item task = new Task("Problem with printer", "Printer do not print");
        this.tracker.add(task);

        expectString = "Printer do not work";

        StartUI ui = new StartUI(input, this.tracker);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream             ps = new PrintStream(baos);

        System.setOut(ps);
        ui.run();

        resultString = task.getDescription();//baos.toString();

        assertThat(expectString,  is(resultString));
    }

    /**
     * Тест добавления комментария к заявке
     * @throws Exception
     */
    @Test
    public void addCommentTest() throws Exception {
        String resultString   = null;
        String expectString   = null;

        Input input = new StubInput( new String[]{
                "3",                    // Main menu: "3. Find task."
                "Problem with printer", // Find menu: "Please enter task's name or description: "
                "1",                    // Find menu: "Please choose the task: "
                "3",                    // Change menu: "3. Add comment. "
                "bla bla bla",          // Change menu: "Please enter a comment:  "
                "n",                    // Change menu: "Any more?(y/n):  "
                "5",                    // Find menu: "5. Exit."
                "4",                    // Main menu: "4. Exit."

        });
        Item task = new Task("Problem with printer", "Printer do not print");
        this.tracker.add(task);

        expectString = "bla bla bla";

        StartUI ui = new StartUI(input, this.tracker);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream             ps = new PrintStream(baos);

        System.setOut(ps);
        ui.run();

        for(Comment comment: task.getAllComments()){
            resultString = comment.getComment();
            break;
        }

        assertThat(expectString,  is(resultString));
    }

    /**
     * Тест удаления заявки
     * @throws Exception
     */
    @Test
    public void delTaskTest() throws Exception {
        int resultLength   = 1;
        int expectLength   = 0;

        Input input = new StubInput( new String[]{
                "3",                    // Main menu: "3. Find task."
                "Problem with printer", // Find menu: "Please enter task's name or description: "
                "1",                    // Find menu: "Please choose the task: "
                "4",                    // Change menu: "4. Del task. "
                "\n",                    // Task delete. Please enter any key... "
                "4",                    // Main menu: "4. Exit."

        });
        Item task = new Task("Problem with printer", "Printer do not print");
        this.tracker.add(task);

        StartUI ui = new StartUI(input, this.tracker);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream             ps = new PrintStream(baos);

        System.setOut(ps);
        ui.run();

        Item[] allTask = this.tracker.getAll();
        resultLength   = allTask.length;

        assertThat(expectLength,  is(resultLength));
    }


}