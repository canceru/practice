字符串
public class Test2 {

    public static int indexOf (String s, String pattern) {
        // write code here
        int i=0;
        int j=0;
        int tmp=0;
        while(i<s.length() &&j<pattern.length()){
            while(i<s.length() && s.charAt(i)!=pattern.charAt(j)){
                i++;
            }
            if(s.charAt(i)==pattern.charAt(j)){
                tmp=i;
                i++;
                j++;
            }else{
                i++;
            }
        }
        /*if(!s.contains(pattern)){
            return -1;
        }else{
            return s.indexOf(pattern);
        }
*/      return tmp;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s= sc.nextLine();
        String pattern= sc.nextLine();
        System.out.println(indexOf(s,pattern));
    }
}