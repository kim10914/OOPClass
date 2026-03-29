package chapter04;

import java.util.Scanner;

public class Assigment1 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            System.out.println("이름, 직업, 나이, 성별, 혈액형을 차례대로 작성해주세요.");

            // 정보 입력
            System.out.print("이름: ");
            String name = sc.nextLine();
            System.out.print("직업: ");
            String job = sc.nextLine();
            System.out.print("나이: ");
            int age = sc.nextInt();
            sc.nextLine(); // nextInt() 다음에 nextLine()을 호출하면 버퍼에 남아있는 개행 문자를 읽어서 성별을 건너 뛰는 오류 발생
            System.out.print("성별: ");
            String gender = sc.nextLine();
            System.out.print("혈액형: ");
            String bloodType = sc.nextLine();

            // 입력 받은 정보로 객체 생성
            Person person = new Person(name, job, age, gender, bloodType);

            // 객체 정보 출력
            System.out.println("--- 입력된 정보 ---");
            System.out.println("이름: " + person.getName());
            System.out.println("직업: " + person.getJob());
            System.out.println("나이: " + person.getAge());
            System.out.println("성별: " + person.getGender());
            System.out.println("혈액형: " + person.getBloodType());

        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }

    }
}