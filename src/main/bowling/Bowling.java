package bowling;

public class Bowling {
    private java.util.ArrayList <Frame> frames=new java.util.ArrayList<Frame>();

    public void roll(int pins)  {
        if(frames.size()==0) advance(frames.size()-1);                        
        for(int frame=0; frame < frames.size(); frame++)
            if(!frames.get(frame).roll(pins)) advance(frame);
    }

    private void advance(int frame) {
        if(notCurrentFrame(frame)) return;
        if(notDone()) frames.add(new FrameFactory().create());                
    }

    private boolean notCurrentFrame(int frame) {
        return frame!=frames.size()-1;
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
