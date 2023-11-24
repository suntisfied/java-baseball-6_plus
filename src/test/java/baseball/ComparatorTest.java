package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ComparatorTest {
    Comparator comparator = new Comparator(new UserAnswer("124"), new CorrectAnswer("123"));

    @Test
    public void calculateBall() {
        int ball = comparator.calculateBall();

        assertThat(ball).isEqualTo(0);
    }

    @Test
    public void calculateStrike() {
        int strike = comparator.calculateStrike();

        assertThat(strike).isEqualTo(2);
    }
}
