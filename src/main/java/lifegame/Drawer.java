package lifegame;

public interface Drawer {
    void drawBoard(int width, int height);
    void drawAliveCell(int x, int y);
    void drawEmptyCell(int x, int y);
}
