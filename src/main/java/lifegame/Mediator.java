package lifegame;

public interface Mediator {
    void setNextCellState(Cell cell);
    void registerCell(int x, int y, Cell cell);
}
