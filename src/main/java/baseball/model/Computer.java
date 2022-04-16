package baseball.model;

import baseball.util.RandomList;

public class Computer {
	private final Balls answer;

	private Computer(Balls answer) {
		this.answer = answer;
	}

	public static Computer pick(RandomList randomList) {
		return new Computer(Balls.of(randomList.pick()));
	}
}
