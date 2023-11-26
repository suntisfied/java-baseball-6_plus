package baseball;

import static baseball.ConvertingUtils.convertStringToList;

import java.util.List;
import java.util.stream.IntStream;

public class Umpire {
    private final List<String> userAnswerEach;
    private final List<String> correctAnswerEach;

    public Umpire(PlayerAnswer playerAnswer, CorrectAnswer correctAnswer) {
        this.userAnswerEach = convertStringToList(playerAnswer.answer());
        this.correctAnswerEach = convertStringToList(correctAnswer.answer());
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
}
