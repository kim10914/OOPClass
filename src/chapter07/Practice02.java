package chapter07;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
        ArrayList<String> grades = new ArrayList<>();
        ArrayList<Double> scores = new ArrayList<>();

        try(Scanner sc = new Scanner(System.in)){
            System.out.print("빈 칸으로 분리하여 5 개의 학점을 입력(A/B/C/D/F) : ");
            for (int i = 0; i < 5; i++) {
                String grade = sc.next().toUpperCase();
                if (!grade.matches("[ABCDF]")) { // 유효한 학점인지 확인
                    throw new IllegalArgumentException("유효한 학점이 아닙니다: " + grade);
                }
                grades.add(grade);
            }
            // 입력된 학점을 숫자로 표현 (A=4, B=3, C=2, D=1, F=0)
            for (String grade : grades) {
                switch (grade) {
                    case "A":
                        scores.add(4.0);
                        break;
                    case "B":
                        scores.add(3.0);
                        break;
                    case "C":
                        scores.add(2.0);
                        break;
                    case "D":
                        scores.add(1.0);
                        break;
                    case "F":
                        scores.add(0.0);
                        break;
                }
            }
            // 입력된 학점과 숫자 점수 출력
            for (double score : scores) {
                System.out.print(score + " ");
            }
            System.out.println();
        }
    }
}
