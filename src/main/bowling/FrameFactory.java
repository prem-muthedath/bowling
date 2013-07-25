package bowling;

import bowling.states.StateTransition;
import bowling.states.FirstRollState;

public class FrameFactory {
	public static Frame create(Bowling game) {
		StateTransition transition=new StateTransition(game);
		FirstRollState state=new FirstRollState(transition);
		return new Frame(state);
	}
}