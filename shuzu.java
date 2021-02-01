public class TestDemo {
    public static void main(String[] args){
        int[] arr = {1,2,5,8,10,9};
        /*for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }*/
        //System.out.println(Arrays.toString(array));
        //printArray(arr);
        //System.out.println(Arrays.toString(arr));

        /*int[] ret = copyArray(arr);
        System.out.println(Arrays.toString(ret));

        int[] copy1 = Arrays.copyOf(arr, 4);
        System.out.println(Arrays.toString(copy1));

        int[] copy2 = arr.clone();
        System.out.println(Arrays.toString(copy2));

        int[] copy3 = copyArray(arr);
        System.out.println(Arrays.toString(copy2));*/
        //最大值
        //System.out.println(maxArray(arr));
        //平均值
        //System.out.println(avg(arr));
        //查找
        //System.out.println(findNum(arr, 5));
        //二分查找
        //System.out.println(binarySearch(arr, 10));
        //有序
        //System.out.println(isSorted(arr));
        //冒泡
        /*bubble(arr);
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));*/
        //数组逆序
        //reverse(arr);
        //System.out.println(Arrays.toString(arr));
        //奇偶排列
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //奇偶排列
    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            while(left<right && arr[left]%2 == 0){
                left++;
            }
            while(left<right && arr[right]%2 != 0){
                right--;
            }
            int tmp = arr[left];
            arr[left]= arr[right];
            arr[right] = tmp;
        }
    }
    //数组逆序
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
    //冒泡
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length; i >0; i--) {
            for (int j = 1; j < i; j++) {
                if(arr[j]>arr[j-1]){
                    int tmp = arr[j-1];
                    arr[j-1] =arr[j];
                    arr[j]= tmp;
                }
            }
        }
    }
    public static void bubble(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            flag = false;
            for (int j = arr.length-1; j > i; j--) {
                if(arr[j]<arr[j-1]){
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                    flag = true;
                }
            }
            if(flag==false){
                break;
            }
        }
    }
    //检查数组的有序性
    public static boolean isSorted (int[] arr) {
        for (int i=0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
    //二分查找
    public static int binarySearch(int[] arr,int n ){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]<n){
                left = mid+1;
            }else if(arr[mid]>n){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    //查找位置
    public static int findNum(int[] arr,int n){
        int i = 0;
        for (; i < arr.length; i++) {
            if(arr[i] == n){
                return i+1;
            }
        }
            return -1;
    }

    //平均值
    public static double avg(int[] arr) {
        int sum = 0;
        int i = 0;
        for (; i < arr.length; i++) {
            sum+=arr[i];
        }
        double ret = sum/arr.length;
        return ret;
    }
    //数组最大值
    public static int maxArray(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    //打印数组
    public static void  printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    //数组拷贝
    public static int[] copyArray(int[] arr){
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
}
