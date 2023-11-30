package baseball.giveup;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GiveUpTest {
    @Test
    void throwGiveUpExceptionWhenCalled() {
        String userInput = "!";
        assertThrows(GiveUpException.class, () -> new GiveUp().checkGiveUp(userInput));
    }
}