package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class ComputerTest {
	@ParameterizedTest
	@CsvSource(value = {"1,2,3", "4,5,6", "7,8,9"})
	void pick_numbers(int first, int second, int third) {
		Computer.pick(() -> Arrays.asList(first, second, third));
	}
}
