package bowling.core;

public class Frame {	
	private Pinfall pinfall=new Pinfall(0);
	private State state;

	public Frame(State initialState) {
		state=initialState;
	}

	public boolean roll(Pinfall count) {
		return state.roll(this, count);
	}

	public void transition(Pinfall count) {
		pinfall=pinfall.add(count);
		state=state.next(pinfall);		
	}

	public int score() {
		return state.score(pinfall);
	}		
}
