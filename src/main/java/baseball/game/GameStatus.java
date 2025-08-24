package baseball.game;

public enum GameStatus {
    START(1),
    EXIT(2);

    private final int command;

    GameStatus(int command) {
        this.command = command;
    }

    public static GameStatus CommandProvider(int command){
        for(GameStatus gameStatus : GameStatus.values()){
            if(gameStatus.command == command){
                return gameStatus;
            }
        }

        throw new IllegalArgumentException("잘못된 입력입니다. 게임 재시작은 1, 종료는 2만 입력할 수 있습니다.");
    }
}
