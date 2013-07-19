package bowling;

public class RollContextFactory {
	private Bowling game;

	public RollContextFactory(Bowling game) {
		this.game=game;
	}

	public RollContext create(int frameIndex, Frame frame) {
		FrameContext frameContext=new FrameContext(game, frameIndex);
		return new RollContext(frame, frameContext);
	}
}