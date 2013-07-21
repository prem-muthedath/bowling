package bowling;

import bowling.states.FirstRollState;

public class Frame {
	private int pinfall=0;
	private State state;

	public Frame() {
		this.state=new FirstRollState();
	}

	public void count(int pins, Play play) {
		state.count(new AdvancingFrame(this, play), pins);
	}

	void transition(AdvancingFrame frame, int pins) {
		pinfall+=pins;	
		this.state=state.next(frame, allPins());
	}

	private boolean allPins() {
		return Tenpin.ALL_PINS.equals(pinfall);
	}	

	public int score() {
		return state.score(pinfall);
	}		
}
