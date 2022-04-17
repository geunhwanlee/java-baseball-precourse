package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultTest {
	@DisplayName("스트라이크/볼 상태 추가 후 결과 확인")
	@ParameterizedTest
	@CsvSource(value = {"STRIKE,1,0", "BALL,0,1"})
	void addStatusTest(BallStatus status, int strikes, int balls) {
		Result result = new Result();
		result.addStatus(status);
		Assertions.assertThat(result.getStrikeCount()).isEqualTo(strikes);
		Assertions.assertThat(result.getBallCount()).isEqualTo(balls);
	}
}
