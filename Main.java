/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14495
 * Date: 2021-03-27
 * Time: 16:12
 */
/*public class Main {
    public static void print(int n,int m){
        Scanner sc =new Scanner(System.in);
        int[] array = new int[n];
        int[] newarray = new int[m];
        int[] tmp = new int[m];
        for (int i = 0; i <n ; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = 0; i <m ; i++) {
            array[i] = sc.nextInt();
        }

        for (int i = 0; i <m ; i++) {
            //int count = 0;
            for (int j = 0; j <n; j++) {
                if(newarray[i] == array[j])
                    tmp[newarray[i]]++;
            }
        }
        for (int i = 0; i <tmp.length ; i++) {
            if(tmp[i]==0){
                System.out.println(0);
            }else if(tmp[i]==1){
                for (int j = 0; j <n; j++) {
                    if(i == array[j]){
                        System.out.print(array[j]);
                        System.out.println(array[j]);
                    }
                }
            }else if(tmp[i]==2){
                for (int j = 0; j <n; j++) {
                    if(i == array[j]){
                        System.out.println(array[j]);
                    }
                }
            }*//*else{
                for (int j = 0; j <n; j++) {
                    if(i == array[j]){
                        System.out.println(j);
                    }
                }*//*
            }
    }

    public static void main(String[] args) {
        print(6,4);
    }
}*/

public class Main {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();*/
        System.out.println(sumDna("CCCATGATGTAACCC",15));

    }
    public static int sumDna(String str,int n){
        int count =0;
        //for (int i = 0; i <str.length(); i++) {
         //  int j = i;
        int j= 0;
            while (j <str.length()) {
                if(str.charAt(j) == 'A' && str.charAt(j+1)=='T' && str.charAt(j+2)=='G'){
                      j=j+3;
                }
                if(str.charAt(j)=='T'){
                    if(str.charAt(j+1)=='A' ){
                        if(str.charAt(j+2)=='A' || str.charAt(j+2)=='G'){
                            j=j+3;
                            count++;
                        }
                    }else if(str.charAt(j+1)=='G' && str.charAt(j+2)=='A'){
                        j=j+3;
                        count++;
                    }
                }
                j++;
            }
        //}
        return count;
    }
}














    /*public int bestStr(String str){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i) == 1){
                sb.append(i);
            }
        }
        char[] arr = str.toCharArray();

        for (int i = 0; i <arr.length;) {
            while(arr[i] == 1){
               i++;

            }
        }

    }
*/
