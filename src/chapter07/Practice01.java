package chapter07;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Practice01 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("5개의 실수를 입력하세요 : ");
            Vector<Double> numbers = new Vector<>(); // 실수를 저장할 벡터

            try {
                // 5개의 실수를 입력받아 벡터에 저장
                for (int i = 0; i < 5; i++) {
                    numbers.add(sc.nextDouble());
                }
                // 벡터가 비어있는지 확인
                if (numbers.isEmpty()) {
                    throw new IllegalStateException("입력된 숫자가 없습니다.");
                }
                // 벡터에서 가장 큰 실수를 찾기
                Double max = numbers.get(0);
                for (Double n : numbers) {
                    if (n > max) {
                        max = n;
                    }
                }

                System.out.println("가장 큰 실수는 : " + max);
            } catch (InputMismatchException e) {
                System.out.println("실수만 입력해야 합니다.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

