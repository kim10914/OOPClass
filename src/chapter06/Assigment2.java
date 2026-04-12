package chapter06;

class Member {
    private String name; // 이름
    private String id; // 아이디
    private String password; // 비밀번호

    // 생성자: 회원 정보를 매개변수로 전달받아 필드 초기화
    public Member(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    // 아이디만 같으면 같은 회원으로 판별 (원래는 주소값 비교)
    @Override
    public boolean equals(Object obj) {
        // 자기 자신과 비교하는 경우
        if (this == obj)
            return true;

        // null이거나 상속 등으로 인해 타입이 다른 경우 false
        if (obj == null || getClass() != obj.getClass())
            return false;

        // Member 타입으로 형변환 후 아이디 비교 (문자열 등 참조형은 .equals() 사용)
        Member member = (Member) obj;
        if (this.id == null) {
            return member.id == null;
        }
        return this.id.equals(member.id);
    }

    // 이름과 아이디만 출력하도록 재정의 (원래는 주소값 출력 - Object에 정의된 메서드 이며, 객체를 문자열로 표현)
    @Override
    public String toString() {
        return "Member [이름=" + name + ", 아이디=" + id + "]";
    }
}

public class Assigment2 {
    public static void main(String[] args) {
        Member m1 = new Member("홍길동", "user123", "passwd01");
        Member m2 = new Member("김철수", "user123", "passwd02"); // m1과 아이디는 같고 이름, 비밀번호 다름
        Member m3 = new Member("이영희", "user456", "passwd01"); // m1과 비밀번호는 같고 아이디, 이름 다름

        // toString() 오버라이딩 확인
        System.out.println("m1 정보: " + m1.toString());
        System.out.println("m2 정보: " + m2); // println 안에서는 자동으로 toString() 호출
        System.out.println("m3 정보: " + m3);

        System.out.println();

        // equals() 오버라이딩 확인 (아이디 비교)
        System.out.println("m1과 m2는 같은 회원인가요? " + m1.equals(m2)); // true (아이디 동일)
        System.out.println("m1과 m3은 같은 회원인가요? " + m1.equals(m3)); // false (아이디 다름)
    }
}
