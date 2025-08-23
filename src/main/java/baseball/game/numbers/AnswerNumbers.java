package baseball.game.numbers;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class AnswerNumbers {

    private final List<Integer> answerNumbers;

    public AnswerNumbers() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        this.answerNumbers = answer;
    }

    public boolean contains(int number){
        return answerNumbers.contains(number);
    }

    public boolean equals(int number, int index){
        return answerNumbers.get(index) == number;
    }
}
