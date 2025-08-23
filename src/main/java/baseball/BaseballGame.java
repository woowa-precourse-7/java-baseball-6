package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public static void run() {

        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        // 게임 안내
        outputHandler.gameStart();

        // answer List 에 정답 설정
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        // 테스트를 위한 정답 출력
        System.out.println(answer.get(0) + "" + answer.get(1) + "" + answer.get(2));

        boolean gameClear = false;
        while(!gameClear){
            // 입력값 받기
            outputHandler.inputNumber();
            String[] userInput = (inputHandler.inputNumber()).split("");

            int first = Integer.parseInt(userInput[0]);
            int second = Integer.parseInt(userInput[1]);
            int third = Integer.parseInt(userInput[2]);

            int strike = 0;
            int ball = 0;

            if(first == answer.get(0)){
                strike++;
            }else if(answer.contains(first)){
                ball++;
            }

            if(second == answer.get(1)){
                strike++;
            }else if(answer.contains(second)){
                ball++;
            }

            if(third == answer.get(2)){
                strike++;
            }else if(answer.contains(third)){
                ball++;
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
