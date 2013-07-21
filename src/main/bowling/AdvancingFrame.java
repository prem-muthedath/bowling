package bowling;

public class AdvancingFrame {
    private Play play;
    private Frame frame;

    public AdvancingFrame(Frame frame, Play play) {
        this.frame=frame;
        this.play=play;        
    }

    public void transition(int pins) {
        frame.transition(this, pins);
    }

    public void advance() {
        play.advance();
    }
}
