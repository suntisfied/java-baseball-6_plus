package baseball;

import baseball.playground.CorrectAnswerGenerator;

public class Application {
    public static void main(String[] args) {
        var stageManager = new StageManager(new CorrectAnswerGenerator());

        stageManager.repeatEntireGameUntilEnd();
    }
}