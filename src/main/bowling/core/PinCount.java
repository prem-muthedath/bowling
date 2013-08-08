package bowling.core;

public class PinCount {
	private int pins;

	public PinCount(int pins) {
		set(pins, maxPins());
	}

	private void set(int pins, int maxPins) {
		if(pins < 0 || pins > maxPins) 
			throw new RuntimeException("EXPECTED PIN COUNT: 0 - "+maxPins+". FOUND: "+pins+".");
		this.pins=pins;
	}

	private int maxPins() {
		return Bowling.PINS*(1+(pins/Bowling.PINS));
	}

	public PinCount add(PinCount pinCount) {
		int sum=this.pins+pinCount.pins;
		return new PinCount(sum, maxPins());
	}

	private PinCount(int pins, int maxPins) {
		set(pins, maxPins);
	}

	public Ball next(Ball ball) {
		return (pins==Bowling.PINS)  ?  ball.markSuccessor() : ball.nonMarkSuccessor();
	}

	public void score(Score score) {
		score.add(pins);
	}	
}