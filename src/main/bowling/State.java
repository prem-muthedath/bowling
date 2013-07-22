package bowling; 

public abstract class State {
	public void count(Frame frame, Play play, int pins) {
		frame.transition(play, pins(pins));
	}

	protected int pins(int pins) {
		return pins;
	}

	public State next(Play play, boolean allPins) {
		exit(play);
		return transition(play, allPins);
	}

	protected void exit(Play play) {}
	
	protected abstract State transition(Play play, boolean allPins);

	public void enter(Play play) {}

	protected void advance(Play play) {
		play.advance();
	}

	public int score(int pinfall) {
		return 0;
	}
}
