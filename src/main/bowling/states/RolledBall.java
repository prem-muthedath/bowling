package bowling.states;

class RolledBall extends Ball {
	private Ball ball;

	public RolledBall(Ball ball) {
		this.ball=ball;
	}

	protected boolean rolled() {
		return true;
	}

	protected int pins(int pins) {
		return ball.pins(pins);
	}

	protected Transition transition(boolean allPins) {
		return ball.transition(allPins);
	}

	public int score(int pinfall) {
		return ball.score(pinfall);
	}
}