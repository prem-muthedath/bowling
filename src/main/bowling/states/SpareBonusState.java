package bowling.states;

import bowling.Bowling;
import bowling.State;

public class SpareBonusState extends State {
	public SpareBonusState(Bowling game) {
		super(game);
	}

	public State next(boolean allPins) {
		return Transition.SPARE_BONUS.next(this, game());
	}

	protected void advance() {}	
}