package baseball;

import static baseball.ConvertingUtils.convertStringToList;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Umpire {
    private final List<String> playerAnswerEach;
    private final List<String> correctAnswerEach;

    public Umpire(PlayerAnswer playerAnswer, CorrectAnswer correctAnswer) {
        this.playerAnswerEach = convertStringToList(playerAnswer.answer());
        this.correctAnswerEach = convertStringToList(correctAnswer.answer());
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

    public boolean isCompleteAnswer() {
        Set<String> mergedAnswer =
                Stream.concat(playerAnswerEach.stream(), correctAnswerEach.stream())
                        .collect(Collectors.toSet());
        return mergedAnswer.size() == correctAnswerEach.size();
    }
}
