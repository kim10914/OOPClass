package test;

public class MiddleTest2 { // 예외 처리 학습
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        // 1. 기본 try-catch
        try {
            int result = 100 / 0;
            System.out.println("결과: " + result);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다: " + e.getMessage());
        }

        // 2. 여러 catch 블록
        try {
            System.out.println(numbers[5]);
        } catch (ArithmeticException e) { // 산술 예외
            System.out.println("산술 예외: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) { // ㅈㄴ 기네
            System.out.println("배열 범위 초과: " + e.getMessage());
        } catch (Exception e) { // Exception은 아래에 쓰기
            System.out.println("기타 예외: " + e.getMessage());
        }

        // 3. try-catch-finally
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("null 참조 예외 발생");
        } finally {
            System.out.println("finally 블록은 항상 실행됩니다.");
        }

        // 4. throw로 직접 예외 발생
        try {
            int age = -5;
            if (age < 0) {
                throw new IllegalArgumentException("나이는 음수일 수 없습니다: " + age);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 인자: " + e.getMessage());
        }

        System.out.println("프로그램이 정상 종료되었습니다.");
    }
}
