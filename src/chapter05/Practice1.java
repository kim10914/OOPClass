package chapter05;

class Circle {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}

class NamedCircle extends Circle {
    private String name;

    public NamedCircle(int radius, String name) {
        super(radius);
        this.name = name;
    }

    public void show() {
        System.out.println(name + ", 반지름 = " + getRadius());
    }
}

public class Practice1 {
    public static void main(String[] args) {
        NamedCircle w = new NamedCircle(5, "Waffle");
        w.show(); // Waffle, 반지름 = 5 출력
    }
}
