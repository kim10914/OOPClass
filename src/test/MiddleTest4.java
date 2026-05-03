import java.util.StringTokenizer;

public class MiddleTest4{ // 6장 실습
    public static void main(String[] args) {
        // String을 통한 == 비교와 equals 비교 차이
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        System.out.println(s1 == s2); // true, 문자열 리터럴은 상수 풀에서 공유됨
        System.out.println(s1 == s3); // false, new 키워드로 생성된 객체는 별도의 메모리 공간을 차지함
        System.out.println(s1.equals(s3)); // true, equals 메서드는 문자열의 내용을 비교함

        // Wrapper 클래스의 박싱과 언박싱
        Integer i = Integer.valueOf(10); // 박싱: 기본형 int를 Integer 객체로 변환
        int j = i.intValue(); // 언박싱: Integer 객체를 기본형 int로 변환
        System.out.println(i); // 10
        System.out.println(j); // 10
        System.out.println(i == 10); // true, 자동 언박싱이 일어나서 비교됨
        System.out.println(i.equals(10)); // true, equals 메서드는 값을 비교함

        // StringBuffer와 StringBuilder의 차이
        StringBuffer sb1 = new StringBuffer("Hello"); // StringBuffer는 동기화되어 있어 멀티스레드 환경에서 안전
        StringBuilder sb2 = new StringBuilder("Hello"); // StringBuilder는 동기화되지 않아 단일 스레드 환경에서 더 빠름
        sb1.append(" World"); // StringBuffer는 동기화되어 있어 멀티스레드 환경에서 안전하지만, StringBuilder는 동기화되지 않아 단일 스레드 환경에서 더 빠름
        sb2.append(" World"); // StringBuilder는 동기화되지 않아 단일 스레드 환경에서 더 빠름
        System.out.println(sb1.toString()); // Hello World
        System.out.println(sb2.toString()); // Hello World

        // StringTokenizer 클래스의 사용
        String str = "Java,Python,C++"; // 쉼표로 구분된 문자열
        StringTokenizer st = new StringTokenizer(str, ","); // 구분자 ","를 사용하여 문자열을 토큰으로 분리
        while (st.hasMoreTokens()) { // 토큰이 더 있는지 확인
            System.out.println(st.nextToken()); // Java, Python, C++ 각각 출력
        }
        
        // java.lang.Math 패키지의 주요 클래스들
        double num1 = 5.5;
        double num2 = 2.3;
        System.out.println(Math.max(num1, num2)); // 5.5, 두 수 중 큰 값
        System.out.println(Math.min(num1, num2)); // 2.3, 두 수 중 작은 값
        System.out.println(Math.sqrt(num1)); // 2.345207879911715, num1의 제곱근
        System.out.println(Math.pow(num1, num2)); // 39.768, num1의 num2 제곱
        System.out.println(Math.abs(-5.5)); // 5.5, 절대값
    }
    
}
