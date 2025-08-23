package baseball.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballNumber {
    public static final int LENGTH = 3;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateLength(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size()) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LENGTH) {
            throw new IllegalArgumentException("숫자의 길이가 적절하지 않습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_VALUE || number > MAX_VALUE) {
                throw new IllegalArgumentException("숫자의 범위가 적절하지 않습니다.");
            }
        }
    }

    /**
     * @param userNumbers 유저가 입력한 숫자를 랩핑한 값.(무결성 보장)
     * @return Map<BaseballState, Integer> 반환. 만약 BaseballState.Nothing 일경우 EmptyMap 리턴.
     */
    public Map<BaseballState, Integer> getBaseballStates(BaseballNumber userNumbers) {
        Map<BaseballState, Integer> baseballStates = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            int userNumber = userNumbers.numbers.get(i);
            BaseballState baseballState = getBaseballState(i, userNumber);

            putBaseballState(baseballStates, baseballState);
        }

        return baseballStates;
    }

    private BaseballState getBaseballState(int idx, int value) {
        if (numbers.get(idx).equals(value)) {
            return BaseballState.STRIKE;
        }
        if (numbers.contains(value)) {
            return BaseballState.BALL;
        }
        return BaseballState.NOTHING;
    }

    private void putBaseballState(Map<BaseballState, Integer> baseballStates, BaseballState baseballState) {
        if (BaseballState.NOTHING.equals(baseballState)) {
            return;
        }
        baseballStates.putIfAbsent(baseballState, 0);
        baseballStates.put(baseballState, baseballStates.get(baseballState) + 1);
    }
}
