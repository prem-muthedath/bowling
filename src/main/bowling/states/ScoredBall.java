package bowling.states;

import bowling.core.Ball;
import bowling.core.Score;

class ScoredBall extends Ball {
	protected int adjust(int pinCount) {
		return 0;
	}

	public Ball nonMarkSuccessor() {
		return this;
	}

	public void score(Score score, int pinCount) {
		score.add(pinCount);
	}
}