package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.Validation;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static baseball.service.Play.playBall;
import static baseball.util.LengthUtil.getNumberLength;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {

    @Test
    void 컴퓨터_객체_랜덤번호_사이값_테스트() {
        int computerNumber = Randoms.pickNumberInRange(0, 999);
        assertThat(computerNumber).isBetween(0, 999);
    }

    @Test
    void 컴퓨터_객체_랜덤번호_자릿수_테스트() {
        int computerNumberLength = getNumberLength(Randoms.pickNumberInRange(0, 999));
        assertEquals(3, computerNumberLength);
    }

    @Test
    void 컴퓨터숫자와_던진볼_스크라이크_체크() {
        String computerNumber = "123";
        String inputNumber = "123";
        pitchCheck(computerNumber, new User(inputNumber));
    }

    public void pitchCheck(String computerNumber, User user) {
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < user.getNumbers().length; i++) {
            String value = user.getNumbers()[i];
            if (computerNumber.indexOf(value) == -1) {
                continue;
                // NOT
            }
            if (computerNumber.indexOf(value) == i) {
                strike ++;
                continue;
                // ST
            }
            if (computerNumber.indexOf(value) != i) {
                ball ++;
                continue;
                // BALL
            }
        }
    }

    private void allValidation(String inputNumber) {
        new Validation(inputNumber);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> allValidation("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
