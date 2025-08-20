package baseball.model;

import java.util.List;
import java.util.Map;

public class BaseballGame {
    private BaseballNumber baseballNumber;
    private final BaseballNumberGenerator baseballNumberGenerator;
    private boolean endFlag;

    public BaseballGame(BaseballNumberGenerator baseballNumberGenerator) {
        this.baseballNumberGenerator = baseballNumberGenerator;
    }

    public void startGame() {
        baseballNumber = new BaseballNumber(baseballNumberGenerator.generateNumbers());
        endFlag = false;
    }

    public Map<BaseballState, Integer> playRound(List<Integer> userNumbers) {
        BaseballNumber userBaseballNumber = new BaseballNumber(userNumbers);
        Map<BaseballState, Integer> baseballStates = baseballNumber.getBaseballStates(userBaseballNumber);

        if (isAllStrikes(baseballStates)) {
            endFlag = true;
        }
        return baseballStates;
    }

    private boolean isAllStrikes(Map<BaseballState, Integer> baseballStates) {
        return baseballStates.get(BaseballState.STRIKE) == BaseballNumber.LENGTH;
    }

    public boolean checkEnd() {
        return endFlag;
    }

}
