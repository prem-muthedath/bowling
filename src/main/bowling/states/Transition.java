package bowling.states;

import bowling.Bowling;

public class Transition {
	private Bowling game;

	public Transition(Bowling game) {
		this.game=game;
	}

	public AbstractState next(AbstractState source, Event event) {
		switch(event) {
			case SCORED: return source;
			case FIRST_ROLL: return new SecondRollState(this);
			case STRIKE: return advance(new StrikeBonusOneState(this));
			case SPARE: return advance(new SpareBonusState(this));
			case OPEN: return advance(new ScoredState(this));
			case STRIKE_BONUS_ONE: return new StrikeBonusTwoState(this);
			case STRIKE_BONUS_TWO: return new ScoredState(this);
			case SPARE_BONUS: return new ScoredState(this);
		}
		return null;
	}

	private AbstractState advance(AbstractState target) {
		game.advance();
		return target;
	}
}