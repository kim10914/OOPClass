package chapter05;

class Line {
    private int x1, y1, x2, y2; // 선을 구성하는 시작점(x1, y1)과 끝점(x2, y2)

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1; // 시작은 1
        this.y1 = y1;
        this.x2 = x2; // 끝은 2
        this.y2 = y2;
    }

    // private 필드를 위한 getter
    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void drawLine() {
        System.out.println("(" + x1 + "," + y1 + ")에서 (" + x2 + "," + y2 + ")까지 선을 그립니다.");
    }

    public void eraseLine() {
        System.out.println("(" + x1 + "," + y1 + ")에서 (" + x2 + "," + y2 + ")까지 선을 지웁니다.");
    }
}

// 색깔을 가진 선
class ColoredLine extends Line {
    private String color; // 색깔

    public ColoredLine(int x1, int y1, int x2, int y2, String color) {
        super(x1, y1, x2, y2); // 수퍼 클래스(Line)의 생성자 호출
        this.color = color;
    }

    // color 반환을 위한 접근 메소드
    public String getColor() {
        return color;
    }

    @Override
    public void drawLine() {
        System.out.print("[" + color + "색] ");
        super.drawLine(); // 부모 클래스의 선그리기 호출
    }

    @Override
    public void eraseLine() {
        System.out.print("[" + color + "색] ");
        super.eraseLine(); // 부모 클래스의 선삭제 호출
    }
}

public class Assigment2 {
    public static void main(String[] args) {
        System.out.println("\n=== Line 및 ColoredLine 출력 ===");
        Line regularLine = new Line(0, 0, 10, 10);
        regularLine.drawLine();
        regularLine.eraseLine();

        System.out.println();

        ColoredLine coloredLine = new ColoredLine(10, 10, 20, 20, "Red");
        coloredLine.drawLine();
        coloredLine.eraseLine();
    }

}
