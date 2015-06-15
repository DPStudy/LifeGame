package lifegame.impl;

import lifegame.CellState;

public class EmptyCellState implements CellState {
    public CellState next() {
        return null;
    }
}
