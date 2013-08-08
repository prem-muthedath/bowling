package bowling.core; 

public abstract class Ball {
	public boolean roll(Frame frame, int pinCount) {
		frame.transition(adjust(pinCount));
		return rolled();
	}

	protected int adjust(int pinCount) {
		return pinCount;
	}	

	protected boolean rolled() {
		return false;
	}
	
	public Ball markSuccessor() {
		return nonMarkSuccessor();
	}	

	public abstract Ball nonMarkSuccessor();

	public void score(Score score, int pinCount) {}
}