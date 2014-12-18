package bowling.core;

public class Score {
	private int points;

	public Score(int points) {
		this.points=points;
	}

	public String toString() {
		return new Integer(points).toString();
	}
}