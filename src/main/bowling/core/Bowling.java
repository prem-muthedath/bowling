package bowling.core;

 public class Bowling {
    public static final int FRAMES=10;
    static final int PINS=10;

    private Frame[] frames;

    public Bowling(Frame[] frames) {
        this.frames=java.util.Arrays.copyOfRange(frames, 0, Bowling.FRAMES);
    }

    public void roll(PinCount count)  {
        for(Frame each : frames)
            if(each.roll(count)) return;
    }

    public Score score() {
        return score(frames.length);
    }

    public Score score(FrameCount count) {
        return count.score(this);
    }

    Score score(int frames) {
        int score=0;
        for(int frame=0; frame < frames; frame++)
            score+=this.frames[frame].score();
        return new Score(score);
    }
}
