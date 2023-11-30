package baseball;

import baseball.giveup.GiveUp;
import baseball.playground.CorrectAnswerGenerator;
import baseball.playground.GameRecorder;
import baseball.playground.Player;
import baseball.playground.Umpire;
import baseball.staff.GameFinalizer;
import baseball.staff.GameInitializer;
import baseball.textformat.TextFormatter;
import baseball.util.ConsoleManager;
import baseball.valueholder.CorrectAnswer;
import baseball.valueholder.InitialSettings;

public class StageManager {
    private final CorrectAnswerGenerator correctAnswerGenerator;
    private final GameInitializer gameInitializer;
    private final GameFinalizer gameFinalizer;
    private final TextFormatter textFormatter;

    public StageManager(CorrectAnswerGenerator correctAnswerGenerator) {
        this.correctAnswerGenerator = correctAnswerGenerator;
        gameFinalizer = new GameFinalizer();
        gameInitializer = new GameInitializer();
        textFormatter = new TextFormatter();
    }

    public void repeatEntireGameUntilEnd() {
        do {
            proceedMainGame();
        } while (gameFinalizer.isRepeating());
        ConsoleManager.closeConsole();
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

        var correctAnswer = correctAnswerGenerator.generateCorrectAnswer(initialSettings);
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
