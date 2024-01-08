package com.example;

import java.util.Arrays;

public class InsertSor {

    //chave = 1
    //2, 2, 2, 2, 2, 2 --valor
    //0  1  2  3  4  5 --indice
    //         i     j --ponteiro

    public static void main(String[] args) {
        int[] nums = new int[]{31,41,59,26,41,58};

        int[] sortedArray =  sortArray(nums);
        Arrays.asList(sortedArray).stream().forEach(System.out::println);
    }
    
    public static int[] sortArray(int[] nums) {

        for(int j =1 ;j<nums.length; j++){ // j = 5

            int chave = nums[j]; // chave = 3
            int i = j-1; // i = 3
            
            while (i > -1 && nums[i] > chave) { // nums[2] = 4, chave = 3
                if(nums[i+1] != nums[i]){
                    nums[i+1] = nums[i];
                }
                i = i -1;
            }

            nums[i+1] = chave; //nums[1+1] = 3

        }

        return nums;    
    }
    
}
