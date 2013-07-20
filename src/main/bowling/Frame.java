package bowling;

import bowling.states.FirstRollState;

public class Frame {
	private int pinfall=0;
	private State state;

	public Frame() {
		this.state=new FirstRollState();
	}

	public void count(GameState gameState, int pins) {
		state.count(new FrameContext(this, gameState), pins);
	}

	void transition(FrameContext context, int pins) {
		pinfall+=pins;	
		this.state=state.next(context, allPins());
	}

	private boolean allPins() {
		return Tenpin.ALL_PINS.equals(pinfall);
	}	

	public int score() {
		return state.score(pinfall);
	}		
}
