package baseball.validator;

import static baseball.util.ValidatingUtils.isValidEndingInput;

import baseball.inputform.InputValidatorForm;
import baseball.setting.Texts;

public class FinalizingInputValidator extends InputValidatorForm {
    public void checkFinalizingInput(String userInput) {
        throwIllegalArgumentExceptionToInvalid(Texts.ERROR_GAME_END_INPUT.getText(),
                () -> validateFinalizingInput(userInput));
    }

    private boolean validateFinalizingInput(String userInput) {
        return isValidEndingInput.test(userInput);
    }
}
