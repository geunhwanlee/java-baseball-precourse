package baseball.model;

import java.util.List;

public class Ball {
	public static final int RANGE_FROM = 1;
	public static final int RANGE_TO = 9;
	private final int number;
	private final int position;

	public Ball(int number, int position) {
		if (!isWithinRange(number)) {
			throw new IllegalArgumentException(RANGE_FROM + "부터 " + RANGE_TO + "까지의 숫자만 입력 가능합니다");
		}
		this.number = number;
		this.position = position;
	}

	private boolean isWithinRange(int number) {
		return number >= RANGE_FROM && number <= RANGE_TO;
	}

	public BallStatus match(List<Ball> targets) {
		BallStatus status = BallStatus.NOTHING;
		for (Ball target : targets) {
			status = status.reduce(match(target));
		}
		return status;
	}

	private BallStatus match(Ball target) {
		if (isStrike(target)) {
			return BallStatus.STRIKE;
		}
		else if (isBall(target)) {
			return BallStatus.BALL;
		}
		return BallStatus.NOTHING;
	}

	private boolean isStrike(Ball target) {
		return this.number == target.number && this.position == target.position;
	}

	private boolean isBall(Ball target) {
		return this.number == target.number && this.position != target.position;
	}
}
