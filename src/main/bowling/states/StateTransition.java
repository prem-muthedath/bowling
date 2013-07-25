package bowling.states;

import bowling.Bowling;
import bowling.State;
import bowling.Transition;

public class StateTransition implements Transition {
	private Bowling game;

	public StateTransition(Bowling game) {
		this.game=game;
	}

	public State next(State source, Transition.Event event) {
		switch(event) {
			case SCORED: return source;
			case FIRST_ROLL: return new SecondRollState(this);
			case STRIKE: return advance(new StrikeBonusOneState(this));
			case SPARE: return advance(new SpareBonusState(this));
			case OPEN: return advance(new ScoredState(this));
			case STRIKE_BONUS_ONE: return new StrikeBonusTwoState(this);
			case STRIKE_BONUS_TWO: return new ScoredState(this);
			case SPARE_BONUS: return new ScoredState(this);
		}
		return null;
	}

	private State advance(State target) {
		game.advance();
		return target;
	}
}