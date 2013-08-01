package bowling.states;

import bowling.core.Pinfall;

class ScoredBall extends Ball {
	protected Pinfall count(Pinfall count) {
		return new Pinfall(0);
	}

	protected Transition transition(Pinfall pinfall) {
		return Transition.SCORED;		
	}

	public int score(Pinfall pinfall) {
		return pinfall.score();
	}
}