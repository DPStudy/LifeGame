package lifegame;

import lifegame.impl.NormalBoard;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Board gameBoard = new NormalBoard(80, 18);
        Timer timer = new Timer(1);
        timer.registerObserver(gameBoard);

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(timer);
    }
}
