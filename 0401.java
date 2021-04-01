public class Main {

    /*public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();
        int count =0;
        int sum=0;
        for (int i = 1; i <=3 ; i++) {
            for (int j = 1; j <=n ; j++) {
                count = count+m;
                sum =sum+count;
            }
            //count = count+m;
            //sum = sum+count;
        }
        System.out.println(sum);
    }*/

    /*public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String S = sc.nextLine();
        String T =sc.nextLine();
        for (int i = 0; i <S.length() ;i++) {
            for (int j = 0; j <T.length() ;j++) {
                if(S.charAt(i)==T.charAt(j)){
                    i++;
                    j++;
                }
            }
        }

    }*/

    public static ArrayList<String> deleteSame(String S) {
        char[] arr = S.toCharArray();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i <arr.length ; i++) {
            if(!list.contains(arr[i])){
                list.add(String.valueOf(arr[i]));
            }
        }
        /*for (int i = 0; i < arr.length; i++) {
            //int j =i+1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                     tmp = j;
                    while (j < arr.length-1) {
                        arr[j] = arr[j+1 ];
                        j++;
                    }
                    j=tmp;
                }
            }
        }*/
        return list;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String S = sc.nextLine();
        String T =sc.nextLine();
        /*char[] arr1 = deleteSame(S);
        char[] arr2= deleteSame(T);
        int count=0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j <arr2.length ; j++) {
                if(arr1[i] == arr2[j]){
                    count++;
                }
            }
        }*/

        ArrayList<Character> list1 = new ArrayList<Character>();
        ArrayList<Character> list2 =new ArrayList<Character>();
        for (int i = 0; i <S.length() ; i++) {
            if(!list1.contains(S.charAt(i))){
                list1.add(S.charAt(i));
            }
        }
        for (int i = 0; i <T.length() ; i++) {
            if(!list2.contains(T.charAt(i))){
                list2.add(T.charAt(i));
            }
        }
        System.out.println(list1.toString());
        System.out.println(list2.toString());
    }
}