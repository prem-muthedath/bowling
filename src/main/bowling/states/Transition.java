package bowling.states;

enum Transition {
	FIRST_ROLL, STRIKE, SPARE, OPEN, STRIKE_BONUS_ONE, STRIKE_BONUS_TWO, SPARE_BONUS, SCORED;

	public Ball next(Ball source) {
		switch(this) {
			case SCORED: return source;
			case FIRST_ROLL: return secondBall();
			case STRIKE: return strikeBonusOneBall();
			case SPARE: return spareBonusBall();
			case OPEN: return scoredBall();
			case STRIKE_BONUS_ONE: return strikeBonusTwoBall();
			case STRIKE_BONUS_TWO: return scoredBall();
			case SPARE_BONUS: return scoredBall();
		}
		return null;
	}

	private Ball secondBall() {
		return new IntermediateBalls().secondBall();
	}

	private Ball strikeBonusOneBall() {
		return new IntermediateBalls().strikeBonusOneBall();
	}

	private Ball strikeBonusTwoBall() {
		return new IntermediateBalls().strikeBonusTwoBall();
	}

	private Ball spareBonusBall() {
		return new IntermediateBalls().spareBonusBall();
	}

	private Ball scoredBall() {
		return new ScoredBall();
	}	
}