package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Creator: Pavlenko Bohdan
 * Date: 17.07.2017
 * Project: testRestoran
 */
public class Client {
    Integer waitTime;
    Integer eatTime;

    static final int WAIT_MIN = 5;
    static final int WAIT_MAX = 120;
    static final int EAT_MIN = 10;
    static final int EAT_MAX = 40;
    static Random gen = new Random();

    public Client() {
        this.waitTime = gen.nextInt(WAIT_MAX - WAIT_MIN) + WAIT_MIN;
        this.eatTime = gen.nextInt(EAT_MAX - EAT_MIN) + EAT_MIN;
    }

    @Override
    public String toString() {
        return "Client{" +
                "waitTime=" + waitTime +
                ", eatTime=" + eatTime +
                '}';
    }

    public static Client createNewClient() {
        return new Client();
    }

    public static List<Client> createNewClients(int count) {
        List<Client> retList = new ArrayList<>(count);
        for (int counter = 0; counter < count; counter++) {
            retList.add(createNewClient());
        }
        return retList;
    }

}
