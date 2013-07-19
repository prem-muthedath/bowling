package bowling;

public class FrameContext {
    private GameContext context;
    private Frame frame;

    public FrameContext(Frame frame, GameContext context) {
        this.frame=frame;
        this.context=context;        
    }

    public void transition(int pins) {
        frame.transition(this, pins);
    }

    public void advance() {
        context.advance();
    }
}
