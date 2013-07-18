package bowling; 

public class Frame {
	private Bowling game;	
	private int index;
	private Turn turn=new Turn();

	public Frame(Bowling game, int index) {
		this.game=game;
		this.index=index;		
	}

	public void count(int pins) {
		turn.count(this, pins);
	}

	void transition(int pins) {
		turn.transition(this, pins);
	}

	public int score() {
		return turn.score();
	}

	void advance() {
		if(notLast()) game.advance();
	}

    private boolean notLast() {
        return !Tenpin.TOTAL_FRAMES.equals(index+1);
    }
}
