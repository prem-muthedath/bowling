package bowling;

import bowling.states.FirstRollState;

public class Turn {
	private int pinfall=0;
	private State state;

	public Turn() {
		this.state=new FirstRollState();
	}

	public void count(Frame frame, int pins) {
		state.count(frame, pins);
	}

	void transition(Frame frame, int pins) {
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
