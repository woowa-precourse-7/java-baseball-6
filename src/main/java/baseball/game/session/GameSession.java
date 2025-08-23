package baseball.game.session;

import baseball.io.InputHandler;
import baseball.io.OutputHandler;
import baseball.game.numbers.AnswerNumbers;
import baseball.game.numbers.UserNumbers;

public class GameSession {

    private final AnswerNumbers answerNumbers;
    public GameSession(AnswerNumbers answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public void start(){
        answerNumbers.printAnswerNumbers();

        while(true){
            OutputHandler.inputNumber();
            UserNumbers userNumbers = InputHandler.inputNumber();

            GameSessionStatus gameSessionStatus = userNumbers.compareToAnswer(answerNumbers);

            gameSessionStatus.printGameResult();

            if(gameSessionStatus.isGameClear()){
                OutputHandler.gameClear();
                break;
            }
        }
    }
}
