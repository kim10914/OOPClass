package chapter09;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// 전화걸기 프레임
// 상단: 입력된 번호와 상태 메시지가 표시되는 텍스트 영역
// 하단: 통화/지움/종료 + 0~9, *, # 버튼 패널 (4행 3열)
public class Assignment3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Assignment3Frame::new);
    }
}

class Assignment3Frame extends JFrame {
    // 번호 최대 입력 길이
    private static final int MAX_NUMBER_LENGTH = 20;

    // 입력된 번호와 메시지를 표시하는 텍스트 영역
    private final JTextArea displayArea = new JTextArea();
    // 사용자가 누른 숫자가 누적되는 버퍼 
    private final StringBuilder numberBuffer = new StringBuilder();
    // 통화 중 상태 플래그 (예외처리용)
    private boolean onCall = false;

    public Assignment3Frame() {
        setTitle("전화걸기");
        setSize(330, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Content pane에 BorderLayout 적용(Content pane은 JFrame의 기본 레이아웃이므로 별도 선언 없이 사용)

        // 상단 텍스트 영역: 편집 불가, 멀티라인
        // 텍스트 영역 비율을 PDF에 맞춰 전체 높이의 약 1/5 수준으로 고정
        displayArea.setEditable(false); // 사용자 편집 불가
        displayArea.setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6)); // 텍스트 영역에 여백 추가
        displayArea.setPreferredSize(new Dimension(0, 80)); // 높이 고정, 너비는 가변
        add(displayArea, BorderLayout.NORTH); // 상단에 텍스트 영역 배치

        // 하단 버튼 패널 (5행 3열)
        JPanel buttonPanel = new JPanel(new GridLayout(5, 3, 2, 2));

        // 1행: 기능 버튼
        JButton callButton = new JButton("통화");
        JButton clearButton = new JButton("지움");
        JButton exitButton = new JButton("종료");

        // "통화" 버튼: 입력된 번호로 "전화를 겁니다..." 표시
        callButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 예외 1: 번호가 비어있는 경우
                if (numberBuffer.length() == 0) {
                    displayArea.setText("번호를 입력하세요.");
                    return;
                }
                // 예외 2: 이미 통화 중인 경우 중복 발신 방지
                if (onCall) {
                    return;
                }
                onCall = true;
                displayArea.setText(numberBuffer.toString() + "\n전화를 겁니다...");
            }
        });

        // "지움" 버튼: 입력 번호와 화면을 전체 지움
        // 통화 중에도 즉시 초기화 가능 (다음 통화 준비)
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberBuffer.setLength(0);
                displayArea.setText("");
                onCall = false;
            }
        });

        // "종료" 버튼: "전화를 끊습니다." 추가 출력 (프로그램은 종료하지 않음)
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 예외 3: 통화 중이 아닐 때 종료 버튼을 눌러도 무시
                if (!onCall) {
                    return;
                }
                displayArea.append("\n전화를 끊습니다.");
                onCall = false;
            }
        });

        buttonPanel.add(callButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        // 2~5행: 숫자/기호 버튼 (1~9, *, 0, #)
        String[] keys = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };

        // 숫자/기호 버튼 공통 리스너: 입력값을 버퍼에 누적
        ActionListener keyListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 예외 4: 통화 중에는 추가 입력 무시
                if (onCall) {
                    return;
                }
                // 예외 5: 번호가 너무 긴 경우 더 이상 입력받지 않음
                if (numberBuffer.length() >= MAX_NUMBER_LENGTH) {
                    return;
                }
                JButton source = (JButton) e.getSource();
                numberBuffer.append(source.getText());
                // 입력 중에는 누적된 번호만 표시
                displayArea.setText(numberBuffer.toString());
            }
        };
        
        // 숫자/기호 버튼 생성 및 리스너 등록
        for (String key : keys) {
            JButton keyButton = new JButton(key);
            keyButton.addActionListener(keyListener);
            buttonPanel.add(keyButton);
        }

        add(buttonPanel, BorderLayout.CENTER); 
        setVisible(true);
    }
}