package baseball.util;

import baseball.model.Ball;
import baseball.model.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballRandomList implements RandomList {
	private static final int START_NUMBER = Ball.RANGE_FROM;
	private static final int END_NUMBER = Ball.RANGE_TO;
	private static final int COUNT_OF_NUMBERS = Balls.SIZE_ONLY;

	@Override
	public List<Integer> pick() {
		return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_OF_NUMBERS);
	}
}
