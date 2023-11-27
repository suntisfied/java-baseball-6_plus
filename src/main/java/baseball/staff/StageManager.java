package baseball.staff;

import baseball.giveup.GiveUp;
import baseball.playground.CorrectAnswerGenerator;
import baseball.playground.GameRecorder;
import baseball.playground.Player;
import baseball.playground.Umpire;
import baseball.textformat.TextFormatter;
import baseball.valueholder.CorrectAnswer;
import baseball.valueholder.InitialSettings;

public class StageManager {
    private final GameInitializer gameInitializer;
    private final TextFormatter textFormatter;

    public StageManager() {
        gameInitializer = new GameInitializer();
        textFormatter = new TextFormatter();
    }

    public void repeatEntireGameUntilEnd() {
        do {
            proceedMainGame();
        } while (new GameFinalizer().isRepeating());
    }

    private InitialSettings initializeMainGame() {
        String gameType = gameInitializer.setGameType();
        int gameSize = gameInitializer.setGameSize(gameType);
        System.out.println();
        return new InitialSettings(gameType, gameSize);
    }

    private void proceedMainGame() {
        var initialSettings = initializeMainGame();
        System.out.println(textFormatter.formatGameStart(initialSettings));

        var correctAnswer = new CorrectAnswerGenerator(initialSettings).generateCorrectAnswer();
        String gameSummary = pitchBall(initialSettings, correctAnswer, new GameRecorder());

        System.out.println(gameSummary);
    }

    private String pitchBall(InitialSettings initialSettings, CorrectAnswer correctAnswer, GameRecorder gameRecorder) {
        var playerAnswer = new Player().speculateAnswer(initialSettings);

        if (!new GiveUp().isGivingUp(playerAnswer)) {
            gameRecorder.recordPitching(playerAnswer);

            var umpire = new Umpire(playerAnswer, correctAnswer);
            var pitchingResult = umpire.umpire();
            System.out.println(textFormatter.formatPitchingResult(pitchingResult));

            if (!umpire.validateAnswer()) {
                return pitchBall(initialSettings, correctAnswer, gameRecorder);
            }
        }
        System.out.print(textFormatter.formatGameEnd(playerAnswer, initialSettings));
        return textFormatter.formatSummary(gameRecorder, correctAnswer);
    }
}
