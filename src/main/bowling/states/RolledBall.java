package bowling.states;

import bowling.core.PinCount;
import bowling.core.Ball;

class RolledBall extends Ball {
	private Ball ball;

	public RolledBall(Ball ball) {
		this.ball=ball;
	}

	protected boolean rolled() {
		return true;
	}
	
	public Ball next(PinCount pinCount) {
		return ball.next(pinCount);
	}	

	protected Ball nonMarkSuccessor() {
		throw new RuntimeException("Undefined method for Rolled Ball");
	}
}