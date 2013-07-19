package bowling;

public class RollContext {
    private FrameContext context;
    private Frame frame;

    public RollContext(Frame frame, FrameContext context) {
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
