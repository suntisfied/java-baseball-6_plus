package baseball.inputform;

public abstract class InputValidatorForm {
    @FunctionalInterface
    public interface InputValidator {
        boolean validateInput();
    }

    protected void throwIllegalArgumentExceptionToInvalid(String errorMessage, InputValidator inputValidator) {
        if (!inputValidator.validateInput()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
