package bowling.states;

class IntermediateBalls {
    public Ball secondBall() {
        return new FirstBall() {
            protected Transition transition(boolean allPins) {
                if(allPins) return Transition.SPARE;
                return Transition.OPEN;     
            }
        };
    }

    public Ball strikeBonusOneBall() {
        return new Ball() {
            protected Transition transition(boolean allPins) {
                return Transition.STRIKE_BONUS_ONE;     
            }
        };
    }

    public Ball strikeBonusTwoBall() {
        return new Ball() {
            protected Transition transition(boolean allPins) {
                return Transition.STRIKE_BONUS_TWO;     
            }
        };
    } 

    public Ball spareBonusBall() {
        return new Ball() {
            protected Transition transition(boolean allPins) {
                return Transition.SPARE_BONUS;      
            }
        };
    }      
}