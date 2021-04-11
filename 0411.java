public class Test7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        if(str.length()<7 || str.length()>15){
            return;
        }
        String[] array = str.split("\\.");
        if(array.length !=4){
            return;
        }
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <array[i].length() ; j++) {
                char tmp=array[i].charAt(j);
                if(!(tmp>'0'&&tmp<'9'))
                    return;
            }
        }
        for (int i = 0; i <4 ; i++) {
            int tmp=Integer.parseInt(array[i]);
            if(tmp<0 || tmp>255){
                return;
            }
        }
        System.out.println("字符串合法");
    }
}