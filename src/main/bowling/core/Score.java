package bowling.core;

public class Score {
	private int points;

	void score(Frame frame) {
		add(frame.finishedScore());
	}

	private void add(int score) {
		points+=score;
	}

	public String toString() {
		return new Integer(points).toString();
	}
}