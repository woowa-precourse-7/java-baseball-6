package baseball;

import baseball.controller.Controller;
import baseball.model.BaseballNumberGenerator;
import baseball.model.BaseballNumberGeneratorImpl;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new BaseballInputView();
        OutputView outputView = new BaseballOutputView();
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGeneratorImpl();

        Controller controller = new Controller(inputView, outputView, baseballNumberGenerator);
        //Config를 이용해서 구성파일 설정
        //Controller Config만 받고 그 내부에서 설정. -> 구성파일 자체를 클래스화 한다. (같은 목적의 클래스를 모아둔다.)

        controller.run();
    }
}

/*
MVC - 스프링에서도 MVC

Model
View
Controller

Controller
├  View
│  ├ InputView ◁ BaseballInputView
│  └ OutputView ◁ BaseballOutputView
└  Model
    └ BaseballGame
         ├ BaseballNumberGenerator ◁ BaseballNumberGeneratorImpl
         └ BaseballNumber
             └ BaseballState

 */
