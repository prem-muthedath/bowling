package bowling.states;

class ScoredState extends AbstractState {
	public ScoredState(Transition transition) {
		super(transition);
	}

	protected int pins(int pins) {
		return 0;
	}

	protected Event event(boolean allPins) {
		return Event.SCORED;		
	}

	public int score(int pinfall) {
		return pinfall;
	}
}