package ru.kostikov.start;

import ru.kostikov.models.Item;

import java.util.Arrays;
import java.util.Random;


/**
 * This class implements tracker logic.
 * Created by Алексей on 14.07.2016.
 */
public class Tracker {
    /** Size of request storage. */
    private int storageSize = 10;
    /**
     * Request storage */
    private Item[] items = new Item[this.storageSize];
    /**
     * Current position in storage */
    private int position = 0;
    /** Random number for Id. */
    private static final Random RN = new Random();

    /**
     * Add new requst.
     * @param item new request.
     * @return true - success, false - fail.
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
     * Delete request.
     * @param delItem Request for del.
     * @return true - success, false - fail.
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
     * Find request by Id.
     * @param id Id
     * @return Request, if it not found return NULL
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
     * Get request by filter
     * @param filter Filter - substring in request.
     * @return request.
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
     * Generate Id.
     * @return id.
     */
    String generateId() {
        return String.valueOf(RN.nextInt());
    }

    /**
     * Get all requests.
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
