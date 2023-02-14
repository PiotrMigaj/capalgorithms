package pl.migibud.quickselect;

class QuickSelect {
    public static void main(String[] args) {
        int[] nums = {0, 3, 13, 1, -2, -3, 5};
        int kth = 2;
        int result = quickSelectKth(nums, kth);
        System.out.println(result);
    }

    public static int quickSelectKth(int[] nums, int kth) {
        return quickSelectKth(nums, kth - 1, 0, nums.length);
    }

    private static int quickSelectKth(int[] nums, int kth, int low, int length) {
        int pivot = partition(nums, low, length);
        if (pivot == kth) {
            return nums[pivot];
        }
        if (pivot > kth) {
            return quickSelectKth(nums, kth, low, pivot);
        }
        return quickSelectKth(nums, kth, pivot + 1, length);
    }

    public static int partition(int[] nums, int low, int length) {
        int i = low - 1;
        for (int j = low; j < length; j++) {
            if (nums[j] <= nums[length - 1]) {
                i++;
                swap(nums, i, j);
            }
        }
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
