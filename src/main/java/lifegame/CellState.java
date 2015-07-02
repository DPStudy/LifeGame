package lifegame;

public enum CellState {
    ALIVE {
        @Override
        public void draw(Drawer drawer, Cell cell) {
            drawer.drawAliveCell(cell.getX(), cell.getY());
        }
    }, EMPTY {
        @Override
        public void draw(Drawer drawer, Cell cell) {
            drawer.drawEmptyCell(cell.getX(), cell.getY());
        }
    };


    public abstract void draw(Drawer drawer, Cell cell);
}
