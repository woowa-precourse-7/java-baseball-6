package baseball.view;

import baseball.model.BaseballState;
import java.util.Map;

public class BaseballOutputView implements OutputView {
    @Override
    public void printInstruction() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void printState(Map<BaseballState, Integer> states) {
        if (states.isEmpty()) {
            System.out.println(BaseballState.NOTHING.getInfo());
            return;
        }

        for (BaseballState state : BaseballState.values()) {
            if(state == BaseballState.NOTHING) continue;
            printIfContains(states, state);
        }

        System.out.println();
    }

    private void printIfContains(Map<BaseballState, Integer> states, BaseballState state) {
        if (states.containsKey(state)) {
            System.out.printf("%d%s ", states.get(state), state.getInfo());
        }
    }

    @Override
    public void printGameEndInstruction() {
        System.out.println("숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
