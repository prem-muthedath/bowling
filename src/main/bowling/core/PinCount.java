package bowling.core;

public class PinCount {
	private int pins;

	public PinCount(int pins) {
		this(pins, Bowling.PINS);
	}

	private PinCount(int pins, int maxPins) {
		set(pins, maxPins);
	}

	private void set(int pins, int maxPins) {
		if(pins < 0 || pins > maxPins) 
			throw new RuntimeException("EXPECTED PIN COUNT RANGE: 0 - "+maxPins+". FOUND: "+pins+".");
		this.pins=pins;
	}

	public PinCount add(PinCount pinCount) {
		int sum=this.pins+pinCount.pins;
		int maxPins=Bowling.PINS*(1+(pins/Bowling.PINS));
		return new PinCount(sum, maxPins);
	}

	public Ball next(Ball ball) {
		if(pins==Bowling.PINS) return ball.markSuccessor();
		return ball.nonMarkSuccessor();
	}

	public void score(Score score) {
		score.add(pins);
	}	
}