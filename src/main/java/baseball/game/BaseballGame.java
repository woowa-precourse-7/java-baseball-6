package baseball.game;

import baseball.game.session.GameSession;
import baseball.io.InputHandler;
import baseball.io.OutputHandler;
import baseball.game.numbers.AnswerNumbers;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    public static void run() {

        GameStatus gameStatus = GameStatus.START;

        OutputHandler.gameStart();

        while(gameStatus != GameStatus.EXIT){
            AnswerNumbers answerNumbers = new AnswerNumbers();

            GameSession newGameSession = new GameSession(answerNumbers);
            newGameSession.start();

            OutputHandler.gameContinue();
            gameStatus = InputHandler.inputCommand();
        }

        Console.close();
    }
}
