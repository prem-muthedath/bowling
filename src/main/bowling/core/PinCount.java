package bowling.core;

public class PinCount {
	private int pins;

	public static PinCount instance(int pins) {
		return new PinCount(0).add(new PinCount(pins));
	}

	private PinCount(int pins) {
		this.pins=pins;
	}
	
	public PinCount add(PinCount pinCount) {
		return new PinCount(pinCount.addTo(pins));
	}

	private int addTo(int basePins) {
		return new PinCountSum(basePins).add(pins);
	}

	Ball nextBall(Ball current) {
		return  pins==Bowling.PINS  ?  current.markSuccessor() : current.nonMarkSuccessor();
	}

	public void score(Score score) {
		score.add(pins);
	}
}
