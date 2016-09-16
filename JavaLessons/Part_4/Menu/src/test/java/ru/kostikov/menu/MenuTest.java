package ru.kostikov.menu;

import com.google.common.base.Joiner;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Алексей on 13.09.2016.
 */
public class MenuTest {
    private String name = "Introduction";
    Menu rootMenu  = new Menu(null);
    Menu menuInt = new Menu("Introduction");
    Menu menuPartI = new Menu("Part I");
    Menu menuPartIChapterI = new Menu("Chapter I");
    Menu menuPartIChapterISceneI = new Menu("Scene I");
    Menu menuPartIChapterII = new Menu("Chapter II");

    @Before
    public void init(){
        menuPartIChapterI.addMenu(menuPartIChapterISceneI);
        menuPartI.addMenu(menuPartIChapterI);
        menuPartI.addMenu(menuPartIChapterII);
        rootMenu.addMenu(menuInt);
        rootMenu.addMenu(menuPartI);
    }

    @Test
    public void whenSetNameThenGetSameName() throws Exception {
        assertThat(name, is(menuInt.getName()));
    }

    @Test
    public void whenNoSubMenuThenGetsSubMenuListEmpty() throws Exception {
        int expected_size = 0;
        int result_size = 1;
        List<Menu> list = menuInt.getSubMenuList();
        result_size = list.size();
        assertThat(expected_size, is(result_size));
    }

    @Test
    public void whenSetSubMenuThenGetRightSubMenuList() throws Exception {
        Menu resultSubMenu;

        resultSubMenu = rootMenu.getSubMenuList().get(0);
        assertThat(menuInt, is(resultSubMenu));
    }

    @Test
    public void whenSetsMenuThenShowCorrectMenu() throws Exception {
        String expected = Joiner.on("").join( "1.Introduction\n",
                                              "2.Part I\n",
                                                "--2.1.Chapter I\n",
                                                "----1.1.Scene I\n",
                                                "--2.2.Chapter II\n");
        String result;

        CharArrayWriter charArray = new CharArrayWriter();
        Writer output = new BufferedWriter(charArray);

        rootMenu.showMenu(output, "-");
        result = charArray.toString();
        assertThat(expected, is(result));
    }

    @Test
    public void whenSetsCallbackThenIfItCallItPrints() throws Exception {
        String expected = "Hello\r\n";
        String result;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream             ps = new PrintStream(baos);

        System.setOut(ps);
        menuInt.setCallback(new Action() {
            @Override
            public void callBackAction() {
                System.out.println("Hello");
            }
        });
        menuInt.action();

        result = baos.toString();

        assertThat(expected, is(result));
    }

    @Test
    public void whenSelectMenuThenMenuReturnRightItem() throws Exception {
        Menu resultSubMenu;
        Menu expectedSubMenu = menuPartIChapterI;
        resultSubMenu = rootMenu.select("2.1");

        assertThat(expectedSubMenu, is(resultSubMenu));
    }
   @Test
    public void whenSelectWrongMenuThenMenuReturnNull() throws Exception {
        Menu resultSubMenu;
        Menu expectedSubMenu = null;
        resultSubMenu = rootMenu.select("2.3.5.");

        assertThat(expectedSubMenu, is(resultSubMenu));
    }
}