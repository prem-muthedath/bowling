package bowling;

import bowling.states.Event;

public interface Transition {
	public State next(State source, Event event);
}