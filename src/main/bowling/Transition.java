package bowling;

import bowling.states.Event;

public abstract class Transition {
	private Bowling game;

	public Transition(Bowling game) {
		this.game=game;
	}

	public abstract State next(State source, Event event);

	protected void advance() {
		game.advance();
	}
}