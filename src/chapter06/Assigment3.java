package chapter06;

import java.util.Scanner;

public class Assigment3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            System.out.print("연속된 문자열을 입력하세요 (예: acccddffff): ");
            String input = scanner.nextLine();

            // 입력받은 문자열에서 공백 제거
            input = input.trim(); // a c c -> 공백까지 카운트 함
            // 만약, 문자열 입력을 A C C 이렇게 받으면
            // input = input.replace(" ", ""); // 문자열 내 공백 제거 이거가 더 좋음.

            // 예외 처리 (아무것도 입력하지 않았을 때)
            if (input.isEmpty()) {
                System.out.println("입력된 문자가 없습니다.");
                scanner.close();
                return;
            }

            char currentChar = input.charAt(0); // 첫번째 문자
            int count = 1; // 카운트

            for (int i = 1; i < input.length(); i++) { // 길이 만큼 1부터 반복
                char nextChar = input.charAt(i); // 다음 문자

                if (currentChar == nextChar) {
                    // 이전 문자와 같으면 카운트 증가
                    count++;
                } else {
                    // 다르면 여태까지 센 문자와 개수 출력 (줄바꿈 없이 이어서)
                    System.out.print(currentChar + " : " + count + "개, ");
                    // 새로운 문자로 갱신하고 카운트 초기화
                    currentChar = nextChar;
                    count = 1;
                }
            }

            // 마지막으로 모인 문자와 개수 출력
            System.out.println(currentChar + " : " + count + "개");
        } catch (Exception e) {
            System.out.println("오류: 잘못된 입력입니다.");
        }
    }
}
