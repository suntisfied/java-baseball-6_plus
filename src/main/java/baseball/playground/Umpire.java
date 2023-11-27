package baseball.playground;

import static baseball.util.ConvertingUtils.convertStringToList;

import baseball.valueholder.CorrectAnswer;
import baseball.valueholder.PitchingResult;
import baseball.valueholder.PlayerAnswer;
import java.util.List;
import java.util.stream.IntStream;

public class Umpire {
    private final List<String> playerAnswerEach;
    private final List<String> correctAnswerEach;
    private final boolean isCompleteAnswer;

    public Umpire(PlayerAnswer playerAnswer, CorrectAnswer correctAnswer) {
        this.playerAnswerEach = convertStringToList(playerAnswer.answer());
        this.correctAnswerEach = convertStringToList(correctAnswer.answer());
        isCompleteAnswer = playerAnswer.answer().equals(correctAnswer.answer());
    }

    public PitchingResult umpire() {
        return new PitchingResult(callBall(), callStrike());
    }

    public int callBall() {
        return (int) playerAnswerEach.stream()
                .filter(correctAnswerEach::contains)
                .count() - callStrike();
    }

    public int callStrike() {
        return (int) IntStream.range(0, correctAnswerEach.size())
                .filter(location -> playerAnswerEach.get(location).equals(correctAnswerEach.get(location)))
                .count();
    }

    public boolean validateAnswer() {
        return isCompleteAnswer;
    }
}
