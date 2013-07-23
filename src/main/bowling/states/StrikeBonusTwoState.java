package bowling.states;

import bowling.Bowling;
import bowling.State;

public class StrikeBonusTwoState extends State {
	public StrikeBonusTwoState(Bowling game) {
		super(game);
	}

	public State next(boolean allPins) {
		return Transition.STRIKE_BONUS_TWO.next(this, game());
	}

	protected void advance() {}
}