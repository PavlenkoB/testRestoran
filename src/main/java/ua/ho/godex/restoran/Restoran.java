package ua.ho.godex.restoran;

import ua.ho.godex.restoran.objects.Client;
import ua.ho.godex.restoran.objects.Display;
import ua.ho.godex.restoran.objects.Manager;
import ua.ho.godex.restoran.objects.Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 16.07.2017
 * Project: testRestoran
 */

public class Restoran {
    public static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    static Display display;    //mThing - объект display
    static Manager manager;    //mThing - объект manager
    static volatile List<Client> clients;
    static volatile List<Table> tables;

    //static List<Client> clientsInWait=new ArrayList<>();
    public static void main(String[] args) throws IOException, InterruptedException {
        clients = Client.createNewClients(5);
        tables = Table.createTables(5);
        display = new Display(clients, tables);
        Thread myThready = new Thread(display);    //Создание потока "display"
        myThready.setDaemon(true);
        myThready.start();                //Запуск потока

        manager = new Manager(clients, tables);
        Thread managerThread = new Thread(manager);    //Создание потока "manager"
        managerThread.setDaemon(true);
        managerThread.start();                //Запуск потока

        consoleReader.readLine();
    }

}
