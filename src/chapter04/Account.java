package chapter04;

// 과제 2번 은행 객체
class Account {
    private String account;
    private String name;
    private int balance;

    public Account(String account, String name, int balance) {
        this.account = account;
        this.name = name;
        this.balance = balance;
    }

    // 배열에서 계좌 찾기 getter
    public String getAccount() {
        return account;
    }

    // 입금
    public void deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println(amount + "원이 입금되었습니다.");
        } else {
            System.out.println("입금액은 0보다 커야 합니다.");
        }
    }

    // 출금
    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
        } else if (amount <= 0) {
            System.out.println("출금액은 0보다 커야 합니다.");
        } else {
            balance = balance - amount;
            System.out.println(amount + "원이 출금되었습니다.");
        }
    }

    // 거래 후 계좌 정보 출력 (잔액)
    public void printAccountInfo() {
        System.out.println("-----------------------------------");
        System.out.println("계좌 번호 : " + account);
        System.out.println("예금주 : " + name);
        System.out.println("잔액 : " + balance);
        System.out.println("-----------------------------------");
    }

}