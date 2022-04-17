package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballRandomList implements RandomList {
	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 9;
	private static final int COUNT_OF_NUMBERS = 3;

	@Override
	public List<Integer> pick() {
		Set<Integer> numbers = new LinkedHashSet<>();
		while (numbers.size() < COUNT_OF_NUMBERS) {
			numbers.add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
		}
		return new ArrayList<>(numbers);
	}
}
