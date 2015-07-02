package lifegame.impl;

import lifegame.Board;
import lifegame.Cell;
import lifegame.Drawer;
import lifegame.Mediator;

public abstract class AbstractBoard implements Board, Mediator {
    final private Cell[][] cells;
    final private int HEIGHT;
    final private int WIDTH;

    public AbstractBoard(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        cells = new Cell[HEIGHT][WIDTH];

        for (int yIndex = 0; yIndex < HEIGHT; yIndex++) {
            for (int xIndex = 0; xIndex < WIDTH; xIndex++) {
                cells[yIndex][xIndex] = new NormalCell(this, xIndex, yIndex);
                if(Math.random() * 100 < 35) cells[yIndex][xIndex].alive();
            }
        }
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

    @Override
    public void setNextCellState(Cell cell) {
        int neighborAliveCount = countAliveNeighbor(cell);
        if(neighborAliveCount == 2) cell.keep();
        else if(neighborAliveCount == 3) cell.alive();
        else cell.empty();
    }

    private int countAliveNeighbor(Cell cell) {

        int x = cell.getX();
        int y = cell.getY();

        int result = 0;

        for (int i = y-1; i <= y+1; i++) {
            for (int j = x-1; j <= x+1; j++) {
                if(i < 0 || j < 0 || i >= HEIGHT || j >= WIDTH || (i == y && j == x)) continue;
                if(cells[i][j].isAlive()) result++;
            }
        }

        return result;
    }

    abstract public Drawer getDraw();
}
