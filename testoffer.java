public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if(pHead == null){
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;

        while(k>0 & fast !=null){
            fast = fast.next;
            k--;
        }
        if(k > 0){
        return null;
        }
        while(fast !=null){
            slow =slow.next;
            fast = fast.next;
        }
        return slow;
    }
}


import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str1 = sc.nextLine();
            str1=  str1.toLowerCase();
            Character str2 = sc.nextLine().toLowerCase().charAt(0);
            int count = 0;
            for(int i =0; i<str1.length();i++){
                if(str2 == str1.charAt(i)){
                    count++;
                }
            }
            System.out.println(count);
      }
}
    