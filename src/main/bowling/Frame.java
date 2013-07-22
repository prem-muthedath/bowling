package bowling;

public class Frame {	
	private int pinfall=0;
	private State state;

	public Frame(State state) {
		this.state=state;
	}

	public void count(int pins) {
		state.count(this, pins);
	}

	void transition(int pins) {
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
