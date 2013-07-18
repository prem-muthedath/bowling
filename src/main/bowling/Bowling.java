package bowling;

public class Bowling {
	private java.util.ArrayList <Frame> frames=new java.util.ArrayList<Frame>();

    public Bowling() {
        advance();
    }

    void advance() {
        frames.add(new Frame(this, frames.size()));        
    }

    public void roll(int pins) {
        int last=frames.size();
        for(int frame=0; frame < last; frame++)
            frames.get(frame).count(pins);
    }

    public int score() {
        return score(frames.size());
    }

    public int score(int theFrame) {
        int score=0;
        for(int frame=0; frame < theFrame; frame++)
            score+=frames.get(frame).score();
        return score;
    }
}