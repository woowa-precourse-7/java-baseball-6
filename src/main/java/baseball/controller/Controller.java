package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.BaseballNumberGenerator;
import baseball.model.BaseballState;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.Map;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballNumberGenerator baseballNumberGenerator;

    public Controller(InputView inputView, OutputView outputView, BaseballNumberGenerator baseballNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballNumberGenerator = baseballNumberGenerator;
    }

    public void run() {
        BaseballGame baseballGame = new BaseballGame(baseballNumberGenerator);

        outputView.printInstruction();
        do {
            playGame(baseballGame);
        } while (inputView.playMoreGame());
    }

    private void playGame(BaseballGame baseballGame) {
        baseballGame.startGame();
        while (continueGame(baseballGame)) {    // !을 붙이는 것보다 함수로 빼서 의미 전달
            List<Integer> numbers = inputView.getNumbers();
            Map<BaseballState, Integer> baseballStates = baseballGame.playRound(numbers); // entrySet <볼,1> <스트라이크.1>
            outputView.printState(baseballStates);
            // 의미 단위로 라인 분리 - 흐름 파악에 도움이 된다.
        }
        outputView.printGameEndInstruction();
    }

    private boolean continueGame(BaseballGame baseballGame) {
        return !baseballGame.checkEnd();
    }
}
