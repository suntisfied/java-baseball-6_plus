package baseball;

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
        int gameType = initialSettings.gameType();
        if (gameType == 1) {
            return Texts.NUMBER_GAME_START.getText();
        }
        return Texts.ALPHABET_GAME_START.getText();
    }

    public String formatInput(InitialSettings initialSettings) {
        int gameType = initialSettings.gameType();
        if (gameType == 1) {
            return Texts.NUMBER_INPUT.getText();
        }
        return Texts.ALPHABET_INPUT.getText();
    }

    public String formatGameEnd(PlayerAnswer playerAnswer, InitialSettings initialSettings) {
        int gameType = initialSettings.gameType();
        int gameSize = initialSettings.gameSize();
        if (new GiveUp().isGivingUp(playerAnswer)) {
            return "";
        }
        if (gameType == 1) {
            return String.format("%d" + Texts.NUMBER_CORRECT_ANSWER.getText() + "%n", gameSize);
        }
        return String.format("%d" + Texts.ALPHABET_CORRECT_ANSWER.getText() + "%n", gameSize);
    }
}
