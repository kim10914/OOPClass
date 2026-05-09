package chapter09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Practice01Frame extends JFrame {
    public Practice01Frame() {
        super("Practice01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();

        JLabel label = new JLabel("자기야"); // 마우스 올리면 사랑해로 바뀜
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("사랑해");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("자기야");
            }
        });
        container.add(label);
        setSize(300, 200);
        setVisible(true);
    }

}

public class Practice01 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Practice01Frame::new);
    }
}
