package ua.ho.godex.restoran.objects;

/**
 * Creator: Pavlenko Bohdan
 * Date: 17.07.2017
 * Project: testRestoran
 */

import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * display status to console
 */


public class Display implements Runnable {
    List<Client> clientsInWait;
    List<Table> tables;

    public Display(List<Client> clientsInWait, List<Table> tables) {
        this.clientsInWait = clientsInWait;
        this.tables = tables;
    }

    @Override
    public void run() {
        while (true) {
            clearScreen();
            System.out.println("Lost clients="+Manager.getLostClient());
            System.out.println("Served clients="+Manager.getServedClients());
            if(clientsInWait.size()<5){
                clientsInWait.addAll(Client.createNewClients(3));
            }
            for (Client client : clientsInWait) {
                System.out.println(client.toString());
            }
            for (Table table : tables) {
                System.out.println(table.toString());
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void clearScreen()  {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
