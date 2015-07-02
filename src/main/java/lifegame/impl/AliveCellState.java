package lifegame.impl;

import lifegame.CellState;

public class AliveCellState implements CellState{
    private static AliveCellState ourInstance = new AliveCellState();

    public static AliveCellState getInstance() {
        return ourInstance;
    }

    private AliveCellState() {}

    public CellState next() {
        return EmptyCellState.getInstance();
    }
}
