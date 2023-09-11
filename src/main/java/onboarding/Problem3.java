package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        List<String> clap = new ArrayList<>();
        for (int i = 1; i < number + 1; i++) {
            clap.add(Integer.toString(i));
        }

        for (String i : clap) {
            for (int j = 0; j < i.length(); j++) {
                if (i.charAt(j) == '3' || i.charAt(j) == '6' || i.charAt(j) == '9') {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
