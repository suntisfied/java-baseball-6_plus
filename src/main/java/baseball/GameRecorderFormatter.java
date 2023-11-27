package baseball;

import java.util.stream.Collectors;

public class GameRecorderFormatter {
    private final GameRecorder gameRecorder;
    private final CorrectAnswer correctAnswer;
    private static final String LINE_BREAK = System.lineSeparator();

    public GameRecorderFormatter(GameRecorder gameRecorder, CorrectAnswer correctAnswer) {
        this.gameRecorder = gameRecorder;
        this.correctAnswer = correctAnswer;
    }

    public String combineAnalyses() {
        return LINE_BREAK
                + Texts.RESULT_INSTRUCTION.getText() + LINE_BREAK
                + formatCorrectAnswer() + LINE_BREAK
                + LINE_BREAK
                + formatPitchingNumber() + LINE_BREAK
                + LINE_BREAK
                + formatPitchingRecords()
                + LINE_BREAK;
    }

    private String formatCorrectAnswer() {
        return Texts.RESULT_HEAD_CORRECT_ANSWER.getText() + LINE_BREAK + correctAnswer.answer();
    }

    private String formatPitchingNumber() {
        return Texts.RESULT_HEAD_PITCHING_NUMBER.getText() + LINE_BREAK + gameRecorder.retrievePitchingNumber();
    }

    private String formatPitchingRecords() {
        String head = Texts.RESULT_HEAD_PITCHING_RECORDS.getText() + LINE_BREAK;
        if (!gameRecorder.retrievePitchingRecords().isEmpty()) {
            return head + gameRecorder.retrievePitchingRecords().stream()
                    .map(PlayerAnswer::answer).collect(Collectors.joining(LINE_BREAK));
        }
        return head + Texts.NONE.getText();
    }
}
