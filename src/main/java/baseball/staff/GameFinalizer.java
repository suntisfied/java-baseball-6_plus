package baseball.staff;

import baseball.inputform.ConsoleInputForm;
import baseball.setting.Buttons;
import baseball.setting.Texts;
import baseball.validator.FinalizingInputValidator;

public class GameFinalizer extends ConsoleInputForm {
    public boolean isRepeating() {
        String userInput = getInputUntilCorrect(
                () -> System.out.println(Texts.RESTART.getText()),
                input -> new FinalizingInputValidator().checkFinalizingInput(input));
        return userInput.equals(Buttons.GAME_REPEAT.getButton());
    }
}
