package bowling.core;

public abstract class Ball {
	public boolean roll(Frame frame, PinCount pinCount) {
		frame.transition(pinCount);
		return rolled();
	}

	protected boolean rolled() {
		return false;
	}

	public Ball next(PinCount pinCount) {
		return pinCount.nextBall(this);
	}

	protected Ball markSuccessor() {
		return nonMarkSuccessor();
	}

	protected Ball nonMarkSuccessor() {
		throw new RuntimeException("Undefined - nonMarkSuccessor()");
	}

	public int score(int pins) {
		return 0;
	}
}