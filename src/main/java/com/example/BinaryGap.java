package com.example;

public class BinaryGap {

    public static void main(String[] args) {
        
        String binaryString = "1000000000000000000000000000001";
        int number = Integer.parseInt(binaryString, 2);

        long start = System.nanoTime();
        binaryGapMyVersion(number);
        //binaryGap(number);
        long finish = System.nanoTime();
        System.out.println("Executed in " + (finish - start) + " ns");
    }

    public static int binaryGap(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }

        return ans;
    }

    public static int binaryGapMyVersion(int n) {
        
        //for(int i=0; i<32;i++){
        //    System.out.println(String.format("i=%d, n>>i=%s, (n>>i)&1=%s", i, Integer.toBinaryString(n >> i), (n>>i)&1));
        //}

        //int arrayLength = Integer.toBinaryString(n).length();

        int longestDistance = 0;
        int max = 0;

        for(int i=0; i<32; i++ ){
            if( ((n>>i) & 1) == 1){
                if(max > longestDistance) longestDistance = max;
                max = 1;
            } else if(max > 0) {
                max++;
            }
        }

        return longestDistance;
    }
}
