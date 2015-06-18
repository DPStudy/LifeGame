package lifegame;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Timer implements Runnable {
    private List<Observer> observers;
    private int delaySecond;

    void setDelaySecond(int delaySecond) {
        this.delaySecond = delaySecond;
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
