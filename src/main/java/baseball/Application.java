package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();

            if (input.equals("1")) {
                continue;
            } else if (input.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException("1또는 2가 입력되어야 합니다.");
            }
        }

    }

    private static void startGame() {
        List<String> computer = makeNumber();

        while (true) {
            int ball = 0;
            int strike = 0;

            System.out.print("숫자를 입력해주세요 : ");
            String user = Console.readLine();

            validateInput(user);

            for (int i = 0; i < computer.size(); i++) {
                int idx = user.indexOf(computer.get(i));
                if (i == idx) {
                    strike++;
                } else if (idx != -1) {
                    ball++;
                }
            }

            if (ball > 0 && strike > 0) {
                System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            } else if (ball > 0) {
                System.out.printf("%d볼\n", ball);
            } else if (strike > 0) {
                System.out.printf("%d스트라이크\n", strike);
            } else {
                System.out.println("낫싱");
            }

            if (strike == 3) {
                break;
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static List<String> makeNumber() {
        List<String> integerList = new ArrayList<>();
        while (integerList.size() < 3) {
            String randNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!integerList.contains(randNumber)) {
                integerList.add(randNumber);
            }
        }

        return integerList;
    }

    /**
     * 야구게임 규칙 - 1-9 사이 중복없는 3자리 숫자만 허용
     */
    private static void validateInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1부터 9사이의 숫자만 포함되어야 합니다.");
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 입력되어야합니다.");
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException("1부터 9 사이의 숫자만 포함되어야 합니다.");
        }

        List<Character> check = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (check.contains(input.charAt(i))) {
                throw new IllegalArgumentException("3개의 숫자는 중복되지 않아야 합니다.");
            } else {
                check.add(input.charAt(i));
            }
        }
    }
}
