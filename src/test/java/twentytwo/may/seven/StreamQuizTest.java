package twentytwo.may.seven;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StreamQuizTest {
    private StreamQuiz streamQuiz = new StreamQuiz();
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    @Test
    void getTransactionsByYearOrderByValue() {
        //given
        int year = 2011;

        List<Transaction> expectedTransactions = Arrays.asList(
                new Transaction(brian,2011, 300),
                new Transaction(raoul,2011, 400)
        );
        //when
        List<Transaction> transactionByYearOrderByValue = streamQuiz.getTransactionsByYearOrderByValue(year);

        //then
        assertThat(transactionByYearOrderByValue).isEqualTo(expectedTransactions);
    }

    @Test
    void getAllCityTraderWorking() {
        //given
        List<String> expectCitys = Arrays.asList("Cambridge", "Milan");
        //when
        List<String> allCityTraderWorking = streamQuiz.getAllCityTraderWorking();
        //then
        assertThat(allCityTraderWorking).isEqualTo(expectCitys);
    }

    @Test
    void getTradersLiveInCityOrderByName() {
        //given
        List<Trader> expectTraders = Arrays.asList(raoul, alan, brian);
        //when
        List<Trader> tradersByCityOrderByName = streamQuiz.getTradersLiveInCityOrderByName("Cambridge");
        //then
        assertThat(tradersByCityOrderByName).hasSameElementsAs(expectTraders);
    }

    @Test
    void isTraderExistInCity() {
        //given

        //when
        boolean traderExistInMilan = streamQuiz.isTraderExistInCity("Milan");
        //then
        assertThat(traderExistInMilan).isTrue();
    }

    @Test
    void getMaxTransactionValue() {
        //given
        int expect = 1000;
        //when
        int maxTransactionValue = streamQuiz.getMaxTransactionValue();
        //then
        assertThat(maxTransactionValue).isEqualTo(expect);
    }

    @Test
    void getMinTransactionValue() {
        //given
        int expect = 300;
        //when
        int minTransactionValue = streamQuiz.getMinTransactionValue();
        //then
        assertThat(minTransactionValue).isEqualTo(expect);
    }
}