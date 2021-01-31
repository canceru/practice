public class TestDemo {
    public static void main(String[] args) {
        System.out.println(faboni(5));
        System.out.println(faboni(1));
        System.out.println(faboni(40));
    }
    public static int faboni(int n) {
        int f1=1;
        int f2=1;
        int f3=1;
        for(int i=3;i<=n;i++){
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        return f3;
    }
    //求斐波那契数列的第 N 项
    /*public static void main(String[] args){
        int f1=1;
        int f2=1;
        int f3=1;
        for(int i=3;i<=40;i++){
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        System.out.println(f3);
    }*/
    }
    //求解汉诺塔问题(提示, 使用递归)
    /*public static void main(String[] args) {
        hanoi(1,'A','B','C');
        hanoi(2,'A','B','C');
        hanoi(3,'A','B','C');
    }
    public static void hanoi(int n,char begin ,char mid, char last){
        if (n == 1) {
            move(begin,last);
            return;
        }
        hanoi(n-1,begin,last,mid);
        move(begin,last);
        hanoi(n-1,mid,begin,last);
    }
    public static void move(char begin,char last){
        System.out.println(begin+"->"+last);
    }*/

    
    //求斐波那契数列的第 N 项
    /*public static void main(String[] args) {
        System.out.println(faboni(5));
        System.out.println(faboni(1));
        System.out.println(faboni(2));
        System.out.println(faboni(3));
    }
    public static int faboni(int n){
        if(n==1 || n==2){
            return 1;
        }
        return faboni(n-1)+faboni(n-2);
    }
*/
    //写一个递归方法，输入一个非负整数，返回组成它的数字之和.
   /* public static void main(String[] args) {
        System.out.println(sumNum(123));
    }
    public static int sumNum(int n) {
        if (n < 10) {
            return n;
        }
        return sumNum(n / 10) + n % 10;
    }*/


   /* public static void main(String[] args) {
        //阶乘
        System.out.println(fac(1));
        System.out.println(fac(5));
        System.out.println(fac(40));

        //求和
        System.out.println(sum(10));
        System.out.println(sum(100));

        printNum(1234);
    }
    public static void printNum(int n) {
        if (n < 10) {
            System.out.println(n);
            return ;
        }
        printNum(n / 10) ;
        System.out.println(n%10);
    }

    public static int fac (int n) {
        if (n == 1){
            return 1;
        }
        return n*fac(n-1);
    }*/