package pl.migibud.mergesort;

import java.util.Arrays;

class MergeSort {

    int[] nums;
    int[] tempArray;

    public MergeSort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

    void sort() {
        mergeSort(0, nums.length - 1);
    }

    private void mergeSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int middleIndex = (low + high) / 2;
        mergeSort(low, middleIndex);
        mergeSort(middleIndex + 1, high);
        merge(low, middleIndex, high);
    }

    private void merge(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            tempArray[i] = nums[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (tempArray[i] < tempArray[j]) {
                nums[k] = tempArray[i];
                i++;
            } else {
                nums[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            nums[k] = tempArray[i];
            i++;
            k++;
        }
        while (j <= high) {
            nums[k] = tempArray[j];
            j++;
            k++;
        }

    }

    void showArray() {
        System.out.println(Arrays.toString(nums));
    }


    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
