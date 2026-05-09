package chapter08;

import java.awt.*;
import javax.swing.*;

class Assignment2Frame extends JFrame {
    public Assignment2Frame() {
        super("과제 2번 계산기"); // 부모 클래스의 생성자 호출하여 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 프로그램 종료
        Container container = getContentPane(); // 컨테이너 가져오기 (기본은 BorderLayout)

        // 상단 : 수식 / 결과 입력 영역 (FlowLayout)
        JPanel topPanel = new JPanel(); // 상단 패널(기본은 FlowLayout)
        topPanel.add(new JLabel("수식"));
        topPanel.add(new JTextField(10)); // 수식 입력 필드
        topPanel.add(new JLabel("결과"));
        topPanel.add(new JTextField(6)); // 결과 입력 필드

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 4, 4, 4)); // 4x4 그리드 레이아웃, 버튼 사이 간격 4px
        centerPanel.setBackground(Color.YELLOW); // 배경색 노란색으로 설정

        String[] labels = { // 버튼 레이블 배열
                "0", "1", "2", "3",
                "4", "5", "6", "7",
                "8", "9", "CE", "계산",
                "+", "-", "*", "/"
        };

        for (int i = 0; i < labels.length; i++) {
            JButton button = new JButton(labels[i]);
            // 마지막 줄은 초록 배경 + 흰 글씨
            if (i >= 12) {
                button.setOpaque(true); // 버튼 배경색이 보이도록 설정
                button.setBackground(Color.GREEN); // 배경색 초록색으로 설정
                // button.setBorderPainted(false); // 버튼 테두리 제거
            }
            centerPanel.add(button);
        }
        container.add(topPanel, BorderLayout.NORTH); // 상단 패널을 북쪽에 추가
        container.add(centerPanel, BorderLayout.CENTER); // 중앙 패널을 중앙에 추가

        setSize(300, 250);
        setVisible(true);
    }

}

public class Assignment2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Assignment2Frame::new); // GUI 생성은 이벤트 디스패치 스레드에서 실행
    }
}
