package baseball.inputform;

import java.util.function.BooleanSupplier;

public abstract class InputValidatorForm {
    protected void throwIllegalArgumentExceptionToInvalid(String errorMessage, BooleanSupplier inputValidator) {
        if (!inputValidator.getAsBoolean()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
