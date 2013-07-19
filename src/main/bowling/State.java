package bowling; 

public abstract class State {
	public void count(FrameContext context, int pins) {
		context.transition(pins);
	}

	public State next(FrameContext context, boolean allPins) {
		exit(context);
		return transition(context, allPins);
	}
	
	protected abstract State transition(FrameContext context, boolean allPins);

	protected void exit(FrameContext context) {}
	public void enter(FrameContext context) {}

	protected void advance(FrameContext context) {
		context.advance();
	}

	public int score(int pinfall) {
		return 0;
	}
}
