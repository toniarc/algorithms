package com.example.livroalgoritmos;

import java.util.Arrays;

public class InsertSor {

    public static void main(String[] args) {
        int[] nums = new int[]{31,41,59,26,41,58};

        int[] sortedArray =  sortArray(nums);
        System.out.println(Arrays.toString(sortedArray));
    }
    
    public static int[] sortArray(int[] nums) {

        //k = 41
        // 26,31,41,59,41,58
        //           j  i

        for (int i=1; i<nums.length; i++){
            int j =i-1;
            int k = nums[i];
            while(j >= 0 && nums[j] > k){
                nums[j+1] = nums[j];
                nums[j] = k;
                j--;
            }
        }

        return nums;    
    }
    
}
