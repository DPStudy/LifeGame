package lifegame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Timer implements Runnable {
    private List<Observer> observers = new ArrayList<Observer>();
    private int delaySecond;

    public void setDelaySecond(int delaySecond) {
        this.delaySecond = delaySecond;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void run() {
        for (Observer observer : observers) {
            observer.tick();
            try {
                TimeUnit.SECONDS.sleep(delaySecond);
            } catch (InterruptedException e) {
                // TODO - 로그 출력방법
                e.printStackTrace();
            }
        }
    }
}
