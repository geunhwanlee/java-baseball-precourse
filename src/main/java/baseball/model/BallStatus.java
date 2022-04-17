package baseball.model;

public enum BallStatus {
	STRIKE,
	BALL,
	NOTHING;

	public boolean isStrike() {
		return this == STRIKE;
	}

	public boolean isBall() {
		return this == BALL;
	}

	public BallStatus reduce(BallStatus status) {
		if (status != NOTHING) {
			return status;
		}
		return this;
	}
}
