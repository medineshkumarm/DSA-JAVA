import java.util.HashMap;

class LongSum {
    public static void main(String[] args) {
        // int[] arr = { 10,5,2,7,1,9 };
        // System.out.println(longestSubArrayWithSumK(arr, 15));
        // int[] arr = {2,4,8,1,3,6,2,9,3,11};
        // System.out.println(longestSubarrayWithSumDivisibleByK(arr, 5));
        int[] arr = {2,7,6,1,4,5};
        System.out.println(longestSubarrayWithSumDivisibleByK(arr, 3));
    }
    public static int longestSubArrayWithSumK(int[] arr, int target){
        int maxLen = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        int psum = 0;
        for(int i =0; i < arr.length; i++){
            psum += arr[i];
            if(map.containsKey(psum - target)){
                maxLen = Math.max(maxLen, i - map.get(psum - target));
            }
            if(map.containsKey(psum) == false){
                map.put(psum , i);
            }
        }
        return maxLen;
    }
    //not working
    public static int longestSubarrayWithSumDivisibleByK (int[] arr, int k ){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int maxLen = 0;

        for(int i =0; i < arr.length; i++){
            sum += arr[i];
            int mod = ((sum%k) + k) % k;
            
            if(map.containsKey(mod) == true){
                maxLen = Math.max(maxLen, i - map.get(mod));
            }else{
                map.put(mod,i);
            }
        }
        return maxLen;
    }
}