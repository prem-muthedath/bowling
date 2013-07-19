package bowling; 

public abstract class State {
	public void count(RollContext context, int pins) {
		context.transition(pins);
	}

	public State next(RollContext context, boolean allPins) {
		exit(context);
		return transition(context, allPins);
	}
	
	protected abstract State transition(RollContext context, boolean allPins);

	protected void exit(RollContext context) {}
	public void enter(RollContext context) {}

	protected void advance(RollContext context) {
		context.advance();
	}

	public int score(int pinfall) {
		return 0;
	}
}
