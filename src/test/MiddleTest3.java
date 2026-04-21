package test;

class Animal {
    String name = "동물";

    void eat() {
        System.out.println(name + "이(가) 먹습니다.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println(name + "이(가) 멍멍 짖습니다.");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println(name + "이(가) 야옹 웁니다.");
    }
}

public class MiddleTest3 { // 업 다운 캐스팅 학습
    public static void main(String[] args) {
        // 1. 업캐스팅 (자식 → 부모): 자동, 안전
        Dog dog = new Dog();
        dog.name = "강아지";
        Animal animal = dog; // 업케스팅 -> 타입은 animal
        animal.eat(); // 강아지가 먹습니다.
        // animal.bark(); // 컴파일 에러! 부모 타입은 자식 메서드 못 봄

        // 2. 다운캐스팅 (부모 → 자식): 명시적 캐스트 필요
        Animal a = new Dog(); // 업케스팅
        a.name = "바둑이"; // name 필드 접근 가능
        Dog d = (Dog) a; // 다운캐스팅
        d.bark(); // 가능

        // 3. 잘못된 다운캐스팅 → ClassCastException
        Animal a2 = new Cat(); // 업케스팅
        try {
            Dog wrong = (Dog) a2; // Cat으로 이미 인스턴스가 되어 있음
            wrong.bark();
        } catch (ClassCastException e) {
            System.out.println("캐스팅 실패: " + e.getMessage());
        }

        // 4. instanceof로 안전하게 다운캐스팅
        Animal[] animals = { new Dog(), new Cat(), new Dog() }; // 3개의 인스턴스를 생성한 배열
        for (Animal x : animals) {
            if (x instanceof Dog) { // Dog 인스턴스인지 판단
                ((Dog) x).bark(); // 개 울기
            } else if (x instanceof Cat) { // Cat 인스턴스인지 판단
                ((Cat) x).meow(); // 고양이 울기
            }
        }

        // 5. Java 16+ 패턴 매칭 instanceof
        Animal pet = new Dog();
        pet.name = "뽀삐";
        if (pet instanceof Dog dog2) {  // 캐스팅 + 변수 선언 한번에
            dog2.bark();
        }
    }
}
