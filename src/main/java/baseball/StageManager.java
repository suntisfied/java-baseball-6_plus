package baseball;

public class StageManager {
    private final GameInitializer gameInitializer;
    private final TextFormatter textFormatter;

    public StageManager() {
        gameInitializer = new GameInitializer();
        textFormatter = new TextFormatter();
    }

    public void repeatEntireGameUntilEnd() {
        do {
            proceedMainGameUntilCorrectAnswer();
        } while (new GameFinalizer().isRepeating());
    }

    private void proceedMainGameUntilCorrectAnswer() {
        var initialSettings = initializeMainGame();
        proceedMainGame(initialSettings);
    }

    private InitialSettings initializeMainGame() {
        String gameType = gameInitializer.setGameType();
        int gameSize = gameInitializer.setGameSize(gameType);
        System.out.println();
        return new InitialSettings(gameType, gameSize);
    }

    private void proceedMainGame(InitialSettings initialSettings) {
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

            if (!umpire.isCompleteAnswer()) {
                return pitchBall(initialSettings, correctAnswer, gameRecorder);
            }
        }
        System.out.print(textFormatter.formatGameEnd(playerAnswer, initialSettings));
        return textFormatter.formatSummary(gameRecorder, correctAnswer);
    }
}
