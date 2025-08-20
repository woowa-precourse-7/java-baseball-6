package baseball;

import baseball.controller.Controller;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new BaseballInputView();
        OutputView outputView = new BaseballOutputView();
        Controller controller = new Controller(inputView, outputView);

        controller.run();
    }
}
