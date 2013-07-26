package bowling.states;

class SecondRollState extends AbstractState {
	public SecondRollState(Transition transition) {
		super(transition);
	}

	protected Event event(boolean allPins) {
		if(allPins) return Event.SPARE;
		return Event.OPEN;		
	}
}