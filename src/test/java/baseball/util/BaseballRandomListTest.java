package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseballRandomListTest {
	@DisplayName("서로 다른 3개의 랜덤 수 선택")
	@ParameterizedTest
	@CsvSource(value = {"1,3,5", "5,8,9"})
	void pickTest(int first, int second, int third) {
		RandomList randomList = new BaseballRandomList();
		assertRandomNumberInRangeTest(
				() -> assertThat(randomList.pick()).containsExactly(first, second, third),
				first, second, third
		);
	}
}
