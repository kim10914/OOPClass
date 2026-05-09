package chapter08;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

class Assignment1Frame extends JFrame {
    public Assignment1Frame() {
        super("Assignment 1"); // 부모 클래스의 생성자 호출하여 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 프로그램 종료
        Container container = getContentPane(); // 컨테이너 가져오기
        container.setLayout(new GridLayout(2, 1)); // 2x1 그리드 레이아웃 설정

        // 상단 패널 : 8장 실습 문제 2번 (BorderLayout, hgap 50, vgap 5)
        JPanel topPanel = new JPanel(); // 상단 패널(기본은 FlowLayout)
        topPanel.setLayout(new BorderLayout(50, 5)); // BorderLayout으로 레이아웃 설정, hgap 50, vgap 5
        topPanel.add(new JButton("North"), BorderLayout.NORTH);
        topPanel.add(new JButton("South"), BorderLayout.SOUTH);
        topPanel.add(new JButton("East"), BorderLayout.EAST);
        topPanel.add(new JButton("West"), BorderLayout.WEST);
        topPanel.add(new JButton("Center"), BorderLayout.CENTER);

        // 하단 패널 : 8장 실습문제 4번 (10개 버튼, 랜덤 색)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 10)); // 1x10 그리드 레이아웃 설정

        // Color 클래스의 모든 public static 필드(색상 상수)를 가져와서 리스트에 저장
        ArrayList<Color> colors = new ArrayList<>(); // 색상 리스트 생성
        for (Field f : Color.class.getFields()) { // Color 클래스의 모든 public 필드(색상 상수(RED, GREEN, BLUE 등))에 대해 반복
            if (f.getType() == Color.class) { // 필드의 타입이 Color인 경우
                try {
                    colors.add((Color) f.get(null)); // static 필드이므로 객체 없이 접근, 색상 리스트에 추가
                } catch (IllegalAccessException e) { // 접근 예외 처리
                    JOptionPane.showMessageDialog( // 오류 메시지 다이얼로그 표시
                            this,
                            "색상 목록을 불러오는 중 문제가 발생했습니다.\n프로그램을 다시 실행해 주세요.",
                            "오류",
                            JOptionPane.ERROR_MESSAGE);
                    System.err.println("색상 목록을 불러오는 중 오류가 발생했습니다: " + e.getMessage()); // 콘솔에 오류 메시지 출력
                    System.exit(1); // 프로그램 비정상 종료
                }
            }
        }

        // 10개의 버튼을 생성하여 하단 패널에 추가, 각 버튼의 배경색은 색상 리스트에서 랜덤하게 선택
        Random random = new Random(); // 랜덤 객체 생성
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(Integer.toString(i)); // 버튼 생성, 텍스트는 버튼 번호
            button.setOpaque(true); // 버튼 배경색이 보이도록 설정
            button.setBackground(colors.get(random.nextInt(colors.size()))); // 랜덤 색상 선택하여 버튼 배경색 설정
            bottomPanel.add(button); // 버튼을 하단 패널에 추가
        }

        container.add(topPanel); // 상단 패널을 컨테이너에 추가
        container.add(bottomPanel); // 하단 패널을 컨테이너에 추가

        setSize(700, 400); // 창 크기 설정
        setVisible(true); // 창을 화면에 보이도록 설정;

    }
}

public class Assignment1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Assignment1Frame::new); // GUI 생성은 이벤트 디스패치 스레드에서 실행
    }
}
