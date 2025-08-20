package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class BaseballInputView implements InputView {
    @Override
    public List<Integer> getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");

        return Arrays.stream(Console.readLine()
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
        };

    }
}
