package bowling.states; 

import bowling.Frame;
import bowling.State;

abstract class Ball implements State {
	public boolean roll(Frame frame, int pins) {
		frame.transition(pins(pins));
		return rolled();
	}

	protected int pins(int pins) {
		return pins;
	}	

	protected boolean rolled() {
		return false;
	}

	public State next(boolean allPins) {
		return transition(allPins).next(this);
	}

	protected abstract Transition transition(boolean allPins);

	public int score(int pinfall) {
		return 0;
	}
}