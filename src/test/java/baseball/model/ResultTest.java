package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
	@DisplayName("스트라이크/볼 상태 추가 후 결과 확인")
	@ParameterizedTest
	@CsvSource(value = {"STRIKE,1,0", "BALL,0,1"})
	void addStatusTest(BallStatus status, int strikes, int balls) {
		Result result = new Result();
		result.addStatus(status);
		assertThat(result.getStrikeCount()).isEqualTo(strikes);
		assertThat(result.getBallCount()).isEqualTo(balls);
	}

	@DisplayName("3스트라이크가 아니면 정답이 아니다")
	@Test
	void notAnswerTest() {
		Result result = new Result();
		result.addStatus(BallStatus.STRIKE);
		result.addStatus(BallStatus.STRIKE);
		assertThat(result.isAnswer()).isFalse();
	}

	@DisplayName("3스트라이크는 정답이다")
	@Test
	void answerTest() {
		Result result = new Result();
		result.addStatus(BallStatus.STRIKE);
		result.addStatus(BallStatus.STRIKE);
		result.addStatus(BallStatus.STRIKE);
		assertThat(result.isAnswer()).isTrue();
	}
}
