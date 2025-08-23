package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserNumbers {
    private final List<Integer> userNumbers;

    public UserNumbers(String userInput) {
        List<Integer> numbers = new ArrayList<>();

        if(userInput.length() != 3){
            throw new IllegalArgumentException("3자리의 수를 입력해야 합니다.");
        }

        for(char c : userInput.toCharArray()){
            int input = c - '0';

            if(input < 0 || input > 9){
                throw new IllegalArgumentException("0-9 사이의 값을 입력해야 합니다.");
            }

            if(numbers.contains(input)){
                throw new IllegalArgumentException("서로 다른 수를 입력해야 합니다.");
            }

            numbers.add(input);
        }

        this.userNumbers = numbers;
    }

    public GameResult compareToAnswer(AnswerNumbers answerNumbers) {
        int ball = 0;
        int strike = 0;
        for(int i = 0; i < 3; i++){
            if(answerNumbers.equals(userNumbers.get(i), i)){
                strike++;
            }else if(answerNumbers.contains(userNumbers.get(i))){
                ball++;
            }
        }
        return new GameResult(strike, ball);
    }
}
