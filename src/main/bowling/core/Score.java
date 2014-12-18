package bowling.core;

public class Score {
	private int points;

	void score(Ball ball, int pins) {
		add(ball.score(pins));
	}

	private void add(int score) {
		points+=score;
	}

	public String toString() {
		return new Integer(points).toString();
	}
}