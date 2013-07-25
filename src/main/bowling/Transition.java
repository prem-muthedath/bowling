package bowling;

public abstract class Transition {
	private Bowling game;
	public enum Event {
		FIRST_ROLL, 
		STRIKE, 
		SPARE, 
		OPEN, 
		STRIKE_BONUS_ONE, 
		STRIKE_BONUS_TWO, 
		SPARE_BONUS, 
		SCORED
	};

	public Transition(Bowling game) {
		this.game=game;
	}

	public abstract State next(State source, Event event);

	protected void advance() {
		game.advance();
	}
}