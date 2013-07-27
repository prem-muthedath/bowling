package bowling;

public class Frame {	
	private int pinfall=0;
	private State state;

	public Frame(State initialState) {
		this.state=initialState;
	}

	public boolean roll(int pins) {
		return state.roll(this, pins);
	}

	public void transition(int pins) {
		pinfall+=pins;	
		this.state=state.next(allPins());
	}

	private boolean allPins() {
		return Tenpin.ALL_PINS.equals(pinfall);
	}	

	public int score() {
		return state.score(pinfall);
	}		
}
