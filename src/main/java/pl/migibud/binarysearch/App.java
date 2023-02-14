package pl.migibud.binarysearch;

import java.util.Arrays;

class App {
    public static void main(String[] args) {
        int[] nums = {1, 2, 10, 13, 14, 5, 6};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int i = binarySearch(nums, 13);
        System.out.println("Index i: " + i);
    }

    public static int binarySearch(int[] nums, int searchValue) {

        int startIndex = 0;
        int endIndex = nums.length;
        int middleIndex = -1;

        while (startIndex <= endIndex) {
            middleIndex = (startIndex + endIndex) / 2;
            if (nums[middleIndex] == searchValue) {
                return middleIndex;
            }
            if (nums[middleIndex] > searchValue) {
                endIndex = middleIndex;
            }
            if (nums[middleIndex] < searchValue) {
                startIndex = middleIndex + 1;
            }
        }
        return middleIndex;
    }
}
