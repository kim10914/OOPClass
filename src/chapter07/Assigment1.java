package chapter07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Assigment1 {
    public static void main(String[] args) {
        // 영어 단어와 그에 대응하는 뜻을 저장하는 HashMap
        HashMap<String, String> wordBook = new HashMap<>();
        wordBook.put("apple", "사과");
        wordBook.put("banana", "바나나");
        wordBook.put("computer", "컴퓨터");
        wordBook.put("book", "책");
        wordBook.put("school", "학교");

        try (Scanner sc = new Scanner(System.in)) {
            try {
                while (true) {
                    System.out.print("영어 단어 입력(종료: exit) >> ");
                    String english = sc.nextLine().trim();

                    if (english.isEmpty()) { // 빈 입력 시
                        System.out.println("단어를 입력하세요.");
                        continue;
                    }
                    // 종료
                    if (english.equals("exit")) {
                        break;
                    }

                    String meaning = null; // 단어장 검색
                    // HashMap을 Iterator로 순회할 경우, Map.Entry를 사용해 key와 value를 함께 접근
                    Iterator<Map.Entry<String, String>> iterator = wordBook.entrySet().iterator();

                    // Iterator를 사용하여 단어장 검색
                    while (iterator.hasNext()) {
                        Map.Entry<String, String> entry = iterator.next(); // Map.Entry는 key와 value를 함께 저장하는 인터페이스
                        if (entry.getKey().equals(english)) { // 입력한 단어와 일치하는 key를 찾으면
                            meaning = entry.getValue(); // 해당 key에 대응하는 value(뜻)를 가져옴
                            break;
                        }
                    }
                    // 단어장 검색 결과 출력
                    if (meaning != null) {
                        System.out.println(english + " : " + meaning);
                    } else {
                        System.out.println("없는 단어");
                    }
                }

            } catch (NoSuchElementException e) { // 입력 도중 EOF 발생
                System.out.println("입력이 종료되었습니다.");
            }
        }
    }
}
