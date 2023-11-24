package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ComparatorTest {
    @Test
    public void calculateStrike() {
        var comparator = new Comparator();

        int strike = comparator.compareTo(new UserAnswer("124"));
        assertThat(strike).isEqualTo(2);
    }
}
