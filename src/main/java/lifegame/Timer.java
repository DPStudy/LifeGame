package lifegame;

import java.util.List;

public class Timer {
    private List<Observer> observers;

    void setDelaySecond(int second) {

    }

    void run() {
        for(Observer observer : observers) {
            observer.tick();
        }
    }
}
