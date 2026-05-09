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
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 60));

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
                int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
                int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
                int x = random.nextInt(Math.max(1, screenWidth - getWidth()));
                int y = random.nextInt(Math.max(1, screenHeight - getHeight()));
                setLocation(x, y);
            }
        });

        add(colorButton);
        add(moveButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}