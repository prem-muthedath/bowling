package bowling;

public class FrameContextFactory {
	private Bowling game;

	public FrameContextFactory(Bowling game) {
		this.game=game;
	}

	public FrameContext create(int frameIndex, Frame frame) {
		GameContext context=new GameContext(game, frame(frameIndex));
		return new FrameContext(frame, context);
	}

	private int frame(int frameIndex) {
		return frameIndex+1;
	}
}