package bowling.core;

public class PinCount {
	private int pins;

	public PinCount() {
		this(0);
	}

	PinCount(int pins) {
		this.pins=pins;
	}
	
	public PinCount add(PinCount pinCount) {
		return new PinCount(pinCount.addTo(pins));
	}

	private int addTo(int basePins) {
		int sum=basePins+pins;
		return new PinCountRange(basePins).filter(sum);
	}

	Ball nextBall(Ball current) {
		return  pins==Bowling.PINS  ?  current.markSuccessor() : current.nonMarkSuccessor();
	}

	public void score(Score score) {
		score.add(pins);
	}

	public boolean equals(Object object) {
		return object!=null && this.getClass()==object.getClass() && this.pins==((PinCount) object).pins;
	}

	public int hashCode() {
		return pins;
	}		
}
