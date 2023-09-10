package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        for (int j = 0; j < cryptogram.length() - 1; j++) {
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) { // 같은 문자가 나란히 있을 때
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
                    if (cryptogram.length() == 2) { // 문자 2개 남았을 때
                        if (cryptogram.charAt(0) == cryptogram.charAt(1)) {
                            cryptogram = "";
                        }
                    }
                }
            }
        }
        return cryptogram;
    }
}
