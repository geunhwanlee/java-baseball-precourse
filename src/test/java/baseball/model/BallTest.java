package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {
	@DisplayName("1~9 사이의 숫자로 생성")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void in_range(int number) {
		assertThat(new Ball(number, 0)).isNotNull();
	}

	@DisplayName("0과 10으로 생성 시 예외 발생")
	@ParameterizedTest
	@ValueSource(ints = {0, 10})
	void out_of_range(int number) {
		assertThatThrownBy(() -> new Ball(number, 0))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("정답과 비교하여 스트라이크/볼 확인")
	@ParameterizedTest
	@CsvSource(value = {"3,0,false,true", "3,2,true,false", "4,0,false,false"})
	void match_to_123(int number, int position, boolean isStrike, boolean isBall) {
		List<Ball> answer = Arrays.asList(
				new Ball(1, 0),
				new Ball(2, 1),
				new Ball(3, 2)
		);
		Ball myBall = new Ball(number, position);
		assertThat(myBall.match(answer)).satisfies(status -> {
			assertThat(status.isStrike()).isEqualTo(isStrike);
			assertThat(status.isBall()).isEqualTo(isBall);
		});
	}
}
