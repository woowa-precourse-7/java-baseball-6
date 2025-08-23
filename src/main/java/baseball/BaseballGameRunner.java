package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameRunner {

    public static void run() {

        // 게임 상태 변경
        GameStatus gameStatus = GameStatus.START;

        // 게임 안내
        OutputHandler.gameStart();

        while(gameStatus != GameStatus.EXIT){
            AnswerNumbers answerNumbers = new AnswerNumbers();

            BaseballGame newGame = new BaseballGame(answerNumbers);
            newGame.gameStart();

            OutputHandler.gameContinue();
            gameStatus = InputHandler.inputCommand();
        }

        Console.close();
    }
}
