package baseball;

public class OutputHandler {

    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_NOTIFY = "숫자를 입력해주세요 : ";
    private static final String GAME_CLEAR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String GAME_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void gameStart() {
        System.out.println(GAME_START);
    }

    public static void inputNumber(){
        System.out.print(INPUT_NUMBER_NOTIFY);
    }

    public static void ballAndStrike(int ball, int strike){
        System.out.println(ball + BALL + " " + strike + STRIKE);
    }

    public static void ball(int ball){
        System.out.println(ball + BALL);
    }

    public static void strike(int strike){
        System.out.println(strike + STRIKE);
    }

    public static void nothing(){
        System.out.println(NOTHING);
    }

    public static void gameClear(){
        System.out.println(GAME_CLEAR);
    }

    public static void gameContinue(){
        System.out.println(GAME_CONTINUE);
    }
}
