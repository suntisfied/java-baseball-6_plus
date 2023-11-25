package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CorrectAnswerGeneratorTest {

    @ParameterizedTest
    @CsvSource({
            "123",
            "abc",
    })
    public void generateCorrectAnswer(String userInput) {
        var correctAnswerGenerator = new CorrectAnswerGenerator(new UserAnswer(userInput));
        var correctAnswer = correctAnswerGenerator.generateCorrectAnswer();
        System.out.println("Correct Answer: " + correctAnswer.answer());

        assertThat(correctAnswer.answer().length()).isEqualTo(userInput.length());
    }
}