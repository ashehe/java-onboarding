package onboarding;

import java.util.*;

public class Problem7 {
    // 동점자가 있는지 확인하는 메서드
    public static boolean isValueDuplicate(LinkedHashMap<String, Integer> point, int valueToCheck) {
        int count = 0;
        for (Integer value : point.values()) {
            if (value == valueToCheck) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // 동점자 중 알파벳순으로 가장 빠른 사람을 반환하는 메서드
    public static String findFirstAlphabetically(LinkedHashMap<String, Integer> point, int valueToCheck) {
        List<String> sameScore = new ArrayList<>();
        String firstAlphabetically = null;

        for (String key : point.keySet()) {
            if (point.get(key) == valueToCheck) {
                sameScore.add(key);
            }
        }

        Collections.sort(sameScore);
        firstAlphabetically = sameScore.get(0);
        return firstAlphabetically;
    }


    // value 최대값의 key 반환하는 메소드(동점자 여러 명이면 알파벳 순으로 한 명)
    public static String findMaxValue(LinkedHashMap<String, Integer> point, List<String> answer) {
        int max = Integer.MIN_VALUE;
        String maxKey = null;

        // 가장 큰 추전 점수 찾기
        for (String person : point.keySet()) {
            if (point.get(person) > max) {
                max = point.get(person);
                maxKey = person;
            }
        }
        // 동점자 있을 때 알파벳 순으로 빠른 사람 찾기 (알파벳 순으로 늦은 사람은 메서드 한 번 더 실행했을 때 뽑힘)
        if (isValueDuplicate(point, max)) {
            maxKey = findFirstAlphabetically(point, max);
        }

        // 추천 점수가 0점이면 0을 반환하기(나중에 0 제거할 것임)
        if (max == 0) {
            return "0";
        }

        // point 리스트에서 최고점수인 사람 제거하기 (다음 번에 메서드 돌릴 땐 현 2등이 뽑히게 하기)
        point.remove(maxKey);

        return maxKey;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> result = new ArrayList<>();

        // frieds의 함께 아는 친구들을 listOfPeople에 넣기 (LinkedList - 중복 허용)
        List<String> listOfPeople = new LinkedList<>();
        for (List<String> list : friends) {
            listOfPeople.add(list.get(1));
        }

        // 등장 한 번 당 10점 HashMap value에 점수 더하기
        LinkedHashMap<String, Integer> point = new LinkedHashMap<>();
        for (String person : listOfPeople) {
            if (point.containsKey(person)) {
                point.put(person, point.get(person) + 10);
            } else {
                point.put(person, 10);
            }
        }

        // visitor들 방문 당 1점씩 주기
        for (String visitor : visitors) {
            if (point.containsKey(visitor)) {
                point.put(visitor, point.get(visitor) + 1);
            } else {
                point.put(visitor, 1);
            }
        }

        // 본인, 이미 친구 제외 .remove
        point.remove(user);
        for (List<String> list : friends) {
            if (Objects.equals(list.get(1), "mrko")) {
                point.remove(list.get(0));
            }
        }

        // 다섯 명 뽑기
        for (int i = 0; i < 5; i++) {
            result.add(findMaxValue(point, result));
        }

        // null 제거(5명이 안될 때), 0 제거(추천 점수가 0일 때)
        while (result.remove(null) || result.remove("0")) {
        }

        return result;
    }
}
