package bowling.core;

public class Pinfall {
	private int pins;

	public Pinfall(int pins) {
		this.pins=pins;
	}

	public Pinfall add(Pinfall pinfall) {
		int sum=pins+pinfall.pins;		
		if(pins < Bowling.PINS && sum > Bowling.PINS) throw new RuntimeException(message(sum));
		return new Pinfall(sum);
	}

	private String message(int sum) {
		return "INVALID ROLL: PINFALL "+sum+" CAN NOT EXCEED "+Bowling.PINS+" WHILE ROLLING";
	}

	public State transition(State state) {
		return state.next(allPins());
	}

	private boolean allPins() {
		return pins==Bowling.PINS;
	}

	public int score(State state) {
		if(state.score()) return pins;
		return 0;
	}	
}