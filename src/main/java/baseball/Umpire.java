package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Umpire {
    private final List<String> userAnswerEach;
    private final List<String> correctAnswerEach;

    public Umpire(UserAnswer userAnswer, CorrectAnswer correctAnswer) {
        this.userAnswerEach = convertToList(userAnswer.answer());
        this.correctAnswerEach = convertToList(correctAnswer.answer());
    }

    public int callBall() {
        return (int) userAnswerEach.stream()
                .filter(correctAnswerEach::contains)
                .count() - callStrike();
    }

    public int callStrike() {
        return (int) IntStream.range(0, correctAnswerEach.size())
                .filter(location -> userAnswerEach.get(location).equals(correctAnswerEach.get(location)))
                .count();
    }

    private static List<String> convertToList(String answer) {
        return Arrays.asList(answer.split(""));
    }
}
