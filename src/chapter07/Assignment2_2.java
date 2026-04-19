package chapter07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Assignment2_2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            HashMap<String, ScoreInfo> top3Map = new HashMap<>(); // 이름을 키로, 점수 정보를 값으로 저장하는 맵

            System.out.println("*** 게임 톱3 관리 프로그램입니다. ***");

            while (true) {
                System.out.print("이름 점수 게임시간 입력>>");
                String name = scanner.next();

                if (name.equals("그만")) {
                    break;
                }

                int score = scanner.nextInt(); // 점수
                int time = scanner.nextInt(); // 시간
                ScoreInfo newInfo = new ScoreInfo(name, score, time); // 새 점수 정보 생성

                // 맵에 새 점수 정보 추가 또는 업데이트
                if (top3Map.containsKey(name)) { // 이미 존재하는 이름인 경우 점수 정보 업데이트
                    top3Map.put(name, newInfo);
                } else if (top3Map.size() < 3) { // 톱3 미만인 경우 바로 추가
                    top3Map.put(name, newInfo);
                } else {
                    String minName = null; // 최하 점수의 이름을 저장할 변수
                    int minScore = Integer.MAX_VALUE; // 최하 점수를 저장할 변수, 초기값은 최대 정수로 설정

                    Iterator<Map.Entry<String, ScoreInfo>> it = top3Map.entrySet().iterator();// 맵을 순회하여 최하 점수와 그에 해당하는 이름을 찾음 
                    // HashMap을 Iterator로 순회할 경우, Map.Entry를 사용해 key와 value를 함께 접근
                    while (it.hasNext()) {
                        Map.Entry<String, ScoreInfo> entry = it.next(); // Map.Entry는 key와 value를 함께 저장하는 인터페이스
                        if (entry.getValue().score < minScore) { // 현재 엔트리의 점수가 최하 점수보다 낮은 경우
                            minScore = entry.getValue().score; // 최하 점수 업데이트
                            minName = entry.getKey(); // 최하 점수에 해당하는 이름 업데이트
                        }
                    }

                    if (score > minScore) { // 새 점수가 최하 점수보다 높은 경우
                        System.out.println("최하 점수의 " + minName + "이 삭제됨"); // 최하 점수의 이름과 점수 정보 출력
                        top3Map.remove(minName); // 최하 점수의 이름을 키로 사용하여 맵에서 해당 엔트리 제거
                        top3Map.put(name, newInfo); // 새 점수 정보를 맵에 추가
                    } else {
                        System.out.println(name + "이 최하위이므로 톱3에 추가되지 못함"); // 새 점수가 최하 점수보다 낮은 경우, 추가되지 못함 메시지 출력
                    }
                }

                ArrayList<ScoreInfo> view = new ArrayList<>(top3Map.values()); // 맵의 값(점수 정보)을 리스트로 변환하여 출력
                Iterator<ScoreInfo> viewIt = view.iterator(); // 리스트의 점수 정보 출력
                while (viewIt.hasNext()) { // 리스트에 점수 정보가 남아있는 동안
                    ScoreInfo info = viewIt.next(); // 리스트의 점수 정보를 하나씩 가져와서 출력
                    System.out.print(info + " "); // ScoreInfo 클래스의 toString() 메서드가 호출되어 점수 정보가 문자열로 출력됨
                }
                System.out.println(); // 줄 바꿈을 추가하여 다음 입력을 위한 준비
            }
        }
    }
}
