package bowling; 

public abstract class State {
	private Play play;

	public State(Play play) {
		this.play=play;
	}

	public void count(Frame frame, int pins) {
		frame.transition(pins(pins));
	}

	protected int pins(int pins) {
		return pins;
	}

	public abstract State next(boolean allPins);
	
	public void enter() {}

	protected void advance() {
		play.advance();
	}

	public int score(int pinfall) {
		return 0;
	}

	protected Play play() {
		return play;
	}	
}
