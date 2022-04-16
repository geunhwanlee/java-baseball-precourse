package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameView {
	private static final String INSERT_YOUR_NUMBERS = "숫자를 입력해주세요 : ";

	public static String insertYourNumbers() {
		System.out.print(INSERT_YOUR_NUMBERS);
		return readLine();
	}
}
