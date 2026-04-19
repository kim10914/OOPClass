package chapter07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Assignment2_1 {
    // ArrayList 방식
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<ScoreInfo> list = new ArrayList<>();

            System.out.println("*** 게임 톱3 관리 프로그램입니다. ***");

            while (true) {
                System.out.print("이름 점수 게임시간 입력(종료 : 그만)>>");
                String name = scanner.next();

                if (name.equals("그만")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                int score = scanner.nextInt(); // 점수
                int time = scanner.nextInt(); // 시간
                ScoreInfo newInfo = new ScoreInfo(name, score, time); // 새 점수 정보 생성
                
                // 리스트에 새 점수 정보 추가
                if (list.size() < 3) { // 톱3 미만인 경우 바로 추가
                    list.add(newInfo);
                } else {
                    int minIndex = 0;
                    for (int i = 1; i < list.size(); i++) {
                        if (list.get(i).score < list.get(minIndex).score) {
                            minIndex = i;
                        }
                    }

                    if (newInfo.score > list.get(minIndex).score) { // 새 점수가 최하 점수보다 높은 경우
                        System.out.println("최하 점수의 " + list.get(minIndex).name + "이 삭제됨");
                        list.remove(minIndex);
                        list.add(newInfo);
                    } else {
                        System.out.println(newInfo.name + "이 최하위이므로 톱3에 추가되지 못함");
                    }
                }

                Iterator<ScoreInfo> it = list.iterator(); // 리스트의 점수 정보 출력
                while (it.hasNext()) { // 리스트에 점수 정보가 남아있는 동안
                    ScoreInfo info = it.next();
                    System.out.print(info.toString() + " ");
                }
                System.out.println();
            }
        }
    }
}
