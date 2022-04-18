package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class IntegerParser {
	private IntegerParser() {}

	public static List<Integer> toList(String input) {
		List<Integer> numbers = new ArrayList<>();
		String[] strings = input.split("");
		for (String string : strings) {
			numbers.add(Integer.parseInt(string));
		}
		return numbers;
	}
}
