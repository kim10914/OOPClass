package chapter06;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Assigment4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            System.out.print("수식을 입력하세요 (예: 10 + 20 - 50): ");
            String input = scanner.nextLine();

            // 예시에 포함된 유니코드 대시(–)를 표준 마이너스(-) 기호로 변환
            input = input.replace("–", "-");

            // StringTokenizer를 생성할 때 3번째 인자를 true로 주면 구분자(+, -)도 토큰으로 반환
            StringTokenizer st = new StringTokenizer(input, "+-", true);

            int result = 0;

            // 첫 번째 토큰(숫자)을 가져와 result에 초기화
            if (st.hasMoreTokens()) {
                result = Integer.parseInt(st.nextToken().trim());
            }

            // 남은 토큰들을 순회하며 연산 수행
            while (st.hasMoreTokens()) {
                // 연산자 추출
                String operator = st.nextToken().trim();

                // 그 다음 토큰(숫자) 추출
                if (st.hasMoreTokens()) {
                    int nextNumber = Integer.parseInt(st.nextToken().trim());

                    // 연산자에 맞게 계산 적용
                    if (operator.equals("+")) {
                        result += nextNumber;
                    } else if (operator.equals("-")) {
                        result -= nextNumber;
                    }
                }
            }

            System.out.println("결과: " + result);
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 값(문자, 띄어쓰기된 숫자 등)이 들어왔을 때의 처리
            System.out.println("오류: 수식에 잘못된 숫자 형식이 포함되어 있습니다. (예: 띄어쓰기 오류, 문자 포함)");
        }
    }
}
