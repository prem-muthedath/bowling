package bowling;

public class FrameContext {
    private GameState state;
    private Frame frame;

    public FrameContext(Frame frame, GameState state) {
        this.frame=frame;
        this.state=state;        
    }

    public void transition(int pins) {
        frame.transition(this, pins);
    }

    public void advance() {
        state.advance();
    }
}
