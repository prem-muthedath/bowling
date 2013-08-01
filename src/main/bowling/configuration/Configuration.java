package bowling.configuration;

import bowling.core.Bowling;
import bowling.core.Frame;
import bowling.core.State;
import bowling.states.TransitionalBalls;

public class Configuration {
	public Bowling game() {
		return new Bowling(frames());
	}

	private Frame[] frames() {
		Frame[] frames=new Frame[Bowling.FRAMES];
		for(int i=0; i < frames.length; i++) {
			State state=new TransitionalBalls().firstBall();
			frames[i]=new Frame(state);
		}
		return frames;
	}
}