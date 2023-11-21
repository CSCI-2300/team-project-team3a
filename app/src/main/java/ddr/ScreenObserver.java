package ddr;

public interface ScreenObserver {
    public void transition();
    public void press(int col);
    public void miss();
    public void move();
}
