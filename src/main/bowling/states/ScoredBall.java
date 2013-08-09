package bowling.states;

import bowling.core.Ball;
import bowling.core.PinCount;
import bowling.core.Score;

class ScoredBall extends Ball {
	protected PinCount adjust(PinCount pinCount) {
		return new PinCount();
	}

	protected Ball nonMarkSuccessor() {
		return this;
	}

	public void score(Score score, PinCount pinCount) {
		pinCount.score(score);
	}
}