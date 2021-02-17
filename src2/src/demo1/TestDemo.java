package demo1;



/**
 * 抽象类：
 * 1、包含抽象方法的类，抽象类。使用abstract关键字来修饰的
 * 2、抽象方法是不能够有具体的实现的。
 * 3、在抽象类当中，可以定义和普通类相同的数据属性和方法
 * 4、抽象类不能够进行实例化.
 *    Shape shape = new Shape();
 * 5、问题：那么抽象类存在的意义是什么？既然不能够进行实例化
 * 那么数据成员和方法如何调用呢？
 *   答案：抽象类天生就是为了被继承
 * 6、一个普通类继承了这个抽象类之后，一定要重写，抽象类的抽象方法
 * 7、如果一个类，继承了抽象类但是又不想重写这个抽象方法
 * 那么就把这个类也设置为抽象类，但是迟早都要重写的。
 * 8、抽象方法不能是private
 *
 */
abstract class Shape {
    public abstract void draw();
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("○");
    }
}

class Flower extends Shape {
    @Override
    public void draw() {
    }
}

public class TestDemo {

    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        //Shape shape = new Shape(); error
        drawMap(new Cycle());
        drawMap(new Flower());
    }
}
