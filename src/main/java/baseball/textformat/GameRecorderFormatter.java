package baseball.textformat;

import static baseball.setting.Texts.LINE_BREAK;

import baseball.playground.GameRecorder;
import baseball.setting.Texts;
import baseball.valueholder.CorrectAnswer;
import baseball.valueholder.PlayerAnswer;
import java.util.stream.Collectors;

public class GameRecorderFormatter {
    private final GameRecorder gameRecorder;
    private final CorrectAnswer correctAnswer;

    public GameRecorderFormatter(GameRecorder gameRecorder, CorrectAnswer correctAnswer) {
        this.gameRecorder = gameRecorder;
        this.correctAnswer = correctAnswer;
    }

    public String combineAnalyses() {
        return LINE_BREAK.getText()
                + Texts.RESULT_INSTRUCTION.getText() + LINE_BREAK.getText()
                + formatCorrectAnswer() + LINE_BREAK.getText()
                + LINE_BREAK.getText()
                + formatPitchingNumber() + LINE_BREAK.getText()
                + LINE_BREAK.getText()
                + formatPitchingRecords()
                + LINE_BREAK.getText();
    }

    private String formatCorrectAnswer() {
        return Texts.RESULT_HEAD_CORRECT_ANSWER.getText() + LINE_BREAK.getText() + correctAnswer.answer();
    }

    private String formatPitchingNumber() {
        return Texts.RESULT_HEAD_PITCHING_NUMBER.getText() + LINE_BREAK.getText()
                + gameRecorder.retrievePitchingNumber();
    }

    private String formatPitchingRecords() {
        String head = Texts.RESULT_HEAD_PITCHING_RECORDS.getText() + LINE_BREAK.getText();
        if (!gameRecorder.retrievePitchingRecords().isEmpty()) {
            return head + gameRecorder.retrievePitchingRecords().stream()
                    .map(PlayerAnswer::answer).collect(Collectors.joining(LINE_BREAK.getText()));
        }
        return head + Texts.NONE.getText();
    }
}
