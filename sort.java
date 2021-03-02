import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14495
 * Date: 2021-03-02
 * Time: 12:50
 */
public class TestSort {
    //直接插入排序
    public static void insert(int[] array){
        for (int i = 1; i <array.length ; i++) {
            int tmp = array[i];
            int j=i-1;
            for (; j>=0 && array[j]>tmp ; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = tmp;
        }
    }
    public static void shell(int[] array,int gap){
        for(int i=gap;i<array.length;i=i+1){
            int tmp=array[i];
            int j=i-gap;
            for (; j>=0 && array[j]>tmp ;j=j-gap) {
                array[j+gap] = array[j];
            }
            array[j+gap] = tmp;
        }
    }
   public static void shellsort(int[]array){
        int [] d = {5,3,1};
        for (int i = 0; i <d.length ; i++) {
            shell(array,d[i]);
        }
    }
    //
    public static void selectSort(int[] array){
        for (int i = 0; i <array.length ; i++) {
            int min = i;
            for (int j = i+1; j <array.length; j++) {
                if(array[i]>array[j]){
                    int tmp = array[i];
                    array[i]= array[j];
                    array[j] = tmp;
                }
            }
        }
    }
    public static void createHeap(int[] array){
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
            adjustDown(array,i,array.length);
        }
    }
    public static void adjustDown(int[] array,int parent,int len) {
        int child = 2*parent+1;
        while (child < len) {

            if(child+1 < len && array[child] < array[child+1]) {
                child++;
            }

            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }


    public static int partion(int[] array,int low,int high){
        int tmp=array[low];
        while(low<high){
            while(low<high && array[high]>=tmp)
                high--;
            array[low] = array[high];
            while(low<high && array[low]<=tmp)
                low++;
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }
    public static void quickSort(int[] array,int low,int high){
        if(low<high){
            int par = partion(array,low,high);
            quickSort(array,low,par-1);
            quickSort(array,par+1,high);
        }
    }

    public static void mergeSort(int[] array,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(array,low,mid);
            mergeSort(array,mid+1,high);
            merge(array,low,high,mid);
        }
    }
    public static void merge(int[] array,int low,int high,int mid){
        int[] tmp = new int[high-low+1];
        int k=0;
        int s1=low;
        int s2=mid+1;
        while(s1<=mid&&s2<=high){
            if(array[s1]<array[s2]){
                tmp[k] = array[s1];
                s1++;
            }else{
                tmp[k] = array[s2];
                s2++;
            }
            k++;
        }
        while (s1 <= mid) {
            tmp[k++] = array[s1++];
        }
        while (s2 <= high) {
            tmp[k++] = array[s2++];
        }
        //也就是说 tmpArr 当中存放的 就是这次归并的有序之后 的 结果
        for (int i = 0; i < tmp.length; i++) {
            array[low+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        System.out.println(Arrays.toString(array));
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}