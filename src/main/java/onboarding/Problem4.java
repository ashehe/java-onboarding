package onboarding;

public class Problem4 {
    public static String solution(String word) {
        for (int i = 0; i < word.length(); i++) {
            if ( 65 <= (int)word.charAt(i) && (int)word.charAt(i) <= 90) {
                word = word.substring(0, i) + (char)(155 - (int)word.charAt(i)) + word.substring(i + 1);
            } else if ( 97 <= (int)word.charAt(i) && (int)word.charAt(i) <= 122) {
                word = word.substring(0, i) + (char)(219 - (int)word.charAt(i)) + word.substring(i + 1);
            }
        }
        String answer = word;
        return answer;
    }
}
