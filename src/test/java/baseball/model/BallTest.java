package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
	void in_range(int number) {
		new Ball(number);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 10})
	void out_of_range(int number) {
		assertThatThrownBy(() -> new Ball(number))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
