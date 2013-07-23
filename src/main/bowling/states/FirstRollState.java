package bowling.states;

import bowling.Bowling;
import bowling.State;

public class FirstRollState extends State {
	public FirstRollState(Bowling game) {
		super(game);
	}

	public State next(boolean allPins) {
		if(allPins) return Transition.STRIKE.next(this, game());
		return Transition.FIRST_ROLL.next(this, game());
	}

	protected void advance() {}	
}