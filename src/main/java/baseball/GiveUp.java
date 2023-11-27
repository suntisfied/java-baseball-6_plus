package baseball;

public class GiveUp {
    public boolean isGivingUp(PlayerAnswer playerAnswer) {
        return playerAnswer.answer().equals(Texts.MARK_GIVE_UP.getText());
    }
}
