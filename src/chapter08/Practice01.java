package chapter08;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class Practice1Frame extends JFrame {
    public Practice1Frame() {
        setTitle("Let's study Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

}

public record Practice01() {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Practice1Frame::new);
    }
}
