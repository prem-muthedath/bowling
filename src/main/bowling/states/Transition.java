package bowling.states;

enum Transition {
	FIRST_ROLL, STRIKE, SPARE, OPEN, STRIKE_BONUS_ONE, STRIKE_BONUS_TWO, SPARE_BONUS, SCORED;

	public Ball next(Ball source) {
		switch(this) {
			case SCORED: return source;
			case FIRST_ROLL: return secondBall();
			case STRIKE: return firstStrikeBonusBall();
			case SPARE: return spareBonusBall();
			case OPEN: return scoredBall();
			case STRIKE_BONUS_ONE: return secondStrikeBonusBall();
			case STRIKE_BONUS_TWO: return scoredBall();
			case SPARE_BONUS: return scoredBall();
		}
		return null;
	}

	private Ball secondBall() {
		return new TransitionalBalls().secondBall();
	}

	private Ball firstStrikeBonusBall() {
		return new TransitionalBalls().firstStrikeBonusBall();
	}

	private Ball secondStrikeBonusBall() {
		return new TransitionalBalls().secondStrikeBonusBall();
	}

	private Ball spareBonusBall() {
		return new TransitionalBalls().spareBonusBall();
	}

	private Ball scoredBall() {
		return new ScoredBall();
	}	
}