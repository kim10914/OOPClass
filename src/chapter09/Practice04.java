package chapter09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Practice04Frame extends JFrame {
    public Practice04Frame() {
        super("Practice04");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();

        // JLabel 컴포넌트를 이용하여 "Love Java"를 출력하고 +를 치면 5픽셀 증가 -를 치면 5픽셀 감소하는 프로그램(최소 5픽셀)
        JLabel label = new JLabel("Love Java");
        label.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
        label.setVerticalAlignment(JLabel.TOP); // 상단 정렬
        label.setFont(new Font("Arial", Font.PLAIN, 10));
        container.add(label);
        setFocusable(true);
        addKeyListener(new KeyAdapter() { // 익명 클래스로 KeyListener 구현
            @Override
            public void keyPressed(KeyEvent e) {
                int fontSize = label.getFont().getSize();
                if (e.getKeyChar() == '+') {
                    label.setFont(new Font("Arial", Font.PLAIN, fontSize + 5));
                } else if (e.getKeyChar() == '-' && fontSize > 5) {
                    label.setFont(new Font("Arial", Font.PLAIN, fontSize - 5));
                }
            }
        });

        setSize(300, 200);
        setVisible(true);
    }

}

public class Practice04 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Practice04Frame::new);
    }
}