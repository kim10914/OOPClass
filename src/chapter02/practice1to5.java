package chapter02;

import java.util.Scanner;

public class practice1to5 {
    public static void main(String[] args) {
        // 1. 두 정수를 입력받아 합을 구하여 출력하는 프로그램을 작성 (Scanner 객체 이용)
        System.out.printf("두 정수를 입력하세요 >>");

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.printf("%d + %d은 %d\n", a, b, a + b);

        // sc.close();

        // 2. 한 층의 높이가 5m일 때, 건물이 몇 층인지 입력받아 높이를 출력하라.
        System.out.printf("건물의 층수를 입력하세요 >>");
        int floor = sc.nextInt();
        System.out.printf("%dm입니다.\n", floor * 5);

        // 3. x 값을 입력받아 y = x^2 - 3x + 7계산하여 y 값을 출력하는 프로그램을 작성.
        System.out.printf("x 값을 입력하세요 >>");
        int x = sc.nextInt();
        int y = x * x - 3 * x + 7;
        System.out.printf("y = %d\n", y);

        // 4. (50, 50)과 (100, 100)의 두 점으로 이루어진 사각형이 있을 때, 한 점을 구하는 정수
        // x와 y 값을 입력받고 점(x,y)가 이 직사각형 않에 있는지 판별하는 프로그램을 작성
        System.out.printf("점(x,y)의 좌표를 입력하세요>>");
        int x4 = sc.nextInt();
        int y4 = sc.nextInt();
        if (x4 >= 50 && x4 <= 100 && y4 >= 50 && y4 <= 100) {
            System.out.println("점(" + x4 + "," + y4 + ")가 (50,50)과 (100,100)의 사각형 내에 있습니다.");
        } else {
            System.out.println("점(" + x4 + "," + y4 + ")가 (50,50)과 (100,100)의 사각형 내에 있지 않습니다.");
        }

        // 5. 다음과 같이 AND와 OR의 논리 연산을 입력받아 결과를 출력하는 프로그램을 작성하라. (입력 : true OR false ->
        // true)
        // if 대신 switch 이용.
        System.out.printf("논리 연산을 입력하세요>>");
        boolean a5 = sc.nextBoolean();
        String op = sc.next();
        boolean b5 = sc.nextBoolean();

        boolean result = switch (op) {
            case "AND" -> a5 && b5;
            case "OR" -> a5 || b5;
            default -> {
                System.out.println("잘못된 입력입니다.");
                yield false; // false를 예외처리
            }
        };
        System.out.println(result);
    }
}
