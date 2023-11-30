package baseball.validator;

import static baseball.util.ValidatingUtils.isPositiveInteger;
import static baseball.util.ValidatingUtils.isProperAlphabetSetting;
import static baseball.util.ValidatingUtils.isProperNumberSetting;
import static baseball.util.ValidatingUtils.isValidType;

import baseball.inputform.InputValidatorForm;
import baseball.setting.Buttons;
import baseball.setting.Texts;

public class InitializingInputValidator extends InputValidatorForm {

    public void checkGameType(String gameType) {
        throwIllegalArgumentExceptionToInvalid(Texts.ERROR_GAME_TYPE_INPUT.getText(),
                () -> validateGameType(gameType));
    }

    public void checkGameSize(String gameSize, String gameType) {
        throwIllegalArgumentExceptionToInvalid(Texts.ERROR_GAME_SIZE_INPUT.getText(),
                () -> validateGameSize(gameSize, gameType));
    }

    private boolean validateGameType(String gameType) {
        return isValidType.test(gameType);
    }

    private boolean validateGameSize(String gameSize, String gameType) {
        if (gameType.equals(Buttons.GAME_TYPE_NUMBER.getButton())) {
            return isPositiveInteger.test(gameSize) && isProperNumberSetting.test(
                    gameSize);
        }
        return isPositiveInteger.test(gameSize) && isProperAlphabetSetting.test(
                gameSize);
    }
}
