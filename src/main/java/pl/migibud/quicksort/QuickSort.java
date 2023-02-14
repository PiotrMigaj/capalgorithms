package pl.migibud.quicksort;

import pl.migibud.ArraysUtils;

import java.util.Arrays;

class QuickSort {

    public static void main(String[] args) {

        int[] nums = {0, 3, 13, 1, -2, -3, 5};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length);
    }

    private static void quickSort(int[] nums, int low, int length) {
        if (low >= length) {
            return;
        }
        int pivot = partition(nums, low, length);
        quickSort(nums, low, pivot);
        quickSort(nums, pivot + 1, length);
    }

    private static int partition(int[] nums, int low, int length) {
        int i = low - 1;
        for (int j = low; j < length; j++) {
            if (nums[j] <= nums[length - 1]) {
                i++;
                ArraysUtils.swap(nums, i, j);
            }
        }
        return i;
    }
}
