package bowling.configuration;

import bowling.states.FirstBall;
import bowling.core.Bowling;
import bowling.core.Frame;
import bowling.core.State;

public class Factory {
	public Bowling create() {
		Bowling bowling=new Bowling();
		bowling.add(frames());
		return bowling;
	}

	private Frame[] frames() {
		Frame[] frames=new Frame[10];
			for(int i=0; i < frames.length; i++) {
				State state=new FirstBall();
				frames[i]=new Frame(state);
    		}
		return frames;
	}
}