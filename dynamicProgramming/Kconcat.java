public class Kconcat {
    public static void main(String[] args){
        int[] arr = {1,-4, -3,2};
        System.out.println(maxSum(arr,3));
    }    

    public static int maxSum(int[] arr, int k){
        if(k==1){
            return kadanes(arr,1);
        }else{
            int sum =0; 
            for(int i =0; i< arr.length; i++){
                sum += arr[i];
            }
            if(sum > 0){
                return (k-1) * sum + kadanes(arr, 2);
            }else{
                return kadanes(arr, 2);
            }
        }
    }

    public static int kadanes(int[] arr,int c){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i< arr.length; i++){
            currSum = Math.max(currSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currSum);

        }
        return maxSum;
    }
}
