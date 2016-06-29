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
    
    public List<Client> findClient(final String firstName, final String secondName)
    {
        List<Client> clients = new ArrayList<>();
        
        for (Client client : clients_base)
        {
            if (client.getFirstName().equals(firstName))
            {
                if (client.getSecondName().equals(secondName))
                {
                    clients.add(client);
                }
            }
        }
        return clients;
    }
    
    /** 
     * Поиск по имени или фамилии
     * @param Name
     * @return Список найденных клиентов
     */
    public List<Client> findClient(final String Name)
    {
        List<Client> clients = new ArrayList<>();
        
        for (Client client : clients_base)
        {
            if (client.getFirstName().equals(Name))
            {
                clients.add(client);
            }
        }
        
        if (clients.isEmpty())
        {
            for (Client client : clients_base)
            {
                if (client.getFirstName().equals(Name))
                {
                    clients.add(client);
                }
            }
        }
        
        return clients;
    }
    
    public boolean removeClient(Client client)
    {
        boolean result = false;

        return result = clients_base.remove(client);
    }
    
    public void start()
    {
        
    }
}
