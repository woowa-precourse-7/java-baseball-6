package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BaseballNumberTest {
    @Test
    @DisplayName("getBaseballState(): 입력한 수에 대한 결과를 볼, 스트라이크 개수로 리턴한다.")
    void getBaseballStates() {
        BaseballNumber baseballNumber = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber threeStrike = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber oneBallOneStrike = new BaseballNumber(List.of(1, 3, 4));

        assertThat(baseballNumber.getBaseballStates(threeStrike).get(BaseballState.STRIKE))
                .isEqualTo(3);

        assertThat(baseballNumber.getBaseballStates(oneBallOneStrike))
                .matches(e -> e.get(BaseballState.STRIKE).equals(1))
                .matches(e -> e.get(BaseballState.BALL).equals(1));


    }

    @Nested
    @DisplayName("기본 생성자 : ")
    class Constructor {
        @Test
        @DisplayName("성공: 생성에 성공한다.")
        public void construct_success() {
            assertThat(new BaseballNumber(List.of(1, 2, 3)))
                    .isNotNull();
        }

        @Test
        @DisplayName("예외: 중복된 숫자")
        public void duplicate_throwException() {
            assertThatThrownBy(() -> new BaseballNumber(List.of(1, 1, 1)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외: 숫자의 범위 제한")
        public void invalidRange_throwException() {
            assertThatThrownBy(() -> new BaseballNumber(List.of(BaseballNumber.MAX_VALUE + 1, 2, 3)))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> new BaseballNumber(List.of(BaseballNumber.MIN_VALUE - 1, 2, 3)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외: 숫자의 개수")
        public void invalidLength_throwException() {
            assertThatThrownBy(() -> new BaseballNumber(List.of(1, 2, 3, 4)))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> new BaseballNumber(List.of(1, 2)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}