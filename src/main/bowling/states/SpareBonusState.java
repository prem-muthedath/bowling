package bowling.states;

class SpareBonusState extends AbstractState {
	public SpareBonusState(Transition transition) {
		super(transition);
	}

	protected Event event(boolean allPins) {
		return Event.SPARE_BONUS;		
	}
}