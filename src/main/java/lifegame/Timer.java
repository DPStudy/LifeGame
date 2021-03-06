package lifegame;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Timer implements Runnable {
    private final Set<Observer> observers = new HashSet<Observer>();
    private int delaySecond;

    public Timer(int delaySecond) {
        this.delaySecond = delaySecond;
    }

    public void setDelaySecond(int delaySecond) {
        this.delaySecond = delaySecond;
    }

    public void registerObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException();
        }

        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException();
        }

        observers.remove(observer);
    }

    public void run() {
        while (true) {
            for (Observer observer : observers) {
                observer.tick();
            }
            try {
                TimeUnit.SECONDS.sleep(delaySecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
