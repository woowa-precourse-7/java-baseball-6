package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private final AnswerNumbers answerNumbers;
    public BaseballGame(AnswerNumbers answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public void gameStart(){
        answerNumbers.printAnswerNumbers();

        while(true){
            OutputHandler.inputNumber();
            UserNumbers userNumbers = InputHandler.inputNumber();

            GameResult gameResult = userNumbers.compareToAnswer(answerNumbers);

            gameResult.printGameResult();

            if(gameResult.isGameClear()){
                OutputHandler.gameClear();
                break;
            }
        }
    }
}
