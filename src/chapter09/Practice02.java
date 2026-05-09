package chapter09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// R키를 누르면 Color.RED, 키를 떼면 다시 Color.CYAN으로 바뀌는 프로그램
class Practice02Frame extends JFrame {
    public Practice02Frame() {
        super("Practice02");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();

        container.setBackground(Color.CYAN);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'r' || e.getKeyChar() == 'R') {
                    container.setBackground(Color.RED);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == 'r' || e.getKeyChar() == 'R') {
                    container.setBackground(Color.CYAN);
                }
            }
        });
        setSize(300, 200);
        setVisible(true);
        SwingUtilities.invokeLater(this::requestFocusInWindow);
    }

}

public class Practice02 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Practice02Frame::new);
    }
}
