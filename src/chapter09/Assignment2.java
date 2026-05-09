package chapter09;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

// 2번 문제: 마우스 이벤트 처리
// 드래그 시 레이블이 따라다니고, 클릭 시 좌표를 타이틀에 출력
// 마우스가 프레임 밖으로 나가면 빨간색, 다시 들어오면 초록색
// MouseAdapter 클래스 이용
public class Assignment2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Assignment2Frame::new);
    }
}

class Assignment2Frame extends JFrame {
    // 드래그 중 따라다닐 레이블
    private final JLabel dragLabel = new JLabel("드래깅...");

    public Assignment2Frame() {
        setTitle("Assignment2");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // content pane은 절대 위치 지정을 위해 레이아웃 제거
        setLayout(null);

        // 레이블 초기 설정 (보이지 않게 시작)
        dragLabel.setSize(80, 20);
        dragLabel.setVisible(false);
        add(dragLabel);

        // MouseAdapter로 마우스 이벤트 일괄 처리
        MouseAdapter mouseHandler = new MouseAdapter() {
            // 마우스 클릭: 좌표를 타이틀에 출력
            @Override
            public void mouseClicked(MouseEvent e) {
                setTitle("(" + e.getX() + ", " + e.getY() + ")");
            }

            // 드래그 시작 시 레이블 표시
            @Override
            public void mousePressed(MouseEvent e) {
                dragLabel.setLocation(e.getX(), e.getY());
                dragLabel.setVisible(true);
            }

            // 드래그 중: 레이블이 마우스 포인터를 따라다님
            @Override
            public void mouseDragged(MouseEvent e) {
                dragLabel.setLocation(e.getX(), e.getY());
            }

            // 드래그 종료 시 레이블 숨김
            @Override
            public void mouseReleased(MouseEvent e) {
                dragLabel.setVisible(false);
            }

            // 마우스가 프레임 밖으로 나가면 배경색을 빨간색으로
            @Override
            public void mouseExited(MouseEvent e) {
                getContentPane().setBackground(Color.RED);
            }

            // 마우스가 프레임 안으로 들어오면 배경색을 초록색으로
            @Override
            public void mouseEntered(MouseEvent e) {
                getContentPane().setBackground(Color.GREEN);
            }
        };

        // content pane에 리스너 등록
        // (드래그 이벤트는 MouseMotionListener 메서드이므로 두 번 등록 필요)
        getContentPane().addMouseListener(mouseHandler);
        getContentPane().addMouseMotionListener(mouseHandler);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}