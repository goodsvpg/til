package modernjava.chap5.quiz;

import java.util.stream.Stream;

public class AdvancedStreamQuiz {
    public void fibonacci(int limit) {
        Stream.iterate(
                    new int[]{0,1},
                    before -> new int[]{before[1], before[0] + before[1]}
                )
                .limit(limit)
                .forEach(fibonacciArr -> System.out.println("(" + fibonacciArr[0] +"," + fibonacciArr[1] + ")"));
    }
}
