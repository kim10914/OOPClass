package chapter02;

import java.util.Scanner;

public class Assigment4 {
    public static void main(String[] args) {
        // 정수 하나 입력으로 아래를 판단
        // 양수 / 음수, 홀수 / 짝수, 3의 배수 여부, 7의 배수 여부, 두자리 수인지 여부
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int number = sc.nextInt();

        // 양수 / 음수 판단
        if (number > 0) {
            System.out.println("양수");
        } else if (number < 0) {
            System.out.println("음수");
        } else {
            System.out.println("0");
        }

        // 홀수 / 짝수 판단
        if (number % 2 == 0) {
            System.out.println("짝수");
        } else {
            System.out.println("홀수");
        }

        // 3의 배수 판단
        if (number % 3 == 0) {
            System.out.println("3의 배수");
        }else{
            System.out.println("3의 배수가 아닙니다."); 
        }

        // 7의 배수 판단
        if (number % 7 == 0) {
            System.out.println("7의 배수");
        }else{
            System.out.println("7의 배수가 아닙니다.");
        }

        // 두자리 수 판단
        if (number >= 10 && number <= 99) {
            System.out.println("두자리 수");
        }else{
            System.out.println("두자리 수가 아닙니다.");
        }

    }
}
