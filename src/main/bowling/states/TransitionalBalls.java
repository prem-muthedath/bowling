package bowling.states;

import bowling.core.Pinfall;

public class TransitionalBalls {
    public Ball firstBall() {
        return new RolledBall(new Ball() {
            protected Transition transition(Pinfall pinfall) {
                if(pinfall.allPins()) return Transition.STRIKE;
                return Transition.FIRST_ROLL;     
            }
        });
    }

    Ball secondBall() {
        return new RolledBall(new Ball() {
            protected Transition transition(Pinfall pinfall) {
                if(pinfall.allPins()) return Transition.SPARE;
                return Transition.OPEN;     
            }
        });
    }

    Ball firstStrikeBonusBall() {
        return new Ball() {
            protected Transition transition(Pinfall pinfall) {
                return Transition.STRIKE_BONUS_ONE;     
            }
        };
    }

    Ball secondStrikeBonusBall() {
        return new Ball() {
            protected Transition transition(Pinfall pinfall) {
                return Transition.STRIKE_BONUS_TWO;     
            }
        };
    } 

    Ball spareBonusBall() {
        return new Ball() {
            protected Transition transition(Pinfall pinfall) {
                return Transition.SPARE_BONUS;      
            }
        };
    }      
}