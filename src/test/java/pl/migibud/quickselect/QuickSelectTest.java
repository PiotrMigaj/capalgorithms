package pl.migibud.quickselect;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class QuickSelectTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, -3),
                Arguments.of(2, -2),
                Arguments.of(3, -1),
                Arguments.of(4, 0),
                Arguments.of(5, 3),
                Arguments.of(6, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void shouldReturnCorrectValue(int kth, int expected) {
        //given
        int[] nums = {-2, -3, -1, 0, 3, 4};
        //when
        int result = QuickSelect.quickSelectKth(nums, kth);
        //then
        assertThat(result).isEqualTo(expected);
    }

}