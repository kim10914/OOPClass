package chapter05;

public class Assigment1 { // PersonEx 객체 지만, 컨벤션 상 Assigment로 작성
    public static void main(String[] args) {
        // Person 객체 생성 및 출력
        System.out.println("====== Person ======");
        Person person = new Person("홍길동", 45);
        person.describe();
        person.speak();
        person.eat();

        // Student 객체 생성 및 출력
        System.out.println("\n====== Student ======");
        Student student = new Student("김철수", 20, "한국대학교", 2);
        student.describe();
        student.study();

        // StudentWorker 객체 생성 및 출력
        System.out.println("\n====== StudentWorker ======");
        StudentWorker worker = new StudentWorker("이영희", 24, "대한대학교", 4, "우리카페", 150);
        worker.describe();
        worker.work();

        // Researcher 객체 생성 및 출력
        System.out.println("\n====== Researcher ======");
        Researcher researcher = new Researcher("박지민", 32, "미래AI연구원", "머신러닝");
        researcher.describe();
        researcher.research();

        // Professor 객체 생성 및 출력
        System.out.println("\n====== Professor ======");
        Professor professor = new Professor("최동훈", 55, "생명공학연구소", "유전자편집", "글로벌대학교", "정교수");
        professor.describe();
        professor.teach();
    }
}
