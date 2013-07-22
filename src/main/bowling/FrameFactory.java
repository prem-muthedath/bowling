package bowling;

import bowling.states.FirstRollState;

public class FrameFactory {
	public static Frame create(Bowling game, int currentFrame) {
		Play play=new Play(game, currentFrame);
		FirstRollState state=new FirstRollState(play);
		return new Frame(state);
	}
}