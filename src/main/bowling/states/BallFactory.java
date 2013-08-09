package bowling.states;

import bowling.core.Ball;

public class BallFactory {
    public Ball firstBall() {
        return new RolledBall(new Ball() {
            protected Ball markSuccessor() {
                return new BallFactory().firstStrikeBonusBall();
            }

            protected Ball nonMarkSuccessor() {
                return new BallFactory().secondBall();     
            }
        });
    }

    Ball secondBall() {
        return new RolledBall(new Ball() {
            protected Ball markSuccessor() {
                return new BallFactory().spareBonusBall();
            }

            protected Ball nonMarkSuccessor() {
                return new BallFactory().scoredBall();     
            }
        });
    }

    Ball firstStrikeBonusBall() {
        return new Ball() {
            protected Ball nonMarkSuccessor() {
                return new BallFactory().secondStrikeBonusBall();     
            }
        };
    }

    Ball secondStrikeBonusBall() {
        return new Ball() {
            protected Ball nonMarkSuccessor() {
                return new BallFactory().scoredBall();     
            }
        };
    } 

    Ball spareBonusBall() {
        return new Ball() {
            protected Ball nonMarkSuccessor() {
                return new BallFactory().scoredBall();      
            }
        };
    }  

    Ball scoredBall() {
        return new ScoredBall();      
    }         
}