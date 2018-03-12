package ua.ho.godex.restoran.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Creator: Pavlenko Bohdan
 * Date: 17.07.2017
 * Project: testRestoran
 */
public class Client {
    private Integer waitTime;
    private Integer eatTime;
    private Integer id;

    static final int WAIT_MIN = 2;
    static final int WAIT_MAX = 15;
    static final int EAT_MIN = 4;
    static final int EAT_MAX = 30;
    static Random gen = new Random();
    boolean wait;

    static Integer addNewClient = 0;
    static Integer newID=1;

    public Client() {
        this.id=newID++;
        this.wait=true;
        this.waitTime = gen.nextInt(WAIT_MAX - WAIT_MIN) + WAIT_MIN;
        this.eatTime = gen.nextInt(EAT_MAX - EAT_MIN) + EAT_MIN;
        addNewClient = (gen.nextInt(WAIT_MAX - WAIT_MIN) + WAIT_MIN) / 2;
    }

    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", waitTime=" + waitTime +
                ", eatTime=" + eatTime +
                '}';
    }

    public static Client createNewClient() {
        return new Client();
    }

    public static List<Client> createNewClients(int count) {
        List<Client> retList = new CopyOnWriteArrayList<>();
        for (int counter = 0; counter < count; counter++) {
            retList.add(createNewClient());
        }
        return retList;
    }

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }

    public Integer getEatTime() {
        return eatTime;
    }

    public void setEatTime(Integer eatTime) {
        this.eatTime = eatTime;
    }
}
