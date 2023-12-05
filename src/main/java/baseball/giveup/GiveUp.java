package baseball.giveup;

import baseball.setting.Texts;
import baseball.valueholder.PlayerAnswer;

public class GiveUp {
    public void checkGiveUp(String userInput) throws GiveUpException {
        if (userInput.equals(Texts.MARK_GIVE_UP.getText())) {
            throw new GiveUpException(Texts.GIVE_UP.getText());
        }
    }

    public boolean isGivingUp(PlayerAnswer playerAnswer) {
        return playerAnswer.answer().equals(Texts.MARK_GIVE_UP.getText());
    }
}
