package lifegame.impl;

import lifegame.Cell;
import lifegame.CellState;
import lifegame.Drawer;

public class NormalCell implements Cell {
    private CellMediator cellMediator;
    private CellState cellState;
    private CellState nextState;
    private int x;
    private int y;

    public NormalCell(int x, int y) {
        this.x = x;
        this.y = y;
        cellState = EmptyCellState.getInstance();
        cellMediator = CellMediator.getInstance();
        cellMediator.addCell(x, y, this);
    }

    @Override
    public void next() {
        int neighborCount = cellMediator.countNeighbor(this);
        if (neighborCount >= 3) {
            nextState = AliveCellState.getInstance();
        } else {
            nextState = EmptyCellState.getInstance();
        }
    }

    @Override
    public void update() {
        cellState = nextState;
    }

    @Override
    public void alive() {
        cellState = AliveCellState.getInstance();
    }

    @Override
    public boolean isAlive() {
        return cellState == AliveCellState.getInstance();
    }

    @Override
    public void draw(Drawer drawer) {
        if (cellState == EmptyCellState.getInstance()) {
            drawer.drawEmptyCell(x, y);
        } else if (cellState == AliveCellState.getInstance()){
            drawer.drawAliveCell(x, y);
        }
    }
}
