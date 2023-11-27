package baseball.giveup;

import baseball.setting.Texts;
import baseball.valueholder.PlayerAnswer;

public class GiveUp {
    public boolean isGivingUp(PlayerAnswer playerAnswer) {
        return playerAnswer.answer().equals(Texts.MARK_GIVE_UP.getText());
    }
}
