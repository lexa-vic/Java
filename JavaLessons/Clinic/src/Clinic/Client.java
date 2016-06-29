/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Алексей
 */
public class Client {
    /** Имя клиента*/
    private String firstName;
    /** Фамилия клиента*/
    private String secondName;
    
    /** Домашние животные клиента*/
    private final List<Pet> client_pets = new ArrayList<>();
    
    
    /** @param firstName  - имя клиента 
      * @param secondName - Фамилия клиента 
      */
    public Client(String firstName, String secondName)
    {
        this.firstName = firstName;
        this.secondName = secondName;
    }
    
    public void addPet(final Pet newPet)
    {
        client_pets.add(newPet);
    }
    
    public List<Pet> getPets()
    {
        return client_pets;
    }
    
    /**
     *
     * @return
     */
    public String getFirstName()
    {
        return this.firstName;
    }
    
    public String getSecondName()
    {                                                                                                
        return this.secondName ;
    }
    
    public void changeFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void changeSecondName(String secondName)
    {
        this.secondName = secondName;
    }
    
    public void show()
    {
        System.out.printf("%s %s has %d pets\n", this.firstName, this.secondName, client_pets.size());
        for(Pet pet_item : client_pets)
        {
            System.out.printf("%s %s \n", pet_item.getAnimal(), pet_item.getName());
        }

    }
}
