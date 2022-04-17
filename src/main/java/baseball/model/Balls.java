package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {
	public static final int SIZE_ONLY = 3;
	private final List<Ball> balls;

	private Balls(List<Ball> balls) {
		this.balls = balls;
	}

	public static Balls of(List<Integer> numbers) {
		if (!is3DistinctNumbers(numbers)) {
			throw new IllegalArgumentException(SIZE_ONLY + "개의 서로 다른 숫자만 선택할 수 있습니다");
		}
		List<Ball> balls = new ArrayList<>();
		for (int i = 0; i < numbers.size(); i++) {
			balls.add(new Ball(numbers.get(i), i));
		}
		return new Balls(balls);
	}

	private static boolean is3DistinctNumbers(List<Integer> numbers) {
		return new HashSet<>(numbers).size() == SIZE_ONLY;
	}

	public Result match(Balls answer) {
		Result result = new Result();
		for (Ball ball : balls) {
			result.addStatus(ball.match(answer.balls));
		}
		return result;
	}
}
