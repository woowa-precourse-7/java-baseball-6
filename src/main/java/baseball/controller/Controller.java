package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.BaseballNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

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
        while (!baseballGame.checkEnd()) {
            outputView.printState(baseballGame.playRound(inputView.getNumbers()));
        }
        outputView.printGameEndInstruction();
    }
}
