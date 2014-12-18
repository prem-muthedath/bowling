package bowling.states;

import bowling.core.Ball;
import bowling.core.PinCount;

class RolledBall extends Ball {
	private Ball ball;

	RolledBall(Ball ball) {
		this.ball=ball;
	}

	protected boolean rolled() {
		return true;
	}

	public Ball next(PinCount pinCount) {
		return ball.next(pinCount);
	}
}