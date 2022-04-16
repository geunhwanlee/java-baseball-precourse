package baseball.model;

public class Ball {
	public static final int RANGE_FROM = 1;
	public static final int RANGE_TO = 9;
	private final int number;

	public Ball(int number) {
		if (!isWithinRange(number)) {
			throw new IllegalArgumentException(RANGE_FROM + "부터 " + RANGE_TO + "까지의 숫자만 입력 가능합니다");
		}
		this.number = number;
	}

	private boolean isWithinRange(int number) {
		return number >= RANGE_FROM && number <= RANGE_TO;
	}
}
