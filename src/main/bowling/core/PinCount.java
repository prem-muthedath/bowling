package bowling.core;

public class PinCount {
	private int pins;

	public static PinCount instance(int pins) {
		return new PinCount(0).add(new PinCount(pins));
	}

	private PinCount(int pins) {
		this.pins=pins;
	}

	PinCount add(PinCount pinCount) {
		int sum=this.pins+pinCount.pins;
		if(sum >= minimum() && sum <= maximum()) return new PinCount(sum);
		throw new RuntimeException(message(sum));
	}

	private int minimum() {
		return this.pins;
	}

	private int maximum() {
		return Bowling.PINS*(1+(minimum()/Bowling.PINS));
	}

	private String message(int count) {
		return "EXPECTED PIN COUNT: "+minimum()+" - "+maximum()+". BUT FOUND: "+count+".";
	}

	Ball nextBall(Ball current) {
		return  pins==Bowling.PINS  ?  current.markSuccessor() : current.nonMarkSuccessor();
	}

	int score(Ball ball) {
		return ball.score(pins);
	}
}
