package chapter08;

import javax.swing.*;
import java.awt.*;

class Practice3Fram extends JFrame {
    public Practice3Fram() {
        setTitle("FlowLayout Practice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));

        contentPane.add(new JButton("Button 1"));
        setSize(500, 400);
        setVisible(true);
    }

}

public class Practice03 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Practice3Frame::new);
    }
}
