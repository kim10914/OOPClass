package chapter02;

import java.util.Scanner;

public class practice6to10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 6. 돈의 액수를 입력받아 잔돈 계산하는 greedy 알고리즘 구현
        System.out.printf("돈의 액수를 입력하세요>>");
        int money = sc.nextInt();

        if (money >= 50000) {
            System.out.printf("50000원: %d개\n", money / 50000);
            money %= 50000;
        }
        if (money >= 10000) {
            System.out.printf("10000원: %d개\n", money / 10000);
            money %= 10000;
        }
        if (money >= 5000) {
            System.out.printf("5000원: %d개\n", money / 5000);
            money %= 5000;
        }
        if (money >= 1000) {
            System.out.printf("1000원: %d개\n", money / 1000);
            money %= 1000;
        }
        if (money >= 500) {
            System.out.printf("500원: %d개\n", money / 500);
            money %= 500;
        }
        if (money >= 100) {
            System.out.printf("100원: %d개\n", money / 100);
            money %= 100;
        }
        if (money >= 50) {
            System.out.printf("50원: %d개\n", money / 50);
            money %= 50;
        }
        if (money >= 10) {
            System.out.printf("10원: %d개\n", money / 10);
            money %= 10;
        }
        if (money >= 5) {
            System.out.printf("5원: %d개\n", money / 5);
            money %= 5;
        }
        if (money >= 1) {
            System.out.printf("1원: %d개\n", money / 1);
            money %= 1;
        }

        // 7. 학점이 A, B이면, "Excellent", C, D이면, "Good", F이면"Bye"를 출력 switch brea 사용
        System.out.printf("학점을 입력하세요>>");
        char grade = sc.next().charAt(0); // nextchar()가 없음
        switch (grade) {
            case 'A':
            case 'B':
                System.out.println("Excellent");
                break;
            case 'C':
            case 'D':
                System.out.println("Good");
                break;
            case 'F':
                System.out.println("Bye");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }

        // 8. 에스프레소 2000원, 아메리카노 2500원, 카푸치노 3000원, 카페라떼 3500원. 입력 ex : 카푸치노 3 -> 9000원
        // 입니다.
        // (1) if문 활용. equals() 사용
        System.out.printf("커피 주문하세요>>");
        String coffee1 = sc.next();
        int count1 = sc.nextInt();
        if (coffee1.equals("에스프레소")) {
            System.out.println(count1 * 2000 + "원입니다.");
        } else if (coffee1.equals("아메리카노")) {
            System.out.println(count1 * 2500 + "원입니다.");
        } else if (coffee1.equals("카푸치노")) {
            System.out.println(count1 * 3000 + "원입니다.");
        } else if (coffee1.equals("카페라떼")) {
            System.out.println(count1 * 3500 + "원입니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }

        // (2) switch문 활용
        System.out.printf("커피 주문하세요>>");
        String coffee = sc.next();
        int count = sc.nextInt();
        switch (coffee) {
            case "에스프레소":
                System.out.println(count * 2000 + "원입니다.");
                break;
            case "아메리카노":
                System.out.println(count * 2500 + "원입니다.");
                break;
            case "카푸치노":
                System.out.println(count * 3000 + "원입니다.");
                break;
            case "카페라떼":
                System.out.println(count * 3500 + "원입니다.");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }

        // 9. 1~99 정수 입력 받고 3,6,9 중 하나가 있는 경우 "박수짝", 두개 있는 경우 "박수짝짝" 없으면 "박수없음"을 출력
        // ex : 13 -> "박수짝", 36 -> "박수짝짝", 5인 경우 "박수없음"
        System.out.printf("1~99 정수를 입력하세요>>");
        int num = sc.nextInt();
        if (num % 3 == 0 && num % 6 == 0 && num % 9 == 0) {
            System.out.println("박수짝짝짝");
        } else if (num % 3 == 0 && num % 6 == 0) {
            System.out.println("박수짝짝");
        } else if (num % 3 == 0 && num % 9 == 0) {
            System.out.println("박수짝짝");
        } else if (num % 6 == 0 && num % 9 == 0) {
            System.out.println("박수짝짝");
        } else if (num % 3 == 0) {
            System.out.println("박수짝");
        } else if (num % 6 == 0) {
            System.out.println("박수짝");
        } else if (num % 9 == 0) {
            System.out.println("박수짝");
        } else {
            System.out.println("박수없음");
        }

        // 10. 에스프레소 2000원, 아메리카노 2500원, 카푸치노 3000원, 카페라떼 3500원이며, 에스프레소의 경우 10잔 이상을
        // 주문하면 5% 할인
        System.out.printf("커피 주문하세요>>");
        String coffee2 = sc.next();
        int count2 = sc.nextInt();
        switch (coffee2) {
            case "에스프레소" -> {
                if (count2 >= 10) {
                    System.out.println(count2 * 2000 * 0.95 + "원입니다.");
                } else {
                    System.out.println(count2 * 2000 + "원입니다.");
                }
            }
            case "아메리카노" -> System.out.println(count2 * 2500 + "원입니다.");
            case "카푸치노" -> System.out.println(count2 * 3000 + "원입니다.");
            case "카페라떼" -> System.out.println(count2 * 3500 + "원입니다.");
            default -> System.out.println("잘못된 입력입니다.");
        }
    }
}
