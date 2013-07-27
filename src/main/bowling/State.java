package bowling;

public interface State {
	public boolean roll(Frame frame, int pins);
	public State next(boolean allPins);
	public int score(int pinfall);
}