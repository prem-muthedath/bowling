package bowling.states;

import bowling.core.Count;

class RolledBall extends Ball {
	private Ball ball;

	public RolledBall(Ball ball) {
		this.ball=ball;
	}

	public boolean rolled() {
		return true;
	}

	protected Count count(Count count) {
		return ball.count(count);
	}

	protected Transition transition(boolean allPins) {
		return ball.transition(allPins);
	}

	public boolean score() {
		return ball.score();
	}
}