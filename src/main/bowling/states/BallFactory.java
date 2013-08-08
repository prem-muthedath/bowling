package bowling.states;

import bowling.core.Ball;

public class BallFactory {
    public Ball firstBall() {
        return new RolledBall(new Ball() {
            public Ball markSuccessor() {
                return new BallFactory().firstStrikeBonusBall();
            }

            public Ball nonMarkSuccessor() {
                return new BallFactory().secondBall();     
            }
        });
    }

    Ball secondBall() {
        return new RolledBall(new Ball() {
            public Ball markSuccessor() {
                return new BallFactory().spareBonusBall();
            }

            public Ball nonMarkSuccessor() {
                return new BallFactory().scoredBall();     
            }
        });
    }

    Ball firstStrikeBonusBall() {
        return new Ball() {
            public Ball nonMarkSuccessor() {
                return new BallFactory().secondStrikeBonusBall();     
            }
        };
    }

    Ball secondStrikeBonusBall() {
        return new Ball() {
            public Ball nonMarkSuccessor() {
                return new BallFactory().scoredBall();     
            }
        };
    } 

    Ball spareBonusBall() {
        return new Ball() {
            public Ball nonMarkSuccessor() {
                return new BallFactory().scoredBall();      
            }
        };
    }  

    Ball scoredBall() {
        return new ScoredBall();      
    }         
}