package lifegame.impl;

import lifegame.Board;
import lifegame.Cell;
import lifegame.Drawer;

public abstract class AbstractBoard implements Board {
    private Cell[][] cells;
    final private int HEIGHT;
    final private int WIDTH;

    public AbstractBoard(int x, int y) {
        WIDTH = x;
        HEIGHT = y;
        cells = new Cell[HEIGHT][WIDTH];
    }

    @Override
    public void addCell(int x, int y) {
        if(y < 0 || y >= cells.length) return;
        if(x < 0 || x >= cells[y].length) return;

        cells[y][x].alive();
    }

    @Override
    public void draw(Drawer drawer) {
        drawer.drawBoard(HEIGHT, WIDTH);
        for(Cell[] cellRow : cells) {
            for(Cell cell : cellRow) {
                cell.draw(drawer);
            }
        }
    }

    @Override
    public void tick() {
        for(Cell[] cellRow : cells) {
            for(Cell cell : cellRow) {
                cell.next();
            }
        }
        for(Cell[] cellRow : cells) {
            for(Cell cell : cellRow) {
                cell.update();
            }
        }
        this.draw(getDraw());
    }

    abstract public Drawer getDraw();
}
