package baseball;

public class Player extends ConsoleInputForm {
    private final PlayerInputValidator playerInputValidator;

    public Player() {
        playerInputValidator = new PlayerInputValidator();
    }

    public PlayerAnswer speculateAnswer(InitialSettings initialSettings) {
        String userInput = getInputUntilCorrect(
                () -> System.out.print(new TextFormatter().formatInput(initialSettings)),
                input -> {
                    if (input.equals(Texts.MARK_GIVE_UP.getText())) {
                        throw new GiveUpException(Texts.GIVE_UP.getText());
                    }
                    if (!playerInputValidator.validatePlayerInput(input, initialSettings)) {
                        throw new IllegalArgumentException(Texts.ERROR_GAME_GUESS_INPUT.getText());
                    }
                }
        );
        return new PlayerAnswer(userInput);
    }
}
