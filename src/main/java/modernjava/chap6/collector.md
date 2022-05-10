[Collector](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collector.html)
======

[Collectors](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html)

자주 사용한는 컬렉터 인스턴스를 솝쉽게 생성할 수 있는 정적 팩토리 메소드를 제공

```java
List<Transaction> transactions 
            = transactionStream.collect(Collectors.toList);
```

리듀싱과 요약
----
Collector로 스트림의 모든 항목을 하나의 결과로 합칠 수 있다

###counting()
```
long howManyDishes = menu.stream().collect(Collectors.counting());

long howManyDishes = menu.stream().count();
```

###최대값과 최소값 
####Collectors.maxBy, Collectors.minBy
```java
Comparator<Dish> dishCaloriesComparator =
    Comparator.comparingInt(Dish::getCalories);

Optional<Dish> mostCalorieDish =
    menu.stream()
        .collect(maxBy(dishCaloriesComparator));
```


###요약 연산
####[Collectors.summingInt](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#summingInt-java.util.function.ToIntFunction-), Collectors.summingLong, Collectors.summingDouble
```java
int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
//혹은
int totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();
```
- 칼로리에 매핑된 각 요리 값을 탐색하면서 초기값(0)으로 설정된 누적자에 칼로리를 더함


####[Collectors.averagingInt](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#averagingInt-java.util.function.ToIntFunction-), Collectors.averagingLong, Collectors.averagingDouble
```java
double avgCalories = menu.stream().collect(averaingInt(Dish::getCalories));
```


###[Collectors.summarizinInt](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#summarizingInt-java.util.function.ToIntFunction-)
```java
IntSummaryStatistics menuStatistics =
    menu.stream().collect(summarizingInt(Dish::getCalories));

IntSummaryStatistics{count=9, sum=4300, min=120, average=477.77778, max=800}
```


###문자열 연결
####[joining](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#joining--)
```java
String shortMenu = menu.stream().map(Dish::getName).collect(joining());
```
- 내부적으로 StringBuilder를 이용해 문자열을 하나로 만든다.


###범용 리듀싱 요약 연산
####[reducing(U identity, Function<? super T, ? extends U>mapper, BinaryOperator<U,> op)](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#reducing-U-java.util.function.Function-java.util.function.BinaryOperator)
```java
int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i,j) -> i + j))
// 컬렉션 프레임워크 유연성 : 같은 연산과 다양한 방식으로 수행할 수 있다.
int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
```
- identity : 리듀싱의 시작값 / 스트림의 인수가 없을때 반환값
- mapper : 변환 함수
- op : 같은 종류의두 항목을 하나의 값으로 더하는 BinaryOperator

####[reducing(BinaryOperator<T> op)](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#reducing-java.util.function.BinaryOperator-)
```java
Optional<Dish> mostCalorieDish =
    menu.stream().collect(reducing(
        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2 
        ));
```

#### collect와 reduce
- collect : 도출하려는 결과를 누적하는 컨테이너를 바꾸도록 설계된 메서드
- reduct : 두 값을 하나로 도출하는 불변형 연산 



> 출저 : 라울-게이브리얼 우르마, 마리오 푸스코, 앨런 마이크로프트 저/우정은 역, 모던 자바 인 액션 (한빛미디어) 6장
