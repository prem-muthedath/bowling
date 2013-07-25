package bowling; 

import bowling.states.Event;

public abstract class State {
	private Transition transition;

	public State(Transition transition) {
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