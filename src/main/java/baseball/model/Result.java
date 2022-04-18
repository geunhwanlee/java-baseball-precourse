package baseball.model;

public class Result {
	private static final int ANSWER_STRIKE_COUNT = 3;
	private int strikeCount = 0;
	private int ballCount = 0;

	public void addStatus(BallStatus status) {
		if (status.isStrike()) {
			strikeCount ++;
		}
		if (status.isBall()) {
			ballCount ++;
		}
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public boolean isAnswer() {
		return strikeCount == ANSWER_STRIKE_COUNT;
	}
}
