package chapter10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Assignment2Frame extends JFrame {
    private JTextField exprField = new JTextField(10); // 수식 입력 필드 (크기)
    private JTextField resultField = new JTextField(6); // 결과 출력 필드 (크기)

    // UI 부분(8장 과제 2번 참고)
    public Assignment2Frame() {
        super("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();

        // 상단: 수식 / 결과
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("수식"));
        topPanel.add(exprField);
        topPanel.add(new JLabel("결과"));
        topPanel.add(resultField);
        resultField.setEditable(false); // 결과 필드는 읽기 전용

        // 중앙: 4x4 버튼 그리드
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 4, 4, 4));
        centerPanel.setBackground(Color.YELLOW);

        String[] labels = {
                "0", "1", "2", "3",
                "4", "5", "6", "7",
                "8", "9", "CE", "계산",
                "+", "-", "x", "/"
        };

        // 버튼에 ActionListener 추가
        ButtonListener listener = new ButtonListener();
        for (int i = 0; i < labels.length; i++) {
            JButton button = new JButton(labels[i]);
            if (i >= 12) {
                button.setOpaque(true);
                button.setBackground(Color.GREEN);
            }
            button.addActionListener(listener);
            centerPanel.add(button);
        }

        container.add(topPanel, BorderLayout.NORTH);
        container.add(centerPanel, BorderLayout.CENTER);

        setSize(350, 300);
        setVisible(true);
    }

    // 화면 표시용 기호(x) -> 평가용 기호(*)로 변환 후 공백 제거
    private String toEvalExpr(String s) {
        return s.replace("x", "*").replace("X", "*").replace(" ", "");
    }

    // 두 스택(피연산자/연산자) 방식으로 +, -, *, / 우선순위 처리 (그냥 라이브러리 쓰면 편함)
    private static class Evaluator {
        /*
         * ===== "2+3*4" 입력 추적 표 =====
         * 단계 | 읽음 | nums       | ops    | 메모
         * -----+------+------------+--------+-------------------------------------------
         *  0   | (시작)| []         | []     | 초기 상태
         *  1   | '2'  | [2]        | []     | 숫자 → nums에 push
         *  2   | '+'  | [2]        | [+]    | ops 비었음 → 그냥 push
         *  3   | '3'  | [2, 3]     | [+]    | 숫자 → nums에 push
         *  4   | '*'  | [2, 3]     | [+, *] | prec('+')=1 < prec('*')=2 → '+' 미루고 '*' 쌓기
         *  5   | '4'  | [2, 3, 4]  | [+, *] | 숫자 → nums에 push
         *  6   | (끝) | [2, 12]    | [+]    | 남은 ops 처리: '*' 먼저 → 3*4=12 우선순위 높음 → nums에서 3,4 꺼내 곱해서 12 push
         *  7   | (끝) | [14]       | []     | '+' 처리 → 2+12=14
         * 최종 결과: 14
         *
         * ★ 핵심: 4단계에서 '*'가 '+'보다 우선순위 높아 '+' 계산을 미뤘기 때문에,
         *   6단계에서 ops 스택의 top인 '*'가 먼저 적용된다.
         */
        static double eval(String input) {
            java.util.Deque<Double> nums = new java.util.ArrayDeque<>(); // 피연산자 스택(최신 버전은 덱을 스택처럼 사용)
            java.util.Deque<Character> ops = new java.util.ArrayDeque<>(); // 연산자 스택
            boolean expectNumber = true; // 다음에 숫자가 와야 하는 상태인지 (단항 +/- 판별용)

            int i = 0; // 입력 문자열을 한 문자씩 읽는 인덱스
            while (i < input.length()) {
                char c = input.charAt(i); // 현재 문자 (예: "2+3*4"라면 i=0일 때 '2', i=1일 때 '+', ...)

                if (Character.isDigit(c) || c == '.') { // 숫자인지 판별 (소수점 포함)
                    int start = i; // 숫자 시작 위치
                    while (i < input.length() && (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.')) // 소수점 포함 숫자 읽기
                        i++; // 다음 문자로 이동
                    nums.push(Double.parseDouble(input.substring(start, i))); // 읽은 숫자 문자열을 double로 변환하여 스택에 push
                    // 예) "2+3*4"의 '2' 읽을 때: nums=[2], '3' 읽을 때: nums=[2,3], '4' 읽을 때: nums=[2,3,4]
                    expectNumber = false; // 다음에는 연산자가 와야 하는 상태로 변경
                } else if (c == '+' || c == '-' || c == '*' || c == '/') { // 연산자인지 판별
                    if (expectNumber && (c == '+' || c == '-')) // 단항 + 또는 -인 경우
                        nums.push(0.0); // 단항 연산을 이항 연산으로 변환하기 위해 0을 피연산자 스택에 push
                    // 연산자 스택 top이 현재 연산자와 우선순위가 같거나 높으면 먼저 계산
                    while (!ops.isEmpty() && prec(ops.peek()) >= prec(c)) // 현재 연산자보다 우선순위가 높은 연산자가 스택에 있으면 먼저 계산 (피크는 스택의 top 요소를 반환하지만 제거하지는 않음)
                    /* 예) "2+3*4"에서 '*'를 읽는 순간: ops=[+], 새 연산자='*'
                     *     prec('+')=1, prec('*')=2 → 1 >= 2 는 false → while 통과 (아무것도 안 함)
                     *     즉 '+' 계산을 미루고 '*'를 위에 쌓음. 결과적으로 ops=[+, *]
                     *
                     *     반대로 "2*3+4"였다면: ops=[*], 새 연산자='+'
                     *     prec('*')=2, prec('+')=1 → 2 >= 1 은 true → apply 호출되어 '*' 먼저 계산
                     */
                        apply(nums, ops); // 연산자 스택 top을 꺼내 피연산자 두 개에 적용 후 결과를 다시 push
                    ops.push(c); // 현재 연산자를 연산자 스택에 push
                    // 예) "2+3*4"의 '+' 읽을 때: ops=[+], '*' 읽을 때: ops=[+, *] (위 while을 통과했기 때문)
                    expectNumber = true; // 다음에는 숫자가 와야 하는 상태로 변경
                    i++;
                } else { // 허용되지 않는 문자 처리
                    throw new RuntimeException("예기치 못한 문자: '" + c + "'");
                }
            }
            // 입력 문자열을 모두 처리한 후에도 연산자 스택에 남아있는 연산자들을 모두 적용하여 최종 결과 계산
            // 예) "2+3*4" 끝났을 때: nums=[2,3,4], ops=[+,*]
            //     1차 apply: ops.pop()='*', b=4, a=3 → nums.push(12) → nums=[2,12], ops=[+]
            //     2차 apply: ops.pop()='+', b=12, a=2 → nums.push(14) → nums=[14], ops=[]
            while (!ops.isEmpty())
                apply(nums, ops); // 연산자 스택이 빌 때까지 연산자 스택 top을 꺼내 피연산자 두 개에 적용 후 결과를 다시 push
            return nums.pop(); // 최종 계산 결과 반환 (예: "2+3*4" → 14.0)
        }

        /**
         * 연산자 우선순위 반환 메서드 (+와 -는 1, *와 /는 2)
         * @param op
         * @return
         */
        private static int prec(char op) {
            return (op == '+' || op == '-') ? 1 : 2; // +, -는 1, *, /는 2로 우선순위 설정
        }

        /**
         * 연산자 스택 top을 꺼내 피연산자 두 개에 적용 후 결과를 다시 push
         * @param nums 피연산자 스택
         * @param ops 연산자 스택
         */
        private static void apply(java.util.Deque<Double> nums, java.util.Deque<Character> ops) {
            char op = ops.pop(); // 연산자 스택에서 연산자 꺼내기
            double b = nums.pop(), a = nums.pop(); // 피연산자 스택에서 피연산자 두 개 꺼내기 (b가 나중에 push된 값, a가 먼저 push된 값)
            switch (op) {
                case '+':
                    nums.push(a + b);
                    break;
                case '-':
                    nums.push(a - b);
                    break;
                case '*':
                    nums.push(a * b);
                    break;
                case '/':
                    nums.push(a / b);
                    break;
            }
        }
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch (cmd) {
                case "CE": // 입력 및 결과 초기화
                    exprField.setText("");
                    resultField.setText("");
                    break;
                case "계산": // 수식 계산
                    calculate();
                    break;
                default: // 숫자, 연산자 버튼: 수식 필드에 이어 붙이기
                    exprField.setText(exprField.getText() + cmd); // 버튼의 텍스트를 수식 필드에 추가
                    break;
            }
        }
    }

    /**
     * 수식을 계산 메서드
     */
    private void calculate() {
        String expr = exprField.getText().trim(); // 수식 입력 필드에서 텍스트 가져와 공백 제거
        if (expr.isEmpty())
            return; // 수식이 비어있는 경우 계산하지 않고 종료

        try {
            double value = Evaluator.eval(toEvalExpr(expr)); // 수식을 평가하여 계산 결과 얻기

            if (Double.isInfinite(value) || Double.isNaN(value)) { // 계산 결과가 무한대이거나 NaN인 경우 (예: 0으로 나누기)
                JOptionPane.showMessageDialog(this,
                        "잘못된 연산입니다 (0으로 나누기 등).",
                        "계산 오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 소수점 최대/ 10자리, 정수면 정수로 표시
            String text; // 결과를 문자열로 변환하여 표시 (소수점 최대 10자리, 정수는 정수로 표시)
            if (value == Math.floor(value) && !Double.isInfinite(value)) { // 정수인 경우
                text = String.valueOf((long) value);
            } else { // 소수인 경우
                text = String.format("%.10f", value); // 소수점 10자리까지 표시
                text = text.replaceAll("0+$", "").replaceAll("\\.$", ""); // 불필요한 0과 소수점 제거
            }
            resultField.setText(text);

        } catch (Exception ex) { // 수식이 잘못된 경우 예외 처리
            JOptionPane.showMessageDialog(this,
                    "수식 오류: " + ex.getMessage(),
                    "계산 오류", JOptionPane.ERROR_MESSAGE);
        }
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Assignment2Frame::new);
    }
}