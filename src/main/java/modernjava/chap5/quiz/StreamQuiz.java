package modernjava.chap5.quiz;

import modernjava.chap5.quiz.exception.TransactionDoesNotExistException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StreamQuiz {
    private Trader raoul = new Trader("Raoul", "Cambridge");
    private Trader mario = new Trader("Mario", "Milan");
    private Trader alan = new Trader("Alan", "Cambridge");
    private Trader brian = new Trader("Brian", "Cambridge");

    private List<Transaction> transactions = Arrays.asList(
            new Transaction(brian,2011, 300),
            new Transaction(raoul,2012, 1000),
            new Transaction(raoul,2011, 400),
            new Transaction(mario,2012, 710),
            new Transaction(mario,2012, 700),
            new Transaction(alan,2012, 950)
    );

    public List<Transaction> getTransactionsByYearOrderByValue(int year) {
        return transactions.stream()
                .filter(transaction -> transaction.getYear() == year)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public List<String> getAllCityTraderWorking() {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Trader> getTradersLiveInCityOrderByName(String city) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(city))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    public String getAllTraderNameOrderByAlphabet() {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (name1, name2) -> name1 + name2);
    }

    public boolean isTraderExistInCity(String city) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(city))
                .findAny()
                .isPresent();
    }

    public void getTransactionsLiveInCity(String city) {
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals(city))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    public int getMaxTransactionValue() {
        return transactions.stream()
                .max(comparing(Transaction::getValue))
                .map(Transaction::getValue)
                .orElseThrow(() -> new TransactionDoesNotExistException());
    }

    public int getMinTransactionValue() {
        return transactions.stream()
                .min(comparing(Transaction::getValue))
                .map(Transaction::getValue)
                .orElseThrow(() -> new TransactionDoesNotExistException());
    }
}
