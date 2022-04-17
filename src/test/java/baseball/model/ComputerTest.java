package baseball.model;

import baseball.util.RandomList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ComputerTest {
	RandomList NUMBERS_OF_123;

	@BeforeEach
	void setUp() {
		NUMBERS_OF_123 = () -> Arrays.asList(1, 2, 3);
	}

	@DisplayName("1부터 9까지 서로다른 임의의 수 3개를 선택")
	@ParameterizedTest
	@CsvSource(value = {"1,2,3", "4,5,6", "7,8,9"})
	void pick_numbers(int first, int second, int third) {
		RandomList numbers = () -> Arrays.asList(first, second, third);
		assertThat(Computer.pick(numbers)).isNotNull();
	}

	@DisplayName("중복되지 않는 숫자 3개를 입력받는다")
	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "789"})
	void input_numbers(String input) {
		Computer computer = Computer.pick(NUMBERS_OF_123);
		assertThat(computer.match(input)).isNotNull();
	}

	@DisplayName("공백문자를 입력받을 시 예외 발생")
	@Test
	void input_blank() {
		Computer computer = Computer.pick(NUMBERS_OF_123);
		assertThatThrownBy(() -> computer.match(""))
						.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("숫자가 아닌 값을 입력받을 시 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"a23", "1b3", "12c"})
	void input_character(String input) {
		Computer computer = Computer.pick(NUMBERS_OF_123);
		assertThatThrownBy(() -> computer.match(input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("입력받은 숫자의 힌트를 확인")
	@ParameterizedTest
	@CsvSource(value = {"123,3,0", "231,0,3", "124,2,0", "321,1,2"})
	void match_to_123(String input, int strikes, int balls) {
		Computer computer = Computer.pick(NUMBERS_OF_123);
		assertThat(computer.match(input)).satisfies(hint -> {
			assertThat(hint.getStrikeCount()).isEqualTo(strikes);
			assertThat(hint.getBallCount()).isEqualTo(balls);
		});
	}
}
