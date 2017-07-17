import objects.Client;

import java.util.Date;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 16.07.2017
 * Project: testRestoran
 */
public class Restoran {
    public static void main(String[] args) {
        List<Client> clients=Client.createNewClients(5);
        clients.forEach(client -> System.out.println(client.toString()));
        System.out.format("End= %s",new Date());
    }
}
