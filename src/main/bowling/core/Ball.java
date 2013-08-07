package bowling.core; 

public abstract class Ball {
	public boolean roll(Frame frame, PinCount pinCount) {
		frame.transition(adjust(pinCount));
		return rolled();
	}

	protected PinCount adjust(PinCount count) {
		return count;
	}	

	protected boolean rolled() {
		return false;
	}
	
	public Ball next(PinCount pinCount) {
		return pinCount.next(this);
	}

	protected Ball markSuccessor() {
		return nonMarkSuccessor();
	}	

	protected abstract Ball nonMarkSuccessor();

	public void score(Score score, PinCount pinCount) {}
}