package onboarding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_score = 0;
        int crong_score = 0;

        // 포비 왼쪽 페이지 가장 큰 수
        int pobi_firstPage = pobi.get(0);
        String pobi_firstPage_s = Integer.toString(pobi_firstPage);
        List<Integer> pobi_pageDigit1 = new ArrayList<>();
        for (int i = 0; i < pobi_firstPage_s.length(); i++) {
            int digit = pobi_firstPage_s.charAt(i) - '0';
            pobi_pageDigit1.add(digit);
        }

        int p_plus1 = 0;
        int p_multiply1 = 1;
        for (int digit : pobi_pageDigit1) {
            p_plus1 += digit;
        }

        for (int digit : pobi_pageDigit1) {
            p_multiply1 *= digit;
        }

        int pobi_firstPage_max = Math.max(p_plus1, p_multiply1);

        // 포비 오른쪽 페이지 가장 큰 수
        int pobi_secondPage = pobi.get(1);
        String pobi_secondPage_s = Integer.toString(pobi_secondPage);
        List<Integer> pobi_pageDigit2 = new ArrayList<>();
        for (int i = 0; i < pobi_secondPage_s.length(); i++) {
            int digit = pobi_secondPage_s.charAt(i) - '0';
            pobi_pageDigit2.add(digit);
        }

        int p_plus2 = 0;
        int p_multiply2 = 1;
        for (int digit : pobi_pageDigit2) {
            p_plus2 += digit;
        }

        for (int digit : pobi_pageDigit2) {
            p_multiply2 *= digit;
        }
        int pobi_secondPage_max = Math.max(p_plus2, p_multiply2);

        // 포비 왼쪽, 오른쪽 페이지 계산한 것 중 가장 큰 수
        pobi_score = Math.max(pobi_firstPage_max, pobi_secondPage_max);

        // 크롱 왼쪽 페이지 가장 큰 수
        int crong_firstPage = crong.get(0);
        String crong_firstPage_s = Integer.toString(crong_firstPage);
        List<Integer> crong_pageDigit1 = new ArrayList<>();
        for (int i = 0; i < pobi_firstPage_s.length(); i++) {
            int digit = crong_firstPage_s.charAt(i) - '0';
            crong_pageDigit1.add(digit);
        }
        int c_plus1 = 0;
        int c_multiply1 = 1;
        for (int digit : crong_pageDigit1) {
            c_plus1 += digit;
        }
        for (int digit : crong_pageDigit1) {
            c_multiply1 *= digit;
        }
        int crong_firstPage_max = Math.max(c_plus1, c_multiply1);

        // 크롱 오른쪽 페이지 가장 큰 수
        int crong_secondPage = crong.get(1);
        String crong_secondPage_s = Integer.toString(crong_secondPage);
        List<Integer> crong_pageDigit2 = new ArrayList<>();
        for (int i = 0; i < crong_secondPage_s.length(); i++) {
            int digit = crong_secondPage_s.charAt(i) - '0';
            crong_pageDigit2.add(digit);
        }
        int c_plus2 = 0;
        int c_multiply2 = 1;
        for (int digit : crong_pageDigit2) {
            c_plus2 += digit;
        }
        for (int digit : crong_pageDigit2) {
            c_multiply2 *= digit;
        }

        int crong_secondPage_max = Math.max(c_plus2, c_multiply2);

        // 크롱 왼쪽, 오른쪽 페이지 계산한 것 중 가장 큰 수
        crong_score = Math.max(crong_firstPage_max, crong_secondPage_max);

        // 예외 사항, 페이지 번호가 1씩 차이 나지 않을 때

        // 승자 정하기
        if (pobi.get(0) +1 != pobi.get(1) && crong.get(0) +1 != crong.get(1)) {
            if (pobi_score > crong_score) {
                answer = 1;
            } else if (pobi_score < crong_score) {
                answer = 2;
            } else if (pobi_score == crong_score) {
                answer = 0;
            }
        } else {
            answer = -1;
        }
        return answer;
    }


}



