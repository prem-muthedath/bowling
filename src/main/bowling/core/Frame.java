package bowling.core;

public class Frame {	
	private Pinfall pinfall=new Pinfall(0);
	private State state;

	public Frame(State initialState) {
		state=initialState;
	}

	public boolean roll(Count count) {
		return state.roll(this, count);
	}

	public void transition(Count count) {
		pinfall=count.addTo(pinfall);
		state=pinfall.transition(state);		
	}

	public int score() {
		return pinfall.score(state);
	}		
}
