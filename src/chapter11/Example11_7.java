package chapter11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// 프레임
class Example11_7Frame extends JFrame{
  public Example11_7Frame(){
    setTitle("마우스로 타원 그리기");
    set DefaulteCloseOperation(JFrame.EXIT_ON_CLOSE);

    DrawPanel penel = new DrawPanel();
    add(panel);
    setSize(600, 500);

    setVisible(true);
  }
}

//그림판 역할 패널
class DrawPanel extends JPanel {

        private int startX, startY;
        private int endX, endY;

        public DrawPanel() {

            // 마우스 누를 때
            addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    startX = e.getX();
                    startY = e.getY();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    endX = e.getX();
                    endY = e.getY();

                    repaint(); // 다시 그리기 요청
                }
            });

            // 드래그 중 실시간 표시
            addMouseMotionListener(new MouseAdapter() {

                @Override
                public void mouseDragged(MouseEvent e) {
                    endX = e.getX();
                    endY = e.getY();

                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 시작점과 끝점 기준 계산
            int x = Math.min(startX, endX);
            int y = Math.min(startY, endY);

            int width = Math.abs(endX - startX);
            int height = Math.abs(endY - startY);

            // 타원 그리기
            g.setColor(Color.BLUE);
            g.drawOval(x, y, width, height);
        }
    }

public class Example11_7 {
  public static void main(String[] args){
    SwingUtilities.invoker(Example11_7Frame :: new);
  }
}
