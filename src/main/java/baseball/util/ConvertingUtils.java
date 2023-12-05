package baseball.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertingUtils {
    public static List<String> convertStringToList(String input) {
        return Arrays.asList(input.split(""));
    }

    public static Set<String> convertStringToSet(String input) {
        return new HashSet<>(Arrays.asList(input.split("")));
    }
}
