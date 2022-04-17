package baseball.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerParserTest {
	@DisplayName("문자열을 숫자 리스트로 변환")
	@Test
	void toListTest() {
		List<Integer> list = IntegerParser.toList("123");
		assertThat(list).containsExactly(1, 2, 3);
	}

	@DisplayName("문자열에 숫자가 아닌 값 포함 시 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"a23", "abc", "a"})
	void not_integer(String input) {
		Assertions.assertThatThrownBy(() -> IntegerParser.toList(input))
				.isInstanceOf(NumberFormatException.class);
	}
}
