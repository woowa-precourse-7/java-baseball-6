package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String inputNumber(){
        return Console.readLine();
    }

    public static GameStatus inputCommand(){
        String inputCommand = Console.readLine();
        return GameStatus.CommandProvider(Integer.parseInt(inputCommand));
    }
}
