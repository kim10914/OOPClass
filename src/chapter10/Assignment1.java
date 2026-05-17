package chapter10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Assignment1Frame extends JFrame {
    private JLabel imgLabel = new JLabel(); // 빈 이미지를 가진 레이블
    private String imagePath = "./src/chapter10/images/apple.jpg"; // 초기 이미지 경로

    public Assignment1Frame() {
        setTitle("과제 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenu(); // 메뉴 생성 메소드 호출
        add(imgLabel, BorderLayout.CENTER); // 이미지 레이블을 프레임 중앙에 추가
        setSize(300, 250); /// 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    /**
     * 상단 메뉴를 생성하는 메소드
     */
    private void createMenu() {
        JMenuBar mb = new JMenuBar(); // 메뉴 바 생성

        // Screen 메뉴 (Load, Hide, ReShow, Exit)
        JMenu screenMenu = new JMenu("Screen"); // Screen 메뉴 생성
        String[] screenItems = { "Load", "Hide", "ReShow", "Exit" }; // Screen 메뉴 아이템 배열
        MenuActionListener listener = new MenuActionListener(); // 메뉴 아이템 액션 리스너 생성
        for (int i = 0; i < screenItems.length; i++) { // Screen 메뉴 아이템 추가
            JMenuItem item = new JMenuItem(screenItems[i]); // 메뉴 아이템 생성
            item.addActionListener(listener); // 메뉴 아이템에 액션 리스너 등록
            screenMenu.add(item); // Screen 메뉴에 아이템 추가
        }
        mb.add(screenMenu); // 메뉴 바에 Screen 메뉴 추가

        // Source 메뉴 (Change)
        JMenu sourceMenu = new JMenu("Source"); // Source 메뉴 생성
        JMenuItem changeItem = new JMenuItem("Change"); // Change 메뉴 아이템 생성
        changeItem.addActionListener(listener); // Change 메뉴 아이템에 액션 리스너 등록
        sourceMenu.add(changeItem); // Source 메뉴에 Change 아이템 추가
        mb.add(sourceMenu); // 메뉴 바에 Source 메뉴 추가

        setJMenuBar(mb); // 프레임에 메뉴 바 적용
    }

    /**
     * 메뉴 이미지 비율, 크기 조정 메서드
     * @param w 원하는 너비 (-1이면 원본 너비 유지)
     * @param h 원하는 높이
     */
    private ImageIcon loadScaledIcon(int w, int h) {
        ImageIcon raw = new ImageIcon(imagePath); // 현재 이미지 경로로 원본 이미지 아이콘 로드
        Image scaled = raw.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT); // 이미지 크기 조정 
        return new ImageIcon(scaled); // 조정된 이미지를 새로운 ImageIcon으로 반환
    }

    /**
     * 메뉴 아이템에 대한 액션 리스너 클래스
     */
    class MenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand(); // 클릭된 메뉴 아이템의 명령 문자열 가져오기
            switch (cmd) {
                case "Load": // 이미지 로드
                    if (imgLabel.getIcon() != null) // 이미 이미지가 로드된 경우
                        return;
                    imgLabel.setIcon(loadScaledIcon(-1, 200)); // 이미지 레이블에 이미지 적용 (높이 200px로 조정, 너비는 비율 유지)
                    break;
                case "Hide": // 이미지 숨기기
                    imgLabel.setVisible(false); // 이미지 레이블을 보이지 않도록 설정
                    break;
                case "ReShow": // 이미지 다시 보이기
                    imgLabel.setVisible(true); // 이미지 레이블을 다시 보이도록 설정
                    break;
                case "Exit": // 종료
                    int result = JOptionPane.showConfirmDialog( // 종료 확인 다이얼로그 표시
                            Assignment1Frame.this, // 부모 컴포넌트로 현재 프레임 지정 (부모 프레임이 다이얼로그의 위치를 결정)
                            "정말 종료하시겠습니까?",
                            "종료 확인",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) { // 사용자가 "Yes"를 선택한 경우 종료
                        System.exit(0);
                    }
                    break;
                case "Change": // 이미지 변경
                    String newPath = JOptionPane.showInputDialog(
                            Assignment1Frame.this, // 부모 컴포넌트로 현재 프레임 지정 (부모 프레임이 다이얼로그의 위치를 결정)
                            "변경할 이미지 파일의 전체 경로를 입력하세요:",
                            "이미지 변경",
                            JOptionPane.QUESTION_MESSAGE); // 입력 다이얼로그 표시
                    if (newPath != null && !newPath.trim().isEmpty()) { // 사용자가 유효한 경로를 입력한 경우
                        imagePath = newPath.trim(); // 새 이미지 경로 업데이트
                        imgLabel.setIcon(loadScaledIcon(-1, 200)); // 이미지 레이블에 새 이미지 적용
                    }
                    break;
            }
        }
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Assignment1Frame::new);
    }
}