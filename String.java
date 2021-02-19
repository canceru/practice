public class TestDemo {

    public static String reverse(String str){
        if(str == null)
            return null;
        char[] array = str.toCharArray();
        int i = 0 ;
        int j = array.length-1;
        while(i < j){
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
        return new String(array);
        //return String.copyValueOf(array);
    }
    public static String reverse2(String str,int i,int j){
        if(str == null)
            return null;
        char[] array = str.toCharArray();
        while(i < j){
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
        return new String(array);
        //return String.copyValueOf(array);
    }
    public static String reversek(String str,int k){
        if(str == null){
            return null;
        }
        int len = str.length();
        if(len == 0 || k<0 ||k>len){
            return null;
        }
        str = reverse2(str,0,k-1);
        str = reverse2(str,k,len-1);
        str = reverse2(str,0,len-1);
        return str;
    }

    public static void main(String[] args) {
        System.out.println(reverse("abcde"));
        System.out.println(reversek("abcdef",2));
    }
}