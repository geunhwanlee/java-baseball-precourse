package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallStatusTest {
	@DisplayName("상태가 STRIKE 인지 BALL 인지 확인")
	@ParameterizedTest
	@CsvSource(value = {"STRIKE,true,false", "BALL,false,true"})
	void statusTest(BallStatus status, boolean isStrike, boolean isBall) {
		assertThat(status.isStrike()).isEqualTo(isStrike);
		assertThat(status.isBall()).isEqualTo(isBall);
	}

	@DisplayName("NOTHING -> STRIKE/BALL 로 바뀌는 지 확인")
	@ParameterizedTest
	@CsvSource(value = {"STRIKE,true,false", "BALL,false,true"})
	void reduceTest(BallStatus status, boolean isStrike, boolean isBall) {
		BallStatus nothing = BallStatus.NOTHING;
		assertThat(nothing.reduce(status).isStrike()).isEqualTo(isStrike);
		assertThat(nothing.reduce(status).isBall()).isEqualTo(isBall);
	}
}
