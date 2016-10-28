package ru.kostikov;

import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 28.10.2016.
 */
public class CacheTxtTest {

    @Test
    public void whenFileExistAndNotInCacheThenItAddAndPrint(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CacheTxt cacheTxt = new CacheTxt(baos);

        String expected = Joiner.on("").join("1. Aleksey\r\n",
                                             "2. Ivan\r\n",
                                             "3. Vladimir\r\n",
                                             "4. Oleg\r\n");

        cacheTxt.getTxt("Names.txt");
        String outStr = baos.toString();

        Assert.assertThat(expected, is(outStr));
    }

    @Test
    public void whenFileExistInCacheThenPrintIt(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CacheTxt cacheTxt = new CacheTxt(baos);

        String expected = Joiner.on("").join("1. St.Petersburg\r\n",
                                             "2. Moscow\r\n",
                                             "3. Sochi\r\n",
                                             "4. Ekb\r\n",
                                             "1. St.Petersburg\r\n",
                                             "2. Moscow\r\n",
                                             "3. Sochi\r\n",
                                             "4. Ekb\r\n");

        cacheTxt.getTxt("Addreses.txt");
        cacheTxt.getTxt("Addreses.txt");
        String outStr = baos.toString();

        Assert.assertThat(expected, is(outStr));
    }

}