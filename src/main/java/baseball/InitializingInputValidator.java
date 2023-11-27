package baseball;

public class InitializingInputValidator {
    private final ValidatingUtils validatingUtils;

    public InitializingInputValidator() {
        validatingUtils = new ValidatingUtils();
    }

    public boolean validateGameType(String input) {
        return validatingUtils.isValidType.test(input);
    }

    public boolean validateGameSize(String input, int gameType) {
        if (gameType == 1) {
            return validatingUtils.isPositiveInteger.test(input) && validatingUtils.isProperNumberSetting.test(input);
        }
        return validatingUtils.isPositiveInteger.test(input) && validatingUtils.isProperAlphabetSetting.test(input);
    }
}
