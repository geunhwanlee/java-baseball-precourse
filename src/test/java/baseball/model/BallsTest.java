package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {
	@ParameterizedTest
	@CsvSource(value = {"1,2,3", "4,5,6", "7,8,9"})
	void create_with_3_distinct_numbers(int first, int second, int third) {
		Balls.of(Arrays.asList(first, second, third));
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2", "3,4", "5,6"})
	void create_with_2_numbers(int first, int second) {
		assertThatThrownBy(() -> Balls.of(Arrays.asList(first, second)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3,4", "5,6,7,8"})
	void create_with_4_numbers(int first, int second, int third, int fourth) {
		assertThatThrownBy(() -> Balls.of(Arrays.asList(first, second, third, fourth)))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,1,2", "4,6,6", "9,8,9"})
	void create_with_duplicate_numbers(int first, int second, int third) {
		assertThatThrownBy(() -> Balls.of(Arrays.asList(first, second, third)))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
