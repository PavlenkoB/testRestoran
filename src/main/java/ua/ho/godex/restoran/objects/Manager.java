package ua.ho.godex.restoran.objects;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Creator: Pavlenko Bohdan
 * Date: 17.07.2017
 * Project: testRestoran
 */
public class Manager implements Runnable {
    static Integer lostClient = 0;
    static Integer servedClients = 0;
    volatile List<Client> clientsInWait;
    volatile List<Table> tables;

    public Manager(List<Client> clientsInWait, List<Table> tables) {
        this.clientsInWait = clientsInWait;
        this.tables = tables;
    }

    public static Integer getLostClient() {
        return lostClient;
    }

    public static Integer getServedClients() {
        return servedClients;
    }

    public static void setServedClients(Integer servedClients) {
        Manager.servedClients = servedClients;
    }

    @Override
    public void run() {
        Client tmpClient;
        System.out.println("Привет из Manager!");
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //отнять по секунде в очереди
            for (int counter = 0; counter < clientsInWait.size(); counter++) {
                tmpClient = clientsInWait.get(counter);
                tmpClient.setWaitTime(tmpClient.getWaitTime() - 1);
                if (tmpClient.getWaitTime() < 1) {
                    clientsInWait.remove(counter);
                    lostClient++;
                }
            }
            //отнять по секунде в сидячих
            for (Table table : tables) {
                if (table.isAvailable() && clientsInWait.size() > 0) {
                    table.sitClient(clientsInWait.remove(0));
                } else {
                    Client client = table.getClient();
                    if (client != null) {
                        client.setEatTime(client.getEatTime() - 1);
                        if (client.getEatTime() < 1) {
                            servedClients++;
                            table.freeTable();
                            if (clientsInWait.size() > 0) {
                                table.sitClient(clientsInWait.remove(0));
                            }
                        }
                    }
                }
            }
            if (lostClient > 10) {
                tables.addAll(Table.createTables(1));
                lostClient = 0;
            }
            if ((Client.addNewClient--) < 1) {
                clientsInWait.addAll(Client.createNewClients(1));
            }
        }
    }
}
