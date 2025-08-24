package baseball.game.session;

import baseball.io.OutputHandler;

public class GameSessionStatus {
    private final int strike;
    private final int ball;

    public GameSessionStatus(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void printGameResult() {
        if (strike != 0 && ball != 0) {
            OutputHandler.ballAndStrike(ball, strike);
            return;
        }

        if (ball != 0) {
            OutputHandler.ball(ball);
            return;
        }

        if (strike != 0) {
            OutputHandler.strike(strike);
            return;
        }

        OutputHandler.nothing();
    }

    public boolean isGameClear(){
        return this.strike == 3;
    }
}
