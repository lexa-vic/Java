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
public class Clinic {
    
    private final List<Client> clients_base = new ArrayList<>();
    
    public void addClient(final Client newClient)
    {
        clients_base.add(newClient);
    }
    
    public void start()
    {
        Client client1 = new Client("Aleksey", "Kostikov");
        
        client1.addPet(new Pet("Cat", "Timofey"));
        client1.addPet(new Pet("Dog", "Marti"));

        
        client1.show();
    }
}
