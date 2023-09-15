package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static boolean hasCommonSubstring(String str1, String str2) {
        char[] str1_charArr = str1.toCharArray();
        char[] str2_charArr = str2.toCharArray();
        List<String> answer = List.of("answer");

        for (int i = 0; i < str1.length() - 1; i++) {
            for (int j = 0; j < str2.length() - 1; j++) {
                if (str1.charAt(i) == str2.charAt(j) && str1.charAt(i + 1) == str2.charAt(j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> email = new ArrayList<>();
        List<String> name = new ArrayList<>();
        TreeSet<String> email_list = new TreeSet<>(); // 중복허용x, 정렬된 순서

        for (List<String> strings : forms) {
            email.add(strings.get(0));
        }
        for (List<String> form : forms) {
            name.add(form.get(1));
        }

        for (int i = 0; i < name.size() - 1; i++) {
            for (int j = i + 1; j < name.size() - 1; j++) {
                if (hasCommonSubstring(name.get(i), name.get(j))) {
                    email_list.add(email.get(i));
                    email_list.add(email.get(j));
                }
            }
        }

        return new ArrayList<>(email_list);
    }
}
