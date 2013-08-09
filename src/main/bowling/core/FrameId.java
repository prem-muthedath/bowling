package bowling.core;

public class FrameId {
	private int frame;

	public FrameId(int frame) {
		this.frame=frame;
	}

	public Score score(Bowling game) {
		return game.score(validFrame());
	}

	private int validFrame() {
		return  frame < 1   ?   0  :  Math.min(frame, Bowling.FRAMES);
	}
}