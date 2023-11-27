package baseball.staff;

import baseball.setting.Buttons;
import baseball.setting.Texts;
import baseball.util.ValidatingUtils;

public class GameFinalizer extends ConsoleInputForm {
    public boolean isRepeating() {
        String userInput = getInputUntilCorrect(
                () -> System.out.println(Texts.RESTART.getText()),
                input -> {
                    if (!new ValidatingUtils().isValidEndingInput.test(input)) {
                        throw new IllegalArgumentException(Texts.ERROR_GAME_END_INPUT.getText());
                    }
                });
        return userInput.equals(Buttons.GAME_REPEAT.getButton());
    }
}
