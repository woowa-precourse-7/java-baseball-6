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
        return null;
    }
}
