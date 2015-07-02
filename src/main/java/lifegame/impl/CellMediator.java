package lifegame.impl;

import lifegame.Cell;
import lifegame.Position;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CellMediator {
    private static CellMediator ourInstance = new CellMediator();

    public static CellMediator getInstance() {
        return ourInstance;
    }

    private CellMediator() {
        this.positionToCell = new HashMap<Position, Cell>();
        this.cellToPosition = new HashMap<Cell, Position>();
    }

    private Map<Position, Cell> positionToCell;
    private Map<Cell, Position> cellToPosition;

    public int countNeighbor(Cell cell) {
        Position position = cellToPosition.get(cell);
        int aliveCount = 0;
        int x = position.getX();
        int y = position.getY();

        // 주변이 셀을 조회한다(주변의 셀은 기존위치에서 가로 세로 좌표 -1에서 +1 내의 값이다.
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != j) {
                    Position nearPosition = new Position(x + i, y + j);
                    if (positionToCell.containsKey(nearPosition) && positionToCell.get(nearPosition).isAlive())
                        aliveCount++;
                }
            }
        }
        return aliveCount;
    }

    public void addCell(int x, int y, Cell cell) {
        positionToCell.put(new Position(x, y), cell);
    }

    public static void main(String[] args) {
        Position position = new Position(1, 1);
        Set<Position> set = new HashSet<Position>();
        set.add(position);
        Position position2 = new Position(1, 1);
        if (set.contains(position2)) {
            System.out.println("contain");
        } else {
            System.out.println("not contain");
        }

    }
}
