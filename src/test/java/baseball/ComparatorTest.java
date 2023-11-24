package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ComparatorTest {
    @Test
    public void calculateStrike() {
        var comparator = new Comparator(new UserAnswer("124"), new CorrectAnswer("123"));

        int strike = comparator.calculateStrike();
        assertThat(strike).isEqualTo(2);
    }
}
