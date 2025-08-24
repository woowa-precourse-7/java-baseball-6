package baseball.view;

import baseball.model.BaseballState;
import java.util.Map;

public interface OutputView {
    public void printInstruction();
    public void printState(Map<BaseballState, Integer> states);
    public void printGameEndInstruction();
}
