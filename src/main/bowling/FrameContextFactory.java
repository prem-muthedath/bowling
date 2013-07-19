package bowling;

public class FrameContextFactory {
	private Bowling game;

	public FrameContextFactory(Bowling game) {
		this.game=game;
	}

	public FrameContext create(int frameIndex, Frame frame) {
		RollContext context=new RollContext(game, frameNumer(frameIndex));
		return new FrameContext(frame, context);
	}

	private int frameNumer(int frameIndex) {
		return frameIndex+1;
	}
}