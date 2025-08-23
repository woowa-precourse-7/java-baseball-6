package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.BaseballNumberGeneratorImpl;
import baseball.model.BaseballState;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Map;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballGame baseballGame;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

        baseballGame = new BaseballGame(new BaseballNumberGeneratorImpl());
    }

    public void run() {
        outputView.printInstruction();

        do {
            baseballGame.startGame();

            while (!checkGameEnd()) {
                Map<BaseballState, Integer> gameResult = baseballGame.playRound(inputView.getNumbers());
                outputView.printState(gameResult);
            }

            outputView.printGameEndInstruction();
        } while (inputView.playMoreGame());
    }

    private boolean checkGameEnd() {
        if (!baseballGame.checkEnd()) {
            return false;
        }
        return true;
    }
}
