package chapter08;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class Practice2Frame extends JFrame {
    public Practice2Frame() {
        setTitle("BorderLayout Practice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(50, 5));

        contentPane.add(new JButton("North"), BorderLayout.NORTH);
        contentPane.add(new JButton("South"), BorderLayout.SOUTH);
        contentPane.add(new JButton("West"), BorderLayout.WEST);
        contentPane.add(new JButton("East"), BorderLayout.EAST);
        contentPane.add(new JButton("Center"), BorderLayout.CENTER);

        setSize(500, 400);

        setVisible(true);
    }

}

public class Practice02 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Practice2Frame::new);
    }
}
