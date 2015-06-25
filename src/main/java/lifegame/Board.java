package lifegame;

public interface Board extends Observer, DrawUser{
    public void addCell(int x, int y);
}
