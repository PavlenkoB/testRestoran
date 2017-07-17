package ua.ho.godex.restoran.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 17.07.2017
 * Project: testRestoran
 */
public class Table {
    static int number=1;
    private  int tNumber;
    private boolean available;
    private Client client;

    public Table() {
        this.available =true;
        this.tNumber=number++;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static List<Table> createTables(int count){
        List<Table> retList = new ArrayList<>(count);
        for (int counter = 0; counter < count; counter++) {
            retList.add(new Table());
        }
        return retList;
    }

    @Override
    public String toString() {
        String ret="Table("+tNumber+")=";
        ret += available ? "available" : "not available";
        return ret;
    }
}
