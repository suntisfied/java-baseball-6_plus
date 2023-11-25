package baseball;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CorrectAnswerGenerator {
    private final Random random;
    private final int length;

    public CorrectAnswerGenerator(UserAnswer userAnswer) {
        random = new Random();
        length = userAnswer.answer().length();
    }

    public CorrectAnswer generateNumberCorrectAnswer() {
        int DigitLength = (int) Math.pow(10, length - 1);

        int correctAnswerNumber = random.nextInt(9 * DigitLength) + DigitLength;
        return new CorrectAnswer(String.valueOf(correctAnswerNumber));
    }

    public CorrectAnswer generateStringCorrectAnswer() {
        String correctAnswerString = IntStream.range(0, length)
                .mapToObj(location -> (char) ('a' + random.nextInt(26)))
                .map(String::valueOf)
                .collect(Collectors.joining());
        return new CorrectAnswer(correctAnswerString);
    }
}
