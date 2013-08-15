package bowling.configuration;

import bowling.core.Bowling;
import bowling.core.Frame;
import bowling.core.PinCount;
import bowling.core.Ball;

import bowling.states.BallFactory;

public class Configuration {
	public Bowling game() {
		return new Bowling(frames());
	}

	private Frame[] frames() {
		Frame[] frames=new Frame[Bowling.FRAMES];
		for(int i=0; i < frames.length; i++) {
			Ball first=new BallFactory().firstBall();
			PinCount none=PinCount.instance(0);
			frames[i]=new Frame(first, none);
		}
		return frames;
	}
}