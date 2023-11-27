package baseball;

public enum GameRangeNumber {
    INITIAL_NUMBER(1),
    LAST_NUMBER(9),
    ;

    private final int number;

    GameRangeNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
