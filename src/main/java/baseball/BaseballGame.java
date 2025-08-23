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
            String[] userInput = (InputHandler.inputNumber()).split("");
            List<Integer> userInputList = new ArrayList<>();
            for(String s : userInput) {
                userInputList.add(Integer.parseInt(s));
            }

            int strike = 0;
            int ball = 0;

            for(int i = 0; i < 3; i++){
                if(answerNumbers.equals(userInputList.get(i), i)){
                    strike++;
                }else if(answerNumbers.contains(userInputList.get(i))){
                    ball++;
                }
            }

            if(strike > 0 && ball > 0){
                OutputHandler.ballAndStrike(ball, strike);
            }else if(strike > 0){
                OutputHandler.strike(strike);
            }else if(ball > 0){
                OutputHandler.ball(ball);
            }else{
                OutputHandler.nothing();
            }

            if(strike == 3){
                OutputHandler.gameClear();
                break;
            }
        }
    }
}
