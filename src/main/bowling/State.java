package bowling; 

public abstract class State {
	private Bowling game;

	public State(Bowling game) {
		this.game=game;
	}

	public void count(Frame frame, int pins) {
		frame.transition(pins(pins));
	}

	protected int pins(int pins) {
		return pins;
	}	

	public abstract State next(boolean allPins);

	protected void advance() {
		game.advance();
	}	

	public void enter() {}

	public int score(int pinfall) {
		return 0;
	}

	protected Bowling game() {
		return game;
	}
}
