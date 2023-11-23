package ddr;

public interface ScreenObserver {
    public void transition(int mode);
    public void press(int col);
    public void miss();
    public void move();
    public void to_main();
    public void retry();
    public int rank();
}
