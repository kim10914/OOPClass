package chapter07;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args) {
        Map<String, Integer> menu = new LinkedHashMap<>(); // 음료, 가격
        menu.put("에스프레소", 2000);
        menu.put("아메리카노", 2500);
        menu.put("카푸치노", 3000);
        menu.put("카페라떼", 3500);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(String.join(", ", menu.keySet()) + " 있습니다.");
            while (true) {
                System.out.print("주문 >> ");
                String order = sc.nextLine().trim();

                if (order.equals("그만")) {
                    System.out.println("주문을 종료합니다.");
                    break;
                }

                Integer price = menu.get(order);
                if (price != null) {
                    System.out.println(order + "는 " + price + "원입니다.");
                } else {
                    System.out.println("죄송합니다. " + order + "는 메뉴에 없습니다.");
                }
            }

        }
    }
}
