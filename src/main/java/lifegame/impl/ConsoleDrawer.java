package lifegame.impl;

import lifegame.Drawer;

public class ConsoleDrawer implements Drawer{

    @Override
    public void drawBoard(int width, int height) {
        // Do nohting!
        // Console에서는 board를 그릴 경우 cell을 표현할 공간이 적어짐 (...)
    }

    // java에서 console에 특정 위치를 지정하여 출력하는 표준화된 방법이 없어서 (...)
    // drawAliveCell와 darwEmptyCell은 순서에 맞추어 출력이 된다고 가정을 합니다.
    @Override
    public void drawAliveCell(int x, int y) {
        drawNewline(y);
        System.out.print('X');
    }

    @Override
    public void drawEmptyCell(int x, int y) {
        drawNewline(y);
        System.out.print('_');
    }

    int prevDrawy = -1;
    private void drawNewline(int y) {
        if(prevDrawy != y) {
            if(y == 0) System.out.println();
            System.out.println();
            prevDrawy = y;
        }
    }
}

