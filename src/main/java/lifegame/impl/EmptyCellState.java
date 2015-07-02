package lifegame.impl;

import lifegame.CellState;

public class EmptyCellState implements CellState {
    private static EmptyCellState ourInstance = new EmptyCellState();

    public static EmptyCellState getInstance() {
        return ourInstance;
    }

    private EmptyCellState() {}

    public CellState next() {
        return AliveCellState.getInstance();
    }
}
