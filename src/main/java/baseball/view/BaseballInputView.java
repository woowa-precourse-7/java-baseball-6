package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class BaseballInputView implements InputView {   //추상화 목적? 클래스명이 잘못되었다. BaseballInputView가 아닌 Console,Computer 등등 그 목적에 맞게
    @Override
    public List<Integer> getNumbers() {
        System.out.print("숫자를 입력 해 주세요 : ");

        return Arrays.stream(
                        Console.readLine()
                                .split(""))
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public boolean playMoreGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return switch (Console.readLine()) {
            case "1" -> true;
            case "2" -> false;
            default -> throw new IllegalArgumentException("잘못된 입력 입니다.");
        };  // enum으로 관리하면 훨씬 좋을것 같다.

        //scanner close()
    }
}
