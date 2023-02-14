package pl.migibud;

public class ArraysUtils {

    private ArraysUtils() {
        throw new UnsupportedOperationException();
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
