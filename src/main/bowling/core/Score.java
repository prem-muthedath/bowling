package bowling.core;

public class Score {
	private int points;

	public void add(int score) {
		points+=score;
	}

	public String toString() {
		return new Integer(points).toString();
	}
}