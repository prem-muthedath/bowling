package bowling; 

public abstract class State {
	public void count(AdvancingFrame frame, int pins) {
		frame.transition(pins);
	}

	public State next(AdvancingFrame frame, boolean allPins) {
		exit(frame);
		return transition(frame, allPins);
	}

	protected void exit(AdvancingFrame frame) {}
	
	protected abstract State transition(AdvancingFrame frame, boolean allPins);

	public void enter(AdvancingFrame frame) {}

	protected void advance(AdvancingFrame frame) {
		frame.advance();
	}

	public int score(int pinfall) {
		return 0;
	}
}
