package chapter04;

import java.util.Scanner;

public class Assigment2 {
    public static void main(String[] args) {
        // 계좌를 배열로 관리하기
        Account[] accountArray = new Account[10];

        accountArray[0] = new Account("111-111", "홍길동", 10000);
        accountArray[1] = new Account("222-222", "김철수", 30000);

        int accountCount = 2;

        try (Scanner sc = new Scanner(System.in);) {
            work: while (true) {
                System.out.println("\n----- 반갑습니다. 강원 은행 입니다. 아래에서 업무를 선택해 주세요. -----");
                System.out.println("1. 입금 | 2. 출금 | 3. 특정 계좌 잔액조회 | 4. 전체 계좌 목록 | 5. 종료");
                System.out.print("메뉴 번호 선택 >> ");
                int menu = sc.nextInt();
                sc.nextLine(); // 버퍼 비워주기 (개행 문자를 입력을 받음)

                switch (menu) {
                    case 5 -> {
                        System.out.println("은행 시스템을 종료합니다.");
                        break work;
                    }
                    case 4 -> {
                        System.out.println("\n 가입된 전체 계좌 목록 : ");
                        for (int i = 0; i < accountCount; i++) {
                            accountArray[i].printAccountInfo();
                        }
                        continue work;
                    }
                    case 1, 2, 3 -> {
                        // 계좌 찾기 우선 실행
                        System.out.print("\n찾으실 계좌번호를 입력하세요 >>");
                        String searchAccNo = sc.nextLine();

                        Account foundAccount = null;
                        for (int i = 0; i < accountCount; i++) {
                            if (accountArray[i].getAccount().equals(searchAccNo)) {
                                foundAccount = accountArray[i];
                                break;
                            }
                        }
                        if (foundAccount == null) {
                            System.out.println("일치하는 계좌번호가 없습니다.");
                            continue work;
                        }

                        // 계좌를 찾은 경우
                        if (menu == 1) { // 입금 처리
                            System.out.print("입금하실 금액 >> ");
                            int amount = Integer.parseInt(sc.nextLine()); // int 읽은 후, 씹힘을 방지하기 위해 문자열로 우선 받고 int 객체로 파싱
                            foundAccount.deposit(amount);
                        } else if (menu == 2) { // 출금 처리
                            System.out.print("출금하실 금액 >> ");
                            int amount = Integer.parseInt(sc.nextLine());
                            foundAccount.withdraw(amount);
                        }
                        foundAccount.printAccountInfo(); // 거래 후 계좌 정보 출력
                    }
                    default -> System.out.println("1~5 사이의 번호를 선택해주세요.");
                }

            }

        } catch (NumberFormatException e) {
            System.err.println("올바른 숫자로만 입력해 주세요.");
        }

    }
}
