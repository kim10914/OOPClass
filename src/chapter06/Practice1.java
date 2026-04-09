package chapter06;

class Student {
    private String name;
    private String major;

    Student(String name, String major) {
        this.name = name;
        this.major = major;
    }

    @Override
    public String toString() {
        return "[" + name + "," + major + "]";
    }
}

public class Practice1 {
    public static void main(String[] args) {
        Student st = new Student("황기태", "컴퓨터공학과");
        System.out.println(st);
    }
}
