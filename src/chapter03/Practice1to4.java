package chapter03;

import java.util.Scanner;

public class Practice1to4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 영문 소문자를 하나 입력받고 그 문자보다 알파벳 순위가 낮은 모든 문자를 출력
        System.out.print("알파벳 한 문자를 입력하세요 >> ");
        char c = sc.next().charAt(0);
        for (char i = 'a'; i <= c; i++) {
            for (char j = i; j <= c; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        // 2. 정수를 10개 입력받아 배열에 저장한 후, 배열을 검색하여 3의 배수만 골라 출력
        System.out.print("정수를 10개 입력 >> ");
        int[] arr = new int[10];
        // 배열에 정수를 입력
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // 배열을 검색하여 3의 배수만 골라 출력
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0) {
                System.out.print(arr[i] + " ");
            }
        }

        // 3. 정수를 입력 받아 "짝"또는 "홀"출력 정수 입력 없으면 예외 처리
        try {
            System.out.print("정수를 입력하세요 >> ");
            int num = sc.nextInt();
            if (num % 2 == 0) {
                System.out.println("짝수");
            } else {
                System.out.println("홀수");
            }
        } catch (Exception e) {
            System.err.println("정수를 입력하지 않아 프로그램 종료합니다.");
            System.exit(0);
        } finally {
            // sc.close();
        }
        
        // 4. 일주일로 초기화된 문자 배열

        sc.close();
    }
}
