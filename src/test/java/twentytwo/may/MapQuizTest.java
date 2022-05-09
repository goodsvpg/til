package twentytwo.may;

import org.junit.jupiter.api.Test;
import twentytwo.may.six.MapQuiz;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MapQuizTest {
    MapQuiz mapQuiz = new MapQuiz();
    @Test
    void square() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //when
        List<Integer> square = mapQuiz.square(numbers);
        //then
        assertThat(square).isEqualTo(Arrays.asList(1, 4, 9, 16, 25));
    }

    @Test
    void pair() {
        //given
        List<Integer> oneNumbers = Arrays.asList(1, 2, 3);
        List<Integer> twoNumbers = Arrays.asList(3, 4);

        //when
        List<Integer[]> pair = mapQuiz.pair(oneNumbers, twoNumbers);

        //then
        assertThat(pair).hasSameElementsAs(
                Arrays.asList(
                        new Integer[]{1, 3}
                        ,new Integer[]{2, 3}
                        ,new Integer[]{3, 3}
                        ,new Integer[]{1, 4}
                        ,new Integer[]{2, 4}
                        ,new Integer[]{3, 4}
                )
        );
    }

    @Test
    void sumDivideThreeZeroPair() {
        //given
        List<Integer> oneNumbers = Arrays.asList(1, 2, 3);
        List<Integer> twoNumbers = Arrays.asList(3, 4);

        //when
        List<Integer[]> pair = mapQuiz.sumDivideResultZeroPair(3, oneNumbers, twoNumbers);

        //then
        assertThat(pair).hasSameElementsAs(
                Arrays.asList(
                        new Integer[]{3, 3}
                        ,new Integer[]{2, 4}
                )
        );
    }
}