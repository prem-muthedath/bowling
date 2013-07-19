package bowling.states;

import bowling.FrameContext;
import bowling.State;

public enum Transition {
	FIRST_ROLL, STRIKE, SPARE, OPEN, STRIKE_BONUS_ONE, STRIKE_BONUS_TWO, SPARE_BONUS, SCORED;

	public State next(State source, FrameContext context) {
		if(done()) return source;
		target().enter(context);
		return target();
	}

	private State target() {
		switch(this) {
			case FIRST_ROLL: return new SecondRollState();
			case STRIKE: return new StrikeBonusOneState();
			case SPARE: return new SpareBonusState();
			case OPEN: return new ScoredState();
			case STRIKE_BONUS_ONE: return new StrikeBonusTwoState();
			case STRIKE_BONUS_TWO: return new ScoredState();
			case SPARE_BONUS: return new ScoredState();
		}
		return null;
	}

	private boolean done() {
		return this==SCORED;
	}
}
