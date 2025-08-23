package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public static void run() {

        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        AnswerNumbers answerNumbers = new AnswerNumbers();

        // 게임 안내
        outputHandler.gameStart();

        // 테스트를 위한 정답 출력
        answerNumbers.printAnswerNumbers();

        boolean gameClear = false;
        while(!gameClear){
            // 입력값 받기
            outputHandler.inputNumber();
            String[] userInput = (inputHandler.inputNumber()).split("");
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
                outputHandler.ballAndStrike(ball, strike);
            }else if(strike > 0){
                outputHandler.strike(strike);
            }else if(ball > 0){
                outputHandler.ball(ball);
            }else{
                outputHandler.nothing();
            }

            if(strike == 3){
                gameClear = true;
                outputHandler.gameClear();
            }
        }

        Console.close();
    }
}
