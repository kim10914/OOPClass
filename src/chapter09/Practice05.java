package chapter09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클릭 연습용 스윙 응용 프로그램을 작성. JLabel을 이용해 문자열 "C"인 레이블을 하나 만들고 초기 위치를 (50, 50)으로 설정. 문자열 클릭이 발생할 때마다 레이블의 위치를 랜덤한 위치로 움직임.

class Practice05Frame extends JFrame {
    public Practice05Frame() {
        super("Practice05");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(null); // 절대 위치 설정
        JLabel label = new JLabel("C");
        label.setBounds(50, 50, 50, 20); // x, y, width, height
        container.add(label);
        // 문자열 클릭시 랜덤한 곳으로 C가 이동하도록 마우스 클릭 이벤트 처리
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = (int) (Math.random() * 250); // 0 ~ 250 사이의 랜덤한 x 좌표
                int y = (int) (Math.random() * 180); // 0 ~ 180 사이의 랜덤한 y 좌표
                label.setLocation(x, y);
            }
        });
        setSize(400, 300);
        setVisible(true);
    }

}

public class Practice05 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Practice05Frame::new);
    }
}
