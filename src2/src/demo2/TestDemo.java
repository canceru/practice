package demo2;



/**
 * 1、接口当中的方法，一定是不能够有具体的实现的
 * 2、接口当中default中修饰的方法才能够有具体的实现的。
 * 3、接口当中的成员变量 都是public static final的
 * 4、接口当中的方法都是public abstract
 * 5、如果不写，默认都是
 * 6、接口不能够进行实例化：Shape shape = new Shape();
 * 7、接口也可以发生向上转型和运行时绑定
 */
interface Shape {
    void draw();
    /*default public void func() {
    }
    default public void func2() {
    }*/
}

class Cycle implements Shape {
    public void draw () {
        System.out.println("圆圈");
    }
}

class Flower implements Shape {
    public void draw () {
        System.out.println("❀");
    }
}

public class TestDemo {

    public static void drawMap (Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape shape1 = new Flower();
        shape1.draw();
        Shape shape2 = new Cycle();
        shape2.draw();
        Flower flower = new Flower();
        drawMap(flower);
    }
}
