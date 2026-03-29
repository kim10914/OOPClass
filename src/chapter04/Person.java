package chapter04;

// 과제 1번 Person Class
class Person {
    private String name; // 이름
    private String job; // 직업
    private int age; // 나이
    private String gender; // 성별
    private String bloodType; // 혈액형

    // 생성자
    public Person(String name, String job, int age, String gender, String bloodType) {
        this.name = name;
        this.job = job;
        this.age = age;
        this.gender = gender;
        this.bloodType = bloodType;
    }

    // getter / setter 정의
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
