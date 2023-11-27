package baseball;

public class GameFinalizer extends ConsoleInputForm {
    public boolean isRepeating() {
        String userInput = getInputUntilCorrect(
                () -> System.out.println(Texts.RESTART.getText()),
                input -> {
                    if (!new ValidatingUtils().isValidEndingInput.test(input)) {
                        throw new IllegalArgumentException(Texts.ERROR_GAME_END_INPUT.getText());
                    }
                });
        return userInput.equals("1");
    }
//    public boolean isEndingMain() {
//
//    }
}
