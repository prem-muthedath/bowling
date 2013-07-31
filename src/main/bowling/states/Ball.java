package bowling.states; 

import bowling.core.Frame;
import bowling.core.Count;
import bowling.core.State;

abstract class Ball implements State {
	public boolean roll(Frame frame, Count count) {
		frame.transition(count(count));
		return rolled();
	}

	protected Count count(Count count) {
		return count;
	}	

	protected boolean rolled() {
		return false;
	}
	
	public State next(boolean allPins) {
		return transition(allPins).next(this);
	}

	protected abstract Transition transition(boolean allPins);

	public boolean score() {
		return false;
	}
}