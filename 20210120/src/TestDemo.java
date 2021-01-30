import java.util.Scanner;

public class TestDemo {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <=n; i++) {
            int tem=i;
            int count = 0;
            while(tem!=0){
                count++;
                tem=tem/10;
            }
            int sum=0;
            tem=i;
            while(tem!=0){
                sum += Math.pow(tem%10,count);
                tem=tem/10;
            }
            if(sum == i) {
                System.out.println(i + "是自幂数");
            }
        }
    }
        //自幂数
        /*for (int i = 100; i <= 999 ; i++) {
            int ret=i;
            int j=ret%10;
            int k=(ret/10)%10;
            ret=ret/100;
            if(i==j*j*j+k*k*k+ret*ret*ret){
                System.out.println(i);
            }
        }
    }*/

    //正负分数
    /*public static void main(String[] args) {
        double sum=0;
        int i = 1,flag=1;
        while ( i <=100 ) {
            //sum=sum+(1.0/i)*flag;
            sum += (1.0/i)*flag;
            flag=-flag;
            i++;
        }
        System.out.println(sum);
    }*/


    //最大公约数
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        while(a%b!=0){
            int c=a%b;
            a = b;
            b = c;
        }
        System.out.println("最大公约数为："+b);
    }*/

    //乘法表
    /*public static void main(String[] args) {
        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }*/

   /* //闰年
    public static void main(String[] args) {
        int count = 0;
        for(int year=1000;year<=2000;year++){
            if(year%4==0 && year%100!=0 || year%400==0){
                count++;
                System.out.print(year+"\t");
                if(count%5==0)
                    System.out.println();
            }
        }
    }*/

    //1-100素数
    /*public static void main(String[] args) {

        for (int j = 1; j <= 100 ; j++) {
            int i=2;
            for(;i<=Math.sqrt(j);i++) {
                if (j % i == 0) {
                    break;
                }
            }
                if(i>Math.sqrt(j)){
                    System.out.println(j);
                }
            }
        }*/

    //素数
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        if(n <= 0){
            System.out.println("不是素数");
            return;
        }
        int i=2;
        for(;i<=Math.sqrt(n);i++){
            if(n % i == 0 ) {
                System.out.println(n + "不是素数");
                break;
            }
        }
        if(i>Math.sqrt(n)){
            System.out.println(n+"是素数");
        }
    }*/

    //阶乘
    /*public static void main(String[] args) {
        int result = sumFac(5);
        System.out.println(result);
    }
    public static int fac(int a) {
        int facNum = 1;
        for (int i = 1; i <=a; i++) {
            facNum=facNum*i;
        }
        return facNum;
    }
    public static int sumFac(int a) {
        int sum = 0;
        for (int i = 1; i <=a; i++) {
            sum=sum+fac(i);
        }
        return sum;
    }*/
}
