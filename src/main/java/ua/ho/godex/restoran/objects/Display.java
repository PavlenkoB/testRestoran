package ua.ho.godex.restoran.objects;

/**
 * Creator: Pavlenko Bohdan
 * Date: 17.07.2017
 * Project: testRestoran
 */

import java.util.List;

/**
 * display status to console
 */


public class Display implements Runnable {
    volatile List<Client> clientsInWait;
    volatile List<Table> tables;
    Integer addClient = 0;

    public Display(List<Client> clientsInWait, List<Table> tables) {
        this.clientsInWait = clientsInWait;
        this.tables = tables;
    }

    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            clearScreen();
            System.out.println("Lost clients=" + Manager.getLostClient());
            System.out.println("Served clients=" + Manager.getServedClients());
            System.out.println("Next clients=" + Client.addNewClient);
            for (Client client : clientsInWait) {
                System.out.println(client.toString());
            }
            for (Table table : tables) {
                System.out.println(table.toString());
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
