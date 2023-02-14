package pl.migibud.quickselect2;

class App {
    public static void main(String[] args) {
//        int[] input = {-1, -2, -3, 0, 5, 6, -4, 7, 1};
//        select(input);
//        System.out.println(Arrays.toString(input));

        int i = simpleFibbo(16);
        System.out.println(i);
    }

    public static final void select(int[] nums) {

        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] <= nums[nums.length - 1]) {
                swap(nums, ++i, j);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int simpleFibbo(int n) {
        int t0 = 0;
        int t1 = 1;
        if (n == 0) {
            return t0;
        }
        if (n == 1) {
            return t1;
        }

        for (int i = 2; i <= n; i++) {
            int sum = t0 + t1;
            t0 = t1;
            t1 = sum;
        }
        return t1;
    }
}
