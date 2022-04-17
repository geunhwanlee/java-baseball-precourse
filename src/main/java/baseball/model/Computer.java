package baseball.model;

import baseball.util.RandomList;

import java.util.List;

import static baseball.util.IntegerParser.toList;

public class Computer {
	private final Balls answer;

	private Computer(Balls answer) {
		this.answer = answer;
	}

	public static Computer pick(RandomList randomList) {
		return new Computer(Balls.of(randomList.pick()));
	}

	public Result match(String input) {
		List<Integer> numbers;
		try {
			numbers = toList(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다");
		}
		return Balls.of(numbers).match(answer);
	}
}
