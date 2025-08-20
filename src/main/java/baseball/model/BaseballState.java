package baseball.model;

public enum BaseballState {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    ;

    private String info;

    BaseballState(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
