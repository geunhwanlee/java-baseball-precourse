package baseball.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ComputerTest {
	@ParameterizedTest
	@CsvSource(value = {"1,2,3", "4,5,6", "7,8,9"})
	void pick_numbers(int first, int second, int third) {
		Computer.pick(() -> Arrays.asList(first, second, third));
	}

	@ParameterizedTest
	@ValueSource(strings = {"123", "456", "789"})
	void input_numbers(String input) {
		Computer computer = Computer.pick(() -> Arrays.asList(1, 2, 3));
		computer.match(input);
	}

	@Test
	void input_blank() {
		Computer computer = Computer.pick(() -> Arrays.asList(1, 2, 3));
		assertThatThrownBy(() -> computer.match(""))
						.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a23", "1b3", "12c"})
	void input_character(String input) {
		Computer computer = Computer.pick(() -> Arrays.asList(1, 2, 3));
		assertThatThrownBy(() -> computer.match(input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
