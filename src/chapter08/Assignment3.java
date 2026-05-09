package chapter08;

import javax.swing.*;
import java.awt.*;

class Assignment3Frame extends JFrame {
    public Assignment3Frame() {
        super("선택");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 프로그램 종료
        Container container = getContentPane(); // 컨테이너 가져오기 (기본은 BorderLayout)

        // 상단 안내 라벨
        JLabel guideLabel = new JLabel("좋아하는 과일을 모두 체크하세요!");
        container.add(guideLabel, BorderLayout.NORTH); // 상단에 안내 라벨 추가

        // 중앙 체크 박스 2x2 그리드 레이아웃
        JPanel centerPanel = new JPanel(); // 중앙 패널 생성(기본은 FlowLayout)
        centerPanel.setLayout(new GridLayout(2, 2)); // 2x2 그리드 레이아웃, 버튼 사이 간격 20px
        centerPanel.add(new JCheckBox("사 과"));
        centerPanel.add(new JCheckBox("딸 기"));
        JCheckBox kiwi = new JCheckBox("키 위");
        // kiwi.setSelected(true); // 그림처럼 키위만 체크된 상태
        centerPanel.add(kiwi);
        centerPanel.add(new JCheckBox("포 도"));

        // 하단 확인 / 취소 버튼(오른쪽 정렬)
        JPanel bottomPanel = new JPanel(); // 하단 패널 생성(기본은 FlowLayout)
        bottomPanel.add(new JButton("확인"));
        bottomPanel.add(new JButton("취소"));

        container.add(centerPanel, BorderLayout.CENTER);
        container.add(bottomPanel, BorderLayout.SOUTH);

        setSize(350,220);
        setVisible(true);
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Assignment3Frame::new); // GUI 생성은 이벤트 디스패치 스레드에서 실행
    }
}
