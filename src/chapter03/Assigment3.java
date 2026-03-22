package chapter03;

import java.util.Scanner;

public class Assigment3 {
    // 3. 실습문제 6번 수정. 프로그램이 시작되면 “단어입력”과 “단어검색”을 선택하도록 하는 출력문 실
    // 행. “단어입력” 선택 시 영어와 한글의 쌍으로 구성된 5개의 단어 쌍을 입력 받아 2차원 배열에 저장
    // 함. 2차원 배열이 다 채워지면 다시 “단어입력”과 “단어검색” 을 선택하도록 하는 출력문 실행.
    // ”단어검색” 선택 시 영어 단어를 입력 받아 매핑된 한글을 출력함. “exit”를 입력하면 프로그램을 종
    // 료함.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] dictionary = new String[5][2];
        boolean isDictFilled = false;

        System.out.println("단어장 프로그램을 시작합니다.");

        // 무한 루프를 돌며 사용자 메뉴 선택 처리
        loop: while (true) {
            System.out.print("\n원하시는 작업을 선택하세요 (단어입력, 단어검색, exit): ");
            String choice = scanner.next();

            switch (choice) {
                case "exit" -> {
                    System.out.println("프로그램을 종료합니다.");
                    break loop; // while 루프 종료
                }
                case "단어입력" -> {
                    System.out.println("영어 단어와 한글 뜻을 빈칸으로 분리하여 차례대로 입력하세요. (총 5쌍)");

                    // 5개의 단어 쌍 입력받아 2차원 배열에 저장
                    for (int i = 0; i < 5; i++) {
                        System.out.print("[단어 " + (i + 1) + "] 영어 한글 입력: ");
                        dictionary[i][0] = scanner.next(); // 영어 저장
                        dictionary[i][1] = scanner.next(); // 한글 저장
                    }

                    isDictFilled = true; // 배열이 다 채워짐을 표시
                    System.out.println("단어장 입력을 완료했습니다.");
                }
                case "단어검색" -> {
                    // 단어 검색 전 배열이 비어있는지 확인
                    if (!isDictFilled) {
                        System.out.println("단어장이 등록되어 있지 않습니다. '단어입력'을 먼저 수행해주세요.");
                        continue loop;
                    }

                    System.out.print("검색할 영어 단어를 입력하세요: ");
                    String searchWord = scanner.next();

                    // 검색어에 exit를 입력해도 프로그램 종료
                    if (searchWord.equals("exit")) {
                        System.out.println("프로그램을 종료합니다.");
                        break loop; // while 루프 종료
                    }

                    boolean isFound = false;
                    for (int i = 0; i < 5; i++) {
                        if (dictionary[i][0].equals(searchWord)) {
                            System.out.println(searchWord + "의 뜻은 " + dictionary[i][1] + "입니다.");
                            isFound = true;
                            break; // 해당 단어 발견 시 검색 종료
                        }
                    }

                    // 단어를 찾지 못한 경우
                    if (!isFound) {
                        System.out.println(searchWord + "는 사전에 없는 단어입니다.");
                    }
                }
                default -> System.out.println("알 수 없는 명령어입니다. 다시 선택해주세요.");
            }
        }

        scanner.close();
    }
}
