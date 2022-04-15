package baseball;

import baseball.service.Validation;
import baseball.util.LengthUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidTest {

    @Test
    void 문자열_인트타입_변환테스트() {
        String strNumber = "";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> typeNoMatch(strNumber));
    }

    @Test
    void 자릿수_예외_테스트() {
        int inputNumber = 0;
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> digitNoMatch(inputNumber));
    }

    @Test
    void 양수값체크_테스트() {
        int inputNumber = -111;
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> minimumNumberCheck(inputNumber));
    }

    @Test
    void 중복된_숫자입력() {
        String inputNumber = "113";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> duplicateNumber(inputNumber));
    }

    @Test
    void 숫자0은_안되도록() {
        String inputNumber = "123";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> prohibitZero(inputNumber));
    }

    private void allValidation(String inputNumber) {
        new Validation(inputNumber);
    }

    private void typeNoMatch(String strNumber) {
        try {
            Integer.parseInt(strNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    private void digitNoMatch(int number) {
        if (LengthUtil.getNumberLength(number) != 3) {
            throw new IllegalArgumentException();
        }
    }
    private void minimumNumberCheck(int number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }
    }
    private void duplicateNumber(String inputNumber) {
        String[] numbers = inputNumber.split("");

        for (String number : numbers) {
            if (inputNumber.indexOf(number) !=
                    inputNumber.lastIndexOf(number)) {
                //예외
                throw new IllegalArgumentException();
            }
        }
    }

    private void prohibitZero(String inputNumber) {
        if (inputNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

}
