package baseball.textformat;

import static baseball.setting.Texts.LINE_BREAK;

import baseball.giveup.GiveUp;
import baseball.playground.GameRecorder;
import baseball.setting.Buttons;
import baseball.setting.Texts;
import baseball.valueholder.CorrectAnswer;
import baseball.valueholder.InitialSettings;
import baseball.valueholder.PitchingResult;
import baseball.valueholder.PlayerAnswer;

public class TextFormatter {
    public String formatPitchingResult(PitchingResult pitchingResult) {
        int ball = pitchingResult.ball();
        int strike = pitchingResult.strike();

        if (ball != 0 && strike != 0) {
            return formatBall(ball) + formatStrike(strike);
        }
        if (ball != 0) {
            return formatBall(ball);
        }
        if (strike != 0) {
            return formatStrike(strike);
        }
        return Texts.NOTHING.getText();
    }

    private String formatBall(int ball) {
        return String.format("%d" + Texts.BALL.getText() + " ", ball);
    }

    private String formatStrike(int strike) {
        return String.format("%d" + Texts.STRIKE.getText(), strike);
    }

    public String formatGameStart(InitialSettings initialSettings) {
        String gameType = initialSettings.gameType();
        String giveUpInstruction = Texts.INSTRUCTION_GIVE_UP.getText() + LINE_BREAK.getText();
        if (gameType.equals(Buttons.GAME_TYPE_NUMBER.getButton())) {
            return Texts.NUMBER_GAME_START.getText() + LINE_BREAK.getText() + giveUpInstruction;
        }
        return Texts.ALPHABET_GAME_START.getText() + LINE_BREAK.getText() + giveUpInstruction;
    }

    public String formatPlayerInput(InitialSettings initialSettings) {
        String gameType = initialSettings.gameType();
        if (gameType.equals(Buttons.GAME_TYPE_NUMBER.getButton())) {
            return Texts.NUMBER_INPUT.getText();
        }
        return Texts.ALPHABET_INPUT.getText();
    }

    public String formatGameEnd(PlayerAnswer playerAnswer, InitialSettings initialSettings) {
        String gameType = initialSettings.gameType();
        int gameSize = initialSettings.gameSize();
        if (new GiveUp().isGivingUp(playerAnswer)) {
            return "";
        }
        if (gameType.equals(Buttons.GAME_TYPE_NUMBER.getButton())) {
            return String.format("%d" + Texts.NUMBER_CORRECT_ANSWER.getText() + "%n", gameSize);
        }
        return String.format("%d" + Texts.ALPHABET_CORRECT_ANSWER.getText() + "%n", gameSize);
    }

    public String formatSummary(GameRecorder gameRecorder, CorrectAnswer correctAnswer) {
        return new GameRecorderFormatter(gameRecorder, correctAnswer).combineAnalyses();
    }
}
