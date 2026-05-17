package chapter10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Assignment3Frame extends JFrame {
    private final String[] fruitNames = { "apple", "banana", "orange" }; // 과일 이름 배열 (소문자 기준)
    private final String[] fruitImages = { // 과일 이미지 경로 배열 (작업 디렉토리 = 프로젝트 루트 기준)
            "src/chapter10/images/apple.jpg",
            "src/chapter10/images/banana.jpg",
            "src/chapter10/images/orange.jpg"
    };

    private DefaultListModel<String> model = new DefaultListModel<>(); // 리스트 모델 (동적 추가 가능)
    private JList<String> list = new JList<>(); // 과일 이름을 보여줄 리스트 (초기에는 빈 리스트)
    private JTextField inputField = new JTextField(15); // 과일 이름 입력 필드 (크기 15) - 사용자가 과일 이름을 입력할 수 있도록
    private JLabel imageLabel = new JLabel("이미지 출력", SwingConstants.CENTER); // 이미지가 표시될 레이블 (초기 텍스트 "이미지 출력", 가운데 정렬)

    public Assignment3Frame() {
        super("List만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 상단: 안내 라벨 + 입력 필드
        JPanel topPanel = new JPanel(); // 상단 패널 생성
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS)); // 수직 박스 레이아웃으로 설정(기본은 FlowLayout)
        JLabel guide = new JLabel("입력 후 <Enter> 키를 입력하세요"); // 안내 라벨 생성
        guide.setAlignmentX(Component.CENTER_ALIGNMENT); // 안내 라벨을 가운데 정렬
        inputField.setMaximumSize(new Dimension(200, 25)); // 입력 필드 최대 크기 설정 (너비 200, 높이 25)
        inputField.setAlignmentX(Component.CENTER_ALIGNMENT); // 입력 필드를 가운데 정렬
        topPanel.add(Box.createVerticalStrut(5)); // 안내 라벨과 입력 필드 사이에 수직 간격 추가
        topPanel.add(guide); // 안내 라벨을 상단 패널에 추가
        topPanel.add(Box.createVerticalStrut(5)); // 안내 라벨과 입력 필드 사이에 수직 간격 추가
        topPanel.add(inputField); // 입력 필드를 상단 패널에 추가
        topPanel.add(Box.createVerticalStrut(5)); // 입력 필드와 상단 패널 아래쪽 사이에 수직 간격 추가

        // 중앙: 리스트 + 이미지
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 5, 5)); // 중앙 패널 생성 (1행 2열, 간격 5px)
        list.setModel(model); // 리스트에 모델 설정 (초기에는 빈 모델)
        centerPanel.add(new JScrollPane(list)); // 리스트를 스크롤 패널에 감싸서 중앙 패널에 추가
        centerPanel.add(imageLabel);// 이미지 레이블을 중앙 패널에 추가

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        // 엔터 입력시 리스트에 과일 이름 추가 액션 리스너
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText().trim(); // 입력된 텍스트 가져오기 및 양쪽 공백 제거
                if (!text.isEmpty()) { // 빈 문자열이 아닌 경우에만 처리
                    model.addElement(text); // 리스트 모델에 입력된 텍스트 추가 (리스트에 새 항목으로 나타남)
                    list.setModel(model); // 리스트에 모델 설정 (새 항목이 추가된 모델로 업데이트)
                    inputField.setText(""); // 입력 필드 초기화 (빈 문자열로 설정)
                }
            }
        });

        // 리스트 선택 시 해당 과일 이미지 표시 리스너
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return; // 선택이 완료되지 않은 경우(드래그 중 등)에는 무시
                String selected = list.getSelectedValue(); // 선택된 리스트 항목의 값을 가져오기 (과일 이름)
                if (selected == null)
                    return; // 선택된 항목이 없는 경우에는 무시
                showFruitImage(selected); // 선택된 과일 이름에 해당하는 이미지를 표시하는 메소드 호출
            }
        });

        setSize(400, 350);
        setVisible(true);
    }

    /**
     * 과일 이름에 해당하는 이미지를 로드하여 이미지 레이블에 표시하는 메소드
     * 
     * @param fruit
     */
    private void showFruitImage(String fruit) {
        int index = -1; // 과일 이름이 배열에서 발견되지 않은 경우를 나타내는 인덱스 초기값 (-1)
        for (int i = 0; i < fruitNames.length; i++) { // 과일 이름 배열을 순회하면서 입력된 과일 이름과 비교
            if (fruitNames[i].equalsIgnoreCase(fruit)) { // 대소문자 구분 없이 비교
                index = i; // 일치하는 과일 이름이 발견된 경우 해당 인덱스를 저장
                break;
            }
        }

        if (index == -1) { // 입력된 과일 이름이 배열에 없는 경우
            imageLabel.setIcon(null); // 이미지 레이블의 아이콘을 제거하여 이미지가 보이지 않도록 설정
            imageLabel.setText("이미지 출력"); // 이미지 레이블의 텍스트를 "이미지 출력"으로 설정하여 안내 메시지로 사용
            // 사용자에게 해당 과일 이름에 대한 이미지가 없다는 메시지 다이얼로그로 표시
            JOptionPane.showMessageDialog(this,
                    "'" + fruit + "'에 해당하는 이미지가 없습니다.",
                    "이미지 없음", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        ImageIcon original = new ImageIcon(fruitImages[index]); // 해당 과일 이름에 대응하는 이미지 경로로 ImageIcon 객체 생성
        Image img = original.getImage(); // ImageIcon에서 Image 객체를 추출하여 이미지 조작에 사용할 수 있도록 준비
        int w = original.getIconWidth(); // 원본 이미지의 너비를 가져오기
        int h = original.getIconHeight(); // 원본 이미지의 높이를 가져오기

        // 이미지 크기를 100x100으로 조정하되, 원본 이미지의 비율을 유지하여 조정된 이미지를 이미지 레이블에 설정
        if (w <= 0 || h <= 0) { // 이미지 로드 실패 시 너비 또는 높이가 0 이하인 경우
            imageLabel.setIcon(null); // 이미지 레이블의 아이콘을 제거하여 이미지가 보이지 않도록 설정
            imageLabel.setText("이미지 로드 실패"); // 이미지 레이블의 텍스트를 "이미지 로드 실패"로 설정하여 안내 메시지로 사용
            // 사용자에게 이미지 로드 실패 메시지 다이얼로그로 표시
            JOptionPane.showMessageDialog(this,
                    "이미지 로드에 실패했습니다: " + fruitImages[index],
                    "로드 실패", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int newW, newH; // 조정된 이미지의 너비와 높이를 저장할 변수 선언
        if (w >= h) { // 원본 이미지의 너비가 높이보다 크거나 같은 경우 (가로형 이미지)
            newW = 100;
            newH = (int) ((double) h / w * 100); // 원본 이미지의 비율을 유지하면서 너비를 100으로 조정한 후 높이를 계산하여 설정
        } else {
            newH = 100; // 원본 이미지의 높이가 너비보다 큰 경우 (세로형 이미지)
            newW = (int) ((double) w / h * 100); // 원본 이미지의 비율을 유지하면서 높이를 100으로 조정한 후 너비를 계산하여 설정
        }

        Image scaled = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH); // 원본 이미지에서 조정된 너비와 높이로 부드러운 스케일링을 사용하여 새로운 Image 객체 생성
        imageLabel.setIcon(new ImageIcon(scaled)); // 조정된 이미지를 ImageIcon으로 감싸서 이미지 레이블의 아이콘으로 설정하여 화면에 표시
        imageLabel.setText(""); // 텍스트 제거
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Assignment3Frame::new);
    }
}