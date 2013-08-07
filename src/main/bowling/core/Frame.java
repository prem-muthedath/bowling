package bowling.core;

public class Frame {	
	private PinCount pinCount=new PinCount(0);
	private Ball ball;

	public Frame(Ball first) {
		ball=first;
	}

	public boolean roll(PinCount count) {
		return ball.roll(this, count);
	}

	public void transition(PinCount count) {
		pinCount=pinCount.add(count);
		ball=ball.next(pinCount);		
	}

	public void score(Score score) {
		ball.score(score, pinCount);
	}		
}
