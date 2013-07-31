package bowling.core;

public interface State {
	public boolean roll(Frame frame, Count count);
	public State next(boolean allPins);
	public boolean score();
}