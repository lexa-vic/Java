package ru.kostikov.menu;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class implements menu item.
 * It may contains other menu-submenu.
 * Created by Алексей on 13.09.2016.
 */
public class Menu implements Show, Select{
    private String name;
    private List<Menu> subMenu = new ArrayList<Menu>();
    private int index = 0;
    private Action callback;

    /**
     * Constructor - create Menu with name
     * @param name
     */
    public Menu(String name) {
        this.name = name;
    }

    /**
     * Gets name of this menu
     * @return
     */
    public String getName(){
        return this.name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    /**
     * Add submenu for this menu
     * @param subMenu
     */
    public void addMenu(Menu subMenu){
        this.subMenu.add(subMenu);
        subMenu.setIndex(this.subMenu.size());
    }

    /**
     * Gets all submenus for this menu
     * @return
     */
    public List<Menu> getSubMenuList(){
        return this.subMenu;
    }

    /**
     * Sets Callback
     * @param action Callback interface
     */
    public void setCallback(Action action) {
        this.callback = action;
    }

    /**
     * Start Callback
     */
    public void action() {
        if (this.callback != null){
            this.callback.callBackAction();
        }
    }

    /**
     * Show current menu
     * @param output    output stream
     * @param prefix    prefix for margin e.g. "-"
     * @throws IOException
     */
    @Override
    public void showMenu(Writer output, String prefix) throws IOException{
        int counter = 1;
        // if this is'n a root menu
        if (this.name != null){
            output.write(Joiner.on("").join(String.valueOf(index), ".", this.name, "\n"));
        }
        for (Menu menu: this.subMenu) {
            if (this.index != 0){
                output.write(Joiner.on("").join(prefix, String.valueOf(index), "."));
            }
            menu.showMenu(output, Strings.repeat(prefix, 2));
            counter++;
        }
        output.flush();
    }

    /**
     * Select menu by Index
     * @param index Index e.g 1.2.3.
     * @return
     */
    @Override
    public Menu select(String index){
        int menuIndex;
        String refactorIndex = index.replace(".", " ");
        Menu findMenu = null;

        if (this.index == 0){
            refactorIndex = Joiner.on("").join("0 ", refactorIndex);
        }

        try{
            menuIndex = Integer.parseInt(refactorIndex.substring(0,1));
            if (this.index == menuIndex) {
                if (refactorIndex.length() > 2){
                    try{
                        String nextNum = refactorIndex.substring(2, 3);
                        Integer.parseInt(nextNum);

                        for (Menu menu : this.subMenu) {
                            findMenu = menu.select(refactorIndex.substring(2));
                            if (findMenu != null){
                                break;
                            }
                        }
                    }
                    catch (Exception e){
                        findMenu = null;
                    }
                }
                else {
                    findMenu = this;
                }
            }
        }catch (Exception e){
            findMenu = null;
        }
        return findMenu;
    }
}
