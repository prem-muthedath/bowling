package bowling;

import bowling.states.FirstRollState;

public class FrameFactory {
	public static Frame create(Bowling game) {
		FirstRollState state=new FirstRollState(game);
		return new Frame(state);
	}
}