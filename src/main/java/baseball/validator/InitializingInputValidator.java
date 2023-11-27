package baseball.validator;

import baseball.setting.Buttons;
import baseball.util.ValidatingUtils;

public class InitializingInputValidator {
    private final ValidatingUtils validatingUtils;

    public InitializingInputValidator() {
        validatingUtils = new ValidatingUtils();
    }

    public boolean validateGameType(String input) {
        return validatingUtils.isValidType.test(input);
    }

    public boolean validateGameSize(String input, String gameType) {
        if (gameType.equals(Buttons.GAME_TYPE_NUMBER.getButton())) {
            return validatingUtils.isPositiveInteger.test(input) && validatingUtils.isProperNumberSetting.test(input);
        }
        return validatingUtils.isPositiveInteger.test(input) && validatingUtils.isProperAlphabetSetting.test(input);
    }
}
