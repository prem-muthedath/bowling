package bowling.states;

import bowling.core.Pinfall;

class RolledBall extends Ball {
	private Ball ball;

	public RolledBall(Ball ball) {
		this.ball=ball;
	}

	public boolean rolled() {
		return true;
	}

	protected Transition transition(Pinfall pinfall) {
		return ball.transition(pinfall);
	}
}