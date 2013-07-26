package bowling.states;

public class FirstRollState extends AbstractState {
	public FirstRollState(Transition transition) {
		super(transition);
	}

	protected Event event(boolean allPins) {
		if(allPins) return Event.STRIKE;
		return Event.FIRST_ROLL;		
	}
}