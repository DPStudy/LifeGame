package lifegame;

public interface Cell extends DrawUser {
    void next();
    void update();
    void alive();
}
