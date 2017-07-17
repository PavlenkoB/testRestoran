package ua.ho.godex.restoran.objects;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Creator: Pavlenko Bohdan
 * Date: 17.07.2017
 * Project: testRestoran
 */
public class Manager implements Runnable {
    List<Client> clientsInWait;
    List<Table> tables;
    Client tmpClient;
    public Manager(List<Client> clientsInWait, List<Table> tables) {
        this.clientsInWait = clientsInWait;
        this.tables = tables;
    }

    @Override
    public void run() {
        System.out.println("Привет из Manager!");
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int counter=0;counter<clientsInWait.size();counter++) {
                    tmpClient=clientsInWait.get(counter);
                    if(tmpClient.getWaitTime()<1){
                        clientsInWait.remove(counter);
                    }
                    tmpClient.setWaitTime(tmpClient.getWaitTime()-1);
                }
                /*
                for (Table table : tables) {
                    System.out.println(table.toString());
                }*/

            }
    }
}
