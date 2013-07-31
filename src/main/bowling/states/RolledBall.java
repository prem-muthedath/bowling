package bowling.states;

class RolledBall extends Ball {
	private Ball ball;

	public RolledBall(Ball ball) {
		this.ball=ball;
	}

	public boolean rolled() {
		return true;
	}

	protected Transition transition(boolean allPins) {
		return ball.transition(allPins);
	}
}