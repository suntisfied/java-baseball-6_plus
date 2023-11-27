package baseball;

public class GameInitializer extends ConsoleInputForm {
    private final InitializingInputValidator initializingInputValidator;

    public GameInitializer() {
        initializingInputValidator = new InitializingInputValidator();
    }

    public String setGameType() {
        return getInputUntilCorrect(
                () -> System.out.print(Texts.GAME_TYPE_INPUT.getText()),
                input -> {
                    if (!initializingInputValidator.validateGameType(input)) {
                        throw new IllegalArgumentException(Texts.ERROR_GAME_TYPE_INPUT.getText());
                    }
                });
    }

    public int setGameSize(String gameType) {
        String userInput = getInputUntilCorrect(
                () -> System.out.print(Texts.GAME_SIZE_INPUT.getText()),
                input -> {
                    if (!initializingInputValidator.validateGameSize(input, gameType)) {
                        throw new IllegalArgumentException(Texts.ERROR_GAME_SIZE_INPUT.getText());
                    }
                });
        return Integer.parseInt(userInput);
    }
}
