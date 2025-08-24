package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumberGeneratorImpl implements BaseballNumberGenerator {
    @Override
    public List<Integer> generateNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < BaseballNumber.LENGTH) {
            addIfNonDuplicate(computerNumbers, getRandomValueInRange());
        }

        return computerNumbers;
    }

    private void addIfNonDuplicate(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    private int getRandomValueInRange() {
        return Randoms.pickNumberInRange(BaseballNumber.MIN_VALUE, BaseballNumber.MAX_VALUE);
    }
}
