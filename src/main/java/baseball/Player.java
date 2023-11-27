package baseball;

public class Player extends ConsoleInputForm {
    private final PlayerInputValidator playerInputValidator;

    public Player() {
        playerInputValidator = new PlayerInputValidator();
    }

    public PlayerAnswer speculateAnswer(int gameType, int gameSize) {
        String userInput = getInputUntilCorrect(
                () -> System.out.print(new TextFormatter().formatInput(gameType)),
                input -> {
                    if (!playerInputValidator.validatePlayerInput(input, gameType, gameSize)) {
                        throw new IllegalArgumentException(Texts.ERROR_GAME_GUESS_INPUT.getText());
                    }
                }
        );
        return new PlayerAnswer(userInput);
    }
}
