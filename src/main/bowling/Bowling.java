package bowling;

public class Bowling {
	private java.util.ArrayList <Frame> frames=new java.util.ArrayList<Frame>();

    public Bowling() {
        advance();
    }

    void advance() {
        frames.add(new Frame());        
    }

    public void roll(int pins) {
        int last=frames.size();
        RollContextFactory factory=new RollContextFactory(this);
        for(int frame=0; frame < last; frame++) {
            RollContext context=factory.create(frame, frames.get(frame));
            frames.get(frame).count(context, pins);
        }
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