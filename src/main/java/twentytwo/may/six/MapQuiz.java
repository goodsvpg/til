package twentytwo.may.six;

import java.util.List;
import java.util.stream.Collectors;

public class MapQuiz {
    public List<Integer> square(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    public List<Integer[]> pair(List<Integer> oneNumbers, List<Integer> twoNumbers) {
        return oneNumbers.stream()
                .flatMap(
                        oneNumber -> twoNumbers.stream()
                                .map(twoNumber -> new Integer[]{oneNumber,twoNumber})
                ).collect(Collectors.toList());
    }

    public List<Integer[]> sumDivideResultZeroPair(int divided, List<Integer> oneNumbers, List<Integer> twoNumbers) {
        return oneNumbers.stream()
                .flatMap(
                        oneNumber -> twoNumbers.stream()
                                .filter(twoNumber -> (oneNumber + twoNumber) % divided == 0)
                                .map(twoNumber -> new Integer[]{oneNumber, twoNumber})
                ).collect(Collectors.toList());
    }
}
