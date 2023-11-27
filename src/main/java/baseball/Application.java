package baseball;

import baseball.staff.StageManager;

public class Application {
    public static void main(String[] args) {
        var stageManager = new StageManager();

        stageManager.repeatEntireGameUntilEnd();
    }
}