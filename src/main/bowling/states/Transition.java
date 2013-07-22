package bowling.states;

import bowling.Play;
import bowling.State;

public enum Transition {
	FIRST_ROLL, STRIKE, SPARE, OPEN, STRIKE_BONUS_ONE, STRIKE_BONUS_TWO, SPARE_BONUS, SCORED;

	public State next(State source, Play play) {
		if(done()) return source;
		target(play).enter();
		return target(play);
	}

	private State target(Play play) {
		switch(this) {
			case FIRST_ROLL: return new SecondRollState(play);
			case STRIKE: return new StrikeBonusOneState(play);
			case SPARE: return new SpareBonusState(play);
			case OPEN: return new ScoredState(play);
			case STRIKE_BONUS_ONE: return new StrikeBonusTwoState(play);
			case STRIKE_BONUS_TWO: return new ScoredState(play);
			case SPARE_BONUS: return new ScoredState(play);
		}
		return null;
	}

	private boolean done() {
		return this==SCORED;
	}
}
