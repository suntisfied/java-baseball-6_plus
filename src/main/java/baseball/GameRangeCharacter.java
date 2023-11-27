package baseball;

public enum GameRangeCharacter {
    INITIAL_CHARACTER('a'),
    LAST_CHARACTER('z'),
    ;

    private final char character;

    GameRangeCharacter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
