package baseball.playground;

import baseball.valueholder.PlayerAnswer;
import java.util.ArrayList;
import java.util.List;

public class GameRecorder {
    private final List<PlayerAnswer> pitchingRecords;
    private int pitchingNumber;

    public GameRecorder() {
        pitchingRecords = new ArrayList<>();
    }

    public void recordPitching(PlayerAnswer playerAnswer) {
        pitchingRecords.add(playerAnswer);
        countPitching();
    }

    private void countPitching() {
        pitchingNumber++;
    }

    public List<PlayerAnswer> retrievePitchingRecords() {
        return pitchingRecords;
    }

    public int retrievePitchingNumber() {
        return pitchingNumber;
    }
}
