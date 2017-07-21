package ua.ho.godex.restoran;

import ua.ho.godex.restoran.objects.Display;
import ua.ho.godex.restoran.objects.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Creator: Pavlenko Bohdan
 * Date: 16.07.2017
 * Project: testRestoran
 */

public class Restoran {
    public static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    static Display display;    //mThing - объект display
    static Manager manager;    //mThing - объект manager

    //static List<Client> clientsInWait=new ArrayList<>();
    public static void main(String[] args) throws IOException, InterruptedException {



/*

        List<Client> clients = Client.createNewClients(5);
        List<Table> tables =Table.createTables(5);
        display = new Display(clients,tables);
        Thread myThready = new Thread(display);    //Создание потока "myThready"
        myThready.setDaemon(true);
        myThready.start();                //Запуск потока

        manager = new Manager(clients,tables);
        Thread managerThread = new Thread(manager);    //Создание потока "myThready"
        managerThread.setDaemon(true);
        managerThread.start();                //Запуск потока

        consoleReader.readLine();
        */

    }

}
