package baseball.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FinalizingInputValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "0",
            "3",
            "a",
    })
    void throwIllegalArgumentExceptionToInvalidGameType(String isRepeatingInput) {
        var finalizingInputValidator = new FinalizingInputValidator();

        assertThatIllegalArgumentException().isThrownBy(
                () -> finalizingInputValidator.checkFinalizingInput(isRepeatingInput));
    }
}