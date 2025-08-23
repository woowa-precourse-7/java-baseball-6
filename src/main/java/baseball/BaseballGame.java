package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public static void run() {

        // 게임 안내
        System.out.println("숫자 야구 게임을 시작합니다.");

        // answer List 에 정답 설정
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        System.out.println("정답"+answer.get(0)+answer.get(1)+answer.get(2));

        boolean gameClear = false;
        while(!gameClear){
            // 입력값 받기
            System.out.print("숫자를 입력해주세요 : ");
            String[] userInput = (Console.readLine()).split("");

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

            String result;

            if(strike == 0 && ball == 0){
                result = "낫싱";
            }else if(strike > 0 && ball == 0){
                result = strike+"스트라이크";
            }else if(ball > 0 && strike == 0){
                result = ball+"볼";
            }else{
                result = ball+"볼 "+strike+"스트라이크";
            }

            System.out.println(result);
            if(strike == 3){
                gameClear = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }

        Console.close();
    }
}
