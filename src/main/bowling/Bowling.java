package bowling;

public class Bowling {
    private java.util.ArrayList <Frame> frames=new java.util.ArrayList<Frame>();

    public Bowling() {
        advance(frames.size()-1);
    }

    public void roll(int pins)  {
        for(int frame=0; frame < frames.size(); frame++)
            if(!frames.get(frame).roll(pins)) advance(frame);
    }

    private void advance(int frame) {
        if(currentFrame(frame) && notDone()) frames.add(new FrameFactory().create());                
    }

    private boolean currentFrame(int frame) {
        return frame==frames.size()-1;
    }

    private boolean notDone() {
        return !Tenpin.TOTAL_FRAMES.equals(frames.size());
    }   

    public int score() {
        return score(frames.size());
    }

    public int score(int aFrame) {
        int score=0;
        for(int frame=0; frame < Math.min(aFrame, frames.size()); frame++)
            score+=frames.get(frame).score();
        return score;
    }
}
