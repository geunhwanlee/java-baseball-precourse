package baseball.util;

import baseball.model.Ball;
import baseball.model.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballRandomList implements RandomList {
	private static final int START_NUMBER = Ball.RANGE_FROM;
	private static final int END_NUMBER = Ball.RANGE_TO;
	private static final int COUNT_OF_NUMBERS = Balls.SIZE_ONLY;

	@Override
	public List<Integer> pick() {
		Set<Integer> numbers = new LinkedHashSet<>();
		while (numbers.size() < COUNT_OF_NUMBERS) {
			numbers.add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
		}
		return new ArrayList<>(numbers);
	}
}
