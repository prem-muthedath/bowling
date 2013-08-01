package bowling.states; 

import bowling.core.State;
import bowling.core.Frame;
import bowling.core.Pinfall;

abstract class Ball implements State {
	public boolean roll(Frame frame, Pinfall count) {
		frame.transition(count(count));
		return rolled();
	}

	protected Pinfall count(Pinfall count) {
		return count;
	}	

	protected boolean rolled() {
		return false;
	}
	
	public State next(Pinfall pinfall) {
		return transition(pinfall).next(this);
	}

	protected abstract Transition transition(Pinfall pinfall);

	public int score(Pinfall pinfall) {
		return 0;
	}
}