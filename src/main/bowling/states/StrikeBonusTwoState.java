package bowling.states;

class StrikeBonusTwoState extends AbstractState {
	public StrikeBonusTwoState(Transition transition) {
		super(transition);
	}

	protected Event event(boolean allPins) {
		return Event.STRIKE_BONUS_TWO;		
	}
}