package bowling;

public class FrameContext {
    private RollContext context;
    private Frame frame;

    public FrameContext(Frame frame, RollContext context) {
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
