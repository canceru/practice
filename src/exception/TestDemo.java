package exception;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2020-10-26
 * Time: 11:33
 */
public class TestDemo {

    public static void main(String[] args) {
        System.out.println(func2());
    }
    public static int func2() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }





    //throws 声明一个异常
    public static void func() throws ArithmeticException,NullPointerException{
        /*int[] arr = {1, 2, 3};
        System.out.println(arr[100]);*/
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(10/a);
    }

    public static void main4(String[] args) {
        try {
            System.out.println(divide(10, 0));
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
    public static int divide(int x, int y) throws ArithmeticException{
        if (y == 0) {
            //手动抛出
            throw new ArithmeticException("抛出除 0 异常");
        }
        return x / y;
    }



    public static void main3(String[] args) {

        /*func();

        System.out.println("bit");*/
         try{
            func();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("after try catch");

       /* Scanner scanner = new Scanner(System.in);
        try {
            int a = scanner.nextInt();
            System.out.println(10/a);
        }catch (ArithmeticException  e) {
            e.printStackTrace();
            System.out.println("bit");
        }finally {
            System.out.println("finally块当中的代码，一定会被执行！");
            scanner.close();
        }
        System.out.println("hello");*/
    }

    public static void main1(String[] args) {
        try {
            System.out.println(10/10);
            int[] array = null;
            System.out.println(array.length);

        }catch (ArithmeticException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("bit");
        }/*catch (NullPointerException e) {
            System.out.println("空指针异常");
        }*/
        System.out.println("hello");
    }
}
