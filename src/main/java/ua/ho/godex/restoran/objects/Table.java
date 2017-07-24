package ua.ho.godex.restoran.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 17.07.2017
 * Project: testRestoran
 */
public class Table {
    static int number = 1;
    private int tNumber;
    private Client client;

    public Table() {
        this.tNumber = number++;
    }

    public boolean isAvailable() {
        return this.client == null;
    }

    public static List<Table> createTables(int count) {
        List<Table> retList = new ArrayList<>(count);
        for (int counter = 0; counter < count; counter++) {
            retList.add(new Table());
        }
        return retList;
    }

    public void sitClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        String ret = "Table(" + tNumber + ")=";
        ret += isAvailable() ? "available" : "not available"+client.toString();
        return ret;
    }

    public void freeTable() {
        this.client = null;
    }

    public Client getClient() {
        return client;
    }
}
