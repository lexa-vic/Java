package ru.kostikov.start;

import ru.kostikov.models.Item;

import java.util.Arrays;
import java.util.Random;


/**
 * Created by Алексей on 14.07.2016.
 */
public class Tracker {
    /**
     * Размер хранилища заявок
     */
    private int storageSize = 10;
    /**
     * Хранилище заявок
     */
    private Item[] items = new Item[this.storageSize];
    /**
     * Текущая позиция в хранилище
     */
    private int position = 0;
    /**
     * Класс для генерации рандомного числа для Id
     */
    private static final Random RN = new Random();

    /**
     * Добавление новой заявки
     * @param item
     * @return true - добавление успешно, false - не успешно
     */
    public boolean add(Item item){

        boolean result = false;

        if (item != null)
        {
            // Если кол-во заявок перевалило за границу массива, расширяем массив
            if (this.position >= this.items.length)
            {
                this.storageSize += 20;
                this.items = Arrays.copyOf(this.items, this.storageSize);
            }

            item.setId(generateId());
            this.items[this.position++] = item;
            result = true;
        }

        return result;
    }

    /**
     * Удаление заявки
     * @param delItem
     * @return true - успешно, false - не успешно
     */
    public boolean del(Item delItem){

        boolean result = false;

        if (delItem != null){
            for(int indx = 0; indx < this.position; indx++){

                if(this.items[indx].getId().equals(delItem.getId())){
                    result = true;

                    this.items[indx] = null;
                    this.position--;
                    for(int offset = indx; offset < this.position; offset++){
                        this.items[offset] = this.items[offset+1];
                    }
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Поиск задачи по id
     * @param id
     * @return Найденая задача, если не найдена NULL
     */
    protected Item findById(String id){
        Item result = null;
        for(Item item: items){
            if(item != null && item.getId().equals(id)){
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Получение заявок по фильтру - если есть в имени или описании строка фильтра
     * @param filter
     * @return
     */
    public Item[] findByFilter(String filter){
        Item[] result = new Item[this.position];
        int count     = 0;

        if (filter != null){

            for(int indx = 0; indx < this.position; indx++){
                String name = this.items[indx].getName();
                String desc = this.items[indx].getDescription();

                if (name.contains(filter) || desc.contains(filter)){
                    result[count] = this.items[indx];
                    count++;
                }
            }
            if (count != 0){
                result = Arrays.copyOf(result, count);
            }
        }

        return result;
    }

    /**
     * Генерация id
     * @return
     */
    String generateId() {
        return String.valueOf(RN.nextInt());
    }

    /**
     * Получение всех заявок
     * @return
     */
    public Item[] getAll(){
        Item[] result = new Item[this.position];

        for(int indx = 0; indx < this.position; indx++){
            result[indx] = this.items[indx];
        }

        return result;

    }

}
