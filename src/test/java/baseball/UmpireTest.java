package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UmpireTest {
    Umpire umpire = new Umpire(new UserAnswer("124"), new CorrectAnswer("123"));

    @Test
    public void callBall() {
        int ball = umpire.callBall();

        assertThat(ball).isEqualTo(0);
    }

    @Test
    public void callStrike() {
        int strike = umpire.callStrike();

        assertThat(strike).isEqualTo(2);
    }
}
