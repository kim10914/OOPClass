package chapter05;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void describe() {
        System.out.println("이름: " + name + ", 나이: " + age);
    }

    public void speak() {
        System.out.println("말하기");
    }

    public void eat() {
        System.out.println("먹기");
    }

    public void walk() {
        System.out.println("걷기");
    }

    public void sleep() {
        System.out.println("잠자기");
    }
}

class Student extends Person {
    private String school;
    private int grade;

    public Student(String name, int age, String school, int grade) {
        super(name, age);
        this.school = school;
        this.grade = grade;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("학교: " + school + ", 학년: " + grade);
    }

    public void study() {
        System.out.println("공부하기");
    }
}

class StudentWorker extends Student {
    private String workplace;
    private int salary;

    public StudentWorker(String name, int age, String school, int grade, String workplace, int salary) {
        super(name, age, school, grade);
        this.workplace = workplace;
        this.salary = salary;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("직장: " + workplace + ", 급여: " + salary);
    }

    public void work() {
        System.out.println("일하기");
    }
}

class Researcher extends Person {
    private String laboratory;
    private String subject;

    public Researcher(String name, int age, String laboratory, String subject) {
        super(name, age);
        this.laboratory = laboratory;
        this.subject = subject;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("연구소: " + laboratory + ", 연구주제: " + subject);
    }

    public void research() {
        System.out.println("연구하기");
    }
}

class Professor extends Researcher {
    private String university;
    private String position;

    public Professor(String name, int age, String laboratory, String subject, String university, String position) {
        super(name, age, laboratory, subject);
        this.university = university;
        this.position = position;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("대학교: " + university + ", 직책: " + position);
    }

    public void teach() {
        System.out.println("가르치기");
    }
}
