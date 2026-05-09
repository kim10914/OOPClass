package chapter09;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

class Practice06Frame extends JFrame {
    public Practice06Frame() {
        super("Practice06");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        String[] labels = { // 버튼 레이블 배열
                "0", "1", "2",
                "3", "4", "5",
                "6", "7", "8",
                "9", "10", "11",
        };
        // 버튼 누르면 랜덤한 색상으로 바탕 바뀜

    }
}

public class Practice06 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Practice06Frame::new);
    }
}
