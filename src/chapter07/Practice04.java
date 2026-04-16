package chapter07;

import java.util.Scanner;
import java.util.Vector;

public class Practice04 {
    public static void main(String[] args) {
        Vector<Double> heights = new Vector<>(); // 키를 저장할 벡터
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("2000 ~ 2009년까지 1년 단위로 키(cm)를 입력");
            System.out.print(" >>");
            for (int year = 2000; year <= 2009; year++) {
                heights.add(sc.nextDouble());
            }
            // 년도, 자란 키(현재 키 )
            System.out.println("가장 키가 많이 자란 년도는 " + findMaxGrowthYear(heights) + "년입니다.");
        }
    }

    private static int findMaxGrowthYear(Vector<Double> heights) {
        if (heights.size() < 2) {
            throw new IllegalArgumentException("최소 2개의 키 데이터가 필요합니다.");
        }

        double maxGrowth = heights.get(1) - heights.get(0); // 가장 많이 자란 키 크기
        int maxGrowthYear = 2000; // 가장 많이 자란 년도 (2000년부터 시작)

        for (int i = 0; i < heights.size(); i++) {
            double growth = heights.get(i) - heights.get(i - 1);
            if (growth > maxGrowth) {
                maxGrowth = growth;
                maxGrowthYear = 2000 + i;
            }
        }

        return maxGrowthYear;
    }
}
