package lifegame.impl;

import lifegame.Cell;
import lifegame.CellState;
import lifegame.Drawer;
import lifegame.Mediator;

public class NormalCell implements Cell {
    private CellState cellState;
    private CellState nextState;
    private final int x;
    private final int y;
    private final Mediator mediator;

    public NormalCell(Mediator mediator, int x, int y) {
        this.x = x;
        this.y = y;

        this.mediator = mediator;
        cellState = CellState.EMPTY;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void next() {
        mediator.setNextCellState(this);
    }

    @Override
    public void update() {
        cellState = nextState;
    }

    @Override
    public void alive() {
        cellState = CellState.ALIVE;
    }

    @Override
    public void empty() {
        nextState = CellState.EMPTY;
    }

    @Override
    public void keep() {
        nextState = cellState;
    }

    @Override
    public boolean isAlive() {
        return cellState == CellState.ALIVE;
    }

    @Override
    public void draw(Drawer drawer) {
        cellState.draw(drawer, this);
    }
}
