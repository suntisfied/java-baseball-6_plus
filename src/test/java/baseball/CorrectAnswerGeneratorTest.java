package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CorrectAnswerGeneratorTest {

    @Test
    public void generateCorrectAnswerInNumber() {
        UserAnswer userAnswer = new UserAnswer("123");

        var correctAnswerGenerator = new CorrectAnswerGenerator(userAnswer);

        var correctAnswer = correctAnswerGenerator.generateNumberCorrectAnswer();
        System.out.println(correctAnswer.answer());

        assertThat(correctAnswer.answer().length()).isEqualTo(3);
    }
}