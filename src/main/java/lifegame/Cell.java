package lifegame;

public interface Cell extends DrawUser {
    int getX();
    int getY();

    void next();
    void update();

    void alive();
    void empty();
    void keep();

    boolean isAlive();
}
