package ru.kostikov.start;

import org.junit.Before;
import org.junit.Test;
import ru.kostikov.models.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Created by Алексей on 18.07.2016.
 */
public class TrackerTest {
    Tracker traker = null;
    @Before
    public void initTest(){
        this.traker = new Tracker();
    }

    @Test
    public void addTest() throws Exception {
        Task task = new Task("First Task", "First Desc");
        this.traker.add(task);

        Item[] expect = new Task[]{task};
        Item[] result = this.traker.getAll();

        assertThat(expect,  is(result));
    }

    @Test
    public void del() throws Exception {
        this.traker = new Tracker();
        Task task = new Task("First Task", "First Desc");
        Task task2 = new Task("Second Task", "Second Desc");
        this.traker.add(task);
        this.traker.add(task2);

        this.traker.del(this.traker.getAll()[0]);

        Item[] expect = new Task[]{task2};
        Item[] result = traker.getAll();

        assertThat(expect,  is(result));
    }

    @Test
    public void findById() throws Exception {
        Task task = new Task("Some Task", "Some Desc");
        traker.add(task);

        String id = traker.getAll()[0].getId();

        Item expect = traker.getAll()[0];
        Item result = traker.findById(id);

        assertThat(expect,  is(result));
    }

    @Test
    public void findByFilter() throws Exception {
        Task task = new Task("Some Task", "Some Desc");
        traker.add(task);

        String id = traker.getAll()[0].getId();

        Item expect = traker.getAll()[0];
        Item result = traker.findByFilter("Some")[0];

        assertThat(expect,  is(result));
    }

}