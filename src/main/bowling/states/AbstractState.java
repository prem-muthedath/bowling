package bowling.states; 

import bowling.Frame;
import bowling.State;

public abstract class AbstractState implements State {
	private Transition transition;

	public AbstractState(Transition transition) {
		this.transition=transition;
	}

	public void count(Frame frame, int pins) {
		frame.transition(pins(pins));
	}

	protected int pins(int pins) {
		return pins;
	}	

	public State next(boolean allPins) {
		return transition.next(this, event(allPins));
	}

	protected abstract Event event(boolean allPins);

	public int score(int pinfall) {
		return 0;
	}
}