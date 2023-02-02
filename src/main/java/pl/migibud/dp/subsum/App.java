package pl.migibud.dp.subsum;

class App {
    public static void main(String[] args) {
        int[] nums = {0,1,-1,2,3,-1,-1,-1,-1,-1,-1,-1,-1,4};
        int result = maxSubSum(nums);
        System.out.println("Result: "+result);
    }

    public static int maxSubSum(int [] nums){

        int globalSum=0;
        int localSum=0;

        for (int i=0;i< nums.length;i++){
            localSum=Math.max(localSum+nums[i],nums[i]);
            System.out.println("Localsum: "+localSum);
            if (localSum>globalSum){
                globalSum=localSum;
            }
        }
        return globalSum;
    }
}

