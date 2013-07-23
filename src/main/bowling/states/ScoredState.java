package bowling.states;

import bowling.Bowling;
import bowling.State;

public class ScoredState extends State {
	public ScoredState(Bowling game) {
		super(game);
	}

	protected int pins(int pins) {
		return 0;
	}

	public State next(boolean allPins) {
		return Transition.SCORED.next(this, game());			
	}

	public int score(int pinfall) {
		return pinfall;
	}

	protected void advance() {}	
}