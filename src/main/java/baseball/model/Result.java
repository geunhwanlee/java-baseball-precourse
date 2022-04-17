package baseball.model;

public class Result {
	private int strikeCount = 0;
	private int ballCount = 0;

	public void addStatus(BallStatus status) {
		if (status.isStrike()) {
			strikeCount ++;
		}
		else if (status.isBall()) {
			ballCount ++;
		}
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}
}
