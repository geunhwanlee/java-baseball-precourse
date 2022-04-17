package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {
	@DisplayName("1부터 9까지 서로다른 임의의 수 3개로 생성")
	@ParameterizedTest
	@CsvSource(value = {"1,2,3", "4,5,6", "7,8,9"})
	void create_with_3_distinct_numbers(int first, int second, int third) {
		List<Integer> numbers = Arrays.asList(first, second, third);
		assertThat(Balls.of(numbers)).isNotNull();
	}

	@DisplayName("숫자 2개로 생성 시 예외 발생")
	@ParameterizedTest
	@CsvSource(value = {"1,2", "3,4", "5,6"})
	void create_with_2_numbers(int first, int second) {
		List<Integer> lessNumbers = Arrays.asList(first, second);
		assertThatThrownBy(() -> Balls.of(lessNumbers))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("숫자 4개로 생성 시 예외 발생")
	@ParameterizedTest
	@CsvSource(value = {"1,2,3,4", "5,6,7,8"})
	void create_with_4_numbers(int first, int second, int third, int fourth) {
		List<Integer> moreNumbers = Arrays.asList(first, second, third, fourth);
		assertThatThrownBy(() -> Balls.of(moreNumbers))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("중복된 숫자로 생성 시 예외 발생")
	@ParameterizedTest
	@CsvSource(value = {"1,1,2", "4,6,6", "9,8,9"})
	void create_with_duplicate_numbers(int first, int second, int third) {
		List<Integer> duplicatedNumbers = Arrays.asList(first, second, third);
		assertThatThrownBy(() -> Balls.of(duplicatedNumbers))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("정답과 비교하여 스트라이크, 볼의 갯수 확인")
	@ParameterizedTest
	@CsvSource(value = {"1,2,3,3,0", "2,3,1,0,3", "1,2,4,2,0", "3,2,1,1,2"})
	void name(int first, int second, int third, int strikes, int balls) {
		Balls answer = Balls.of(Arrays.asList(1, 2, 3));
		List<Integer> numbers = Arrays.asList(first, second, third);
		assertThat(Balls.of(numbers).match(answer)).satisfies(result -> {
			assertThat(result.getStrikeCount()).isEqualTo(strikes);
			assertThat(result.getBallCount()).isEqualTo(balls);
		});
	}
}
