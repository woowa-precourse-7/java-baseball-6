package baseball;

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

    // 테스트를 위한 정답 출력 메서드
    public void printAnswerNumbers() {
        System.out.println(answerNumbers.get(0) + "" + answerNumbers.get(1) + "" + answerNumbers.get(2));
    }

    public boolean contains(int number){
        return answerNumbers.contains(number);
    }

    public boolean equals(int number, int index){
        return answerNumbers.get(index) == number;
    }
}
