package bowling.states;

public class TransitionalBalls {
    public Ball firstBall() {
        return new RolledBall(new Ball() {
            protected Transition transition(boolean allPins) {
                if(allPins) return Transition.STRIKE;
                return Transition.FIRST_ROLL;     
            }
        });
    }

    Ball secondBall() {
        return new RolledBall(new Ball() {
            protected Transition transition(boolean allPins) {
                if(allPins) return Transition.SPARE;
                return Transition.OPEN;     
            }
        });
    }

    Ball firstStrikeBonusBall() {
        return new Ball() {
            protected Transition transition(boolean allPins) {
                return Transition.STRIKE_BONUS_ONE;     
            }
        };
    }

    Ball secondStrikeBonusBall() {
        return new Ball() {
            protected Transition transition(boolean allPins) {
                return Transition.STRIKE_BONUS_TWO;     
            }
        };
    } 

    Ball spareBonusBall() {
        return new Ball() {
            protected Transition transition(boolean allPins) {
                return Transition.SPARE_BONUS;      
            }
        };
    }      
}