/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

/**
 *
 * @author Алексей
 */
public class Pet {
    
    private String animal;
    private String name;
    
    /**
     *
     * @param animal
     * @param name
     */
    public Pet(final String animal, final String name)
    {
        this.animal = animal;
        this.name   = name;
    }
    
    public String getAnimal()
    {
        return this.animal;
    }
    
    public String getName()
    {
        return this.name;
    }
    /**
     */
    public void changeName(final String name)
    {
        this.name = name;
    }
}
