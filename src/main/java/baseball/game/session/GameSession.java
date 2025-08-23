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
        while(true){
            UserNumbers userNumbers = askUserNumbers();

            GameSessionStatus gameSessionStatus = userNumbers.compareToAnswer(answerNumbers);

            gameSessionStatus.printGameResult();

            if(gameSessionStatus.isGameClear()){
                OutputHandler.gameClear();
                break;
            }
        }
    }

    private static UserNumbers askUserNumbers() {
        OutputHandler.inputNumber();
        return InputHandler.inputNumber();
    }
}
