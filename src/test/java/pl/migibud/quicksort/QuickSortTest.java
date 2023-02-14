package pl.migibud.quicksort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuickSortTest {

    @Test
    void shouldSortArray() {
        //given
        int[] nums = {-1, 10, -5, 3, 4, 1};
        //when
        QuickSort.quickSort(nums);
        //then
        assertThat(nums).containsExactly(-5, -1, 1, 3, 4, 10);
    }

}