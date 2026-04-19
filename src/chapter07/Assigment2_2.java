package chapter07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Assigment2_2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            HashMap<String, ScoreInfo> top3Map = new HashMap<>();

            System.out.println("*** 게임 톱3 관리 프로그램입니다. ***");

            while (true) {
                System.out.print("이름 점수 게임시간 입력>>");
                String name = scanner.next();

                if (name.equals("그만")) {
                    break;
                }

                int score = scanner.nextInt();
                int time = scanner.nextInt();
                ScoreInfo newInfo = new ScoreInfo(name, score, time);

                if (top3Map.containsKey(name)) {
                    top3Map.put(name, newInfo);
                } else if (top3Map.size() < 3) {
                    top3Map.put(name, newInfo);
                } else {
                    String minName = null;
                    int minScore = Integer.MAX_VALUE;

                    Iterator<Map.Entry<String, ScoreInfo>> it = top3Map.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, ScoreInfo> entry = it.next();
                        if (entry.getValue().score < minScore) {
                            minScore = entry.getValue().score;
                            minName = entry.getKey();
                        }
                    }

                    if (score > minScore) {
                        System.out.println("최하 점수의 " + minName + "이 삭제됨");
                        top3Map.remove(minName);
                        top3Map.put(name, newInfo);
                    } else {
                        System.out.println(name + "이 최하위이므로 톱3에 추가되지 못함");
                    }
                }

                ArrayList<ScoreInfo> view = new ArrayList<>(top3Map.values());
                Iterator<ScoreInfo> viewIt = view.iterator();
                while (viewIt.hasNext()) {
                    ScoreInfo info = viewIt.next();
                    System.out.print(info + " ");
                }
                System.out.println();
            }
        }
    }
}
