package bowling.core;

public class FrameCount {
	private int frames;

	public FrameCount(int frames) {
		this.frames=frames;
	}

	public Score score(Bowling game) {
		return game.score(validFrames());
	}

	private int validFrames() {
		return  frames < 1   ?   0  :  Math.min(frames, Bowling.FRAMES);
	}
}