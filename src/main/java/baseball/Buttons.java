package baseball;

public enum Buttons {
    GAME_TYPE_NUMBER("1"),
    GAME_TYPE_ALPHABET("2"),
    GAME_REPEAT("1"),
    GAME_END("2"),
    ;

    private final String button;

    Buttons(String button) {
        this.button = button;
    }

    public String getButton() {
        return button;
    }
}
