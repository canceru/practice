import java.util.Scanner;

public class TestDemo {

    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }

    public static void func1() {
        try {

        }catch (NullPointerException e) {

        }catch ( Exception e) {

        }
    }

    public static void main(String[] args) {

        Scanner scan =  new Scanner(System.in);

        while(scan.hasNextLine()) {
            String str = scan.nextLine();
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i < str.length();i++) {
                char tmp = str.charAt(i);
                if(!sb.toString().contains(tmp+"")) {
                    sb.append(tmp);
                }
            }
            System.out.println(sb);
        }

        /*StringBuilder sb = new StringBuilder();
        sb.append("12");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("1234");*/

        //String str = "ab";
        /*for (int i = 0; i < 10; i++) {
            str += i;
        }
        System.out.println(str);*/
      /*  StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < 10; i++) {
            str = sb.append(i).toString();
        }
        System.out.println(str);
        */


        /*String str = "abcd";
        String str2 = str+"ef";
        System.out.println(str2);*/


        /*StringBuilder sb = new StringBuilder();
        sb.append("abcd").append("ef");
        String str2 = sb.toString();
        System.out.println(str2);*/

       /* System.out.println(sb);
        sb.append("ef").append("gh");
        sb.append("jk");
        System.out.println(sb);*/

    }



/*
    public static String reverse(String str) {
        if(str == null) return null;
        //1、先把字符串转变为数组
        char[] array = str.toCharArray();
        //2、开始逆置
        int i = 0;
        int j = array.length-1;
        while (i < j) {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
        //3、把数组变成字符串
        //return new String(array);
        //return String.valueOf(array);
        return String.copyValueOf(array);
    }

    public static String reverse2(String str,int i,int j) {
        if(str == null) return null;
        //1、先把字符串转变为数组
        char[] array = str.toCharArray();
        //2、开始逆置
        while (i < j) {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
        return String.copyValueOf(array);
    }

    public static String reverseK(String str,int k) {
        if(str == null) return null;
        int len = str.length();
        if(len == 0 || k <= 0 || k > len) {
            return null;
        }
        str = reverse2(str,0,k-1);//bacdef
        str = reverse2(str,k,len-1);//bafedc
        str = reverse2(str,0,len-1);//cdefab
        return str;
    }

    public static void main(String[] args) {
        System.out.println(reverseK("abcdef",2));
    }*/
}
