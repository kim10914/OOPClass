package chapter07;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment3 {
    private static class Student {
        String studentId; // 학번
        String name; // 이름
        int attendance; // 출석
        int assignment; // 과제
        int midterm; // 중간고사 점수
        int finals; // 기말고사 점수
        double total; // 총점
        String grade; // 학점

        Student(String studentId, String name, int attendance, int assignment, int midterm, int finals) {
            this.studentId = studentId;
            this.name = name;
            this.attendance = attendance;
            this.assignment = assignment;
            this.midterm = midterm;
            this.finals = finals;
            this.total = attendance * 0.1 + assignment * 0.3 + midterm * 0.3 + finals * 0.3;
            this.grade = calculateGrade(this.total);
        }

        @Override
        public String toString() {
            return "학번: " + studentId
                    + ", 이름: " + name
                    + ", 출석: " + attendance
                    + ", 과제: " + assignment
                    + ", 중간: " + midterm
                    + ", 기말: " + finals
                    + ", 총점: " + String.format("%.1f", total)
                    + ", 학점: " + grade;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(); // 학생 정보를 저장할 리스트 선언

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("성적 입력(1), 개인 성적 조회(2), 전체 성적 조회(3), 개인 성적 삭제(4), 종료(5) >> ");
                int menu = readMenu(scanner);

                switch (menu) {
                    case 1 -> addStudent(scanner, students); // 학생 정보(성적) 추가
                    case 2 -> showOne(scanner, students); // 개인 성적 조회
                    case 3 -> showAll(students); // 전체 성적 조회
                    case 4 -> removeOne(scanner, students); // 개인 성적 삭제
                    case 5 -> {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default -> System.out.println("1~5 사이의 메뉴 번호를 입력하세요.");
                }
            }
        }
    }

    /**
     * 메뉴 번호를 읽는 메서드
     * 
     * @param scanner
     * @return
     */
    private static int readMenu(Scanner scanner) { // 스캐너로 메뉴 번호 입력을 읽음
        try {
            return Integer.parseInt(scanner.nextLine().trim()); // 메뉴 번호 입력을 정수로 변환
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * 학생 정보를 추가하는 메서드
     * 
     * @param scanner
     * @param students 학생 정보를 저장하는 리스트
     */
    private static void addStudent(Scanner scanner, ArrayList<Student> students) {
        System.out.print("학번: ");
        String studentId = scanner.nextLine().trim(); // 학번 입력

        if (studentId.isEmpty()) { // 학번이 비어 있을 경우
            System.out.println("학번은 비어 있을 수 없습니다.");
            return;
        }
        if (findById(students, studentId) != null) { // 이미 등록된 학번이 있는지 확인
            System.out.println("이미 등록된 학번입니다.");
            return;
        }

        System.out.print("이름: ");
        String name = scanner.nextLine().trim(); // 이름 입력
        if (name.isEmpty()) { // 이름이 비어 있을 경우
            System.out.println("이름은 비어 있을 수 없습니다.");
            return;
        }

        int attendance = readScore(scanner, "출석점수"); // 출석 점수 입력을 읽는 메서드 호출
        int assignment = readScore(scanner, "실습과제"); // 실습과제 점수 입력을 읽는 메서드 호출
        int midterm = readScore(scanner, "중간고사"); // 중간고사 점수 입력을 읽는 메서드 호출
        int finals = readScore(scanner, "기말고사"); // 기말고사 점수 입력을 읽는 메서드 호출

        Student student = new Student(studentId, name, attendance, assignment, midterm, finals); // 학생 정보 추가
        students.add(student); // 학생 리스트에 새 학생 객체 추가

        System.out.println("총점: " + String.format("%.1f", student.total)); // 소수점 한 자리 까지 출력
        System.out.println("학점: " + student.grade);
    }

    /**
     * 점수를 읽는 메서드
     * 
     * @param scanner
     * @param label   항목 이름(출석점수, 실습과제, 중간고사, 기말고사)
     * @return
     */
    private static int readScore(Scanner scanner, String label) {
        while (true) { // 사용자가 유효한 점수를 입력할 때까지 계속 반복
            System.out.print(label + ": ");
            String line = scanner.nextLine().trim();
            try {
                int score = Integer.parseInt(line); // 입력된 점수를 정수로 변환
                if (score < 0 || score > 100) { // 점수가 0~100 사이가 아닐 경우
                    System.out.println("점수는 0~100 사이여야 합니다.");
                    continue; // 유효하지 않은 점수 입력 시 다시 입력 받도록 반복
                }
                return score;
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력하세요.");
            }
        }
    }

    /**
     * 총점에 따른 학점을 계산하는 메서드
     * 
     * @param total 총점
     * @return
     */
    private static String calculateGrade(double total) {
        // 총점에 따라 학점을 계산하여 반환
        if (total >= 90) {
            return "A";
        }
        if (total >= 80) {
            return "B";
        }
        if (total >= 70) {
            return "C";
        }
        if (total >= 60) {
            return "D";
        }
        return "F";
    }

    /**
     * 학번으로 학생을 찾는 메서드
     * 
     * @param students
     * @param studentId
     * @return
     */
    private static Student findById(ArrayList<Student> students, String studentId) {
        for (Student student : students) { // 리스트 순회
            if (student.studentId.equals(studentId)) { // 학번 같음?
                return student;
            }
        }
        return null;
    }

    /**
     * 학번으로 학생 정보를 조회하는 메서드
     * 
     * @param scanner
     * @param students 학생 정보를 저장하는 리스트
     */
    private static void showOne(Scanner scanner, ArrayList<Student> students) {
        System.out.print("조회할 학번: ");
        String studentId = scanner.nextLine().trim();
        Student student = findById(students, studentId);

        if (student == null) { // 해당 학번의 학생이 없을 경우
            System.out.println("해당 학번의 학생이 없습니다.");
            return;
        }

        System.out.println(student); // 학생 정보 출력 (toString() autoCalled)
    }

    /**
     * 전체 학생 정보를 조회하는 메서드
     * 
     * @param students 학생 정보를 저장하는 리스트
     */
    private static void showAll(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("등록된 학생 정보가 없습니다.");
            return;
        }

        double sum = 0.0; // 총점 합계를 저장할 변수
        Student maxStudent = students.get(0); // 최고 점수를 가진 학생을 찾기 위해 첫 번째 학생으로 초기화
        Student minStudent = students.get(0); // 최저 점수를 가진 학생을 찾기 위해 첫 번째 학생으로 초기화

        System.out.println("[전체 성적 목록]"); // 전체 성적 목록 출력
        for (Student student : students) { // 학생 리스트 순회
            System.out.println(student);
            sum = sum + student.total; // 총점 합계 계산
            if (student.total > maxStudent.total) { // 현재 학생의 총점이 최고 점수보다 높을 경우
                maxStudent = student;
            }
            if (student.total < minStudent.total) { // 현재 학생의 총점이 최저 점수보다 낮을 경우
                minStudent = student;
            }
        }

        double average = sum / students.size(); // 평균 점수 계산 (총점 합계 / 학생 수)
        System.out.println("평균 점수: " + String.format("%.2f", average)); // 평균 점수 출력 (소수점 둘째 자리까지)
        System.out.println("최고 점수: " + maxStudent.name + "(" + String.format("%.1f", maxStudent.total) + ")");
        System.out.println("최저 점수: " + minStudent.name + "(" + String.format("%.1f", minStudent.total) + ")");
    }

    /**
     * 학번으로 학생 정보를 삭제하는 메서드
     * 
     * @param scanner
     * @param students
     */
    private static void removeOne(Scanner scanner, ArrayList<Student> students) {
        System.out.print("삭제할 학번: ");
        String studentId = scanner.nextLine().trim();
        Student student = findById(students, studentId); // 학번으로 학생을 찾는 메서드 호출

        if (student == null) { // 해당 학번의 학생이 없을 경우
            System.out.println("해당 학번의 학생이 없습니다.");
            return;
        }

        students.remove(student); // 학생 리스트에서 해당 학생 객체 제거
        System.out.println("삭제되었습니다: " + student.name + "(" + student.studentId + ")");
    }
}
