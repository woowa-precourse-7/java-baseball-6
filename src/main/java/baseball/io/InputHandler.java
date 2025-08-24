package baseball.io;

import baseball.game.GameStatus;
import baseball.game.numbers.UserNumbers;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static UserNumbers inputNumber(){
        String userInput = Console.readLine();
        return new UserNumbers(userInput);
    }

    public static GameStatus inputCommand(){
        String inputCommand = Console.readLine();
        return GameStatus.CommandProvider(Integer.parseInt(inputCommand));
    }
}
