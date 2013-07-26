package bowling.states;

class StrikeBonusOneState extends AbstractState {
	public StrikeBonusOneState(Transition transition) {
		super(transition);
	}

	protected Event event(boolean allPins) {
		return Event.STRIKE_BONUS_ONE;		
	}
}