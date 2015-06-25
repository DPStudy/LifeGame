package lifegame.impl;

import lifegame.Drawer;

public class NormalBoard extends AbstractBoard {
    private Drawer drawer = new ConsoleDrawer();

    public NormalBoard(int x, int y) {
        super(x, y);
    }

    @Override
    public Drawer getDraw() {
        return drawer;
    }
}
