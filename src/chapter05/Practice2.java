package chapter05;

interface AdderInterface {
    int add(int x, int y);

    int add(int n);
}

class MyAdder implements AdderInterface {
    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int add(int n) {
        return n + n;
    }
}

public class Practice2 {
    public static void main(String[] args) {
        MyAdder adder = new MyAdder();
        System.out.println(adder.add(5, 10));
        System.out.println(adder.add(10));
    }
}
