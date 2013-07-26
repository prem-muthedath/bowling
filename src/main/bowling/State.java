package bowling;

public interface State {
	public void count(Frame frame, int pins);
	public State next(boolean allPins);
	public int score(int pinfall);
}