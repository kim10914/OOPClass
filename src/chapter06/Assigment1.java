package chapter06;

public class Assigment1 {
    public static void main(String[] args) {
        String data = "15, 3;40 50";
        
        // 쉼표(,), 공백( ), 세미콜론(;)을 구분자로 사용하여 split
        String[] tokens = data.split("[,\\s;]+");
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (String token : tokens) {
            int num = Integer.parseInt(token);
            sum += num;
            
            // Math 클래스를 사용하여 최대값, 최소값 구하기
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        double average = (double) sum / tokens.length;
        
        System.out.println("합: " + sum);
        System.out.println("평균: " + average);
        System.out.println("최대값: " + max);
        System.out.println("최소값: " + min);
    }
}
