package chapter03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Assigment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        System.out.println("10개의 양수를 입력하여 합산합니다. (양수 이외의 값은 무시됩니다)");

        while (count < 10) {
            System.out.print((count + 1) + "번째 양수 입력: ");
            
            try {
                int num = scanner.nextInt();
                
                if (num > 0) {
                    sum += num;
                    count++; // 정상적인 양수 1개가 입력되었을 때만 카운트 증가
                } else {
                    System.out.println("음수 또는 0이 입력되었습니다. 무시하고 다시 입력받습니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 형식(문자 등)이 입력되었습니다. 무시하고 다시 입력받습니다.");
                scanner.next(); // 잘못된 입력을 버퍼에서 제거
            }
        }

        System.out.println("\n입력된 10개 양수의 총합: " + sum);
        scanner.close();
    }
}
