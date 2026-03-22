package chapter03;

import java.util.InputMismatchException; // 정수 입력이 아닐 경우.
import java.util.Scanner;

public class Assigment1 {
        public static void main(String[] args) {
//            1. 정수 배열에서 최댓값과 최솟값을 찾는 프로그램을 작성하시오. 단, 배열의 크기는 가변적이며 프
//            로그램 실행 인자로 받아들임. 배열의 크기에 맞춰 배열의 원소에 저장할 값들을 입력 받아 저장하
//            고 저장된 값들을 먼저 출력한 후 최댓값 및 최솟값을 출력하도록 함. 정수가 아닌 문자가 입력되면
//            다시 입력 받도록 처리함. 음수도 허용되며 예외 처리를 포함하여야 함.
            // 프로그램 실행 인자로 배열의 크기 받기
        if (args.length == 0) {
            System.out.println("실행 인자로 배열의 크기를 입력해주세요.");
            return;
        }

        int size;
        try {
            size = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("배열의 크기로 올바른 정수를 입력해주세요.");
            return;
        }

        if (size <= 0) {
            System.out.println("배열의 크기는 양의 정수이어야 합니다.");
            return;
        }

        // 배열 생성
        int[] array = new int[size];
        Scanner scanner = new Scanner(System.in);

        System.out.println(size + "개의 정수를 입력하세요:");

        // 배열의 크기에 맞춰 값 입력받기
        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    array[i] = scanner.nextInt();
                    break; // 정상적으로 입력되면 루프 탈출
                } catch (InputMismatchException e) {
                    // 정수가 아닌 값 입력에 대한 예외 처리
                    System.out.println("정수가 아닌 값이 입력되었습니다. 다시 입력해주세요.");
                    scanner.next(); // 잘못된 입력 버퍼에서 제거
                }
            }
        }

        // 저장된 값들 먼저 출력
        System.out.print("입력된 배열의 값: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); // 줄바꿈

        // 최댓값 및 최솟값 찾기
        int max = array[0];
        int min = array[0];

        for (int i = 1; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        // 최댓값 및 최솟값 출력
        System.out.println("최댓값: " + max);
        System.out.println("최솟값: " + min);

        scanner.close();
    }
}