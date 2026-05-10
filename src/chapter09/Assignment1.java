package chapter09;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// 1번 문제: "배경색 변경" 버튼과 "랜덤 이동" 버튼 구현
// ActionListener와 익명 클래스 사용
public class Assignment1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Assignment1Frame::new);
    }
}

class Assignment1Frame extends JFrame {
    // 배경색/위치 랜덤 생성을 위한 Random 객체
    private final Random random = new Random();

    public Assignment1Frame() {
        setTitle("Assignment1");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 60)); // Content pane에 FlowLayout 적용(Content pane은 JFrame의 기본 레이아웃이므로 별도 선언 없이 사용)

        // "배경색 변경" 버튼 생성
        JButton colorButton = new JButton("배경색 변경");
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // RGB 값을 무작위로 생성하여 content pane 배경색 변경
                int r = random.nextInt(256);
                int g = random.nextInt(256);
                int b = random.nextInt(256);
                getContentPane().setBackground(new Color(r, g, b));
            }
        });

        // "랜덤 이동" 버튼 생성
        JButton moveButton = new JButton("랜덤 이동");
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 화면 해상도 범위 내에서 임의 좌표로 프레임 이동
                int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width; // 화면 너비
                int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height; // 화면 높이
                int x = random.nextInt(Math.max(1, screenWidth - getWidth())); // 프레임 너비를 고려하여 최대값 조정
                int y = random.nextInt(Math.max(1, screenHeight - getHeight())); // 프레임 높이를 고려하여 최대값 조정
                setLocation(x, y); // 프레임 위치 변경
            }
        });

        add(colorButton);
        add(moveButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}