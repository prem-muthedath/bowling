package bowling.states;

import bowling.core.Ball;
import bowling.core.Frame;
import bowling.core.PinCount;
import bowling.core.Score;

class ScoredBall extends Ball {
	public boolean roll(Frame frame, PinCount pinCount) {
		return rolled();
	}

	public int score(int pins) {
		return pins;
	}
}