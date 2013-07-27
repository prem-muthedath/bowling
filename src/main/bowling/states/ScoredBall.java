package bowling.states;

class ScoredBall extends Ball {
	protected int pins(int pins) {
		return 0;
	}

	protected Transition transition(boolean allPins) {
		return Transition.SCORED;		
	}

	public int score(int pinfall) {
		return pinfall;
	}
}