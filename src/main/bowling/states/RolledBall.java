package bowling.states;

import bowling.core.Ball;

class RolledBall extends Ball {
	private Ball ball;

	public RolledBall(Ball ball) {
		this.ball=ball;
	}

	protected boolean rolled() {
		return true;
	}

	public Ball markSuccessor() {
		return ball.markSuccessor();
	}
	
	public Ball nonMarkSuccessor() {
		return ball.nonMarkSuccessor();		
	}
}