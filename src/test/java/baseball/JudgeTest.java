package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class JudgeTest {
    Judge judge = new Judge(new UserAnswer("124"), new CorrectAnswer("123"));

    @Test
    public void calculateBall() {
        int ball = judge.judgeBall();

        assertThat(ball).isEqualTo(0);
    }

    @Test
    public void calculateStrike() {
        int strike = judge.judgeStrike();

        assertThat(strike).isEqualTo(2);
    }
}
