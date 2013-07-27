package bowling.states;

public class FirstBall extends Ball {
	protected boolean rolled() {
		return true;
	}

	protected Transition transition(boolean allPins) {
		if(allPins) return Transition.STRIKE;
		return Transition.FIRST_ROLL;		
	}
}