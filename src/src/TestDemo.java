
class Shape {
    public void draw() {

    }
}

class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("○");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("♦");
    }
}

class Flower extends Shape  {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}


public class TestDemo {

    public static void drawMap (Shape shape) {
        shape.draw();
    }

    public static void drawShapes() {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();
        //存放到数组的时候  发生了 向上转型的
        Shape[] shapes = {rect,cycle,cycle,rect,flower};
        //sh存放的是 shapes数组里面的每个元素
        for (Shape sh : shapes) {
            sh.draw();
        }

        /*String[] shapes = {"cycle", "rect", "cycle", "rect"};

        for (String shape : shapes) {
            if (shape.equals("cycle")) {
                cycle.draw();
            } else if (shape.equals("rect")) {
                rect.draw();
            }
        }*/
    }

    public static void main(String[] args) {
        drawShapes();
        /*Cycle cycle = new Cycle();
        drawMap(cycle);

        Rect rect = new Rect();
        drawMap(rect);*/

    }
    /*public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        // 得到一个毫秒级别的时间戳
        out.println(date.getTime());
        err.println();
    }*/
}
