package chapter02;

import java.util.Scanner;

public class Assigment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요(초) : ");
        // 일, 시간, 분, 초 모두 계산
        int time = scanner.nextInt();
        int second = time % 60;
        int minute = time / 60;
        int hour = minute / 60;
        int day = hour / 24;

        System.out.printf("%d 일 : %d 시간 : %d 분 : %d 초\n", day, hour, minute, second);

        scanner.close();
    }
}
