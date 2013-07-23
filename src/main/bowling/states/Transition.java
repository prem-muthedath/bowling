package bowling.states;

import bowling.Bowling;
import bowling.State;

public enum Transition {
	FIRST_ROLL, STRIKE, SPARE, OPEN, STRIKE_BONUS_ONE, STRIKE_BONUS_TWO, SPARE_BONUS, SCORED;

	public State next(State source, Bowling game) {
		if(done()) return source;
		target(game).enter();
		return target(game);
	}

	private State target(Bowling game) {
		switch(this) {
			case FIRST_ROLL: return new SecondRollState(game);
			case STRIKE: return new StrikeBonusOneState(game);
			case SPARE: return new SpareBonusState(game);
			case OPEN: return new ScoredState(game);
			case STRIKE_BONUS_ONE: return new StrikeBonusTwoState(game);
			case STRIKE_BONUS_TWO: return new ScoredState(game);
			case SPARE_BONUS: return new ScoredState(game);
		}
		return null;
	}

	private boolean done() {
		return this==SCORED;
	}
}
