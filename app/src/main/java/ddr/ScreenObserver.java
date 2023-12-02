package ddr;

public interface ScreenObserver {
    public void transition(int mode);
    public void press();
    public void miss();
    public void to_main();
    public void retry();
    public int rank();
    public void startGame();
    public void endGame();
}
