package bowling.core;

public class Frame {
	private PinCount pinCount;
	private Ball ball;

	public Frame(Ball first, PinCount initial) {
		ball=first;
		pinCount=initial;
	}

	boolean roll(PinCount count) {
		return ball.roll(this, count);
	}

	void transition(PinCount count) {
		pinCount=pinCount.add(count);
		ball=ball.next(pinCount);
	}

	int score() {
		return pinCount.score(ball);
	}
}
