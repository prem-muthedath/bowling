package bowling; 

public abstract class State {
	public void count(Frame frame, int pins) {
		frame.transition(pins);
	}

	public State next(Frame frame, boolean allPins) {
		exit(frame);
		return transition(frame, allPins);
	}
	
	protected abstract State transition(Frame frame, boolean allPins);

	protected void exit(Frame frame) {}
	public void enter(Frame frame) {}

	protected void advance(Frame frame) {
		frame.advance();
	}

	public int score(int pinfall) {
		return 0;
	}
}
