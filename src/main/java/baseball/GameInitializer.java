package baseball;

public class GameInitializer extends ConsoleInputForm {
    public int setGameType() {
        String userInput = getInputUntilCorrect(
                () -> System.out.print(Texts.GAME_TYPE_INPUT.getText()),
                input -> {
                    if (!new ValidatingUtils().isValidType.test(input)) {
                        throw new IllegalArgumentException(Texts.ERROR_GAME_TYPE_INPUT.getText());
                    }
                });
        return Integer.parseInt(userInput);
    }

    public int setGameSize() {
        String userInput = getInputUntilCorrect(
                () -> System.out.print(Texts.GAME_SIZE_INPUT.getText()),
                input -> {
                    if (!new ValidatingUtils().isPositiveInteger.test(input)) {
                        throw new IllegalArgumentException(Texts.ERROR_GAME_SIZE_INPUT.getText());
                    }
                });
        return Integer.parseInt(userInput);
    }
}
