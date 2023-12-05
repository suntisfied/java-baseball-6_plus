package baseball.validator;

import static baseball.util.ValidatingUtils.isLowercaseAlphabet;
import static baseball.util.ValidatingUtils.isPositiveInteger;
import static baseball.util.ValidatingUtils.isPredefinedSize;
import static baseball.util.ValidatingUtils.isProperAlphabetRange;
import static baseball.util.ValidatingUtils.isProperNumberRange;
import static baseball.util.ValidatingUtils.isUniqueOnly;

import baseball.inputform.InputValidatorForm;
import baseball.setting.Buttons;
import baseball.setting.Texts;
import baseball.valueholder.InitialSettings;

public class PlayerInputValidator extends InputValidatorForm {
    public void checkPlayerInputValidity(String userInput, InitialSettings initialSettings) {
        throwIllegalArgumentExceptionToInvalid(Texts.ERROR_GAME_GUESS_INPUT.getText(),
                () -> validatePlayerInput(userInput, initialSettings));
    }

    private boolean validatePlayerInput(String userInput, InitialSettings initialSettings) {
        String gameType = initialSettings.gameType();
        int gameSize = initialSettings.gameSize();
        boolean commonValidity = isUniqueOnly.test(userInput) && isPredefinedSize.test(userInput, gameSize);

        if (gameType.equals(Buttons.GAME_TYPE_NUMBER.getButton())) {
            return isProperNumberRange.test(userInput) && isPositiveInteger.test(userInput) && commonValidity;
        }

        return isProperAlphabetRange.test(userInput) && isLowercaseAlphabet.test(userInput) && commonValidity;
    }
}
