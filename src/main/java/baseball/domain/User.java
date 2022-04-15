package baseball.domain;

public class User {
    private final String[] numbers;

    public User(String inputNumber) {
        this.numbers = inputNumber.split("");
    }

    public String[] getNumbers() {
        return this.numbers;
    }
}
