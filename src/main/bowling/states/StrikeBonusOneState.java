package bowling.states;

import bowling.Bowling;
import bowling.State;

public class StrikeBonusOneState extends State {
	public StrikeBonusOneState(Bowling game) {
		super(game);
	}

	public State next(boolean allPins) {
		return Transition.STRIKE_BONUS_ONE.next(this, game());
	}

	public void enter() {
		advance();
	}
}