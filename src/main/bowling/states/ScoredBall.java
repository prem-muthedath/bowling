package bowling.states;

import bowling.core.Count;

class ScoredBall extends Ball {
	protected Count count(Count count) {
		return new Count(0);
	}

	protected Transition transition(boolean allPins) {
		return Transition.SCORED;		
	}

	public boolean score() {
		return true;
	}
}