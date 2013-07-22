package bowling;

import bowling.states.FirstRollState;

public class Frame {
	private int pinfall=0;
	private State state;

	public Frame() {
		this.state=new FirstRollState();
	}

	public void count(Play play, int pins) {
		state.count(this, play, pins);
	}

	void transition(Play play, int pins) {
		pinfall+=pins;	
		this.state=state.next(play, allPins());
	}

	private boolean allPins() {
		return Tenpin.ALL_PINS.equals(pinfall);
	}	

	public int score() {
		return state.score(pinfall);
	}		
}
