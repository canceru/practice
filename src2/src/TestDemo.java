
class A {
    public void func() {
        System.out.println("A:FUNC");
    }
}
class B extends  A {

}

class C extends  B {
    public void func() {

        System.out.println("C:FUNC");
    }
}

class Base{
    public Base(String s){
        System.out.print("B");
    }
}

class Derived extends Base{

    public Derived (String s) {
        super(s);
        System.out.print("D");
    }

    public static void main(String[] args){
        new Derived("C");
    }
}

class Shape {
    public void draw() {
    }
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
        System.out.println("❀");
    }
}

public class TestDemo {

    public static void drawMap (Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        drawMap(new Cycle());
        drawMap(new Flower());
    }
}
