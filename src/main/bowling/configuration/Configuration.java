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
		for(int frame=0; frame < frames.length; frame++) {
			Ball first=new BallFactory().firstBall();
			PinCount none=PinCount.instance(0);
			frames[frame]=new Frame(first, none);
		}
		return frames;
	}
}