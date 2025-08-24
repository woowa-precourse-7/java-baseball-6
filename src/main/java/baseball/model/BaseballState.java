package baseball.model;

public enum BaseballState {
    BALL("볼"),  //출력 순서대로 정렬
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    ;

    private final String info; // final 수정.

    BaseballState(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
