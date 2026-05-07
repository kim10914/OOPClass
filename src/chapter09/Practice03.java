package chapter09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Practice03Frame extends JFrame {
    public Practice03Frame() {
        super("Practice03");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();

        container.setBackground(Color.GREEN);
        setFocusable(true);
        // 마우스 드래깅 동안만 노란색으로 바뀜
        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                container.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                container.setBackground(Color.GREEN);
            }
        });

        setSize(300, 200);
        setVisible(true);
    }

}

public class Practice03 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Practice03Frame::new);
    }
}
