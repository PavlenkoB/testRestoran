package learn;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 19.07.2017
 * Project: testRestoran
 */
class Incremenator extends Thread {
    private volatile boolean mIsIncrement = true;

    public void changeAction()    //Меняет действие на противоположное
    {
        mIsIncrement = !mIsIncrement;
    }

    @Override
    public void run() {
        do {
            if (!Thread.interrupted())    //Проверка прерывания
            {
                if (mIsIncrement) Program.mValue++;    //Инкремент
                else Program.mValue--;            //Декремент

                //Вывод текущего значения переменной
                System.out.print(Program.mValue + " ");
            } else
                return;        //Завершение потока

            try {
                Thread.sleep(1000);        //Приостановка потока на 1 сек.
            } catch (InterruptedException e) {
                return;    //Завершение потока после прерывания
            }
        }
        while (true);
    }
}

class ShowMassage extends Thread {
    volatile List<String> msgQueue = new ArrayList<>();

    int inc=0;
    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {
                while (!hasMessages()){
                    Thread.yield();
                    inc++;
                }
                showMassage();
            } else {
                return;
            }
        } while (true);
    }

    boolean hasMessages() {
        return msgQueue.size() > 0;
    }

    void showMassage() {
        System.out.println(inc+"="+msgQueue.remove(0));
        inc=0;
    }

    public void addMessage(String string) {
        msgQueue.add(string);
    }
}

class Program {
    //Переменая, которой оперирует инкременатор
    public static int mValue = 0;

    static ShowMassage mSM;    //Объект побочного потока

    public static void main(String[] args) {

        mSM = new ShowMassage();    //Создание потока

        mSM.start();    //Запуск потока


        System.out.println("Start main");
        //Троекратное изменение действия инкременатора
        //с интервалом в i*2 секунд
        for (int i = 1; i <= 6; i++) {
            try {
                mSM.addMessage("increment =" + i++);
                mSM.addMessage("increment =" + i);
                System.out.println("some text");
                Thread.sleep(1000);        //Ожидание в течении i*2 сек.
            } catch (InterruptedException e) {
            }
        }
        mSM.interrupt();
        System.out.println("end main");
    }
}
