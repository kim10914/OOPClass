package chapter07;

import java.util.ArrayList;
import java.util.Scanner;

public class Assigment2_1 {
    // ArrayList 방식
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<ScoreInfo> list = new ArrayList<>();

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

                if (list.size() < 3) {
                    list.add(newInfo);
                } else {
                    int minIndex = 0;
                    for (int i = 1; i < list.size(); i++) {
                        if (list.get(i).score < list.get(minIndex).score) {
                            minIndex = i;
                        }
                    }

                    if (newInfo.score > list.get(minIndex).score) {
                        System.out.println("최하 점수의 " + list.get(minIndex).name + "이 삭제됨");
                        list.remove(minIndex);
                        list.add(newInfo);
                    } else {
                        System.out.println(newInfo.name + "이 최하위이므로 톱3에 추가되지 못함");
                    }
                }

                for (ScoreInfo info : list) {
                    System.out.print(info.toString() + " ");
                }
                System.out.println();
            }
        }
    }
}
