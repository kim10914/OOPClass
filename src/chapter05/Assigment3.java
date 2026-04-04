package chapter05;

import java.util.Scanner;

// 사칙연산별 인터페이스 정의
interface AddInterface { // 덧샘
    double add(double a, double b);
}

interface SubtractInterface { // 뺄샘
    double subtract(double a, double b);
}

interface MultiplyInterface { // 곱샘
    double multiply(double a, double b);
}

interface DivideInterface { // 나눗샘
    double divide(double a, double b);
}

// 4개의 인터페이스를 모두 구현(다중 구현)하는 클래스
class Calculator implements AddInterface, SubtractInterface, MultiplyInterface, DivideInterface {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("오류: 0으로 나눌 수 없습니다.");
            return Double.NaN; // NaN : Not a Number(숫자가 아님) -> 정상적인 숫자가 아님을 Return
        }
        return a / b;
    }
}

public class Assigment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("계산기 프로그램을 시작합니다.");
        System.out.println("종료하시려면 'exit'를 입력하세요.\n");

        while (true) {
            System.out.print("식 입력 (띄어쓰기 포함, 예: 10 + 20): ");
            String input = scanner.next();

            // 종료 검사
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            try {
                // 띄어쓰기로 구분된 숫자, 연산자, 숫자를 가져옵니다
                double a = Double.parseDouble(input);
                String operator = scanner.next();
                double b = scanner.nextDouble();

                double result = 0;
                boolean isValid = true;

                switch (operator) {
                    case "+":
                        result = calc.add(a, b);
                        break;
                    case "-":
                        result = calc.subtract(a, b);
                        break;
                    case "*":
                        result = calc.multiply(a, b);
                        break;
                    case "/":
                        result = calc.divide(a, b);
                        break;
                    default:
                        System.out.println("오류: 올바르지 않은 연산자입니다.");
                        isValid = false;
                }

                // 결과가 정상적으로 계산되었을 경우
                if (isValid && !Double.isNaN(result)) {
                    // 정수형으로 표현 가능한지 확인하고 출력
                    if (result == (long) result) {
                        System.out.printf("결과: %d\n\n", (long) result);
                    } else {
                        System.out.printf("결과: %.2f\n\n", result);
                    }
                }
            } catch (Exception e) {
                System.out.println("입력 형식이 잘 못 됬었습니다.\n");
                // 잘못된 입력이 들어온 경우 버퍼를 비워줌
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
