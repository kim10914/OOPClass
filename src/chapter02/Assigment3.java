package chapter02;

import java.util.Scanner;

public class Assigment3 {
    public static void main(String[] args) {
        System.out.print("이름, 학번, 학점, 학년을 입력하시오. : ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int studentNumber = sc.nextInt();
        double grade = sc.nextDouble();
        int year = sc.nextInt();

        // 4학년은 4.0 이상 장학금 대상, 1~3학년은 3.8이상 장학금 대상(switch -> 로)
        switch (year) {
            case 4 -> {
                if (grade >= 4.0) {
                    System.out.println(studentNumber + "_" + name + "님은 장학금 대상자입니다.");
                } else {
                    System.out.println(studentNumber + "_" + name + "님은 장학금 대상자가 아닙니다.");
                }
            }
            case 1, 2, 3 -> {
                if (grade >= 3.8) {
                    System.out.println(studentNumber + "_" + name + "님은 장학금 대상자입니다.");
                } else {
                    System.out.println(studentNumber + "_" + name + "님은 장학금 대상자가 아닙니다.");
                }
            }
            default -> System.out.println("잘못된 학년입니다.");
        }
        sc.close();
    }
}
