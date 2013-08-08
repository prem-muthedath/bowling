package bowling.core;

public class Frame {	
	private int pinfall=0;
	private Ball ball;

	public Frame(Ball first) {
		ball=first;
	}

	public boolean roll(int count) {
		return ball.roll(this, count);
	}

	void transition(int count) {
		pinfall=addPins(count);
		ball=nextBall();		
	}

	private int addPins(int count) {
		int sum=pinfall+count;
		int maxPins=Bowling.PINS*(1+(pinfall/Bowling.PINS));
		return new PinCountRange(pinfall, maxPins).filter(sum);		
	}

	private Ball nextBall() {
		return pinfall==Bowling.PINS  ?  ball.markSuccessor() : ball.nonMarkSuccessor();
	}	

	public void score(Score score) {
		ball.score(score, pinfall);
	}		
}
