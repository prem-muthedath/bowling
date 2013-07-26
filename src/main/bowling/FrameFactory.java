package bowling;

import bowling.states.FirstRollState;
import bowling.states.Transition;

class FrameFactory {
	public static Frame create(Bowling game) {
		Transition transition=new Transition(game);
		State state=new FirstRollState(transition);
		return new Frame(state);
	}
}