/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Clinic.Client;
import Clinic.Clinic;
import Clinic.Pet;
import java.util.List;
/**
 *
 * @author Алексей
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Clinic clinic = new Clinic();
        
        Client client1 = new Client("Aleksey", "Kostikov");
        
        client1.addPet(new Pet("Cat", "Timofey"));
        client1.addPet(new Pet("Dog", "Marti"));
        
        clinic.addClient(client1);
        
        Client client2 = new Client("Aleksey", "Petrov");
        client2.addPet(new Pet("Cat", "Busila"));
        
        clinic.addClient(client2);
        
        //clinic.removeClient(client2);
        

        List<Client> needClients = clinic.findClient("Aleksey");
        
         for (Client item: needClients)
         {
             item.show();
             item.changeSecondName("Иванов");
             item.show();
         }
         
        clinic.start();
    }
 
}
