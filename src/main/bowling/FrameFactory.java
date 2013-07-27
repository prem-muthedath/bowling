package bowling;

import bowling.states.FirstBall;

public class FrameFactory {
	public Frame create() {
		State state=new FirstBall();
		return new Frame(state);
	}
}