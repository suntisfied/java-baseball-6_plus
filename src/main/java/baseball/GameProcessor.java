package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameProcessor {

    private static final int INITIAL_RANDOM_NUMBER = 1;
    private static final int LAST_RANDOM_NUMBER = 9;
    private static final int DIGIT_SIZE = 3;

    private static List<String> generateRandomNumberList() {
        List<String> randomNumberList = new ArrayList<>();
        for (int i = 0; i < DIGIT_SIZE; i++) {
            int randomNumber = Randoms.pickNumberInRange(INITIAL_RANDOM_NUMBER, LAST_RANDOM_NUMBER);
            randomNumberList.add(String.valueOf(randomNumber));
        }
        return randomNumberList;
    }

    private static List<String> generateUserNumberList(Data data) {
        List<String> userNumberList = new ArrayList<>();

        String userNumberString = data.getUserInput();

        for (int i = 0; i < DIGIT_SIZE; i++) {
            char digitChar = userNumberString.charAt(i);
            userNumberList.add(String.valueOf(digitChar));
        }
        return userNumberList;
    }

    private static String calculateStrike(Data data, List<String> userNumberList, List<String> randomNumberList) {
        int strike = 0;

        for (int i = 0; i < DIGIT_SIZE; i++) {
            if (userNumberList.get(i).equals(randomNumberList.get(i))) {
                strike++;
            }
        }
        return String.valueOf(strike);
    }

    private static String calculateBall(Data data, List<String> userNumberList, List<String> randomNumberList) {
        int ball = 0;

        for (int i = 0; i < DIGIT_SIZE; i++) {
            for (int j = 0; j < DIGIT_SIZE; j++) {
                if (userNumberList.get(i).equals(randomNumberList.get(j))) {
                    ball++;
                    break;
                }
            }
        }
        return String.valueOf(ball);
    }

    public List<String> calculateStrikeBall(Data data) {
        List<String> strikeBall = Arrays.asList("0", "0");
        List<String> userNumberList = generateUserNumberList(data);
        List<String> randomNumberList = generateRandomNumberList();

        String strike = calculateStrike(data, userNumberList, randomNumberList);
        String ball = calculateBall(data, userNumberList, randomNumberList);

        strikeBall.set(0, strike);
        strikeBall.set(1, ball);

        System.out.println(strikeBall);
        System.out.println(userNumberList);
        System.out.println(randomNumberList);

        return strikeBall;
    }

    public void IllegalArgumentException(Data data) {
        if ((data.getUserInput().length()) > 3) {
            System.out.println("3보다 큽니다");
        }
    }


}
