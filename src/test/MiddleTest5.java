import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MiddleTest5 { // 7장 실습
    public static void main(String[] args) {
        // 컬렉션 
        // List 사용
        List<String> list = List.of("Java", "Python", "C++"); // List 인터페이스의 불변 리스트 생성
        System.out.println(list); // [Java, Python, C++]

        // Vector 사용
        Vector<String> vector = new Vector<>(); // Vector 클래스는 List 인터페이스를 구현한 동기화된 컬렉션
        vector.add("Java"); // 요소 추가
        vector.add("Python");
        vector.add("C++");
        // vector.addAll(list); // List의 모든 요소를 Vector에 추가
        System.out.println(vector); // [Java, Python, C++]

        // ArrayList 사용
        List<String> arrayList = new ArrayList<>(); // ArrayList 클래스는 List 인터페이스를 구현한 동적 배열
        arrayList.add("Java"); // 요소 추가
        arrayList.add("Python");
        arrayList.add("C++");
        System.out.println(arrayList); // [Java, Python, C++]
        
        // Iterator 사용
        Iterator<String> iterator = arrayList.iterator(); // ArrayList의 요소를 순회하기 위한 Iterator 객체 생성
        while (iterator.hasNext()) { // 다음 요소가 있는지 확인
            String element = iterator.next(); // 다음 요소를 가져옴
            System.out.println(element); // Java, Python, C++ 각각 출력
        }

        // HashMap 사용
        HashMap<String, Integer> hashMap = new HashMap<>(); // HashMap 클래스는 Map 인터페이스를 구현한 해시 테이블 기반의 컬렉션
        hashMap.put("Java", 1); // 키-값 쌍 추가
        hashMap.put("Python", 2);
        hashMap.put("C++", 3);
        System.out.println(hashMap); // {Java=1, Python=2, C++=3}
        System.out.println(hashMap.get("Python")); // 2, 키 "Python"에 해당하는 값 가져오기
        hashMap.remove("C++"); // 키 "C++"에 해당하는 요소 제거
        System.out.println(hashMap); // {Java=1, Python=2}

        // 제네릭 사용
        List<String> genericList = new ArrayList<>(); // 제네릭을 사용하여 String 타입의 요소만 허용하는 리스트 생성
        genericList.add("Java"); // 요소 추가
        genericList.add("Python");
        genericList.add("C++");
        // genericList.add(123); // 컴파일 오류, 제네릭으로 지정된 타입이 아니므로 추가할 수 없음
        System.out.println(genericList); // [Java, Python, C++]

    }
}
