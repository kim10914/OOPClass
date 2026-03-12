package chapter02;

import java.util.Scanner;

public class Season17 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("월(1~12)을 입력하시오 : ");
            int month = sc.nextInt();

            switch (month) {
                case 3, 4, 5 -> System.out.println("봄");
                case 6, 7, 8 -> System.out.println("여름");
                case 9, 10, 11 -> System.out.println("가을");
                case 12, 1, 2 -> System.out.println("겨울");
                default -> System.out.println("잘못된 월입니다.");
            }
        }
    }
}
