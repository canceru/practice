统计一个数字在排序数组中出现的次数。
class Solution {
    public int search(int[] nums, int target) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     if(!map.containsKey(nums[i])){
        //         map.put(nums[i],1);
        //     }else{
        //         map.put(nums[i],map.get(nums[i])+1);
        //     }
        // }
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==target){
        //         return map.get(nums[i]);
        //     }
        // }
        // return 0;

        //return help(nums,target)-help(nums,target-1);

        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]<=target){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        int right =i;
        if(j >= 0 && nums[j] != target) return 0;
        i=0;
        j=nums.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]<target){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    // public int help(int[] nums,int target){
    //     int i=0;
    //     int j=nums.length-1;
    //     while(i<=j){
    //         int mid=(i+j)/2;
    //         if(nums[mid]<=target){
    //             i=mid+1;
    //         }else{
    //             j=mid-1;
    //         }
    //     }
    //     return i;
    // }
}